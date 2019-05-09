package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "btn_gSignIn") 
	private WebElement btn_SignInGoogle;
	
	public void clickOn_SignInGoogle() {
		btn_SignInGoogle.click();
	}

}
