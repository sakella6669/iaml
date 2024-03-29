/**
 * 
 */
package org.openiaml.model.tests.codegen.functions;

import org.openiaml.model.model.domain.DomainAttribute;
import org.openiaml.model.model.domain.DomainType;

/**
 * 
 * @author jmwright
 *
 */
public class HasDomainAttribute extends DroolsHelperFunctionsTestCase {

	@Override
	protected Class<? extends DroolsHelperFunctionsTestCase> getTestClass() {
		return HasDomainAttribute.class;
	}

	public void testNotPrimaryKey() throws Exception {
		
		DomainType d1 = assertHasDomainType(root, "Not Empty");
		DomainAttribute a1 = assertHasDomainAttribute(d1, "attr1");
		DomainType d3 = assertHasDomainType(root, "Generated Primary Key");
		DomainAttribute a2 = assertHasDomainAttribute(d3, "generated primary key");
		
		assertTrue(getHelper().notPrimaryKey(a1));
		assertFalse(getHelper().notPrimaryKey(a2));
		
	}
	
}
