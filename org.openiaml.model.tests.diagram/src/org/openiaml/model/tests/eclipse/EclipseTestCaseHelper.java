/**
 *
 */
package org.openiaml.model.tests.eclipse;

import java.util.List;

import junit.framework.AssertionFailedError;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.openiaml.model.model.BuiltinOperation;
import org.openiaml.model.model.BuiltinProperty;
import org.openiaml.model.model.ECARule;
import org.openiaml.model.model.Event;
import org.openiaml.model.model.Function;
import org.openiaml.model.model.GeneratedElement;
import org.openiaml.model.model.NamedElement;
import org.openiaml.model.model.Operation;
import org.openiaml.model.model.Parameter;
import org.openiaml.model.model.SimpleCondition;
import org.openiaml.model.model.Value;
import org.openiaml.model.model.domain.DomainAttribute;
import org.openiaml.model.model.domain.DomainAttributeInstance;
import org.openiaml.model.model.domain.DomainIterator;
import org.openiaml.model.model.domain.DomainSource;
import org.openiaml.model.model.domain.DomainType;
import org.openiaml.model.model.domain.SelectEdge;
import org.openiaml.model.model.messaging.Email;
import org.openiaml.model.model.operations.ActivityOperation;
import org.openiaml.model.model.operations.ActivityPredicate;
import org.openiaml.model.model.operations.DataFlowEdge;
import org.openiaml.model.model.operations.DecisionNode;
import org.openiaml.model.model.operations.ExecutionEdge;
import org.openiaml.model.model.operations.StartNode;
import org.openiaml.model.model.operations.TemporaryVariable;
import org.openiaml.model.model.scopes.Session;
import org.openiaml.model.model.visual.Button;
import org.openiaml.model.model.visual.Frame;
import org.openiaml.model.model.visual.InputForm;
import org.openiaml.model.model.visual.InputTextField;
import org.openiaml.model.model.visual.Label;
import org.openiaml.model.model.wires.SyncWire;

/**
 * Adds some helper assert...() methods to the EclipseTestCase.
 *
 * This also allows errors to be logged directly to the console,
 * set up in {@link #setUp()}.
 *
 * @see EclipseTestCase
 * @author jmwright
 *
 */
public abstract class EclipseTestCaseHelper extends EclipseTestCase {

	/**
	 * Add an error log listener.
	 */
	@Override
	public void setUp() throws Exception {
		super.setUp();

		// register errors
		addLogListener();
	}

	/**
	 * Close all active editors.
	 */
	@Override
	public void tearDown() throws Exception {
		// close all editors
		PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);

