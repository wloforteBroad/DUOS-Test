package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.AdminConsolePage;
import pageObjects.GoogleSignInPage;
import pageObjects.HeaderPage;
import pageObjects.HomePage;


public class PageObjectManager {
	
	private WebDriver driver;
	private HomePage homePage;
	private GoogleSignInPage googleSingInPage;
	private AdminConsolePage adminConsole;
	private HeaderPage headerPage;

	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public GoogleSignInPage getGoogleSignInPage() {
		return (googleSingInPage == null) ? googleSingInPage = new GoogleSignInPage(driver) : googleSingInPage;
	}
	
	public AdminConsolePage getAdminConsolePage() {
		return (adminConsole == null) ? adminConsole = new AdminConsolePage(driver) : adminConsole;
	}
	
	
	public HeaderPage getHeaderPage() {
		return (headerPage == null) ? headerPage = new HeaderPage(driver) : headerPage;
	}

}
