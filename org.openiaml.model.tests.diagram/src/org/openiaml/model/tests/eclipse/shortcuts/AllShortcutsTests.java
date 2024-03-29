package org.openiaml.model.tests.eclipse.shortcuts;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * All tests for the Eclipse editors shortcuts.
 * 
 * @author jmwright
 *
 */
public class AllShortcutsTests {

	/**
	 * Get all the tests in this package and return as a test suite.
	 * 
	 * @return
	 */
    public static Test suite() { 
        TestSuite suite = new TestSuite("Shortcuts");

        suite.addTestSuite(ShortcutsManyTestCase.class);
        suite.addTestSuite(ShortcutsOperationTestCase.class);
        suite.addTestSuite(ShortcutsRootTestCase.class);
        suite.addTestSuite(Issue47.class);
        suite.addTestSuite(Issue69.class);

        return suite; 
   }

}
