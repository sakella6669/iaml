/**
 *
 */
package org.openiaml.model.tests.inference.model0_4;

import java.util.List;
import java.util.Set;

import org.openiaml.model.model.ECARule;
import org.openiaml.model.model.Event;
import org.openiaml.model.model.Operation;
import org.openiaml.model.model.Value;
import org.openiaml.model.model.Wire;
import org.openiaml.model.model.components.LoginHandler;
import org.openiaml.model.model.components.LoginHandlerTypes;
import org.openiaml.model.model.operations.ActivityOperation;
import org.openiaml.model.model.scopes.Session;
import org.openiaml.model.model.visual.Button;
import org.openiaml.model.model.visual.Frame;
import org.openiaml.model.model.visual.InputForm;
import org.openiaml.model.model.visual.InputTextField;
import org.openiaml.model.model.wires.SetWire;
import org.openiaml.model.tests.inference.ValidInferenceTestCase;

/**
 * Test case for inference of login handler[type=secret key]
 *
 * @author jmwright
 *
 */
public class LoginHandlerKey extends ValidInferenceTestCase {

	@Override
	public Class<? extends ValidInferenceTestCase> getInferenceClass() {
		return LoginHandlerKey.class;
	}

	/**
	 * Test the initial model.
	 *
	 * @throws Exception
	 */
	public void testInitial() throws Exception {
		root = loadDirectly(LoginHandlerKey.class);

		Frame page = assertHasFrame(root, "Home");
		assertNotGenerated(page);
		Session session = assertHasSession(root, "my session");
		assertNotGenerated(session);

		Value value = assertHasValue(session, "login key");
		assertTrue(value.isReadOnly());
		assertNotGenerated(value);

		Frame viewkey = assertHasFrame(session, "viewkey");
		assertNotGenerated(viewkey);

		LoginHandler handler = assertHasLoginHandler(session, "Login Handler");
		assertNotGenerated(handler);
		assertEquals(handler.getType(), LoginHandlerTypes.SECRET_KEY);

		// stored key
		Value key = assertHasValue(session, "my login key");
		assertNotGenerated(key);
		// the key must have a default
		assertNotNull(key.getDefaultValue());
		assertEquals("", key.getDefaultValue());

		// handler logout--> home
		{
			assertHasNoWiresFromTo(handler, handler, page);
			ECARule nav = assertHasNavigateAction(handler, handler, page, "logout");
			assertNotGenerated(nav);
		}

		// handler login--> viewkey
		{
			assertHasNoWiresFromTo(handler, handler, viewkey);
			ECARule nav = assertHasNavigateAction(handler, handler, viewkey, "success");
			assertNotGenerated(nav);
		}

		// handler set--> key
		{
			Set<Wire> wires = assertHasWiresFromTo(1, handler, handler, key);
			SetWire nav = (SetWire) wires.iterator().next();
			assertNotGenerated(nav);
			assertEquals("set", nav.getName());
		}

	}

	/**
	 * Test the generation of event triggers and check operations.
	 *
	 * @throws Exception
	 */
	public void testChecks() throws Exception {
		root = loadAndInfer(LoginHandlerKey.class);

		Session session = assertHasSession(root, "my session");

		Frame viewkey = assertHasFrame(session, "viewkey");
		assertNotGenerated(viewkey);

		Operation check = assertHasOperation(session, "check key");
		Event access = viewkey.getOnAccess();
		{
			ECARule run = assertHasRunAction(session, access, check);
			assertGenerated(run);
			assertEquals("run", run.getName());
		}

	}

	/**
	 * The logout page should execute the 'do logout' operation
	 *
	 * @throws Exception
	 */
	public void testLogoutOperation() throws Exception {
		root = loadAndInfer(LoginHandlerKey.class);

		Session session = assertHasSession(root, "my session");

		Frame page = assertHasFrame(root, "Home");
		assertNotGenerated(page);

		Operation op = assertHasOperation(session, "do logout");
		Event access = page.getOnAccess();
		{
			ECARule run = assertHasRunAction(session, access, op);
			assertGenerated(run);
		}

	}

