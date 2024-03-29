package org.openiaml.model.tests.inference.model0_5_2;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * All inference tests for model 0.5.2.
 * 
 * @author jmwright
 *
 */
public class AllModel0_5_2InferenceTests {

	/**
	 * Get all the tests in this package and return as a test suite.
	 * 
	 * @return
	 */
	public static Test suite() { 
		TestSuite suite = new TestSuite("Model 0.5.2");
		
		suite.addTestSuite(SyncWireInstant.class);
		suite.addTestSuite(IteratorListSetWire.class);
		suite.addTestSuite(AutocompleteWireSimple.class);
		
		return suite;
	}
	
}
