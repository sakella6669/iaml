/**
 * 
 */
package org.openiaml.model.tests.codegen.model0_4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.openiaml.model.tests.codegen.DatabaseCodegenTestCase;

/**
 * Test a Login Handler in a Session, where the login handler
 * is authenticating against a domain object instance.
 * 
 * @example LoginHandler
 * 		The complete {@model WireEdge wire-based} implementation of a 
 * 		{@model LoginHandler} (selecting a
 * 		{@model DomainObject})
 * 
 * @operational LoginHandler
 * 		If a {@model LoginHandler} (selecting a {@model DomainObject}) has an outgoing
 * 		{@model NavigateWire navigation} to a {@model Page} named 'logout', the successful
 * 		logout of the current user will be redirected to this page.
 * 
 * @operational LoginHandler
 * 		If a {@model LoginHandler} (selecting a {@model DomainObject}) has an outgoing
 * 		{@model NavigateWire navigation} to a {@model Page} named 'login', the successful
 * 		logout of the current user will be redirected to this page.
 * 
 * @author jmwright
 *
 */
public class LoginHandlerInstanceComplete extends DatabaseCodegenTestCase {
	
	protected void setUp() throws Exception {
		super.setUp();
		root = loadAndCodegen(LoginHandlerInstanceComplete.class);
		initialiseDatabase();
	}
	
	@Override
	protected String getDatabaseName() {
		return "output/model_122f7c69efd_d.db";
	}

	@Override
	protected List<String> getDatabaseInitialisers() {
		List<String> s = new ArrayList<String>();
		s.add("CREATE TABLE User (generated_primary_key INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(64) NOT NULL, email VARCHAR(64) NOT NULL, password VARCHAR(64) NOT NULL)");
		s.add("INSERT INTO User (generated_primary_key, name, email, password) VALUES (12, 'User Default', 'default@jevon.org', 'test1')");
		s.add("INSERT INTO User (generated_primary_key, name, email, password) VALUES (22, 'User Two', 'target@jevon.org', 'test2')");
		s.add("INSERT INTO User (generated_primary_key, name, email, password) VALUES (42, 'User Three', 'test3@jevon.org', 'test3')");
		s.add("INSERT INTO User (generated_primary_key, name, email, password) VALUES (82, 'User Four', 'test4@jevon.org', 'test4')");
		return s;
	}
	
	/**
	 * The site should have a login page.
	 */
	public void testHasLoginPage() {
		IFile sitemap = getProject().getFile("output/sitemap.html");
		assertTrue("sitemap " + sitemap + " exists", sitemap.exists());

		beginAt(sitemap.getProjectRelativePath().toString());
		assertTitleMatch("sitemap");

		clickLinkWithText("login");
		assertTitleMatch("login");
		assertNoProblem();

	}

	/**
	 * The site should have a home page.
	 */
	public void testHasHomePage() {
		IFile sitemap = getProject().getFile("output/sitemap.html");
		assertTrue("sitemap " + sitemap + " exists", sitemap.exists());

		beginAt(sitemap.getProjectRelativePath().toString());
		assertTitleMatch("sitemap");

		clickLinkWithText("Home");
		assertTitleMatch("Home");
		assertNoProblem();

	}
	
	/**
	 * The site should have a current user page, that presents a problem (since
	 * we're not yet authenticated).
	 */
	public void testHasCurrentUserPage() {
		IFile sitemap = getProject().getFile("output/sitemap.html");
		assertTrue("sitemap " + sitemap + " exists", sitemap.exists());

		beginAt(sitemap.getProjectRelativePath().toString());
		assertTitleMatch("sitemap");

		clickLinkWithText("current user");
		assertProblem();	// who knows where we are?

	}
	