	/**
	 * A default logout page should be created; this will
	 * only redirect to the actual logout page in our case.
	 *
	 * @throws Exception
	 */
	public void testGeneratedLogoutPage() throws Exception {
		root = loadAndInfer(LoginHandlerKey.class);

		Session session = assertHasSession(root, "my session");

		// a generated 'logout' page
		Frame page = assertHasFrame(session, "logout");
		assertGenerated(page);

		Frame target = assertHasFrame(root, "Home");
		assertNotGenerated(target);

		Event access = page.getOnAccess();
		{
			ECARule nav = assertHasNavigateAction(session, access, target);
			assertGenerated(nav);
		}
	}

	/**
	 * The session should only have one ApplicationElementProperty.
	 *
	 * @throws Exception
	 */
	public void testSessionProperties() throws Exception {
		root = loadAndInfer(LoginHandlerKey.class);

		Session session = assertHasSession(root, "my session");

		Value my = assertHasValue(session, "my login key");
		assertNotGenerated(my);
		assertFalse(my.isReadOnly());

		// in r2677, StaticValue was merged into Value[readOnly]
		Value key = assertHasValue(session, "login key");
		assertNotGenerated(key);
		assertTrue(key.isReadOnly());

		// shouldn't be generated
		assertHasNoValue(session, "current login key");

		// there should only be one
		assertEquals("Values found: " + session.getValues().toString(), 2, session.getValues().size());

		// there should be a SetWire from the LoginHandler to this
		LoginHandler loginHandler = assertHasLoginHandler(session, "Login Handler");
		assertNotGenerated(loginHandler);

		assertHasSetWire(session, loginHandler, my, "set");
	}

	/**
	 * A default login page should be created.
	 *
	 * @throws Exception
	 */
	public void testLoginPage() throws Exception {
		root = loadAndInfer(LoginHandlerKey.class);

		Session loginSession = assertHasSession(root, "Login Handler login");
		Frame login = assertHasFrame(loginSession, "login");
		assertGenerated(login);

		// it should contain a form
		InputForm form = assertHasInputForm(login, "login form");
		assertGenerated(form);

		// with a "login key" property
		InputTextField field = assertHasInputTextField(form, "login key");
		assertGenerated(field);

		// there should be a login button
		Button button = assertHasButton(form, "Login");
		assertGenerated(button);

		// a generated operation will handle the login
		Operation op = assertHasOperation(loginSession, "do login");
		assertGenerated(op);

		// button has an 'onClick' run wire
		ECARule run = assertHasECARule(root, button, op);
		assertGenerated(run);
		assertEquals("onClick", run.getName());

		// the text field has a parameter
		Value prop = assertHasFieldValue(field);
		assertGenerated(prop);

		// connecting to the run wire
		assertGenerated(getParameterFromTo(root, prop, run));

	}

	/**
	 * The 'check key' operation should have a fail wire that
	 * navigates to the login page.
	 *
	 * @throws Exception
	 */
	public void testCheckInstanceFailWire() throws Exception {
		root = loadAndInfer(LoginHandlerKey.class);

		Session session = assertHasSession(root, "my session");

		ActivityOperation check = assertHasActivityOperation(session, "check key");
		assertGenerated(check);

		Session loginSession = assertHasSession(root, "Login Handler login");
		assertGenerated(loginSession);

		// destination page
		Frame login = assertHasFrame(loginSession, "login");
		{
			ECARule wire = assertHasECARule(root, check, login, "fail");
			assertGenerated(wire);
		}

	}

	/**
	 * There should not be a 'check instance' operation generated in
	 * the session, since we are a LoginHandler[type=key].
	 *
	 * @throws Exception
	 */
	public void testNoCheckInstanceOperation() throws Exception {
		root = loadAndInfer(LoginHandlerKey.class);

		Session session = assertHasSession(root, "my session");

		assertHasNoOperation(session, "check instance");

	}

}
