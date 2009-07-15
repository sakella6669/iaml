/**
 * 
 */
package org.openiaml.model.diagramextensions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.openiaml.model.model.DataFlowEdge;
import org.openiaml.model.model.DataFlowEdgeDestination;
import org.openiaml.model.model.DataFlowEdgesSource;
import org.openiaml.model.model.ExecutionEdge;
import org.openiaml.model.model.ExecutionEdgeDestination;
import org.openiaml.model.model.ExecutionEdgesSource;
import org.openiaml.model.model.GeneratedElement;
import org.openiaml.model.model.NamedElement;
import org.openiaml.model.model.WireEdge;
import org.openiaml.model.model.WireEdgeDestination;
import org.openiaml.model.model.WireEdgesSource;

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
	
	// have directly incoming/outgoing edges
	private List<GeneratedElement> requireConfirmation = new ArrayList<GeneratedElement>();
	
	// contains elements that also require confirmation
	private List<GeneratedElement> containsRequirements = new ArrayList<GeneratedElement>();
	
	// the directly incoming/outgoing edges found
	private Map<EObject, Map<EObject, EObject>> incomingMap = new HashMap<EObject, Map<EObject,EObject>>();

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
			if (o instanceof ShapeNodeEditPart) {
				ShapeNodeEditPart part = (ShapeNodeEditPart) o;
				
				// it must be a GeneratedElement...
				if (part.resolveSemanticElement() instanceof GeneratedElement) {
					GeneratedElement g = (GeneratedElement) part.resolveSemanticElement();
					
					elementsToCheck.add(g);

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
		// that is currently generated
		if (g.isIsGenerated()) {
			// and has an incoming non-generated relationship						
			Map<EObject,EObject> incoming = getIncomingNonGeneratedRelationships(g);
			
			if (!incoming.isEmpty()) {
				// save it
				requireConfirmation.add(g);
				incomingMap.put(g, incoming);
			}
			
			// or contain elements that have incoming edges
			for (EObject content : g.eContents()) {
				if (content instanceof GeneratedElement) {
					GeneratedElement ge = (GeneratedElement) content;
					GeneratedElementHandler handler = new GeneratedElementHandler(ge);
					if (handler.needsConfirmation()) {
						containsRequirements.add(ge);
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
	 * Find all the relationships and target objects from this
	 * generated element.
	 * 
	 * @param g
	 * @return a map of (relationship, target node)
	 */
	private Map<EObject, EObject> getIncomingNonGeneratedRelationships(
			GeneratedElement g) {
		
		Map<EObject,EObject> result = new HashMap<EObject,EObject>();

		// NOTE model-specific
		if (g instanceof WireEdgeDestination) {
			checkAllWireEdges((WireEdgeDestination) g, result);
		}
		if (g instanceof WireEdgesSource) {
			checkAllWireEdges((WireEdgesSource) g, result);
		}
		if (g instanceof ExecutionEdgesSource) {
			checkAllExecutionEdges((ExecutionEdgesSource) g, result);
		}
		if (g instanceof ExecutionEdgeDestination) {
			checkAllExecutionEdges((ExecutionEdgeDestination) g, result);
		}
		if (g instanceof DataFlowEdgesSource) {
			checkAllDataFlowEdges((DataFlowEdgesSource) g, result);
		}
		if (g instanceof DataFlowEdgeDestination) {
			checkAllDataFlowEdges((DataFlowEdgeDestination) g, result);
		}

		return result;
	}

	/**
	 * Check all incoming edges to the given wire destination.
	 */
	private void checkAllWireEdges(WireEdgeDestination g,
			Map<EObject, EObject> result) {
		for (WireEdge edge : g.getInEdges()) {
			if (!edge.isIsGenerated()) {
				// edge isn't generated; mark it
				result.put(edge, edge.getFrom());
			}
		}
	}
	
	/**
	 * Check all outgoing edges from the given wire source.
	 */
	private void checkAllWireEdges(WireEdgesSource g,
			Map<EObject, EObject> result) {
		for (WireEdge edge : g.getOutEdges()) {
			if (!edge.isIsGenerated()) {
				// edge isn't generated; mark it
				result.put(edge, edge.getTo());
			}
		}
	}

	private void checkAllExecutionEdges(ExecutionEdgeDestination g,
			Map<EObject, EObject> result) {
		for (ExecutionEdge edge : g.getInExecutions()) {
			if (!edge.isIsGenerated()) {
				// edge isn't generated; mark it
				result.put(edge, edge.getFrom());
			}
		}
	}
	
	private void checkAllExecutionEdges(ExecutionEdgesSource g,
			Map<EObject, EObject> result) {
		for (ExecutionEdge edge : g.getOutExecutions()) {
			if (!edge.isIsGenerated()) {
				// edge isn't generated; mark it
				result.put(edge, edge.getTo());
			}
		}
	}
	
	private void checkAllDataFlowEdges(DataFlowEdgeDestination g,
			Map<EObject, EObject> result) {
		for (DataFlowEdge edge : g.getInFlows()) {
			if (!edge.isIsGenerated()) {
				// edge isn't generated; mark it
				result.put(edge, edge.getFrom());
			}
		}
	}
	
	private void checkAllDataFlowEdges(DataFlowEdgesSource g,
			Map<EObject, EObject> result) {
		for (DataFlowEdge edge : g.getOutFlows()) {
			if (!edge.isIsGenerated()) {
				// edge isn't generated; mark it
				result.put(edge, edge.getTo());
			}
		}
	}
	
	/**
	 * @return
	 */
	public boolean needsConfirmation() {
		return !requireConfirmation.isEmpty() || !containsRequirements.isEmpty();
	}

	/**
	 * @return
	 */
	public Collection<? extends EObject> getConfirmationElements() {
		return requireConfirmation;
	}

	/**
	 * @param element
	 * @return
	 */
	public Collection<EObject> getRelationshipsFor(EObject element) {
		return incomingMap.get(element).keySet();
	}

	/**
	 * @param relationship
	 * @return
	 */
	public EObject getTarget(EObject element, EObject relationship) {
		return incomingMap.get(element).get(relationship);
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
		if (relationship instanceof NamedElement && target instanceof NamedElement) {
			return relationship.eClass().getName() + " '" + ((NamedElement) relationship).getName() + "' connecting to " +
					target.eClass().getName() + " '" + ((NamedElement) target).getName() + "'";
		}
		return relationship + " connecting to " + target;
		
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
		if (!getConfirmationElements().isEmpty()) {		
			message = "The generated element '" + element + "' is connected to the following non-generated elements:\n";
			int pos = 0;
			for (EObject relationship : getRelationshipsFor(element)) {
				if (pos++ > 5) {
					message += "\n[more]";
					break;
				}
				EObject target = getTarget(element, relationship);
				message += "\n" + formatRelationship(relationship, target);
			}
		}
		
		if (!containsRequirements.isEmpty()) {
			if (!message.isEmpty()) {
				message += "\n\n";
			}
			
			message += "The generated element '" + element + "' contains elements which are connected to non-generated elements:\n";
			int pos = 0;
			for (EObject e : containsRequirements) {
				if (pos++ > 5) {
					message += "\n[more]";
					break;
				}
				message += "\n" + e;
			}
		}
		
		return message;
	}

}
