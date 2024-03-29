/**
 *
 */
package org.openiaml.model.tests.codegen.model0_4_1;

import org.openiaml.model.tests.CodegenTestCase;

/**
 * Testing the 'set' PrimitiveOperation with a readonly Value. This can also
 * be achieved with a {@model SetNode}.
 *
 * @author jmwright
 * @example BuiltinOperation,Value
 * 		Setting a {@model InputTextField text field} {@model Value}
 * 		to a {@model Value#readOnly} {@model Value static value}.
 * @implementation BuiltinOperation
 * 		If a {@model BuiltinOperation} is named 'set', it will
 * 		set the {@model Value target destination} to the value
 * 		of its {@model DataFlowEdge incoming edge}.
 */
public class SetValueStatic extends CodegenTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		root = loadAndCodegen(SetValueStatic.class);
	}

	/**
	 * Initially, the target is empty.
	 *
	 * @throws Exception
	 */
	public void testInitial() throws Exception {

		beginAtSitemapThenPage("Home");
		{
			String target = getLabelIDForText("target");
			assertLabeledFieldEquals(target, "");
		}
		assertButtonPresentWithText("execute");
		assertNoProblem();

	}

	/**
	 * Clicking the button will set the target value to the
	 * static value.
	 *
	 * @throws Exception
	 */
	public void testClick() throws Exception {

		testInitial();
		clickButtonWithText("execute");
		{
			String target = getLabelIDForText("target");
			assertLabeledFieldEquals(target, "hello42");
		}
		assertButtonPresentWithText("execute");
		assertNoProblem();

		// pressing it again will do nothing
		clickButtonWithText("execute");
		{
			String target = getLabelIDForText("target");
			assertLabeledFieldEquals(target, "hello42");
		}
		assertButtonPresentWithText("execute");
		assertNoProblem();

	}

}
