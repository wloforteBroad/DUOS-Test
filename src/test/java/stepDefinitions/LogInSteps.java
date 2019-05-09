package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.AdminConsolePage;
import pageObjects.GoogleSignInPage;
import pageObjects.HeaderPage;
import pageObjects.HomePage;

public class LogInSteps {
	
	TestContext testContext;
	GoogleSignInPage googleSignInPage;
	HomePage homePage;
	HeaderPage headerPage;
	AdminConsolePage adminConsolePage;
	
	public LogInSteps(TestContext context) {
		testContext = context;
		googleSignInPage = testContext.getPageObjectManager().getGoogleSignInPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		headerPage = testContext.getPageObjectManager().getHeaderPage();
		adminConsolePage = testContext.getPageObjectManager().getAdminConsolePage();
	}
	
	@Given("^The user is in the Home Page$")
	public void the_user_is_in_the_Home_Page() {
		testContext.getWebDriverManager().navigateToUrl(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	@Given("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() {
		headerPage.clickOn_SignIn();
		homePage.clickOn_SignInGoogle();
	}
	
	@When("^user enters correct AdminUserName and AdminPassword$")
	public void user_enters_correct_UserName_and_Password() throws InterruptedException {
		testContext.getWebDriverManager().changeWinSignIn(googleSignInPage, FileReaderManager.getInstance().getConfigReader().getAdminUserName(), FileReaderManager.getInstance().getConfigReader().getAdminPassword());
	}
	
	@Then("^user navigates to Admin Console$")
	public void user_navigates_to_Admin_Console() throws Throwable {
		headerPage.waitForAdminToLoad();
		headerPage.clickOn_AdminConsole();
	    assert adminConsolePage.isUserOnAdminConsole();
	}

}
