package org.openiaml.model.tests.migration;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * All tests for the Migration functionality, without the Eclipse
 * overhead.
 * 
 * @author jmwright
 *
 */
public class AllMigrationTests {

	/**
	 * Get all the tests in this package and return as a test suite.
	 * 
	 * @return
	 */
    public static Test suite() { 
        TestSuite suite = new TestSuite("Migration");

        suite.addTestSuite(Migrate0_1SignupForm.class);
        suite.addTestSuite(Migrate0_2SyncPages.class);
        
        // model 0.3
        suite.addTestSuite(Migrate0_3FileDomainObjects.class);

        // model 0.4
        suite.addTestSuite(Migrate0_4JoinSplitClientSide.class);

        // model 0.5
        suite.addTestSuite(Migrate0_5IterateSyncWires.class);

        // model 0.6
        suite.addTestSuite(Migrate0_5_3IteratorCurrentPointer.class);

        return suite; 
   }

}
