/**
 *
 */
package org.openiaml.model.tests.inference.model0_5_1;

import org.openiaml.model.model.ECARule;
import org.openiaml.model.model.Event;
import org.openiaml.model.model.Operation;
import org.openiaml.model.model.Parameter;
import org.openiaml.model.model.QueryParameter;
import org.openiaml.model.model.Value;
import org.openiaml.model.model.domain.DomainAttributeInstance;
import org.openiaml.model.model.domain.DomainInstance;
import org.openiaml.model.model.domain.DomainIterator;
import org.openiaml.model.model.domain.DomainSource;
import org.openiaml.model.model.domain.DomainType;
import org.openiaml.model.model.visual.Button;
import org.openiaml.model.model.visual.Frame;
import org.openiaml.model.model.visual.InputForm;
import org.openiaml.model.model.visual.Label;
import org.openiaml.model.tests.inference.InferenceTestCase;

/**
 * We should be creating a lot of new elements in here.
 *
 * @author jmwright
 */
public class FeedProducerSimple extends InferenceTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		root = loadAndInfer(FeedProducerSimple.class);
	}

	/**
	 * The 'View News' page needs to require a 'generated primary key'
	 * parameter.
	 *
	 * @throws Exception
	 */
	public void testViewNewsPage() throws Exception {

		Frame view = assertHasFrame(root, "View News");
		assertNotGenerated(view);

		InputForm viewForm = assertHasInputForm(view, "View News");
		assertGenerated(viewForm);

		QueryParameter qp = assertHasQueryParameter(view, "generated primary key");
		assertGenerated(qp);

		DomainIterator instance = assertHasDomainIterator(view, "Current News instance");
		assertGenerated(instance);
		assertEquals(1, instance.getLimit());	// selecting one!

		// the order doesn't matter here

		// parameter
		assertGenerated(assertHasParameter(root, qp, instance));

		// a SetWire from the instance to the form
		assertGenerated(assertHasSetWire(root, instance, viewForm));

	}

	/**
	 * Since we are only selecting one on the 'view news' page, we should
	 * not have any navigation buttons.
	 *
	 * @throws Exception
	 */
	public void testViewNewsPageHasNoNavigationButtons() throws Exception {
		Frame view = assertHasFrame(root, "View News");
		InputForm viewForm = assertHasInputForm(view, "View News");

		assertHasNoButton(viewForm, "Next");
		assertHasNoButton(viewForm, "next");
		assertHasNoButton(viewForm, "Previous");
		assertHasNoButton(viewForm, "First");
		assertHasNoButton(viewForm, "Last");
		assertHasNoButton(viewForm, "Reset");

	}

	/**
	 * Test the contents of the 'Feed Item'
	 *
	 * @throws Exception
	 */
	public void testTargetFeedForm() throws Exception {
		Frame feed = assertHasFrame(root, "Target Feed");
		InputForm form = assertHasInputForm(feed, "Feed Item");

		// a Label 'title'
		assertGenerated(assertHasLabel(form, "title"));
		assertGenerated(assertHasLabel(form, "description"));
		assertGenerated(assertHasLabel(form, "updated"));

		// a Link 'link'
		Button button = assertHasButton(form, "link");
		assertGenerated(button);
	}

	/**
	 * The 'link' button should have an action to the 'view news' page
	 *
	 * @throws Exception
	 */
	public void testButtonHasNavigateAction() throws Exception {
		Frame view = assertHasFrame(root, "View News");

		Frame feed = assertHasFrame(root, "Target Feed");
		InputForm form = assertHasInputForm(feed, "Feed Item");

		// the 'generated primary key' is from the instance
		DomainIterator iterator = assertHasDomainIterator(feed, "recent news");
		DomainInstance instance = iterator.getCurrentInstance();
		assertGenerated(instance);
		DomainAttributeInstance pk = assertHasDomainAttributeInstance(instance, "generated primary key");
		assertGenerated(pk);

		Value pkValue = assertHasFieldValue(pk);
		assertGenerated(pkValue);

		// a Link 'link'
		Button button = assertHasButton(form, "link");
		Event onClick = button.getOnClick();

		ECARule nav = assertHasNavigateAction(root, onClick, view);

		// with a parameter
		Parameter param = assertHasParameter(root, pkValue, nav);
		assertEquals(param.getName(), "generated primary key");

	}

	/**
	 * The 'Feed Item' form should have navigation buttons created.
	 *
	 * @throws Exception
	 */
	public void testDatabaseTypes() throws Exception {
		Frame feed = assertHasFrame(root, "Target Feed");
		InputForm form = assertHasInputForm(feed, "Feed Item");

		// generated
		assertGenerated(assertHasButton(form, "Next"));
		assertGenerated(assertHasButton(form, "Previous"));
		assertGenerated(assertHasButton(form, "First"));
		assertGenerated(assertHasButton(form, "Last"));
		assertGenerated(assertHasLabel(form, "Results"));

	}

	/**
	 * Form.onAccess should update
	 * Label[results], i.e. the first number of results.
	 *
	 * @throws Exception
	 */
	public void testInstanceOnAccessUpdatesLabel() throws Exception {

		Frame feed = assertHasFrame(root, "Target Feed");
		InputForm form = assertHasInputForm(feed, "Feed Item");
		Label label = assertHasLabel(form, "Results");
		Operation update = assertHasOperation(label, "update");

		DomainIterator instance = assertHasDomainIterator(feed, "recent news");

		Event onAccess = form.getOnAccess();
		ECARule run = assertHasRunAction(root, onAccess, update);
		assertGenerated(run);

		Value count = instance.getResults();
		assertGenerated(assertHasParameter(root, count, run));

	}

	/**
	 * The generated DomainIterator will also be connected to the
	 * same DomainSource, referring to the same DomainSchema.
	 *
	 * @throws Exception
	 */
	public void testGeneratedIteratorHasSourceAndSchema() throws Exception {

		Frame view = assertHasFrame(root, "View News");
		Frame feed = assertHasFrame(root, "Target Feed");

		DomainIterator instance = assertHasDomainIterator(view, "Current News instance");
		assertEquals(1, instance.getLimit());	// selecting one

		// the [limit 10] iterator is connected to a source
		DomainIterator iterator10 = assertHasDomainIterator(feed, "recent news");
		assertEquals(10, iterator10.getLimit());

		assertEquals(1, iterator10.getOutSelects().size());
		DomainSource source = iterator10.getOutSelects().get(0).getTo();

		// connected to a DomainSchema
		DomainType schema = assertHasDomainType(root, "News");
		assertNotGenerated(schema);

		assertHasSelectEdge(iterator10, source);
		assertHasSchemaEdge(source, schema);

		// our [limit 1] iterator connects to the same source
		assertEquals(1, instance.getOutSelects().size());
		assertHasSelectEdge(instance, source);

	}

}