		super.tearDown();
	}

	public void assertExists(IFile file) {
		assertTrue("File '" + file + "' should exist", file.exists());
	}

	public void assertNotExists(IFile file) {
		assertFalse("File '" + file + "' should not exist", file.exists());
	}

	public void assertExists(IFolder folder) {
		assertTrue("Folder '" + folder + "' should exist", folder.exists());
	}

	public void assertNotExists(IFolder folder) {
		assertFalse("Folder '" + folder + "' should not exist", folder.exists());
	}

	/**
	 * Is the given part a shortcut element?
	 *
	 * @param part
	 * @return
	 */
	public boolean isShortcut(ShapeNodeEditPart part) {
		return null != ((View) part.getModel()).getEAnnotation("Shortcut");
	}

	/**
	 * Assert that the given edit part is a shortcut element.
	 */
	public void assertShortcut(ShapeNodeEditPart part) {
		assertTrue("part '" + part + "' does not have a shortcut annotation", isShortcut(part));
	}

	/**
	 * Assert that the given edit part is a shortcut element.
	 */
	public void assertNotShortcut(ShapeNodeEditPart part) {
		assertFalse("part '" + part + "' has a shortcut annotation", isShortcut(part));
	}

	/**
	 * Assert that the given edit part is openable, that is, it has an Open Diagram Hint
	 */
	public void assertOpenable(ShapeNodeEditPart part) {
		View view = (View) part.getModel();
		Style link = view.getStyle(NotationPackage.eINSTANCE
				.getHintedDiagramLinkStyle());
		if (link == null || !(link instanceof HintedDiagramLinkStyle))
			fail("part '" + part + "' is not a shortcut, it should be (link=" + link + ")");
	}

	/**
	 * Assert that the given edit part is not openable, that is, it does not have an Open Diagram Hint
	 */
	public void assertNotOpenable(ShapeNodeEditPart part) {
		View view = (View) part.getModel();
		Style link = view.getStyle(NotationPackage.eINSTANCE
				.getHintedDiagramLinkStyle());
		if (!(link == null || !(link instanceof HintedDiagramLinkStyle)))
			fail("part '" + part + "' is not a shortcut, it should be (link=" + link + ")");
	}

	/**
	 * An abstract method which checks an editors children to see
	 * if the editor contains a given model element, with the given
	 * shortcut parameters.
	 *
	 * @param root the editor to search
	 * @param objectClass the EObject class to look for
	 * @param name the name of the NamedElement
	 * @param checkShortcut
	 * @param shortcutRequired
	 * @return
	 */
	protected ShapeNodeEditPart assertHasRenderedNamedObject(DiagramDocumentEditor root,
			Class<? extends NamedElement> objectClass,
			String name,
			boolean checkShortcut,
			boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, objectClass, name, checkShortcut, shortcutRequired, null);
	}
	
	/**
	 * An abstract method which checks an editors children to see
	 * if the editor contains a given model element, with the given
	 * shortcut parameters.
	 *
	 * @param root the editor to search
	 * @param objectClass the EObject class to look for
	 * @param name the name of the NamedElement
	 * @param checkShortcut
	 * @param shortcutRequired
	 * @return
	 */
	protected ShapeNodeEditPart assertHasRenderedENamedObject(DiagramDocumentEditor root,
			Class<? extends ENamedElement> objectClass,
			String name,
			boolean checkShortcut,
			boolean shortcutRequired) {
		return assertHasRenderedENamedObject(root, objectClass, name, checkShortcut, shortcutRequired, null);
	}
	
	/**
	 * An abstract method which checks an editors children to see
	 * if the editor contains a given model element, with the given
	 * shortcut parameters.
	 *
	 * @param root the editor to search
	 * @param objectClass the EObject class to look for
	 * @param name the name of the NamedElement
	 * @param checkShortcut
	 * @param shortcutRequired
	 * @return
	 */
	protected ShapeNodeEditPart assertHasRenderedNodeObject(DiagramDocumentEditor root,
			Class<? extends DecisionNode> objectClass,
			String name,
			boolean checkShortcut,
			boolean shortcutRequired) {
		return assertHasRenderedNodeObject(root, objectClass, name, checkShortcut, shortcutRequired, null);
	}
	
	/**
	 * An abstract method which checks an editors children to see
	 * if the editor contains a given model element, with the given
	 * shortcut parameters, contained with a given containment feature name.
	 * 
	 * <p>TODO remove containingFeatureName(String), and replace with containingFeature(EStructuralFeature).
	 *
	 * @param root the editor to search
	 * @param objectClass the EObject class to look for
	 * @param name the name of the NamedElement, or <code>null</code> to ignore
	 * @param checkShortcut
	 * @param shortcutRequired
	 * @param containingFeature the containing feature, or <code>null</code> if this shouldn't be checked
	 * @return
	 */
	protected ShapeNodeEditPart assertHasRenderedNamedObject(DiagramDocumentEditor root,
			Class<? extends NamedElement> objectClass,
			String name,
			boolean checkShortcut,
			boolean shortcutRequired,
			EStructuralFeature containingFeature) {
		// debug
		String found = "";

		for (Object o : root.getDiagramEditPart().getChildren()) {
			if (o instanceof ShapeNodeEditPart) {
				ShapeNodeEditPart s = (ShapeNodeEditPart) o;
				// check for shortcut status if necessary
				if (!checkShortcut || isShortcut(s) == shortcutRequired) {
					EObject obj = s.resolveSemanticElement();
					if (objectClass.isInstance(obj)) {
						// check containing feature name
						NamedElement e = (NamedElement) obj;
						if (name == null || (e.getName() != null && e.getName().equals(name))) {
							if (containingFeature == null || containingFeature.equals(obj.eContainingFeature())) {
							assertNotNull(s);
							return s;
							}
						}
						found += e.getName() + "[" + obj.eContainingFeature() + "],";
					}
				}
			}
		}

		// failed
		fail("No " + objectClass.getSimpleName() + " named '" + name + "' found in editor " + root + " with containing feature '" + containingFeature + "'. Found: " + found);
		return null;
	}
	
	/**
	 * An abstract method which checks an editors children to see
	 * if the editor contains a given model element, with the given
	 * shortcut parameters, contained with a given containment feature name.
	 * 
	 * <p>TODO remove containingFeatureName(String), and replace with containingFeature(EStructuralFeature).
	 *
	 * @param root the editor to search
	 * @param objectClass the EObject class to look for
	 * @param name the name of the NamedElement, or <code>null</code> to ignore
	 * @param checkShortcut
	 * @param shortcutRequired
	 * @param containingFeature the containing feature, or <code>null</code> if this shouldn't be checked
	 * @return
	 */
	protected ShapeNodeEditPart assertHasRenderedENamedObject(DiagramDocumentEditor root,
			Class<? extends ENamedElement> objectClass,
			String name,
			boolean checkShortcut,
			boolean shortcutRequired,
			EStructuralFeature containingFeature) {
		// debug
		String found = "";

		for (Object o : root.getDiagramEditPart().getChildren()) {
			if (o instanceof ShapeNodeEditPart) {
				ShapeNodeEditPart s = (ShapeNodeEditPart) o;
				// check for shortcut status if necessary
				if (!checkShortcut || isShortcut(s) == shortcutRequired) {
					EObject obj = s.resolveSemanticElement();
					if (objectClass.isInstance(obj)) {
						// check containing feature name
						ENamedElement e = (ENamedElement) obj;
						if (name == null || (e.getName() != null && e.getName().equals(name))) {
							if (containingFeature == null || containingFeature.equals(obj.eContainingFeature())) {
							assertNotNull(s);
							return s;
							}
						}
						found += e.getName() + "[" + obj.eContainingFeature() + "],";
					}
				}
			}
		}

		// failed
		fail("No " + objectClass.getSimpleName() + " named '" + name + "' found in editor " + root + " with containing feature '" + containingFeature + "'. Found: " + found);
		return null;
	}
	
	/**
	 * An abstract method which checks an editors children to see
	 * if the editor contains a given model element, with the given
	 * shortcut parameters, contained with a given containment feature name.
	 * 
	 * <p>TODO remove containingFeatureName(String), and replace with containingFeature(EStructuralFeature).
	 *
	 * @param root the editor to search
	 * @param objectClass the EObject class to look for
	 * @param name the name of the NamedElement, or <code>null</code> to ignore
	 * @param checkShortcut
	 * @param shortcutRequired
	 * @param containingFeature the containing feature, or <code>null</code> if this shouldn't be checked
	 * @return
	 */
	protected ShapeNodeEditPart assertHasRenderedNodeObject(DiagramDocumentEditor root,
			Class<? extends DecisionNode> objectClass,
			String name,
			boolean checkShortcut,
			boolean shortcutRequired,
			EStructuralFeature containingFeature) {
		// debug
		String found = "";

		for (Object o : root.getDiagramEditPart().getChildren()) {
			if (o instanceof ShapeNodeEditPart) {
				ShapeNodeEditPart s = (ShapeNodeEditPart) o;
				// check for shortcut status if necessary
				if (!checkShortcut || isShortcut(s) == shortcutRequired) {
					EObject obj = s.resolveSemanticElement();
					if (objectClass.isInstance(obj)) {
						// check containing feature name
						DecisionNode e = (DecisionNode) obj;
						if (name == null || (e.getName() != null && e.getName().equals(name))) {
							if (containingFeature == null || containingFeature.equals(obj.eContainingFeature())) {
							assertNotNull(s);
							return s;
							}
						}
						found += e.getName() + "[" + obj.eContainingFeature() + "],";
					}
				}
			}
		}

		// failed
		fail("No " + objectClass.getSimpleName() + " named '" + name + "' found in editor " + root + " with containing feature '" + containingFeature + "'. Found: " + found);
		return null;
	}

	/**
	 * @see #assertHasEvent(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasEvent(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired, EStructuralFeature containingFeature) {
		return assertHasRenderedNamedObject(editor, Event.class, name, true, shortcutRequired, containingFeature);
	}

	/**
	 * Look at the editor's children to see if a Session is being displayed.
	 *
	 * @param root
	 * @param sessionName
	 * @return
	 */
	public ShapeNodeEditPart assertHasSession(DiagramDocumentEditor root, String sessionName) {
		for (Object o : root.getDiagramEditPart().getChildren()) {
			if (o instanceof ShapeNodeEditPart) {
				ShapeNodeEditPart s = (ShapeNodeEditPart) o;
				EObject obj = s.resolveSemanticElement();
				if (obj instanceof Session) {
					Session p = (Session) obj;
					if (p.getName() != null && p.getName().equals(sessionName)) {
						assertNotNull(s);
						return s;
					}
				}
			}
		}
		// failed
		fail("assertHasSession: no Session '" + sessionName + "' found.");
		return null;
	}

	/**
	 * Look at the editor's children to see if an InputForm is being displayed.
	 *
	 * @param editor
	 * @param name
	 * @return
	 */
	public ShapeNodeEditPart assertHasInputForm(DiagramDocumentEditor editor, String name, boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, InputForm.class, name, checkShortcut, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if a Frame is being displayed.
	 *
	 * @param editor
	 * @param name
	 * @return
	 */
	public ShapeNodeEditPart assertHasFrame(DiagramDocumentEditor editor, String name, boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, Frame.class, name, checkShortcut, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if an Email is being displayed.
	 *
	 * @param editor
	 * @param name
	 * @return
	 */
	public ShapeNodeEditPart assertHasEmail(DiagramDocumentEditor editor, String name, boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, Email.class, name, checkShortcut, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if an InputForm is being displayed.
	 *
	 * @see #isShortcut(ShapeNodeEditPart)
	 * @param root
	 * @param textName
	 * @param checkShortcut should we check to see if the element has a shortcut?
	 * @param shortcutRequired if checkShortcut is true, only search for parts where isShortcut(part) = shortcutRequired
	 * @return
	 */
	public ShapeNodeEditPart assertHasInputTextField(DiagramDocumentEditor root, String textName,
			boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, InputTextField.class, textName, checkShortcut, shortcutRequired);
	}

	/**
	 * Simply calls {@link #assertHasInputTextField(DiagramDocumentEditor, String, boolean, boolean)},
	 * does not check the EditPart for shortcuts.
	 *
	 * @see #assertHasInputTextField(DiagramDocumentEditor, String, boolean, boolean)
	 * @param root
	 * @param textName
	 * @return
	 */
	public ShapeNodeEditPart assertHasInputTextField(DiagramDocumentEditor root, String textName) {
		return assertHasInputTextField(root, textName, false, false);
	}

	/**
	 * Look at the editor's children to see if a StartNode is being displayed.
	 * Note that we can't specify which StartNode to look for.
	 *
	 * @param root
	 * @return
	 */
	public ShapeNodeEditPart assertHasStartNode(DiagramDocumentEditor root) {
		for (Object o : root.getDiagramEditPart().getChildren()) {
			if (o instanceof ShapeNodeEditPart) {
				ShapeNodeEditPart s = (ShapeNodeEditPart) o;
				EObject obj = s.resolveSemanticElement();
				if (obj instanceof StartNode) {
					assertNotNull(s);
					return s;
				}
			}
		}
		// failed
		fail("assertHasStartNode: no start node found.");
		return null;
	}

	/**
	 * Look at the editor's children to see if a Domain Store is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasDomainType(DiagramDocumentEditor root, String storeName) {
		return assertHasRenderedENamedObject(root, DomainType.class, storeName, false, false);
	}

	/**
	 * Look at the editor's children to see if a Domain Store is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasDomainSource(DiagramDocumentEditor root, String storeName) {
		return assertHasRenderedNamedObject(root, DomainSource.class, storeName, false, false);
	}
	
	public ShapeNodeEditPart assertHasDomainSource(DiagramDocumentEditor root, String storeName, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, DomainSource.class, storeName, true, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if an {@link Event} is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasEvent(DiagramDocumentEditor root, String eventName, boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, Event.class, eventName, checkShortcut, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if a Domain Attribute is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasDomainAttribute(DiagramDocumentEditor root, String attrName, boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedENamedObject(root, DomainAttribute.class, attrName, checkShortcut, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if a Domain Object is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasDomainType(DiagramDocumentEditor root, String objectName, boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedENamedObject(root, DomainType.class, objectName, checkShortcut, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if a Domain Object Instance is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasDomainIterator(DiagramDocumentEditor root, String objectName, boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, DomainIterator.class, objectName, checkShortcut, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if an Operation is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasOperation(DiagramDocumentEditor root, String operationName,
			boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, Operation.class, operationName, checkShortcut, shortcutRequired);
	}
	
	/**
	 * Look at the editor's children to see if an DecisionNode is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasDecisionNode(DiagramDocumentEditor root, String operationName,
			boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNodeObject(root, DecisionNode.class, operationName, checkShortcut, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if a PrimitiveOperation is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasBuiltinOperation(DiagramDocumentEditor root, String operationName,
			boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, BuiltinOperation.class, operationName, checkShortcut, shortcutRequired);
	}
	
	/**
	 * Look at the editor's children to see if a PrimitiveOperation is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasBuiltinOperation(DiagramDocumentEditor root, String operationName,
			boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, BuiltinOperation.class, operationName, true, shortcutRequired);
	}
	
	/**
	 * Look at the editor's children to see if a {@link BuiltinProperty} is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasPrimitiveCondition(DiagramDocumentEditor root, String operationName,
			boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, BuiltinProperty.class, operationName, true, shortcutRequired);
	}

	/**
	 * Look at the editor's children to see if a {@link ActivityPredicate} is being displayed.
	 *
	 * @param root
	 * @param pageName
	 * @return
	 */
	public ShapeNodeEditPart assertHasActivityPredicate(DiagramDocumentEditor root, String operationName,
			boolean checkShortcut, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(root, ActivityPredicate.class, operationName, checkShortcut, shortcutRequired);
	}
	
	/**
	 * Assert that an {@link ECARule} exists between two elements in the editor.
	 */
	public ConnectionNodeEditPart assertHasECARule(DiagramDocumentEditor editor, EditPart source, EditPart target, String name) {
		String found = "";

		for (Object c : editor.getDiagramEditPart().getConnections()) {
			if (c instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connection = (ConnectionNodeEditPart) c;
				EObject element = connection.resolveSemanticElement();
				if (element instanceof ECARule) {
					ECARule w = (ECARule) element;
					if (connection.getSource().equals(source) &&
							connection.getTarget().equals(target) && w.getName().equals(name))
						return connection;	// found it
					found += ", " + w.getName();
				}
			}
		}

		fail("assertHasRunAction: no connection found between '" + source + "' and '" + target + "' with name '" + name + "'. found: " + found);
		return null;
	}

	/**
	 * Assert that a {@link SimpleCondition} exists between two elements in the editor,
	 * with the specific name.
	 * 
	 * TODO refactor these methods
	 */
	public ConnectionNodeEditPart assertHasSimpleCondition(DiagramDocumentEditor editor, EditPart source, EditPart target, String name) {
		String found = "";

		for (Object c : editor.getDiagramEditPart().getConnections()) {
			if (c instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connection = (ConnectionNodeEditPart) c;
				EObject element = connection.resolveSemanticElement();
				if (element instanceof SimpleCondition) {
					SimpleCondition w = (SimpleCondition) element;
					if (connection.getSource().equals(source) &&
							connection.getTarget().equals(target) && w.getName().equals(name))
						return connection;	// found it
					found += ", " + w.getName();
				}
			}
		}

		fail("assertHasRunInstanceWire: no connection found between '" + source + "' and '" + target + "' with name '" + name + "'. found: " + found);
		return null;
	}

	/**
	 * Assert that a {@link SimpleCondition} exists between two elements in the editor,
	 * with any name.
	 * 
	 * TODO refactor these methods
	 */
	public ConnectionNodeEditPart assertHasSimpleCondition(DiagramDocumentEditor editor, EditPart source, EditPart target) {
		String found = "";

		for (Object c : editor.getDiagramEditPart().getConnections()) {
			if (c instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connection = (ConnectionNodeEditPart) c;
				EObject element = connection.resolveSemanticElement();
				if (element instanceof SimpleCondition) {
					SimpleCondition w = (SimpleCondition) element;
					if (connection.getSource().equals(source) &&
							connection.getTarget().equals(target))
						return connection;	// found it
					found += ", " + w.getName();
				}
			}
		}

		fail("assertHasConditionEdge: no connection found between '" + source + "' and '" + target + "' with any name. found: " + found);
		return null;
	}

	/**
	 * Assert that a DataFlowEdge exists between two elements in the editor.
	 */
	public ConnectionNodeEditPart assertHasDataFlowEdge(DiagramDocumentEditor editor, EditPart source, EditPart target) {
		for (Object c : editor.getDiagramEditPart().getConnections()) {
			if (c instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connection = (ConnectionNodeEditPart) c;
				EObject element = connection.resolveSemanticElement();
				if (element instanceof DataFlowEdge) {
					if (connection.getSource().equals(source) &&
							connection.getTarget().equals(target))
						return connection;	// found it
				}
			}
		}

		fail("assertHasDataFlowEdge: no data flow edge found between '" + source + "' and '" + target + "'");
		return null;
	}

	/**
	 * Assert that a SyncWire exists between two elements in the editor.
	 *
	 * SyncWires are bidirectional, so the order of elements in the parameters
	 * do not matter.
	 */
	public ConnectionNodeEditPart assertHasSyncWire(DiagramDocumentEditor editor,
			EditPart part1, EditPart part2, String name) {
		String found = "";

		for (Object c : editor.getDiagramEditPart().getConnections()) {
			if (c instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connection = (ConnectionNodeEditPart) c;
				EObject element = connection.resolveSemanticElement();
				if (element instanceof SyncWire) {
					SyncWire w = (SyncWire) element;
					// SyncWires are bidirectional
					if (connection.getSource().equals(part1) &&
							connection.getTarget().equals(part2) && w.getName().equals(name))
						return connection;	// found it (a->b)
					if (connection.getSource().equals(part2) &&
							connection.getTarget().equals(part1) && w.getName().equals(name))
						return connection;	// found it (b->a)
					found += ", " + w.getName();
				}
			}
		}

		fail("assertHasSyncWire: no connection found between '" + part1 + "' and '" + part2 + "'. found: " + found);
		return null;
	}

	/**
	 * Assert that an ExecutionEdge exists between two elements in the editor.
	 */
	public ConnectionNodeEditPart assertHasExecutionEdge(DiagramDocumentEditor editor, EditPart source, EditPart target) {

		for (Object c : editor.getDiagramEditPart().getConnections()) {
			if (c instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connection = (ConnectionNodeEditPart) c;
				EObject element = connection.resolveSemanticElement();
				if (element instanceof ExecutionEdge) {
					if (connection.getSource().equals(source) &&
							connection.getTarget().equals(target))
						return connection;	// found it
				}
			}
		}

		fail("assertHasExecutionEdge: no connection found between '" + source + "' and '" + target + "'");
		return null;
	}
	
	/**
	 * Assert that an SelectEdge exists between two elements in the editor.
	 */
	public ConnectionNodeEditPart assertHasSelectEdge(DiagramDocumentEditor editor, EditPart source, EditPart target) {

		for (Object c : editor.getDiagramEditPart().getConnections()) {
			if (c instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connection = (ConnectionNodeEditPart) c;
				EObject element = connection.resolveSemanticElement();
				if (element instanceof SelectEdge) {
					if (connection.getSource().equals(source) &&
							connection.getTarget().equals(target))
						return connection;	// found it
				}
			}
		}

		fail("assertHasSelectEdge: no connection found between '" + source + "' and '" + target + "'");
		return null;
	}

	/**
	 * Assert that these two EditParts refer to the same semantic element.
	 */
	public void assertSameReferencedElement(EditPart a, EditPart b) {
		// TODO remove XXX checks. even though the two elements DO
		// refer to the same semantic element, because we do not yet
		// share editing domains, they are loaded as different instances
		// and thus cannot be considered equal.
		// or at the very least, .equals() returns false because they are different instances.

		if (a instanceof ConnectionEditPart && b instanceof ConnectionEditPart) {
			assertEquals(
					((GeneratedElement) ((ConnectionEditPart) a).resolveSemanticElement()).getId(),
					((GeneratedElement) ((ConnectionEditPart) b).resolveSemanticElement()).getId());
			// XXX assertEquals(((ConnectionEditPart) a).resolveSemanticElement(), ((ConnectionEditPart) b).resolveSemanticElement());
		} else if (a instanceof ShapeNodeEditPart && b instanceof ShapeNodeEditPart) {
			assertEquals(
					((GeneratedElement) ((ShapeNodeEditPart) a).resolveSemanticElement()).getId(),
					((GeneratedElement) ((ShapeNodeEditPart) b).resolveSemanticElement()).getId());
			// XXX assertEquals(((ShapeNodeEditPart) a).resolveSemanticElement(), ((ShapeNodeEditPart) b).resolveSemanticElement());
		} else {
			fail("a and b are not of the same type of part. a='" + a + "', b='" + b + "'");
		}
	}

	/**
	 * Assert the given editor is from the root plugin.
	 */
	public void assertEditorRoot(IEditorPart editor) {
		assertEquals("active editor is the root plugin",
				org.openiaml.model.diagram.part.IamlDiagramEditor.class.getName(),
				editor.getClass().getName());
	}

	/**
	 * Assert the given editor is from the visual plugin.
	 */
	public void assertEditorVisual(IEditorPart editor) {
		assertEquals("active editor is the visual plugin",
				org.openiaml.model.diagram.visual.part.IamlDiagramEditor.class.getName(),
				editor.getClass().getName());
	}
	
	/**
	 * Assert the given editor is from the frame plugin.
	 */
	public void assertEditorFrame(IEditorPart editor) {
		assertEquals("active editor is the frame plugin",
				org.openiaml.model.diagram.frame.part.IamlDiagramEditor.class.getName(),
				editor.getClass().getName());
	}

	/**
	 * Assert the given editor is from the operation plugin.
	 */
	public void assertEditorOperation(IEditorPart editor) {
		assertEquals("active editor is the operation plugin",
				org.openiaml.model.diagram.operation.part.IamlDiagramEditor.class.getName(),
				editor.getClass().getName());
	}

	/**
	 * Assert the given editor is from the domainstore plugin.
	 */
	public void assertEditorDomainSchema(IEditorPart editor) {
		assertEquals("active editor is the schema plugin",				
				org.openiaml.model.diagram.schema.part.IamlDiagramEditor.class.getName(),
				editor.getClass().getName());
	}

	/**
	 * Assert the given editor is from the condition plugin.
	 */
	public void assertEditorCondition(IEditorPart editor) {
		assertEquals("active editor is the condition plugin",
				org.openiaml.model.diagram.condition.part.IamlDiagramEditor.class.getName(),
				editor.getClass().getName());
	}

	/**
	 * Check the number of children nodes in this editor.
	 * The "number of children" are the number of nodes, not the number of
	 * edges, visible in the current editor.
	 *
	 * @param i
	 * @param sub
	 */
	public void assertEditorHasChildren(int i, DiagramDocumentEditor sub) {
		assertEquals("There should be " + i + " children in editor '" + sub.getTitle() + "'", i, sub.getDiagramEditPart().getChildren().size());
	}

	/**
	 * @see #assertHasDomainType(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasDomainType(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedENamedObject(editor, DomainType.class, name, true, shortcutRequired);
	}

	/**
	 * @see #assertHasDomainObjectInstance(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasDomainIterator(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, DomainIterator.class, name, true, shortcutRequired);
	}
	
	public ShapeNodeEditPart assertHasDomainIterator(
			DiagramDocumentEditor editor, String name) {
		return assertHasRenderedNamedObject(editor, DomainIterator.class, name, false, false);
	}

	/**
	 * @see #assertHasDomainAttribute(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasDomainAttribute(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedENamedObject(editor, DomainAttribute.class, name, true, shortcutRequired);
	}

	/**
	 * @see #assertHasEvent(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasEvent(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, Event.class, name, true, shortcutRequired);
	}

	/**
	 * @see #assertHasEvent(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasEvent(
			DiagramDocumentEditor editor, boolean shortcutRequired, EStructuralFeature containingFeature) {
		return assertHasRenderedNamedObject(editor, Event.class, null, true, shortcutRequired, containingFeature);
	}

	/**
	 * @see #assertHasInputTextField(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasInputTextField(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, InputTextField.class, name, true, shortcutRequired);
	}
	
	/**
	 * @see #assertHasInputTextField(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasLabel(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, Label.class, name, true, shortcutRequired);
	}

	/**
	 * @see #assertHasInputForm(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasInputForm(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, InputForm.class, name, true, shortcutRequired);
	}

	/**
	 * @see #assertHasFrame(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasFrame(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, Frame.class, name, true, shortcutRequired);
	}

	/**
	 * @see #assertHasOperation(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasOperation(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, Operation.class, name, true, shortcutRequired);
	}

	/**
	 * @see #assertHasActivityPredicate(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasActivityPredicate(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, ActivityPredicate.class, name, true, shortcutRequired);
	}
	
	/**
	 * @see #assertHasCondition(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasFunction(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, Function.class, name, true, shortcutRequired);
	}

	public ShapeNodeEditPart assertHasButton(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, Button.class, name, true, shortcutRequired);
	}
	
	public ShapeNodeEditPart assertHasButton(
			DiagramDocumentEditor editor, String name) {
		return assertHasRenderedNamedObject(editor, Button.class, name, false, false);
	}
	
	public ShapeNodeEditPart assertHasActivityOperation(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, ActivityOperation.class, name, true, shortcutRequired);
	}
	
	public ShapeNodeEditPart assertHasActivityOperation(
			DiagramDocumentEditor editor, String name) {
		return assertHasRenderedNamedObject(editor, ActivityOperation.class, name, false, false);
	}
	
	public ShapeNodeEditPart assertHasDomainAttributeInstance(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, DomainAttributeInstance.class, name, true, shortcutRequired);
	}
	
	public ShapeNodeEditPart assertHasDomainAttributeInstance(
			DiagramDocumentEditor editor, String name) {
		return assertHasRenderedNamedObject(editor, DomainAttributeInstance.class, name, false, false);
	}
	
	/**
	 * @see #assertHasApplicationElementProperty(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasValue(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, Value.class, name, true, shortcutRequired);
	}
	
	public ShapeNodeEditPart assertHasValue(
			DiagramDocumentEditor editor, String name) {
		return assertHasRenderedNamedObject(editor, Value.class, name, true, false);
	}

	/**
	 * @see #assertHasTemporaryVariable(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasTemporaryVariable(
			DiagramDocumentEditor editor, String name, boolean shortcutRequired) {
		return assertHasRenderedNamedObject(editor, TemporaryVariable.class, name, true, shortcutRequired);
	}

	/**
	 * @see #assertHasDomainAttribute(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasDomainAttribute(
			DiagramDocumentEditor editor, String name) {
		return assertHasDomainAttribute(editor, name, false, false);
	}

	/**
	 * @see #assertHasEvent(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasEventTrigger(
			DiagramDocumentEditor editor, String name) {
		return assertHasEvent(editor, name, false, false);
	}

	/**
	 * @see #assertHasInputForm(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasInputForm(
			DiagramDocumentEditor editor, String name) {
		return assertHasInputForm(editor, name, false, false);
	}

	/**
	 * @see #assertHasFrame(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasFrame(
			DiagramDocumentEditor editor, String name) {
		return assertHasFrame(editor, name, false, false);
	}

	/**
	 * @see #assertHasEmaile(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasEmail(
			DiagramDocumentEditor editor, String name) {
		return assertHasEmail(editor, name, false, false);
	}

	/**
	 * @see #assertHasOperation(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasOperation(
			DiagramDocumentEditor editor, String name) {
		return assertHasOperation(editor, name, false, false);
	}
	
	/**
	 * @see #assertHasDecisionNode(DiagramDocumentEditor, String, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasDecisionNode(
			DiagramDocumentEditor editor, String name) {
		return assertHasDecisionNode(editor, name, false, false);
	}


	/**
	 * Assert that a {@link Parameter} exists between two elements in the editor.
	 *
	 * @param editor
	 * @param source
	 * @param target
	 * @return
	 */
	public ConnectionNodeEditPart assertHasParameter(DiagramDocumentEditor editor,
			ShapeNodeEditPart source, ConnectionNodeEditPart target) {

		String found = "";

		for (Object c : editor.getDiagramEditPart().getConnections()) {
			if (c instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connection = (ConnectionNodeEditPart) c;
				EObject element = connection.resolveSemanticElement();
				if (element instanceof Parameter) {
					Parameter w = (Parameter) element;
					if (connection.getSource().equals(source) &&
							connection.getTarget().equals(target))
						return connection;	// found it
					found += ", " + w.getName();
				}
			}
		}

		fail("assertHasParameterEdge: no connection found between '" + source + "' and '" + target + "'. found: " + found);
		return null;

	}

	/**
	 * The given edit part must not be generated.
	 *
	 * @param part
	 */
	public void assertNotGenerated(ShapeNodeEditPart part) {
		assertFalse("EditPart '" + part + "' should not be generated", ((GeneratedElement) part.resolveSemanticElement()).isIsGenerated());
	}

	/**
	 * The given edit part must be generated.
	 *
	 * @param part
	 */
	public void assertGenerated(ShapeNodeEditPart part) {
		assertTrue("EditPart '" + part + "' should be generated", ((GeneratedElement) part.resolveSemanticElement()).isIsGenerated());
	}

	/**
	 * The given edit part must not be generated.
	 *
	 * @param part
	 */
	public void assertNotGenerated(ConnectionNodeEditPart part) {
		assertFalse("EditPart '" + part + "' should not be generated", ((GeneratedElement) part.resolveSemanticElement()).isIsGenerated());
	}

	/**
	 * The given edit part must be generated.
	 *
	 * @param part
	 */
	public void assertGenerated(ConnectionNodeEditPart part) {
		assertTrue("EditPart '" + part + "' should be generated", ((GeneratedElement) part.resolveSemanticElement()).isIsGenerated());
	}

	/**
	 * @see #assertHasFieldValue(DiagramDocumentEditor, boolean, boolean)
	 */
	public ShapeNodeEditPart assertHasFieldValue(DiagramDocumentEditor editor, boolean shortcutRequired) {
		return assertHasFieldValue(editor, true, shortcutRequired);
	}

	/**
	 * The editor should contain an {@link Value} called
	 * 'fieldValue' that is shortcut=requiredShortcut.
	 *
	 * @param editor
	 * @param checkShortcut should we check if it's a shortcut?
	 * @param shortcutRequired the required value of shortcut
	 * @return
	 */
	public ShapeNodeEditPart assertHasFieldValue(
			DiagramDocumentEditor editor, boolean checkShortcut,
			boolean shortcutRequired) {
		String found = "";

		for (Object o : editor.getDiagramEditPart().getChildren()) {
			if (o instanceof ShapeNodeEditPart) {
				ShapeNodeEditPart s = (ShapeNodeEditPart) o;
				if (!checkShortcut || isShortcut(s) == shortcutRequired) {
					EObject obj = s.resolveSemanticElement();
					if (obj instanceof Value) {
						Value p = (Value) obj;
						if (p.getName().equals("fieldValue")) {
							assertNotNull(s);
							return s;
						}
						found += p.getName() + ",";
					}
				}
			}
		}
		// failed
		fail("assertHasFieldValue: no fieldValue found. Found: " + found);
		return null;

	}

	/**
	 * Force the deletion of the given file, and halt until it is.
	 *
	 * @param diagram
	 * @throws Exception
	 */
	public void forceDelete(IFile diagram) throws Exception {
		diagram.delete(true, monitor);

		for (int i = 0; i < 300; i++) {
			getProject().refreshProject();
			if (!diagram.exists())
				return;		// done
			Thread.sleep(300);	// wait
		}

		fail("Could not successfully force delete diagram file '" + diagram + "'");

	}

	public void assertNotHasPage(DiagramDocumentEditor editor, String string) {
		boolean failed = false;
		try {
			assertHasFrame(editor, string);
			failed = true;
		} catch (AssertionFailedError e) {
			// expected
		}
		assertFalse("Editor had unexpected page '" + string + "'", failed);
	}

	public void assertNotHasInputTextField(DiagramDocumentEditor editor_page2, String string) {
		boolean failed = false;
		try {
			assertHasInputTextField(editor_page2, string);
			failed = true;
		} catch (AssertionFailedError e) {
			// expected
		}
		assertFalse("Editor had unexpected text field '" + string + "'", failed);
	}

	public void assertNotHasInputForm(DiagramDocumentEditor editor_page2, String string) {
		boolean failed = false;
		try {
			assertHasInputForm(editor_page2, string);
			failed = true;
		} catch (AssertionFailedError e) {
			// expected
		}
		assertFalse("Editor had unexpected input form '" + string + "'", failed);
	}

	/**
	 * Assert that the given list contains the given object
	 */
	public void assertContains(Object obj,
			List<? extends Object> list) {

		assertTrue("List should contain '" + obj + "': current list " + list, list.contains(obj));

	}

}
