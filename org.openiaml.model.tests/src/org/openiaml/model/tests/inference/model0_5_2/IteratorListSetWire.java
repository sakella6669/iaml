/**
 *
 */
package org.openiaml.model.tests.inference.model0_5_2;

import org.openiaml.model.datatypes.BuiltinDataTypes;
import org.openiaml.model.model.ECARule;
import org.openiaml.model.model.EXSDDataType;
import org.openiaml.model.model.Event;
import org.openiaml.model.model.Function;
import org.openiaml.model.model.Operation;
import org.openiaml.model.model.Value;
import org.openiaml.model.model.domain.DomainAttribute;
import org.openiaml.model.model.domain.DomainAttributeInstance;
import org.openiaml.model.model.domain.DomainInstance;
import org.openiaml.model.model.domain.DomainIterator;
import org.openiaml.model.model.domain.DomainSource;
import org.openiaml.model.model.domain.DomainType;
import org.openiaml.model.model.visual.Frame;
import org.openiaml.model.model.visual.IteratorList;
import org.openiaml.model.model.visual.Label;
import org.openiaml.model.tests.inference.InferenceTestCase;

/**
 * Basic inference of an IteratorList connected to a DomainIterator by
 * a SetWire.
 *
 * @author jmwright
 */
public class IteratorListSetWire extends InferenceTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		root = loadAndInfer(IteratorListSetWire.class);
	}

	/**
	 * Test the initial model.
	 *
	 * @throws Exception
	 */
	public void testInitial() throws Exception {

		Frame home = assertHasFrame(root, "Home");

		DomainType news = assertHasDomainType(root, "News");
		DomainSource db = assertHasDomainSource(root, "Database");
		assertHasSchemaEdge(db, news);

		IteratorList list = assertHasIteratorList(home, "List");
		DomainIterator iterator = assertHasDomainIterator(home, "select three news");
		assertEquals(3, iterator.getLimit());

		assertHasSetWire(root, iterator, list);

		// iterator has a source
		assertHasSelectEdge(iterator, db);

		// attributes in the schema
		DomainAttribute id = assertHasDomainAttribute(news, "id");
		DomainAttribute title = assertHasDomainAttribute(news, "title");
		DomainAttribute content = assertHasDomainAttribute(news, "content");

		assertEquals(((EXSDDataType) id.getEType()).getDefinition().getURI(), BuiltinDataTypes.getTypeInteger().getURI());
		assertEquals(((EXSDDataType) title.getEType()).getDefinition().getURI(), BuiltinDataTypes.getTypeString().getURI());
		assertEquals(((EXSDDataType) content.getEType()).getDefinition().getURI(), BuiltinDataTypes.getTypeString().getURI());

	}

	/**
	 * The DomainIterator will have DomainAttributeInstances created.
	 *
	 * @throws Exception
	 */
	public void testDomainIteratorHasDomainAttributes() throws Exception {
		Frame home = assertHasFrame(root, "Home");
		DomainType news = assertHasDomainType(root, "News");
		DomainIterator iterator = assertHasDomainIterator(home, "select three news");
		DomainInstance instance = iterator.getCurrentInstance();
		assertGenerated(instance);

		DomainAttributeInstance iid = assertHasDomainAttributeInstance(instance, "id");
		DomainAttributeInstance ititle = assertHasDomainAttributeInstance(instance, "title");
		DomainAttributeInstance icontent = assertHasDomainAttributeInstance(instance, "content");

		assertGenerated(iid);
		assertGenerated(ititle);
		assertGenerated(icontent);

		// correct data types
		DomainAttribute id = assertHasDomainAttribute(news, "id");
		DomainAttribute title = assertHasDomainAttribute(news, "title");
		DomainAttribute content = assertHasDomainAttribute(news, "content");

		assertEqualType(id, iid);
		assertEqualType(title, ititle);
		assertEqualType(content, icontent);

	}

	/**
	 * The IteratorList will have Labels created within it.
	 *
	 * @throws Exception
	 */
	public void testLabelsCreatedInList() throws Exception {
		Frame home = assertHasFrame(root, "Home");
		DomainType news = assertHasDomainType(root, "News");
		IteratorList list = assertHasIteratorList(home, "List");

		Label lid = assertHasLabel(list, "id");
		Label ltitle = assertHasLabel(list, "title");
		Label lcontent = assertHasLabel(list, "content");

		assertGenerated(lid);
		assertGenerated(ltitle);
		assertGenerated(lcontent);
		assertFalse(lid.isVisible());
		assertTrue(ltitle.isVisible());
		assertTrue(lcontent.isVisible());

		// same data types
		// attributes in the schema
		DomainAttribute id = assertHasDomainAttribute(news, "id");
		DomainAttribute title = assertHasDomainAttribute(news, "title");
		DomainAttribute content = assertHasDomainAttribute(news, "content");

		assertEqualType(id, lid);
		assertEqualType(title, ltitle);
		assertEqualType(content, lcontent);

	}

	/**
	 * Each Label within the IteratorList will be connected by a SetWire.
	 *
	 * @throws Exception
	 */
	public void testLabelsConnectedBySetWire() throws Exception {
		Frame home = assertHasFrame(root, "Home");
		IteratorList list = assertHasIteratorList(home, "List");
		DomainIterator iterator = assertHasDomainIterator(home, "select three news");
		DomainInstance instance = iterator.getCurrentInstance();
		assertGenerated(instance);

		Label lid = assertHasLabel(list, "id");
		Label ltitle = assertHasLabel(list, "title");
		Label lcontent = assertHasLabel(list, "content");

		DomainAttributeInstance iid = assertHasDomainAttributeInstance(instance, "id");
		DomainAttributeInstance ititle = assertHasDomainAttributeInstance(instance, "title");
		DomainAttributeInstance icontent = assertHasDomainAttributeInstance(instance, "content");

		assertGenerated(assertHasSetWire(root, iid, lid));
		assertGenerated(assertHasSetWire(root, ititle, ltitle));
		assertGenerated(assertHasSetWire(root, icontent, lcontent));
	}

	/**
	 * DomainAttribute.onChange calls Label.update only if DomainAttribute exists
	 *
	 * @throws Exception
	 */
	public void testLabelUpdatedOnlyIfAttributeExists() throws Exception {
		Frame home = assertHasFrame(root, "Home");
		IteratorList list = assertHasIteratorList(home, "List");
		DomainIterator iterator = assertHasDomainIterator(home, "select three news");
		DomainInstance instance = iterator.getCurrentInstance();
		assertGenerated(instance);

		Label ltitle = assertHasLabel(list, "title");
		DomainAttributeInstance ititle = assertHasDomainAttributeInstance(instance, "title");
		assertGenerated(assertHasSetWire(root, ititle, ltitle));

		Event onChange = ititle.getOnChange();
		assertGenerated(onChange);

		Operation op = assertHasOperation(ltitle, "update");
		assertGenerated(op);

		ECARule run = assertHasRunAction(root, onChange, op);
		assertGenerated(run);

		// with ActivityParameter from attr instance
		Value value = assertHasFieldValue(ititle);
		assertGenerated(value);
		assertGenerated(assertHasParameter(root, value, run));

		Function cond = assertHasFunction(iterator, "not empty");

		assertGenerated(assertHasSimpleCondition(root, cond, run));
	}

}
