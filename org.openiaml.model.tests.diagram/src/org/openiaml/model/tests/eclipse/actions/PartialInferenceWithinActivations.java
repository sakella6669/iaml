/**
 * 
 */
package org.openiaml.model.tests.eclipse.actions;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.openiaml.model.custom.actions.InferEntireModelAction;
import org.openiaml.model.custom.actions.ProgressEnabledAction;
import org.openiaml.model.diagram.custom.actions.InferContainedElementsAction;
import org.openiaml.model.drools.CreateMissingElementsWithDrools;
import org.openiaml.model.drools.DroolsInferenceEngine;
import org.openiaml.model.drools.ICreateElementsFactory;

/**
 * Test partial inference, but makes sure that if we infer an element
 * that is contained within the containing element, and other elements
 * are created in the same activation that are outside the containing element,
 * that this original element is also deleted.
 * 
 * @see #getModel()
 * @author jmwright
 *
 */
public class PartialInferenceWithinActivations extends AbstractActionTestCase<GraphicalEditPart> {

	@Override
	public String getModel() {
		return "PartialInference.iaml";
	}
	
	protected DiagramDocumentEditor editor_page;
	
	/**
	 * We want our own Action to control the types of rules used.
	 * This method returns the "only contained elements" action.
	 * 
	 * @return
	 */
	protected ProgressEnabledAction<GraphicalEditPart> getAction() {
		return new InferContainedElementsAction() {

			@Override
			public DroolsInferenceEngine getEngine(ICreateElementsFactory handler) {
				return new CreateMissingElementsWithDrools(handler, true) {

					/**
					 * We need to extend this to use the testing classloader,
					 * not the drools plugin classloader.
					 */
					@Override
					public InputStream loadResourceAsStream(String filename) {
						return PartialInferenceWithinActivations.class.getResourceAsStream( filename );
					}
					
					@Override
					public List<String> getRuleFiles() {
						return getTestcaseRuleFiles();
					}
					
				};
			}
			
		};
	}
	
	/**
	 * We want our own Action to control the types of rules used.
	 * This method returns the "all elements in the model" action.
	 * 
	 * @return
	 */
	protected ProgressEnabledAction<IFile> getFullAction() {
		return new InferEntireModelAction() {

			@Override
			public DroolsInferenceEngine getEngine(ICreateElementsFactory handler) {
				return new CreateMissingElementsWithDrools(handler, true) {

					/**
					 * We need to extend this to use the testing classloader,
					 * not the drools plugin classloader.
					 */
					@Override
					public InputStream loadResourceAsStream(String filename) {
						return PartialInferenceWithinActivations.class.getResourceAsStream( filename );
					}
					
					@Override
					public List<String> getRuleFiles() {
						return getTestcaseRuleFiles();
					}
					
				};
			}
			
		};
	}
	
	protected List<String> getTestcaseRuleFiles() {
		return Arrays.asList(
				"/rules/test-partial.drl"
				);
	}
	
	/**
	 * Test the initial model.
	 * 
	 * @throws Exception
	 */
	public void testInitial() throws Exception {
		initializeModelFile();
		
		// there should only be two children
		assertEditorHasChildren(2, editor);
		
		// get contents
		assertHasFrame(editor, "target");
		assertHasFrame(editor, "other");
		
		// there should not be a page called 'outside activation'
		assertNotHasPage(editor, "created");
		
		// open page
		ShapeNodeEditPart page = assertHasFrame(editor, "target");
		editor_page = openDiagram(page);
		assertEditorFrame(editor_page);

		// there should not be a text field called 'created'
		assertNotHasInputTextField(editor_page, "created");

	}

