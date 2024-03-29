/**
 * 
 */
package org.openiaml.model.diagram.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.openiaml.model.diagram.helpers.inference.EmfInferenceHandler;
import org.openiaml.model.helpers.EdgeTypes;
import org.openiaml.model.helpers.EdgeTypes.EdgeType;
import org.openiaml.model.inference.EcoreCreateElementsHelper;
import org.openiaml.model.inference.InferenceException;
import org.openiaml.model.model.Event;
import org.openiaml.model.model.GeneratedElement;
import org.openiaml.model.model.NamedElement;

/**
 * <p>
 * A handler called when deleting elements. If the user is
 * trying to delete a generated element that is being used by
 * non-generated elements, they should ask if they still want to
 * confirm deleting it.
 * </p>
 * 
 * <p>
 * Currently, only incoming non-generated edges are considered:
 * {@link #getIncomingNonGeneratedRelationships(GeneratedElement)}
 * </p>
 * 
 * @author jmwright
 *
 */
public class GeneratedElementHandler {
	
	// all elements that are important in some way
	private List<GeneratedElement> elementsFound = new ArrayList<GeneratedElement>();
	
	// contains elements that also require confirmation
	private Map<GeneratedElement, List<EObject>> containsDirectEdges = new HashMap<GeneratedElement, List<EObject>>();
	
	// elements generated by this element that would also be deleted, that also require confirmation
	private Map<GeneratedElement, List<EObject>> relatedGenerated = new HashMap<GeneratedElement, List<EObject>>();

	// the directly incoming/outgoing edges found
	private Map<EObject, Map<EObject, EObject>> directEdgesFound = new HashMap<EObject, Map<EObject,EObject>>();

	// an editing domain to delete further elements
	private TransactionalEditingDomain editingDomain;

	// all GeneratedElement elements selected
	private List<GeneratedElement> selectedElements = new ArrayList<GeneratedElement>();
	
	/**
	 * Populate through the selection of ShapeNodeEditParts
	 * (hopefully) and identify which elements require input
	 * from the user to delete from.
	 * 
	 * @param selected
	 */
	public GeneratedElementHandler(Object[] selected) {
		
		List<GeneratedElement> elementsToCheck = new ArrayList<GeneratedElement>();
		
		// iterate over the selected elements, and
		for (Object o : selected) {
			if (o instanceof IGraphicalEditPart) {
				IGraphicalEditPart part = (IGraphicalEditPart) o;
				
				// it must be a GeneratedElement...
				if (part.resolveSemanticElement() instanceof GeneratedElement) {
					GeneratedElement g = (GeneratedElement) part.resolveSemanticElement();
					
					elementsToCheck.add(g);
				}
				
				if (part.getEditingDomain() != null) {
					editingDomain = part.getEditingDomain();
				}
			}
		}
		
		checkElements(elementsToCheck);
		
	}
	
	private void checkElements(List<GeneratedElement> elementsToCheck) {		
		for (GeneratedElement g : elementsToCheck) {
			checkElement(g);
		}
	}
	
	private void checkElement(GeneratedElement g) {
		// add a copy of this element always
		selectedElements.add(g);

		// that is currently generated
		if (g.isIsGenerated()) {
			// and has an incoming non-generated relationship						
			Map<EObject,EObject> incoming = getIncomingNonGeneratedRelationships(g);
			
			if (!incoming.isEmpty()) {
				// save it
				elementsFound.add(g);
				directEdgesFound.put(g, incoming);
			}
			
			// or contain elements that have incoming edges
			for (EObject content : g.eContents()) {
				if (content instanceof GeneratedElement) {
					GeneratedElement ge = (GeneratedElement) content;
					GeneratedElementHandler handler = new GeneratedElementHandler(ge);
					if (handler.needsConfirmation()) {
						if (!elementsFound.contains(g)) {
							elementsFound.add(g);
						}
						if (containsDirectEdges.get(g) == null) {
							containsDirectEdges.put(g, new ArrayList<EObject>());
						}
						containsDirectEdges.get(g).add(ge);
					}
				}
			}
			
			// or generated elements which will also be deleted
			GeneratedElementDeleter deleter = new GeneratedElementDeleter(g);
			for (EObject d : deleter.getElementsToDelete()) {
				if (d instanceof GeneratedElement) {
					GeneratedElement ge = (GeneratedElement) d;
					GeneratedElementHandler handler = new GeneratedElementHandler(ge);
					if (handler.needsConfirmation()) {
						if (!elementsFound.contains(g)) {
							elementsFound.add(g);
						}
						if (relatedGenerated.get(g) == null) {
							relatedGenerated.put(g, new ArrayList<EObject>());
						}
						relatedGenerated.get(g).add(ge);
					}
				}
			}
			
		}
	}

	/**
	 * Only check one generated element, rather than a list of them.
	 */
	public GeneratedElementHandler(GeneratedElement ge) {
		checkElement(ge);
	}

