/**
 *
 */
package org.openiaml.model.tests.inference.model0_4;

import org.openiaml.model.datatypes.BuiltinDataTypes;
import org.openiaml.model.model.BuiltinProperty;
import org.openiaml.model.model.ECARule;
import org.openiaml.model.model.EXSDDataType;
import org.openiaml.model.model.Event;
import org.openiaml.model.model.Operation;
import org.openiaml.model.model.Parameter;
import org.openiaml.model.model.Value;
import org.openiaml.model.model.components.AccessControlHandler;
import org.openiaml.model.model.components.LoginHandler;
import org.openiaml.model.model.components.LoginHandlerTypes;
import org.openiaml.model.model.domain.DomainAttribute;
import org.openiaml.model.model.domain.DomainIterator;
import org.openiaml.model.model.operations.ActivityOperation;
import org.openiaml.model.model.operations.CancelNode;
import org.openiaml.model.model.operations.FinishNode;
import org.openiaml.model.model.operations.OperationCallNode;
import org.openiaml.model.model.operations.StartNode;
import org.openiaml.model.model.scopes.Session;
import org.openiaml.model.model.users.Role;
import org.openiaml.model.model.visual.Frame;
import org.openiaml.model.model.visual.InputForm;
import org.openiaml.model.model.visual.InputTextField;
import org.openiaml.model.model.wires.ExtendsEdge;
import org.openiaml.model.model.wires.RequiresEdge;
import org.openiaml.model.model.wires.SetWire;
import org.openiaml.model.tests.inference.InferenceTestCase;

/**
 * Inference of access control handlers.
 *
 * @author jmwright
 *
 */
public class UserRoles extends InferenceTestCase {

	/**
	 * Test the initial model.
	 *
	 * @throws Exception
	 */
	public void testInitial() throws Exception {
		root = loadDirectly(UserRoles.class);

		Frame page = assertHasFrame(root, "Home");
		assertNotGenerated(page);
		Role role = assertHasRole(root, "default role");
		assertNotGenerated(role);
		assertHasNone(role, "iaml:attributes");
		Session session = assertHasSession(root, "target session");
		assertNotGenerated(session);

		Frame target = assertHasFrame(session, "target");
		assertNotGenerated(target);

		AccessControlHandler ach = assertHasAccessControlHandler(session, "role-based access");
		assertNotGenerated(ach);
		RequiresEdge requires = assertHasRequiresEdge(session, ach, role);
		assertNotGenerated(requires);

		// there shouldn't be a login handler on this page
		assertHasNoLoginHandler(session, "role-based login handler");

		// or a logout page
		assertHasNoFrame(session, "logout");

		// or a login page in the root
		assertHasNoFrame(root, "login");

		// no operations in the ach or session
		assertEquals(0, ach.getOperations().size());
		assertEquals(0, session.getOperations().size());

		// or events in the target page
		assertNull(target.getOnAccess());
		assertNull(target.getOnInit());
	}