	/**
	 * The site should have a login successful page [generated], that presents a problem (since
	 * we're not yet authenticated).
	 */
	public void testHasLoginSuccesfulPage() {
		IFile sitemap = getProject().getFile("output/sitemap.html");
		assertTrue("sitemap " + sitemap + " exists", sitemap.exists());

		beginAt(sitemap.getProjectRelativePath().toString());
		assertTitleMatch("sitemap");

		clickLinkWithText("current user");
		assertProblem();	// who knows where we are?

	}

	/**
	 * The site should have a logout page, that presents a problem (since
	 * we're not yet authenticated).
	 * 
	 * Normally the user wouldn't see the "logout" link, but we should
	 * check that if they access it manually without being authenticated,
	 * that an error is thrown.
	 */
	public void testHasLogoutPage() {
		try {
			
		IFile sitemap = getProject().getFile("output/sitemap.html");
		assertTrue("sitemap " + sitemap + " exists", sitemap.exists());

		beginAt(sitemap.getProjectRelativePath().toString());
		assertTitleMatch("sitemap");

		clickLinkWithExactText("logout");
		assertProblem();	// who knows where we are?
		
		} catch (Error e) {
			System.out.println(getPageSource());
			throw e;
		}

	}

	/**
	 * We can't access the view key page without first
	 * logging in. It should redirect us to the login page.
	 */
	public void testCantAccessSecurePageWithoutSession() {
		IFile sitemap = getProject().getFile("output/sitemap.html");
		assertTrue("sitemap " + sitemap + " exists", sitemap.exists());

		beginAt(sitemap.getProjectRelativePath().toString());
		assertTitleMatch("sitemap");
	
		// try and view the key without having a valid session
		// it should go to the login page
		clickLinkWithText("current user");
		// TODO add: assertTitleNotMatch("viewkey");
		assertTitleMatch("login");
		assertProblem();		// we should have been warned

	}
	
	/**
	 * We can login; and then we can logout by going through the
	 * sitemap (since our model doesn't have a link to logout yet.)
	 * @throws Exception 
	 */
	public void testCanLoginLogoutFromSitemap() throws Exception {
		try {
		IFile sitemap = beginAtSitemapThenPage("login");
		assertNoProblem();
		
		String loginId = getLabelIDForText("password");
		setLabeledFormElementField(loginId, "test2");
		
		String emailId = getLabelIDForText("email");
		setLabeledFormElementField(emailId, "target@jevon.org");
		
		submit();		// submit the form
		waitForAjax();	// wait for ajax forms
		
		// we should now be on the viewkey page
		assertEquals("current user", getPageTitle());
		assertTitleMatch("current user");
		assertNoProblem();
		
		// now we just quickly go logout, we should now be on the
		// "logout successful" page
		gotoSitemapThenPage(sitemap, "logout", "logout destination");
		assertNoProblem();
		
		} catch (Error e) {
			System.out.println( getPageSource() );		// let us debug the page source
			throw e;		// continue throwing
		}

	}
	
	/**
	 * We login;
	 * We check the page to make sure we are the right user;
	 * We navigate to it again to check it's still there;
	 * Then we logout.
	 */
	public void testLoginLogoutCheck2() throws Exception {
		IFile sitemap = beginAtSitemapThenPage("login");
		assertNoProblem();
		
		String loginId = getLabelIDForText("password");
		setLabeledFormElementField(loginId, "test2");
		
		String emailId = getLabelIDForText("email");
		setLabeledFormElementField(emailId, "target@jevon.org");
		
		submit();		// submit the form
		waitForAjax();	// wait for ajax forms
		
		// we should now be on the "current user" page
		assertEquals("current user", getPageTitle());
		assertNoProblem();
		
		// lets now go to the "current user" page
		{
			String username = getLabelIDForText("current user name");
			assertLabeledFieldEquals(username, "User Two");
		}
		
		// the password should _not_ be present
		assertNoMatch("test2");
		
		// reload the page
		gotoSitemapThenPage(sitemap, "current user");
		{
			String username = getLabelIDForText("current user name");
			assertLabeledFieldEquals(username, "User Two");
		}
		
		// now we logout, we should now be on the logout page
		gotoSitemapThenPage(sitemap, "logout", "logout destination");
	}
	
