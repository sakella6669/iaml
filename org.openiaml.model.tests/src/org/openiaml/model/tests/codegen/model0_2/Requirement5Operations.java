/**
 * 
 */
package org.openiaml.model.tests.codegen.model0_2;

import java.util.Random;

import org.openiaml.model.tests.CodegenTestCase;

/**
 * Tests requirement 5: operation composition
 * 
 * @author jmwright
 *
 */
public class Requirement5Operations extends CodegenTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		root = loadAndCodegen(Requirement5Operations.class, ROOT + "../examples/requirements/5-operations.iaml");
	}
	
	public void testRequirement() throws Exception {
		// go to sitemap
		beginAtSitemapThenPage("container");
		
		{
			// we will be changing the text field 'target' to various values
			String targetID = getLabelIDForText("target");
			String helloID = getLabelIDForText("setToHello");
			String worldID = getLabelIDForText("setToWorld");
			
			// initially target should be empty
			assertLabeledFieldEquals(targetID, "");
			
			// now if we change hello, the target should change to "hello"
			setLabeledFormElementField(helloID, "hello " + new Random().nextDouble());
			assertLabeledFieldEquals(targetID, "hello");
			
			// and if we change world, it will go to "world!"
			setLabeledFormElementField(worldID, "goodbye " + new Random().nextDouble());
			assertLabeledFieldEquals(targetID, "world!");
			
			// and change hello again, and it will go back
			setLabeledFormElementField(helloID, "hello again " + new Random().nextDouble());
			assertLabeledFieldEquals(targetID, "hello");
		}
		
	}

}
