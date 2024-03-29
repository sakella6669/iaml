/**
 *
 */
package org.openiaml.model.tests.inference.model0_3;

import org.openiaml.model.model.InternetApplication;
import org.openiaml.model.model.domain.DomainAttributeInstance;
import org.openiaml.model.model.domain.DomainInstance;
import org.openiaml.model.model.domain.DomainIterator;
import org.openiaml.model.model.domain.DomainSource;
import org.openiaml.model.model.domain.DomainType;
import org.openiaml.model.model.visual.Frame;
import org.openiaml.model.model.visual.InputForm;
import org.openiaml.model.model.visual.InputTextField;
import org.openiaml.model.tests.inference.EclipseInheritanceInterface;

/**
 * Tests automatic mapping of SyncWires between InputForms and
 * DomainObjectInstances
 *
 * @author jmwright
 *
 */
public class InputFormInstanceMapping extends EclipseInheritanceInterface {

	@Override
	public Class<? extends EclipseInheritanceInterface> getTestClass() {
		return InputFormInstanceMapping.class;
	}
	
	/**
	 * Test that the correct new knowledge has not yet been added.
	 *
	 * @param root
	 * @throws Exception
	 */
	@Override
	public void checkNotInferredKnowledge(InternetApplication root) throws Exception {

		DomainSource ds = assertHasDomainSource(root, "domain source");
		assertNotGenerated(ds);
		DomainType user = assertHasDomainType(root, "User");
		assertNotGenerated(user);

		Frame page = assertHasFrame(root, "container");
		assertEquals("container", page.getName());

		// the form should be empty
		InputForm form = assertHasInputForm(page, "target input form");
		assertEquals(0, form.getChildren().size());

		assertEquals(2, page.getChildren().size());	// forms
		assertEquals(1, page.getIterators().size()); // domain object instance
		assertEquals(0, page.getLoginHandlers().size());
		assertEquals(0, page.getAccessHandlers().size());
		DomainIterator obj = assertHasDomainIterator(page, "User instance");

		// the instance should be empty
		assertNull(obj.getCurrentInstance());

		// the untargeted form should remain empty
		InputForm ignore = assertHasInputForm(page, "unrelated input form");
		assertEquals(0, ignore.getChildren().size());

	}


	/**
	 * Test that the correct new knowledge has been added.
	 *
	 * @param root
	 * @throws Exception
	 */
	@Override
	public void checkInferredKnowledge(InternetApplication root) throws Exception {

		DomainSource ds = assertHasDomainSource(root, "domain source");
		assertNotGenerated(ds);
		DomainType user = assertHasDomainType(root, "User");
		assertNotGenerated(user);

		Frame page = assertHasFrame(root, "container");
		assertEquals("container", page.getName());

		// the instance should NOT be empty
		assertEquals(2, page.getChildren().size());	// forms
		assertEquals(1, page.getIterators().size());	// domain object instance
		assertEquals(0, page.getLoginHandlers().size());
		assertEquals(0, page.getAccessHandlers().size());
		DomainIterator obj = assertHasDomainIterator(page, "User instance");

		// issue 241: there should now be a DomainInstance
		DomainInstance instance = obj.getCurrentInstance();
		assertGenerated(instance);
		
		// two attributes + generated primary key
		assertEquals(3, typeSelect(instance.getFeatureInstances(), DomainAttributeInstance.class).size());

		// get the domain attribute instances
		DomainAttributeInstance username = assertHasDomainAttributeInstance(instance, "username");
		assertEquals(username.getName(), "username");

		DomainAttributeInstance email = assertHasDomainAttributeInstance(instance, "email");
		assertEquals(email.getName(), "email");

		// the form should NOT be empty
		InputForm form = assertHasInputForm(page, "target input form");
		assertEquals(2, form.getChildren().size());

		{
			InputTextField text = assertHasInputTextField(form, "username");
			assertEquals("username", text.getName());

			// should have a sync wire
			assertHasWiresBidirectional(1, root, text, username);
		}
		{
			InputTextField text = assertHasInputTextField(form, "email");
			assertEquals("email", text.getName());

			// should have a sync wire
			assertHasWiresBidirectional(1, root, text, email);

		}

		// the untargeted form should remain empty
		InputForm ignore = assertHasInputForm(page, "unrelated input form");
		assertEquals(0, ignore.getChildren().size());

	}

}
