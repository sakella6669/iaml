package org.openiaml.model.tests.release;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * All tests for release quality.
 * 
 * @author jmwright
 *
 */
public class AllReleaseTests {

	/**
	 * Get all the tests in this package and return as a test suite.
	 * 
	 * @return
	 */
    public static Test suite() { 
        TestSuite suite = new TestSuite("Release Quality");
		//$JUnit-BEGIN$
        suite.addTestSuite(PluginsTestCase.class);
        suite.addTestSuite(EcoreTestCase.class);
        suite.addTestSuite(GmfGraphTestCase.class);
        suite.addTestSuite(GmfToolTestCase.class);
        suite.addTestSuite(GmfMapTestCase.class);
        suite.addTestSuite(GmfGenTestCase.class);
        suite.addTestSuite(ParentNamesTestCase.class);
        suite.addTestSuite(NewWizardsTest.class);
        suite.addTestSuite(LicenceTest.class);
		//$JUnit-END$
        return suite; 
   }

}
