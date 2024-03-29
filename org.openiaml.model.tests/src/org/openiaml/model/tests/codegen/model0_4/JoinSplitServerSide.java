/**
 * 
 */
package org.openiaml.model.tests.codegen.model0_4;

import org.openiaml.model.tests.CodegenTestCase;

/**
 * A JoinNode executing on the server-side.
 * 
 * @implementation JoinNode,SplitNode A {@model SplitNode} executing on 
 * 		the server will split execution into separate threads until 
 * 		each thread meets up at a {@model JoinNode}. 
 * @example JoinNode,SplitNode,ExecutionEdge {@model SplitNode Splitting} execution into
 * 		different threads on the server.
 * @author jmwright
 *
 */
public class JoinSplitServerSide extends CodegenTestCase {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		root = loadAndCodegen(JoinSplitServerSide.class);
	}
	
	/**
	 * This operation is executed as soon as we hit the page, so
	 * the field values should exist already.
	 * 
	 * @throws Exception
	 */
	public void testInitial() throws Exception {
		beginAtSitemapThenPage("Home");
		assertNoProblem();
		
		{
			String field = getLabelIDForText("field1");
			assertLabeledFieldEquals(field, "foo");
		}

		{
			String field = getLabelIDForText("field2");
			assertLabeledFieldEquals(field, "bar");
		}

		{
			String field = getLabelIDForText("field3");
			assertLabeledFieldEquals(field, "baz");
		}
		
		// there shouldn't be any button present
		assertButtonNotPresentWithText("target");
	}

}
