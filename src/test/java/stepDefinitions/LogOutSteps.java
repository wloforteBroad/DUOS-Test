package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HeaderPage;

public class LogOutSteps {
	TestContext testContext;
	HeaderPage headerPage;
	
	public LogOutSteps(TestContext context) {
		testContext = context;
		headerPage = testContext.getPageObjectManager().getHeaderPage();
	}
	
	@When("^user enters clicks on User DropDown$")
	public void user_enters_clicks_on_User_DropDown() throws Throwable {
	    headerPage.clickOn_User();
	}
	
	@When("^clicks on Logout$")
	public void clicks_on_Logout() throws Throwable {
		Thread.sleep(1000);
	    headerPage.clickOn_SignOut();
	}
	
	@Then("^Sign in button is diplayed in header$")
	public void sign_in_button_is_diplayed_in_header() throws Throwable {
		Thread.sleep(1000);
	    assert headerPage.isUserLoguedOut();
	}
	

}
