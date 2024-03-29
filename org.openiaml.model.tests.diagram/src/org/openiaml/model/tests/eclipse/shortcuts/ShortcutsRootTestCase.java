/**
 * 
 */
package org.openiaml.model.tests.eclipse.shortcuts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.openiaml.model.model.ModelPackage;

/**
 * Tests root shortcuts.
 * 
 * @see #getModel()
 * @author jmwright
 *
 */
public class ShortcutsRootTestCase extends AbstractShortcutsTestCase {

	@Override
	public String getModel() {
		return "shortcuts-root.iaml";
	}
	
	protected DiagramDocumentEditor editor_page;
	
	public void testLoadModel() throws Exception {
		initializeModelFile();

		// there should be three children (one of them is a shortcut)
		assertEditorHasChildren(3, editor);
		
		// check the contents
		ShapeNodeEditPart page = assertHasFrame(editor, "page");
		ShapeNodeEditPart op = assertHasOperation(editor, "op");
		ShapeNodeEditPart chained = assertHasEvent(editor, true, ModelPackage.eINSTANCE.getScope_OnInit());

		// they should be connected
		assertHasECARule(editor, chained, op, "run2");
		assertShortcut(chained);
		assertNotShortcut(page);
		assertNotShortcut(op);

		// open the page
		editor_page = openDiagram(page);

		assertEditorFrame(editor_page);

		// it should have a domain object
		assertEditorHasChildren(2, editor_page);
		ShapeNodeEditPart chained2 = assertHasEvent(editor_page, false, ModelPackage.eINSTANCE.getScope_OnInit());
		ShapeNodeEditPart op2 = assertHasOperation(editor_page, "op");

		// they should be connected
		assertHasECARule(editor_page, chained2, op2, "run2");
		assertShortcut(op2);
		assertNotShortcut(chained2);

		assertSameReferencedElement(chained, chained2);
		assertSameReferencedElement(op, op2);

	}
	
	/**
	 * Close loaded editors.
	 * @throws Exception 
	 */
	@Override
	public void tearDown() throws Exception {

		if (editor_page != null)
			editor_page.close(false);
		
		super.tearDown();
	}

}
