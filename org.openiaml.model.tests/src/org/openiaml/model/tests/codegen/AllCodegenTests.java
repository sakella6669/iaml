package org.openiaml.model.tests.codegen;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.openiaml.model.tests.codegen.functions.AllHelperFunctionsTests;
import org.openiaml.model.tests.codegen.model0_1.AllModel0_1CodegenTests;
import org.openiaml.model.tests.codegen.model0_2.AllModel0_2CodegenTests;
import org.openiaml.model.tests.codegen.model0_3.AllModel0_3CodegenTests;
import org.openiaml.model.tests.codegen.model0_4.AllModel0_4CodegenTests;
import org.openiaml.model.tests.codegen.model0_4_1.AllModel0_4_1CodegenTests;
import org.openiaml.model.tests.codegen.model0_4_2.AllModel0_4_2CodegenTests;
import org.openiaml.model.tests.codegen.model0_4_3.AllModel0_4_3CodegenTests;
import org.openiaml.model.tests.codegen.model0_4_4.AllModel0_4_4CodegenTests;
import org.openiaml.model.tests.codegen.model0_5.AllModel0_5CodegenTests;
import org.openiaml.model.tests.codegen.model0_5_1.AllModel0_5_1CodegenTests;
import org.openiaml.model.tests.codegen.model0_5_2.AllModel0_5_2CodegenTests;
import org.openiaml.model.tests.codegen.model0_5_3.AllModel0_5_3CodegenTests;
import org.openiaml.model.tests.codegen.model0_6.AllModel0_6CodegenTests;
import org.openiaml.model.tests.codegen.oaw.AllOawTests;
import org.openiaml.model.tests.codegen.runtime.client.AllClientRuntimeTests;
import org.openiaml.model.tests.codegen.runtime.server.AllServerRuntimeTests;
import org.openiaml.model.tests.codegen.runtime.server.direct.AllDirectRuntimeTests;

/**
 * All tests for code generation.
 * 
 * @author jmwright
 *
 */
public class AllCodegenTests {

	/**
	 * Get all the tests in this package and return as a test suite.
	 * 
	 * @return
	 */
	public static Test suite() { 
		TestSuite suite = new TestSuite("Code Generation");
		
		// make sure we can catch exceptions
        suite.addTestSuite(TestExceptionHandling.class);

		// and that the client-side library exists
        suite.addTestSuite(TestClientsideRuntimeLibrary.class);

		// (issue 81) runtime libraries can be included
        suite.addTestSuite(TestIncludeLibraries.class);

		// OAW-specific tests
		suite.addTest(AllOawTests.suite());
		
		// issue 123: helper functions tests
		suite.addTest(AllHelperFunctionsTests.suite());

		// different model versions
		suite.addTest(AllModel0_1CodegenTests.suite());
		suite.addTest(AllModel0_2CodegenTests.suite());
		suite.addTest(AllModel0_3CodegenTests.suite());
		suite.addTest(AllModel0_4CodegenTests.suite());
		suite.addTest(AllModel0_4_1CodegenTests.suite());
		suite.addTest(AllModel0_4_2CodegenTests.suite());
		suite.addTest(AllModel0_4_3CodegenTests.suite());
		suite.addTest(AllModel0_4_4CodegenTests.suite());
		suite.addTest(AllModel0_5CodegenTests.suite());
		suite.addTest(AllModel0_5_1CodegenTests.suite());
		suite.addTest(AllModel0_5_2CodegenTests.suite());
		suite.addTest(AllModel0_5_3CodegenTests.suite());
		suite.addTest(AllModel0_6CodegenTests.suite());
		
		// client-side runtime library tests
		suite.addTest(AllClientRuntimeTests.suite());
		
		// server-side runtime library tests
		suite.addTest(AllServerRuntimeTests.suite());

		// runtime library tests called directly
		suite.addTest(AllDirectRuntimeTests.suite());

		return suite;
	}

}
