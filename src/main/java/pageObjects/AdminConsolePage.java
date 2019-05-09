package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminConsolePage {
	WebDriver driver;
	
	public AdminConsolePage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "adminConsole_title")
	private WebElement lbl_Title;
	
	@FindBy(how = How.ID, using = "adminConsole_description")
	private WebElement lbl_Description;
	
	@FindBy(how = How.ID, using = "btn_manageDUL") 
	private WebElement btn_ManageDul;
	
	@FindBy(how = How.ID, using = "btn_addDUL") 
	private WebElement btn_AddDul;
	
	@FindBy(how = How.ID, using = "btn_manageUsers") 
	private WebElement btn_ManageUsers;
	
	@FindBy(how = How.ID, using = "btn_addUser") 
	private WebElement btn_AddUser;
	
	@FindBy(how = How.ID, using = "btn_manageDAR") 
	private WebElement btn_ManageDar;
	
	@FindBy(how = How.ID, using = "btn_addDataset") 
	private WebElement btn_AddDatasets;
	
	@FindBy(how = How.ID, using = "btn_electionTimeout") 
	private WebElement btn_ElectionTimeout;
	
	@FindBy(how = How.ID, using = "btn_invalidRequest") 
	private WebElement btn_InvalidRestrictions;
	
	@FindBy(how = How.ID, using = "btn_manageOntologies") 
	private WebElement btn_ManageOntologies;
	
	@FindBy(how = How.ID, using = "btn_addOntologies") 
	private WebElement btn_AddOntologies;

	@FindBys(@FindBy(className="admin-box-title"))
	private List<WebElement> allTitles;
	
	@FindBys(@FindBy(className="admin-box-description"))
	private List<WebElement> allDescriptions;
	
	private List<String> titleList = Arrays.asList("Manage Data Use Limitations", "Add Data Use Limitations", "Manage Users", "Add User", "Manage Data Access Request", "Add Datasets", "Set Data Owner election Timeout", "Invalid Request Restrictions", "Manage Ontologies", "Add Ontologies");
	
	private List<String> descriptionList = Arrays.asList("Select and manage Data Use Limitations Record for review", "Catalog a Data Use Limitation Record in the system", "Select and manage Users and their roles", "Catalog a new User in the system", "Select and manage Data Access Request for review", "Store Datasets associated with Data Use Limitations", "Manage Data Owner election expiration time", "Show Invalid Restrictions for Data Use Limitations and Data Access Requests", "Select and manage Ontologies for index", "Store Ontologies for index");
	
	public boolean isUserOnAdminConsole() {
		try {
			return lbl_Title.isDisplayed();
		}catch(NoSuchElementException e) {
			return false;
		}	
	}
	
	public void clickOn_ManageDul() {
		btn_ManageDul.click();
	}
	
	public void clickOn_AddDul() {
		btn_AddDul.click();
	}
	
	public void clickOn_ManageUsers() {
		btn_ManageUsers.click();
	}
	
	public void clickOn_AddUser() {
		btn_AddUser.click();
	}
	
	public void clickOn_ManageDar() {
		btn_ManageDar.click();
	}
	
	public void clickOn_AddDatasets() {
		btn_AddDatasets.click();
	}
	
	public List<WebElement> getAllTitles() {
        return allTitles;
    }
	
	public List<WebElement> getAllDescriptions() {
		return allDescriptions;
    }
	
	public boolean compareTitles() {
		boolean result = true;
		List<String> webList = new ArrayList<String>();
		for (WebElement title : allTitles) {
			webList.add(title.getText());
		}
		for (String title : titleList) {
			if (!webList.contains(title)) {
				result = false;
				System.out.println(webList.size());
				break;
			}
		}
		System.out.println(webList);
		System.out.println(titleList);
		return result;
	}
	
	public boolean compareDescriptions() {
		boolean result = true;
		List<String> webList = new ArrayList<String>();
		for (WebElement description : allDescriptions) {
			webList.add(description.getText());
		}
		for (String description : descriptionList) {
			if (!webList.contains(description)) {
				result = false;
				break;
			}
		}
		System.out.println(webList);
		System.out.println(descriptionList);
		return result;
	}
	
	public void waitForConsoleToLoad() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("btn_manageDUL")));
    }
	
	
}
