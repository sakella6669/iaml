/**
 *
 */
package org.openiaml.model.tests.inference.model0_3;

import org.openiaml.model.datatypes.BuiltinDataTypes;
import org.openiaml.model.model.InternetApplication;
import org.openiaml.model.model.domain.DomainAttribute;
import org.openiaml.model.model.domain.DomainSource;
import org.openiaml.model.model.domain.DomainStoreTypes;
import org.openiaml.model.model.domain.DomainType;
import org.openiaml.model.tests.inference.EclipseInheritanceInterface;

/**
 * Tests automatic mapping of DomainStores when connected to
 * Properties files
 *
 * @author jmwright
 *
 */
public class PropertiesFileMapping extends EclipseInheritanceInterface {

	@Override
	public Class<? extends EclipseInheritanceInterface> getTestClass() {
		return PropertiesFileMapping.class;
	}

	/* (non-Javadoc)
	 * @see org.openiaml.model.tests.inference.EclipseInheritanceInterface#checkNotInferredKnowledge(org.openiaml.model.model.InternetApplication)
	 */
	@Override
	public void checkNotInferredKnowledge(InternetApplication root)
			throws Exception {

		DomainSource ds = assertHasDomainSource(root, "my domain store");
		assertEquals(ds.getType(), DomainStoreTypes.PROPERTIES_FILE);
		
		// we don't have any DomainSchemas
		assertEquals(0, root.getTypes().size());

	}

	/* (non-Javadoc)
	 * @see org.openiaml.model.tests.inference.EclipseInheritanceInterface#checkInferredKnowledge(org.openiaml.model.model.InternetApplication)
	 */
	@Override
	public void checkInferredKnowledge(InternetApplication root)
			throws Exception {
		
		// generated
		DomainType schema = assertHasDomainType(root, "properties");
		assertGenerated(schema);

		assertEquals(4, schema.getEStructuralFeatures().size());	// four attributes (one is a generated primary key)

		{
			DomainAttribute attribute = assertHasDomainAttribute(schema, "fruit");
			assertEquals(attribute.getName(), "fruit");
			assertEqualType(BuiltinDataTypes.getTypeString(), attribute.getEType());
		}
		{
			DomainAttribute attribute = assertHasDomainAttribute(schema, "animal");
			assertEquals(attribute.getName(), "animal");
			assertEqualType(BuiltinDataTypes.getTypeString(), attribute.getEType());
		}
		{
			DomainAttribute attribute = assertHasDomainAttribute(schema, "empty");
			assertEquals(attribute.getName(), "empty");
			assertEqualType(BuiltinDataTypes.getTypeString(), attribute.getEType());
		}
		{
			DomainAttribute attribute = assertHasDomainAttribute(schema, "generated primary key");
			assertEquals(attribute.getName(), "generated primary key");
			assertTrue(attribute.isPrimaryKey());
			
			// primary keys are always integer
			assertEqualType(BuiltinDataTypes.getTypeInteger(), attribute.getEType());
		}

	}


}
