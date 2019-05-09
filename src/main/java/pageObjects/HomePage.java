package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "btn_gSignIn") 
	private WebElement btn_SignInGoogle;
	
	public void clickOn_SignInGoogle() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("btn_gSignIn")));
		btn_SignInGoogle.click();
	}

}
