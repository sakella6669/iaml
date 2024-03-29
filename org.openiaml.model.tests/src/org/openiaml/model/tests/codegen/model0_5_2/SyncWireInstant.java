/**
 * 
 */
package org.openiaml.model.tests.codegen.model0_5_2;

import org.openiaml.model.tests.CodegenTestCase;


/**
 * Tests SyncWires with executeOnInput = true. Also tests 
 * InputTextField.onInput.
 */
public class SyncWireInstant extends CodegenTestCase {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		root = loadAndCodegen(SyncWireInstant.class);
	}

	/**
	 * The home page can be accessed.
	 * 
	 * @throws Exception 
	 */
	public void testHome() throws Exception {
		beginAtSitemapThenPage("Home");
		assertNoProblem();
	}
	
	/**
	 * We can update the 'normal' text fields as normal.
	 * 
	 * @throws Exception
	 */
	public void testInputNormal() throws Exception {
		beginAtSitemapThenPage("Home");
		
		{
			String target = getLabelIDForText("normal 1");
			assertLabeledFieldEquals(target, "");
			setLabeledFormElementField(target, "new value");
		}
		
		// updates as normal
		{
			String target = getLabelIDForText("normal 2");
			assertLabeledFieldEquals(target, "new value");
			setLabeledFormElementField(target, "another value");
		}

		// updates as normal
		{
			String target = getLabelIDForText("normal 1");
			assertLabeledFieldEquals(target, "another value");
		}

		// doesn't update other labels
		{
			String target = getLabelIDForText("instant 2");
			assertLabeledFieldEquals(target, "");
		}
		{
			String target = getLabelIDForText("mixed 2");
			assertLabeledFieldEquals(target, "");
		}

		assertNoProblem();
	}
	
	/**
	 * We can update the 'instant' text fields as normal.
	 * 
	 * @throws Exception
	 */
	public void testInputInstant() throws Exception {
		beginAtSitemapThenPage("Home");
		
		{
			String target = getLabelIDForText("instant 1");
			assertLabeledFieldEquals(target, "");
			setLabeledFormElementField(target, "new value");
		}
		
		// updates as normal
		{
			String target = getLabelIDForText("instant 2");
			assertLabeledFieldEquals(target, "new value");
			setLabeledFormElementField(target, "another value");
		}

		// updates as normal
		{
			String target = getLabelIDForText("instant 1");
			assertLabeledFieldEquals(target, "another value");
		}

		// doesn't update other labels
		{
			String target = getLabelIDForText("normal 2");
			assertLabeledFieldEquals(target, "");
		}
		{
			String target = getLabelIDForText("mixed 2");
			assertLabeledFieldEquals(target, "");
		}

		assertNoProblem();
	}
	
	/**
	 * As we type in characters into instant1, we will see
	 * the results in instant1.
	 * 
	 * @throws Exception
	 */
	public void testInstantInput() throws Exception {
		beginAtSitemapThenPage("Home");
		
		// currently empty
		{
			String target = getLabelIDForText("instant 1");
			assertLabeledFieldEquals(target, "");
			
			// type in a string
			typeLabeledFormElement(target, "new value");
		}
		
		// instant2 is updated already
		{
			String target = getLabelIDForText("instant 2");
			assertLabeledFieldEquals(target, "new value");
		}
		
		// type in some more into instant1
		{
			String target = getLabelIDForText("instant 1");
			assertLabeledFieldEquals(target, "new value");
			
			// type in a string
			typeLabeledFormElement(target, " and more");
		}
		
		// instant2 is updated already
		{
			String target = getLabelIDForText("instant 2");
			assertLabeledFieldEquals(target, "new value and more");
		}

		assertNoProblem();
	}
	
	/**
	 * If we type characters into normal1, they are not automatically
	 * updated into normal2, until we lose focus.
	 * 
	 * @throws Exception
	 */
	public void testInstantInputOnNormal() throws Exception {
		beginAtSitemapThenPage("Home");
		
		// currently empty
		{
			String target = getLabelIDForText("normal 1");
			assertLabeledFieldEquals(target, "");
			
			// type in a string
			typeLabeledFormElement(target, "new value");
			
			// is set
			assertLabeledFieldEquals(target, "new value");
		}
		
		// normal2 is not updated
		{
			String target = getLabelIDForText("normal 2");
			assertLabeledFieldEquals(target, "");
		}
		
		// until we lose focus on normal1
		{
			String target = getLabelIDForText("normal 1");
			
			// still set
			assertLabeledFieldEquals(target, "new value");
			
			// remove focus
			loseFocus(target);
		}
		
		// normal2 is now updated
		{
			String target = getLabelIDForText("normal 2");
			assertLabeledFieldEquals(target, "new value");
		}

		assertNoProblem();
	}


}
