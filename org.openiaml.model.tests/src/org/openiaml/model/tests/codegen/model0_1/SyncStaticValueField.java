/**
 * 
 */
package org.openiaml.model.tests.codegen.model0_1;

import org.openiaml.model.tests.CodegenTestCase;

/**
 * Testing a simple value to field sync wire.
 * 
 * property <--> text field
 * 
 * @author jmwright
 *
 */
public class SyncStaticValueField extends CodegenTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		root = loadAndCodegen(SyncStaticValueField.class);
	}
	
	public void testSync() throws Exception {
		// go to sitemap
		beginAtSitemapThenPage("target");

		// find the value
		String nameId = getLabelIDForText("current value");
		assertLabeledFieldEquals(nameId, "a default value");
		
	}

}
