package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
WebDriver driver;
	
	public HeaderPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "link_about") 
	private WebElement btn_About;
	
	@FindBy(how = How.ID, using = "link_help") 
	private WebElement btn_Help;
	
	@FindBy(how = How.ID, using = "link_signIn") 
	private WebElement btn_SignIn;
	
	@FindBy(how = How.ID, using = "link_join") 
	private WebElement btn_Join;
	
	@FindBy(how = How.ID, using = "link_memberConsole") 
	private WebElement btn_DacConsole;

	@FindBy(how = How.ID, using = "link_chairConsole") 
	private WebElement btn_ChairConsole;
	
	@FindBy(how = How.ID, using = "link_adminConsole") 
	private WebElement btn_AdminConsole;
	
	@FindBy(how = How.ID, using = "link_researcherConsole") 
	private WebElement btn_ResearcherConsole;
	
	@FindBy(how = How.ID, using = "link_dataOwnerConsole") 
	private WebElement btn_DataOwnerConsole;
	
	@FindBy(how = How.ID, using = "link_requestApplication") 
	private WebElement btn_RequestApplication;
	
	@FindBy(how = How.ID, using = "sel_statistics") 
	private WebElement btn_Stats;
	
	@FindBy(how = How.ID, using = "link_statistics") 
	private WebElement btn_VotesStats;
	
	@FindBy(how = How.ID, using = "link_reviewedCases") 
	private WebElement btn_ReviewedCases;
	
	@FindBy(how = How.ID, using = "link_datasetCatalog") 
	private WebElement btn_DatasetCatalog;
	
	@FindBy(how = How.ID, using = "sel_requestHelp") 
	private WebElement btn_RequestHelp;
	
	@FindBy(how = How.ID, using = "link_helpModal") 
	private WebElement btn_CreateReport;
	
	@FindBy(how = How.ID, using = "link_reportList") 
	private WebElement btn_ListReports;
	
	@FindBy(how = How.ID, using = "sel_dacUser") 
	private WebElement btn_User;
	
	@FindBy(how = How.ID, using = "link_signOut") 
	private WebElement btn_SignOut;
	
	
	public void clickOn_About() {
		btn_About.click();
	}
	
	public void clickOn_Help() {
		btn_Help.click();
	}
	
	public void clickOn_SignIn() {
		btn_SignIn.click();
	}
	
	public void clickOn_DacConsole() {
		btn_DacConsole.click();
	}
	
	public void clickOn_ChairConsole() {
		btn_ChairConsole.click();
	}
	
	public void clickOn_AdminConsole() {
		btn_AdminConsole.click();
	}
	
	public void clickOn_ResearcherConsole() {
		btn_ResearcherConsole.click();
	}
	
	public void clickOn_DataOwnerConsole() {
		btn_DataOwnerConsole.click();
	}
	
	public void clickOn_RequestApplication() {
		btn_RequestApplication.click();
	}
	
	public void clickOn_VotesStatistics() throws InterruptedException {
		btn_Stats.click();
		Thread.sleep(500);
		btn_VotesStats.click();
	}
	
	public void clickOn_ReviewedCases() throws InterruptedException {
		btn_Stats.click();
		Thread.sleep(500);
		btn_ReviewedCases.click();
	}
	
	public void clickOn_DatasetCatalog() {
		btn_DatasetCatalog.click();
	}
	
	public void clickOn_RequestHelp() throws InterruptedException {
		btn_RequestHelp.click();
	}
	
	public void clickOn_CreateReport() throws InterruptedException {
		btn_CreateReport.click();
	}
	
	public void clickOn_ListReports() throws InterruptedException {
		btn_ListReports.click();
	}
	
	public void clickOn_User() throws InterruptedException {
		btn_User.click();
	}
	
	public void clickOn_SignOut() throws InterruptedException {
		btn_SignOut.click();
	}
	
	public void signOut() throws InterruptedException {
		btn_User.click();
		btn_SignOut.click();
	}
	
	public boolean isUserLoguedOut() {
		try {
			return btn_SignIn.isDisplayed();
		}catch(NoSuchElementException e) {
			return false;
		}	
	}
	
	public void refreshPage() {
		btn_Help.sendKeys(Keys.F5);
	}
	
	public boolean isUserLoguedIn() {
		try {
			return btn_User.isDisplayed();
		}catch(NoSuchElementException e) {
			return false;
		}	
	}
	
	public void waitForAdminToLoad() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("link_adminConsole")));
    }
	
	public void waitForChairToLoad() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("link_chairConsole")));
    }
	
	public void waitForDACToLoad() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("link_memberConsole")));
    }
	
	public void waitForDataOwnerToLoad() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("link_dataOwnerConsole")));
    }

}