	/**
	 * @param target
	 */
	public GeneratedElementHandler(IGraphicalEditPart target) {
		if (target.resolveSemanticElement() instanceof GeneratedElement) {
			checkElement((GeneratedElement) target.resolveSemanticElement());
		} else {
			throw new IllegalArgumentException("EditPart does not resolve to GeneratedElement");
		}
	}

	/**
	 * Check a list of generated elements.
	 * 
	 * @param result
	 */
	public GeneratedElementHandler(List<GeneratedElement> result, TransactionalEditingDomain domain) {
		for (GeneratedElement ge : result) {
			checkElement(ge);
		}
		this.editingDomain = domain;
	}
	
	/**
	 * Find all the relationships and target objects from this
	 * generated element.
	 * 
	 * @param g
	 * @return a map of (relationship, target node)
	 */
	private Map<EObject, EObject> getIncomingNonGeneratedRelationships(
			GeneratedElement g) {
		
		Map<EObject,EObject> result = new HashMap<EObject,EObject>();

		for (EdgeType typ : EdgeTypes.getAllEdgeTypes()) {
			// WireSource
			if (typ.getEdgeSource().isInstance(g)) {
				// find the EOpposite (outWires)
				EReference opposite = typ.getFromOpposite();
				
				// get results as a list
				List<Object> edges = new ArrayList<Object>();
				if (opposite.isMany()) {
					List<?> e2 = (List<?>) g.eGet(opposite);
					for (Object e : e2)
						edges.add(e);
				} else {
					edges.add(g.eGet(opposite));
				}
								
				for (Object edge : edges) {
					// if it's a NON-generated element that has been generated, add it to the list
					if (edge instanceof GeneratedElement) { 
						GeneratedElement edge2 = (GeneratedElement) edge;
						
						if (!edge2.isIsGenerated()) {
							EReference target = typ.getToRef();
							
							Object reverse = edge2.eGet(target);
							if (reverse == null)
								continue;
							
							if (!(reverse instanceof EObject)) {
								throw new IllegalArgumentException("Object '" + reverse + "' is not an EObject, resolved reference = '" + target + "' of edgeType " + typ);
							}
							result.put(edge2, (EObject) reverse);
						}
					}
				}
			}
			
			// WireDestination
			if (typ.getEdgeDestination().isInstance(g)) {
				// find the EOpposite (inWires)
				EReference opposite = typ.getToOpposite();
				
				// get results as a list
				List<Object> edges = new ArrayList<Object>();
				if (opposite.isMany()) {
					List<?> e2 = (List<?>) g.eGet(opposite);
					for (Object e : e2)
						edges.add(e);
				} else {
					edges.add(g.eGet(opposite));
				}
								
				for (Object edge : edges) {
					// if it's a NON-generated element that has been generated, add it to the list
					if (edge instanceof GeneratedElement) { 
						GeneratedElement edge2 = (GeneratedElement) edge;
						
						if (!edge2.isIsGenerated()) {
							EReference target = typ.getFromRef();
							
							Object reverse = edge2.eGet(target);
							if (reverse == null)
								continue;
							
							if (!(reverse instanceof EObject)) {
								throw new IllegalArgumentException("Object '" + reverse + "' is not an EObject, resolved reference = '" + target + "' of edgeType " + typ);
							}
							result.put(edge2, (EObject) reverse);
						}
					}
				}
			}
		}
		
		return result;
	}

	/**
	 * @return
	 */
	public boolean needsConfirmation() {
		return !elementsFound.isEmpty() 
			|| !containsDirectEdges.isEmpty()
			|| !relatedGenerated.isEmpty();
	}

	/**
	 * @return
	 */
	public List<? extends EObject> getConfirmationElements() {
		return elementsFound;
	}

	/**
	 * @param relationship
	 * @return
	 */
	public EObject getTarget(EObject element, EObject relationship) {
		return directEdgesFound.get(element).get(relationship);
	}

	/**
	 * Make a pretty description string of the relationship to
	 * a given target.
	 * 
	 * @param relationship
	 * @param target
	 * @return
	 */
	public String formatRelationship(EObject relationship, EObject target) {
		return formatElement(relationship) + " connecting to " + formatElement(target);
		
	}