	/**
	 * We login;
	 * We check the page to make sure we are the right user;
	 * We navigate to it again to check it's still there;
	 * Then we logout.
	 */
	public void testLoginLogoutCheck3() throws Exception {
		IFile sitemap = beginAtSitemapThenPage("login");
		assertNoProblem();
		
		String loginId = getLabelIDForText("password");
		setLabeledFormElementField(loginId, "test3");
		
		String emailId = getLabelIDForText("email");
		setLabeledFormElementField(emailId, "test3@jevon.org");
		
		submit();		// submit the form
		waitForAjax();	// wait for ajax forms
		
		// we should now be on the "current user" page
		assertEquals("current user", getPageTitle());
		assertNoProblem();
		{
			String username = getLabelIDForText("current user name");
			assertLabeledFieldEquals(username, "User Three");
		}
		
		// the password should _not_ be present
		assertNoMatch("test3");
		
		// reload the page
		gotoSitemapThenPage(sitemap, "current user");
		{
			String username = getLabelIDForText("current user name");
			assertLabeledFieldEquals(username, "User Three");
		}
		
		// now we logout, we should now be on the logout page
		gotoSitemapThenPage(sitemap, "logout", "logout destination");
	}
	
	/**
	 * Once we can login, we can change our name.
	 */
	public void testChangeName() throws Exception {
		IFile sitemap = beginAtSitemapThenPage("login");
		assertNoProblem();
		
		String loginId = getLabelIDForText("password");
		setLabeledFormElementField(loginId, "test4");
		
		String emailId = getLabelIDForText("email");
		setLabeledFormElementField(emailId, "test4@jevon.org");
		
		submit();		// submit the form
		waitForAjax();	// wait for ajax forms

		// we should now be on the "current user" page
		assertEquals("current user", getPageTitle());
		assertNoProblem();
		String newUsername = "my new username " + new Date();
		{
			String username = getLabelIDForText("current user name");
			assertLabeledFieldEquals(username, "User Four");
			
			// lets set it
			setLabeledFormElementField(username, newUsername);
			waitForAjax();
		}
		
		// reload the page, it should remain
		gotoSitemapThenPage(sitemap, "current user");
		{
			String username = getLabelIDForText("current user name");
			assertLabeledFieldEquals(username, newUsername);
		}
		
		// now we logout, we should now be on the logout page
		gotoSitemapThenPage(sitemap, "logout", "logout destination");
		
		// re-login to make sure the change was successful
		beginAtSitemapThenPage(sitemap, "login", "login");
		String loginId2 = getLabelIDForText("password");
		setLabeledFormElementField(loginId2, "test4");
		submit();		// submit the form
		waitForAjax();	// wait for ajax forms
		
		// we should now be on the "current user" page
		assertEquals("current user", getPageTitle());
		assertNoProblem();
		
		// lets now go to the "current user" page
		gotoSitemapThenPage(sitemap, "current user");
		{
			String username = getLabelIDForText("current user name");
			assertLabeledFieldEquals(username, newUsername);
		}
	}
	
	/**
	 * Test that we are actually comparing against the database
	 */
	public void testTryInvalidLogin() throws Exception {
		IFile sitemap = getProject().getFile("output/sitemap.html");
		assertTrue("sitemap " + sitemap + " exists", sitemap.exists());

		beginAt(sitemap.getProjectRelativePath().toString());
		assertTitleMatch("sitemap");

		clickLinkWithText("login");
		String loginId = getLabelIDForText("password");
		setLabeledFormElementField(loginId, "test6"); // INVALID password
		submit();		// submit the form
		waitForAjax();	// wait for ajax forms
		
		// we should not be on the "current user" page
		assertNotEquals("current user", getPageTitle());
		assertProblem();
		
	}

}