	/**
	 * There should be a default role 'User' generated
	 * in the user store.
	 *
	 * @throws Exception
	 */
	public void testDefaultUserRole() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Role guest = assertHasRole(root, "User");
		assertGenerated(guest);

	}

	/**
	 * Since there is an Access Control in the session, and no login handler,
	 * a login handler for the session should be created.
	 *
	 * @throws Exception
	 */
	public void testGeneratedLoginHandler() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");

		// the session should have a generated login handler
		LoginHandler handler = assertHasLoginHandler(session, "role-based login handler for target session");
		assertGenerated(handler);

		// the login handler should be of type 'user'
		assertEquals(handler.getType(), LoginHandlerTypes.USER);

		// so there should be a login page
		Session loginSession = assertHasSession(root, "role-based login handler for target session login");
		assertGenerated(loginSession);
		Frame login = assertHasFrame(loginSession, "login");
		assertGenerated(login);

		// and a logout page
		Frame logout = assertHasFrame(session, "logout");
		assertGenerated(logout);

	}

	/**
	 * The Login Handler[type=user] should generate a
	 * UserInstance in the session.
	 *
	 * @throws Exception
	 */
	public void testHandlerGeneratedUserInstance() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		LoginHandler handler = assertHasLoginHandler(session, "role-based login handler for target session");

		// user instance
		DomainIterator instance = assertHasDomainIterator(session, "current instance");
		assertGenerated(instance);

		// a Set wire: [handler] --> [instance]
		SetWire set = assertHasSetWire(session, handler, instance, "set");
		assertGenerated(set);

		// this user instance should have an 'empty' PrimitiveCondition
		BuiltinProperty exists = (BuiltinProperty) instance.getEmpty();
		assertGenerated(exists);

	}

	/**
	 * The Login Handler[type=user] should have an incoming
	 * ActivityParameter of 'User' - the default role/user instance
	 * to generate.
	 *
	 * @throws Exception
	 */
	public void testHandlerGeneratedUserParameter() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		LoginHandler handler = assertHasLoginHandler(session, "role-based login handler for target session");

		Role user = assertHasRole(root, "User");
		assertGenerated(user);

		// a ActivityParameter wire: [guest] --> [handler]
		Parameter param = assertHasParameter(session, user, handler);
		assertGenerated(param);

	}

	/**
	 * The Login Handler[type=user] should generate a
	 * "check instance" operation
	 *
	 * @throws Exception
	 */
	public void testHandlerGeneratedCheckInstance() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		LoginHandler handler = assertHasLoginHandler(session, "role-based login handler for target session");
		assertGenerated(handler);

		ActivityOperation check = assertHasActivityOperation(session, "check instance");
		assertGenerated(check);
	}

	/**
	 * <p>Since there is an Access Control in the session, the 'access'
	 * event on the target session should connect to a 'check permissions'
	 * operation owned by the access control.</p>
	 *
	 * <p>TODO Write up semantics: The events/operations are stored as part of the page, instead
	 * of the session, to allow for easy extensibility. For example,
	 * particular pages could redirect to different targets when the
	 * authentication check fails, or we could extend only certain
	 * pages with additional check constraints.</p>
	 *
	 * @throws Exception
	 */
	public void testGeneratedAccessEventSession() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		Frame target = assertHasFrame(session, "target");

		// access event in the session
		Event event = target.getOnAccess();
		assertGenerated(event);

		// check permissions operation contained in the session, not the page
		ActivityOperation pageOp = assertHasActivityOperation(target, "permissions check");
		assertGenerated(pageOp);

		// connected
		ECARule run = assertHasECARule(target, event, pageOp, "run");
		assertGenerated(run);

		// a failure wire connecting the op to the login page
		Session loginSession = assertHasSession(root, "role-based login handler for target session login");
		Frame login = assertHasFrame(loginSession, "login");
		ECARule fail = assertHasECARule(root, pageOp, login, "fail");
		assertGenerated(fail);

	}

	/**
	 * There should not be a 'permissions check' in the target session;
	 * this is part of the page.
	 *
	 * @throws Exception
	 */
	public void testGeneratedAccessEventNotPage() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		Frame target = assertHasFrame(session, "target");

		// access event in the page
		Event event = session.getOnAccess();
		assertGenerated(event);

		// check permissions operation contained in the session, not the page
		assertHasNoOperation(session, "permissions check");
		
		ActivityOperation sessionOp = assertHasActivityOperation(target, "permissions check");
		assertGenerated(sessionOp);
	}

	/**
	 * Even though the ACH adds a run wire from 'access' to 'check permissions',
	 * there should still be a 'check user' operation as well.
	 * (i.e. an event trigger can have two outgoing run wires.)
	 *
	 * @throws Exception
	 */
	public void testAccessEventHasCheckUserOperation() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		Frame target = assertHasFrame(session, "target");

		// find 'check instance'
		ActivityOperation check = assertHasActivityOperation(session, "check instance");
		assertGenerated(check);

		// access event
		Event event = target.getOnAccess();
		assertGenerated(event);

		// connected
		ECARule run = assertHasECARule(target, event, check, "run");
		assertGenerated(run);

		// a failure wire connecting the op to the login page
		Session loginSession = assertHasSession(root, "role-based login handler for target session login");
		Frame login = assertHasFrame(loginSession, "login");
		ECARule fail = assertHasECARule(root, check, login, "fail");
		assertGenerated(fail);

	}

	/**
	 * Check the generated contents of the 'permission check' operation
	 * in the target page.
	 *
	 * @throws Exception
	 */
	public void testGeneratedPermissionCheckOperationContents() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		AccessControlHandler ach = assertHasAccessControlHandler(session, "role-based access");
		Frame target = assertHasFrame(session, "target");

		// the actual 'check permissions' operation in the ACH
		Operation targetOp = assertHasOperation(ach, "check permissions");
		assertGenerated(targetOp);

		// access event
		Event event = session.getOnAccess();
		assertGenerated(event);

		// check permissions operation contained in the page
		ActivityOperation op = assertHasActivityOperation(target, "permissions check");
		assertGenerated(op);

		StartNode start = assertHasStartNode(op);
		assertGenerated(start);
		FinishNode end = assertHasFinishNode(op);
		assertGenerated(end);
		CancelNode cancel = assertHasCancelNode(op);
		assertGenerated(cancel);
		OperationCallNode virtualOp = assertHasOperationCallNode(op, "call permissions operation");
		assertGenerated(virtualOp);
		ECARule virtualRun = assertHasECARule(op, virtualOp, targetOp, "run");
		assertGenerated(virtualRun);

		// execution edges between all the operations
		assertGenerated(assertHasExecutionEdge(op, start, virtualOp));
		assertGenerated(assertHasExecutionEdge(op, virtualOp, end));
		assertGenerated(assertHasExecutionEdge(op, virtualOp, cancel));

	}

	/**
	 * The AccessControlHandler should have an incoming UserInstance
	 * as a parameter.
	 *
	 * @throws Exception
	 */
	public void testHasIncomingUserInstance() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		AccessControlHandler ach = assertHasAccessControlHandler(session, "role-based access");
		DomainIterator instance = assertHasDomainIterator(session, "current instance");

		Parameter param = assertHasParameter(session, instance, ach);
		assertGenerated(param);

	}

	/**
	 * The 'default role' should extend 'User'
	 *
	 * @throws Exception
	 */
	public void testDefaultRoleExtendsGuest() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Role guest = assertHasRole(root, "User");
		assertGenerated(guest);
		Role role = assertHasRole(root, "default role");
		assertNotGenerated(role);

		ExtendsEdge ext = assertHasExtendsEdge(root, role, guest);
		assertGenerated(ext);

	}

	/**
	 * 'User' should have 'email' and 'password' attributes; these
	 * are the default requirements for Users
	 *
	 * @throws Exception
	 */
	public void testGuestAttributes() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Role guest = assertHasRole(root, "User");

		DomainAttribute email = assertHasDomainAttribute(guest, "email");
		assertGenerated(email);
		DomainAttribute password = assertHasDomainAttribute(guest, "password");
		assertGenerated(password);

		// check the types
		assertEqualType(BuiltinDataTypes.getTypeEmail(), ((EXSDDataType) email.getEType()).getDefinition());
		// TODO password needs to have iamlPassword data type

	}

	/**
	 * Since Default Role extends User, the attributes of User
	 * will be reproduced in Default Role.
	 *
	 * @throws Exception
	 */
	public void testInheritanceOfAttributes() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Role guest = assertHasRole(root, "User");

		DomainAttribute email = assertHasDomainAttribute(guest, "email");
		assertGenerated(email);
		DomainAttribute password = assertHasDomainAttribute(guest, "password");
		assertGenerated(password);

		Role role = assertHasRole(root, "default role");

		DomainAttribute email2 = assertHasDomainAttribute(role, "email");
		assertGenerated(email2);
		DomainAttribute password2 = assertHasDomainAttribute(role, "password");
		assertGenerated(password2);

		// there should be extends wires between each attribute
		assertGenerated(assertHasExtendsEdge(root, email2, email));
		assertGenerated(assertHasExtendsEdge(root, password2, password));

		// none the other way around
		assertHasNoExtendsEdge(root, email, email2);
		assertHasNoExtendsEdge(root, password, password2);
		assertHasNoExtendsEdge(root, email, email);
		assertHasNoExtendsEdge(root, email, password);
		assertHasNoExtendsEdge(root, password2, email);

	}

	/**
	 * Since Default Role extends User, there will be an
	 * ID in Default Role which will be the index/foreign key
	 * of Guest.
	 *
	 * @throws Exception
	 */
	public void testInheritancePrimaryKeys() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Role guest = assertHasRole(root, "User");

		DomainAttribute source_id = assertHasDomainAttribute(guest, "generated primary key");
		assertGenerated(source_id);

		Role role = assertHasRole(root, "default role");

		DomainAttribute id = assertHasDomainAttribute(role, "generated primary key");
		assertGenerated(id);
		DomainAttribute fk = assertHasDomainAttribute(role, "User.generated primary key");
		assertGenerated(fk);

		// there should be an extends wire between the PK and FK
		assertGenerated(assertHasExtendsEdge(root, fk, source_id));

		// and none between the PK and PK
		assertHasNoExtendsEdge(root, id, source_id);
		assertHasNoExtendsEdge(root, source_id, id);

		// check the types of the keys
		assertEqualType(BuiltinDataTypes.getTypeInteger(), ((EXSDDataType) id.getEType()).getDefinition());
		assertEqualType(id, fk);
		assertEqualType(BuiltinDataTypes.getTypeInteger(), ((EXSDDataType) fk.getEType()).getDefinition());

	}

	/**
	 * The generated login form on the generated 'login' page
	 * should have 'email' and 'password' fields.
	 *
	 * @throws Exception
	 */
	public void testLoginFormAttributes() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session loginSession = assertHasSession(root, "role-based login handler for target session login");
		Frame login = assertHasFrame(loginSession, "login");
		assertGenerated(login);

		InputForm form = assertHasInputForm(login, "login form");
		assertGenerated(form);

		InputTextField email = assertHasInputTextField(form, "email");
		assertGenerated(email);
		InputTextField password = assertHasInputTextField(form, "password");
		assertGenerated(password);

		// but not an 'generated primary key'
		assertHasNoInputTextField(form, "generated primary key");

	}

	/**
	 * The session should have 'email' and 'password' properties.
	 *
	 * @throws Exception
	 */
	public void testSessionProperties() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		assertNotGenerated(session);

		Value email = assertHasValue(session, "current email");
		assertGenerated(email);
		Value password = assertHasValue(session, "current password");
		assertGenerated(password);

		// but not an 'generated primary key'
		assertHasNoValue(session, "current generated primary key");

	}

	/**
	 * The UserInstance should have a SelectWire from the given Role
	 * with the current Value values as parameters.
	 *
	 * @throws Exception
	 */
	public void testUserInstanceSelectWires() throws Exception {
		root = loadAndInfer(UserRoles.class);

		Session session = assertHasSession(root, "target session");
		assertNotGenerated(session);

		Value email = assertHasValue(session, "current email");
		Value password = assertHasValue(session, "current password");

		// user instance
		DomainIterator instance = assertHasDomainIterator(session, "current instance");

		// the query should be one of these values
		assertEqualsOneOf(new String[]{
				"email = :email and password = :password",
				"password = :password and email = :email"
		}, instance.getQuery());

		// parameters
		Parameter p1 = assertHasParameter(root, email, instance);
		assertGenerated(p1);
		Parameter p2 = assertHasParameter(root, password, instance);
		assertGenerated(p2);

	}

}
