package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSignInPage {
	WebDriver driver;
	
	public GoogleSignInPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "identifierId") 
	private WebElement txtbx_UserName;
	
	@FindBy(how = How.ID, using = "identifierNext") 
	private WebElement btn_Next;
	
	@FindBy(how = How.NAME, using = "password") 
	private WebElement txtbx_Password;
	
	@FindBy(how = How.ID, using = "passwordNext") 
	private WebElement btn_PasswordNext;
	
	@FindBy(how = How.NAME, using = "Email") 
	private WebElement txtbx_UserNameOld;
	
	@FindBy(how = How.ID, using = "next") 
	private WebElement btn_NextOld;
	
	@FindBy(how = How.NAME, using = "Passwd") 
	private WebElement txtbx_PasswordOld;
	
	@FindBy(how = How.NAME, using = "signIn") 
	private WebElement btn_PasswordNextOld;
	
	
	public void enter_UserName(String name) {
		txtbx_UserName.sendKeys(name);
	}
	
	public void enter_Password(String pass) {
		txtbx_Password.sendKeys(pass);
	}
	
	public void clickOn_Next() {
		btn_Next.click();
	}
	
	public void clickOn_PasswordNext() {
		btn_PasswordNext.click();
	}
	
	public void enter_UserNameOld(String name) {
		txtbx_UserNameOld.sendKeys(name);
	}
	
	public void enter_PasswordOld(String pass) {
		txtbx_PasswordOld.sendKeys(pass);
	}
	
	public void clickOn_NextOld() {
		btn_NextOld.click();
	}
	
	public void clickOn_PasswordNextOld() {
		btn_PasswordNextOld.click();
	}
	
	public void signIn(String user, String password) throws InterruptedException {

			Thread.sleep(1000);
			if (txtbx_UserName.isDisplayed()) {
				enter_UserName(user);
				clickOn_Next();
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
				Thread.sleep(1000);
				enter_Password(password);
				clickOn_PasswordNext();
			} else {
				enter_UserNameOld(user);
				clickOn_NextOld();
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.name("Passwd")));
				Thread.sleep(1000);
				enter_PasswordOld(password);
				clickOn_PasswordNextOld();
			}


	}
	
}
