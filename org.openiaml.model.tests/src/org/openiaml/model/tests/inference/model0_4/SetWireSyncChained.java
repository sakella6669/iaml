/**
 *
 */
package org.openiaml.model.tests.inference.model0_4;

import org.openiaml.model.model.BuiltinProperty;
import org.openiaml.model.model.ECARule;
import org.openiaml.model.model.Event;
import org.openiaml.model.model.Operation;
import org.openiaml.model.model.Value;
import org.openiaml.model.model.visual.Frame;
import org.openiaml.model.model.visual.InputTextField;
import org.openiaml.model.model.wires.ParameterEdgesSource;
import org.openiaml.model.tests.inference.InferenceTestCase;

/**
 * <pre>
 * Home              p2                p3
 * source --set--&gt; target &lt;--sync--&gt; changed
 * </pre>
 *
 * @author jmwright
 *
 */
public class SetWireSyncChained extends InferenceTestCase {

	/**
	 * Test the initial model.
	 *
	 * @throws Exception
	 */
	public void testInitial() throws Exception {
		root = loadDirectly(SetWireSyncChained.class);

		Frame home = assertHasFrame(root, "Home");
		Frame page2 = assertHasFrame(root, "page2");
		Frame page3 = assertHasFrame(root, "page3");
		InputTextField source = assertHasInputTextField(home, "source");
		InputTextField target = assertHasInputTextField(page2, "target");
		InputTextField changed = assertHasInputTextField(page3, "changed");

		assertNotGenerated(assertHasSetWire(root, source, target));
		assertNotGenerated(assertHasSyncWire(root, target, changed));

		assertNotGenerated(home);
		assertNotGenerated(page2);
		assertNotGenerated(page3);
		assertNotGenerated(source);
		assertNotGenerated(target);
		assertNotGenerated(changed);

	}

	/**
	 * target.onAccess should call target.init(source.value) only if source.isSet
	 *
	 * @throws Exception
	 */
	public void testTargetOnAccessFromSource() throws Exception {
		root = loadAndInfer(SetWireSyncChained.class, true);

		Frame home = assertHasFrame(root, "Home");
		Frame page2 = assertHasFrame(root, "page2");
		final InputTextField source = assertHasInputTextField(home, "source");
		InputTextField target = assertHasInputTextField(page2, "target");

		Event onAccess = target.getOnAccess();
		assertNotNull(onAccess);
		assertGenerated(onAccess);

		Operation init = assertHasOperation(target, "init");
		assertGenerated(init);

		ECARule run = assertHasRunAction(root, onAccess, init, new Filter<ECARule>() {
			@Override
			public boolean accept(ECARule r) {
				if (r.getInParameterEdges().size() != 1)
					return false;
				ParameterEdgesSource paramSource = r.getInParameterEdges().get(0).getParameterValue();
				if (paramSource.eContainer().equals(source))
					return true;
				return false;
			}
		});
		assertGenerated(run);

		Value sourceValue = assertHasFieldValue(source);
		assertGenerated(sourceValue);

		// parameter
		assertGenerated(assertHasParameter(root, sourceValue, run));
		// but there should only be one
		assertEquals(run.getInParameterEdges().toString(), 1, run.getInParameterEdges().size());

		BuiltinProperty cond = assertHasBuiltinProperty(source, "fieldValue is set");
		assertGenerated(cond);

		assertGenerated(assertHasSimpleCondition(root, cond, run));

	}

	/**
	 * target.onAccess should call target.init(source.value) only if changed.isSet
	 *
	 * @throws Exception
	 */
	public void testTargetOnAccessFromChanged() throws Exception {
		root = loadAndInfer(SetWireSyncChained.class);

		Frame page3 = assertHasFrame(root, "page3");
		Frame page2 = assertHasFrame(root, "page2");
		InputTextField target = assertHasInputTextField(page2, "target");
		final InputTextField changed = assertHasInputTextField(page3, "changed");

		Event onAccess = target.getOnAccess();
		assertNotNull(onAccess);
		assertGenerated(onAccess);

		Operation init = assertHasOperation(target, "init");
		assertGenerated(init);

		ECARule run = assertHasRunAction(root, onAccess, init, new Filter<ECARule>() {
			@Override
			public boolean accept(ECARule r) {
				if (r.getInParameterEdges().size() != 1)
					return false;
				ParameterEdgesSource paramSource = r.getInParameterEdges().get(0).getParameterValue();
				if (paramSource.eContainer().equals(changed))
					return true;
				return false;
			}
		});
		assertGenerated(run);

		Value sourceValue = assertHasFieldValue(changed);
		assertGenerated(sourceValue);

		// parameter
		assertGenerated(assertHasParameter(root, sourceValue, run));
		// but there should only be one
		assertEquals(run.getInParameterEdges().toString(), 1, run.getInParameterEdges().size());

		BuiltinProperty cond = assertHasBuiltinProperty(changed, "fieldValue is set");
		assertGenerated(cond);

		assertGenerated(assertHasSimpleCondition(root, cond, run));

	}

	/**
	 * source.onAccess should not do anything
	 *
	 * @throws Exception
	 */
	public void testsourceOnAccessDoesNothing() throws Exception {
		root = loadAndInfer(SetWireSyncChained.class);

		Frame home = assertHasFrame(root, "Home");
		InputTextField source = assertHasInputTextField(home, "source");

		Event onAccess = source.getOnAccess();
		assertNotNull(onAccess);
		assertGenerated(onAccess);

		// onAccess should do nothing!
		assertNoECARulesFrom(root, onAccess, ECARule.class);

	}

}