	/**
	 * Get the confirmation message for a particular element
	 * which was identified to need confirmation.
	 * 
	 * @param element
	 * @return
	 */
	public String getConfirmationMessage(EObject element) {
		
		String message = "";
		if (directEdgesFound.get(element) != null) {		
			message = "The generated element '" + formatElement(element) + "' is connected to the following non-generated elements:\n";
			int pos = 0;
			for (EObject relationship : directEdgesFound.get(element).keySet()) {
				if (pos++ > 5) {
					message += "\n[more]";
					break;
				}
				EObject target = getTarget(element, relationship);
				message += "\n" + formatRelationship(relationship, target);
			}
		}
		
		if (containsDirectEdges.get(element) != null) {
			if (!message.isEmpty()) {
				message += "\n\n";
			}
			
			message += "The generated element '" + formatElement(element) + "' contains elements which are connected to non-generated elements:\n";
			int pos = 0;
			for (EObject e : containsDirectEdges.get(element)) {
				if (pos++ > 5) {
					message += "\n[more]";
					break;
				}
				message += "\n" + formatElement(e);
			}
		}

		if (relatedGenerated.get(element) != null) {
			if (!message.isEmpty()) {
				message += "\n\n";
			}
			
			message += "Deleting '" + formatElement(element) + "' will also delete these generated elements, currently in use:\n";
			int pos = 0;
			for (EObject e : relatedGenerated.get(element)) {
				if (pos++ > 5) {
					message += "\n[more]";
					break;
				}
				message += "\n" + formatElement(e);
			}
		}

		return message;
	}

	/**
	 * Format an EObject as "ClassName 'name'"
	 * 
	 * @param element
	 * @return
	 */
	public String formatElement(EObject element) {
		if (element instanceof NamedElement) {
			NamedElement ne = (NamedElement) element;
			if (ne instanceof Event && ne.getName() == null) {
				return ne.eClass().getName() + " " + ne.eContainingFeature().getName();
			} else {
				return ne.eClass().getName() + " '" + ne.getName() + "'";
			}
		}
		return element.toString();
	}
	
	/**
	 * Actually deletes an element.
	 * 
	 * @param selected
	 * @param monitor
	 * @param info
	 * @param diagramEditPart
	 * @throws InferenceException
	 * @throws ExecutionException 
	 */
	public void deleteElement(EcoreCreateElementsHelper helper, EObject selected, IProgressMonitor monitor, IAdaptable info, IGraphicalEditPart diagramEditPart) throws InferenceException, ExecutionException {
	
		// if the element has no container, it shouldn't exist anymore in the model?
		if (selected.eContainer() != null) {								
			helper.deleteElement(selected, selected.eContainer(), selected.eContainingFeature());
			
			// is this element currently contained within the current
			// edit part?
			IGraphicalEditPart contained = elementContainedWithin(selected, diagramEditPart);
			if (contained != null) {
				// it is: delete the node from the current display								
				DeleteCommand command2 = new DeleteCommand(editingDomain, contained.getPrimaryView());
				command2.execute(monitor, info);
			}
		}
	}

	/**
	 * Delete the other generated elements that should be deleted. Does not delete
	 * the actual selected element.
	 * 
	 * @see #deleteElement(EcoreCreateElementsHelper, EObject, IProgressMonitor, IAdaptable, IGraphicalEditPart)
	 * @param diagramEditPart the current edit part in order to refresh it, or null
	 */
	public void deleteOtherElements(final IGraphicalEditPart diagramEditPart) {
		if (editingDomain == null)
			throw new RuntimeException("Cannot delete related elements; we do not have an editing domain.");
		
		ICommand command = new AbstractTransactionalCommand(editingDomain, "delete related elements", Collections.EMPTY_LIST) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				
				try {
					// we don't want to just delete related elements;
					// we want to delete _all_ elements
					for (GeneratedElement selected : selectedElements) {
						EcoreCreateElementsHelper helper = new EmfInferenceHandler( 
								editingDomain, 
								Collections.EMPTY_LIST, 
								monitor, 
								info, 
								selected.eResource() );
						
						// get all elements to delete
						List<EObject> toDelete = new GeneratedElementDeleter(selected).getElementsToDelete();
						
						for (EObject d : toDelete) {
							deleteElement(helper, d, monitor, info, diagramEditPart);
						}
					}
					
					if (diagramEditPart != null)
						diagramEditPart.refresh();
				} catch (InferenceException e) {
					throw new ExecutionException(e.getMessage(), e);
				}
				
				return CommandResult.newOKCommandResult();
			}

		};
		
		try {
			command.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}

	/**
	 * Is the given eobject rendered in the current edit part?
	 * Return the edit part rendering the object, or null
	 * if none is found.
	 * 
	 * @param d
	 * @param diagramEditPart
	 * @return
	 */
	private IGraphicalEditPart elementContainedWithin(EObject d,
			IGraphicalEditPart diagramEditPart) {
		
		for (Object obj : diagramEditPart.getChildren()) {
			if (obj instanceof IGraphicalEditPart) {
				IGraphicalEditPart p = (IGraphicalEditPart) obj;
				if (d.equals(p.resolveSemanticElement()))
					return p;
			}
		}
		return null;
		
	}
	
	/**
	 * What other elements should we delete for the given selection?
	 * 
	 * @return
	 */
	public List<EObject> getOtherElementsToDelete() {
		
		List<EObject> result = new ArrayList<EObject>();
		for (EObject from : relatedGenerated.keySet()) {
			result.addAll(relatedGenerated.get(from));
		}
		return result;
		
	}

}
