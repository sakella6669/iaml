/**
 * 
 */
package org.openiaml.model.tests.eclipse.migration;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

/**
 * Tests migrating a very old model version. 
 * 
 * @see #getModel()
 * @author jmwright
 *
 */
public class MigrateSignupForm extends AbstractMigrateTestCase {

	public void testLoadModel() throws Exception {

		// there should be four children
		assertEquals("there should be 2 children", 2, editor.getDiagramEditPart().getChildren().size());
		
		// check the contents
		ShapeNodeEditPart page = assertHasPage(editor, "SignupForm");
		ShapeNodeEditPart store = assertHasDomainStore(editor, "domain store");

		// here we could open the page/stores and see what they contain
		assertNotNull(page);
		assertNotNull(store);
		
	}

	public String getModel() {
		return "signup_form.iaml";
	}
	
	public String getModelMigrated() {
		return "signup_form2.iaml";
	}
	
}