	/**
	 * Test partial inference - should only create elements within
	 * the selected element.
	 * 
	 * @throws Exception
	 */
	public void testPartialInference() throws Exception {
		initializeModelFile();
		
		{
			// there should only be two children
			assertEditorHasChildren(2, editor);
			
			// get contents
			ShapeNodeEditPart target = assertHasFrame(editor, "target");
			assertHasFrame(editor, "other");
			
			// select the first text field and infer!
			runAction(getAction(), target);
			
			// save it
			editor.doSave(new NullProgressMonitor());
			
			// nothing should be added (remember we are using
			// a custom rule set)
			assertEditorHasChildren(2, editor);
			
			// however, if we open up the text field, there should be elements
			// in here generated
			editor_page = openDiagram(target);
	
			checkPartialInferenceEditor();
			
			editor_page.close(false);
			editor_page = null;
			editor.close(false);
			editor = null;
		}
		
		// delete the target diagram
		IFile model = getProject().getFile(getModel());
		IFile modelNew = getProject().getFile("new-model.iaml");
		IFile diagramNew = getProject().getFile("new-model.iaml_diagram");
		
		// infer entire model
		inferSourceModelFile(model, getFullAction());
		getProject().refreshProject();
		
		// try renaming the model file
		// (otherwise, it seems only the old diagram is stored in memory, and the test case below fails)
		model.move(modelNew.getFullPath(), true, monitor);
		getProject().refreshProject();
		
		assertTrue("New model file " + modelNew + " exists", modelNew.exists());
	
		// re-init diagram and reload
		initialiseAndLoadDiagram(modelNew, diagramNew);
		
		{
			// there should now be three children
			assertEditorHasChildren(3, editor);
			
			// get contents
			ShapeNodeEditPart target = assertHasFrame(editor, "target");
			assertHasFrame(editor, "other");
			assertHasFrame(editor, "outside activation");
			
			// however, if we open up the text field, there should be elements
			// in here generated
			editor_page = openDiagram(target);
			
			checkFullInferenceEditor();
		}
		
	}

	/**
	 * Test full inference - elements should be created everywhere.
	 * 
	 * @throws Exception
	 */
	public void testFullInference() throws Exception {
		// copy file
		copyLocalFile();
		
		// infer
		inferSourceModelFile(getProject().getFile(getModel()), getFullAction());
				
		// initialise and load the diagram file
		IFile targetModel = getProject().getFile(getModel());
		IFile targetDiagram = getProject().getFile(getDiagram());
		initialiseAndLoadDiagram(targetModel, targetDiagram);
	
		// there should now be three children
		assertEditorHasChildren(3, editor);
		
		// get contents
		ShapeNodeEditPart target = assertHasFrame(editor, "target");
		assertHasFrame(editor, "other");
		assertHasFrame(editor, "outside activation");
		
		// however, if we open up the text field, there should be elements
		// in here generated
		editor_page = openDiagram(target);
		
		checkFullInferenceEditor();	
	}

	/**
	 * Check the editor 'target' (editor_page) to make sure it's been _partially_ inferred.
	 */
	protected void checkPartialInferenceEditor() {
		assertEditorFrame(editor_page);
		
		assertEditorHasChildren(3, editor_page);
		
		// previously
		ShapeNodeEditPart t1 = assertHasInputTextField(editor_page, "target text field");
		assertNotGenerated(t1);
		ShapeNodeEditPart t2 = assertHasInputTextField(editor_page, "in sync");
		assertNotGenerated(t2);
		
		// generated
		ShapeNodeEditPart t3 = assertHasInputTextField(editor_page, "created");
		assertGenerated(t3);
		
		// no input form (outside activation)!
		assertNotHasInputForm(editor_page, "created");
		
	}
	
	/**
	 * Check the editor to make sure it's been _fully_ inferred.
	 */
	protected void checkFullInferenceEditor() {
		assertEditorFrame(editor_page);
		
		// plus an InputForm!
		assertEditorHasChildren(4, editor_page);
		
		// previously
		ShapeNodeEditPart t1 = assertHasInputTextField(editor_page, "target text field");
		assertNotGenerated(t1);
		ShapeNodeEditPart t2 = assertHasInputTextField(editor_page, "in sync");
		assertNotGenerated(t2);
		
		// generated
		ShapeNodeEditPart t3 = assertHasInputTextField(editor_page, "created");
		assertGenerated(t3);
		
		// no input form (outside activation)!
		ShapeNodeEditPart f1 = assertHasInputForm(editor_page, "created");
		assertGenerated(f1);
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
