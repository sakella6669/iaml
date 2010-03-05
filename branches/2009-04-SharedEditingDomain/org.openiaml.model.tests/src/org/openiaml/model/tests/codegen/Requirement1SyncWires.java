/**
 * 
 */
package org.openiaml.model.tests.codegen;

import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.openiaml.model.model.InternetApplication;
import org.openiaml.model.tests.CodegenTestCase;

/**
 * Tests requirement 1: sync wires.
 * 
 * @model ../examples/requirements/1-sync_wires.iaml 
 * @author jmwright
 *
 */
public class Requirement1SyncWires extends CodegenTestCase {
	
	protected InternetApplication root;
	
	protected void setUp() throws Exception {
		root = loadAndCodegen(ROOT + "../examples/requirements/1-sync_wires.iaml");
	}
	
	public void testRequirement() throws Exception {
		// go to sitemap
		IFile sitemap = getProject().getFile("output/sitemap.html");
		assertTrue("sitemap " + sitemap + " exists", sitemap.exists());
		
		// go to page
		beginAtSitemapThenPage(sitemap, "container");
		
		// fill in name and email
		String testName = "name " + new Date().toString();
		String testPassword = "password " + new Date().toString();
		{
			String nameId = getLabelIDForText("firstName");
			assertNotNull(nameId);
			assertLabeledFieldNotEquals(nameId, testName);
			setLabeledFormElementField(nameId, testName);
			String passId = getLabelIDForText("password");
			assertNotNull(passId);
			assertLabeledFieldNotEquals(passId, testPassword);
			setLabeledFormElementField(passId, testPassword);
		}
		
		// reload page
		gotoSitemapThenPage(sitemap, "container");
		waitForAjax();
		
		// should have changed
		{
			String nameId = getLabelIDForText("firstName");
			assertLabeledFieldEquals(nameId, testName);
			String passId = getLabelIDForText("password");
			assertLabeledFieldEquals(passId, testPassword);
		}
		
	}

}