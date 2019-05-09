package managers;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import enums.DriverType;
import enums.EnvironmentType;
import pageObjects.GoogleSignInPage;


public class WebDriverManager {
	
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private String browserName;
 
	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
 
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
 
	private WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case DEV : driver = createRemoteDriver();
	        	break;
	        case PROD : driver = createProdDriver();
        	break;
		   }
		   return driver;
	}
 
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createProdDriver() {
		throw new RuntimeException("ProdWebDriver is not yet implemented");
	}
 
	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX :
        	FirefoxOptions FirefoxOpts = new FirefoxOptions();
        	browserName = FirefoxOpts.getBrowserName().toLowerCase();
        	System.out.println(browserName);
        	driver = new FirefoxDriver(FirefoxOpts);
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	ChromeOptions chromeOpts = new ChromeOptions();
        	chromeOpts.addArguments("start-maximized");
        	browserName = chromeOpts.getBrowserName().toLowerCase();
        	System.out.println(browserName);
        	driver = new ChromeDriver(chromeOpts);
    		break;
        case CHROME_HEADLESS : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	ChromeOptions chromeHeadlessOpts = new ChromeOptions();
        	chromeHeadlessOpts.addArguments("--headless");
        	chromeHeadlessOpts.addArguments("window-size=1920,1080");
        	browserName = chromeHeadlessOpts.getBrowserName().toLowerCase();
        	System.out.println(browserName);
        	driver = new ChromeDriver(chromeHeadlessOpts);
    	break;
        case INTERNETEXPLORER : 
        	driver = new InternetExplorerDriver();
    		break;
        case SAFARI : 
        	driver = new SafariDriver();
		break;
        case FIREFOX_HEADLESS : 
        	FirefoxOptions FirefoxHeadlessOpts = new FirefoxOptions();
        	FirefoxHeadlessOpts.setHeadless(true);
        	driver = new FirefoxDriver(FirefoxHeadlessOpts);
	    break;
        }
 
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	
	
	public String getWindowsHandle() {
		return driver.getWindowHandle();
	}
	
	public  Set<String> getWindowsHandles() {
		return driver.getWindowHandles();
	}
	
	public void switchWindow(String window) {
		driver.switchTo().window(window);
	}
	
	public void changeWinSignIn(GoogleSignInPage googleSignInPage, String user, String password) throws InterruptedException {
		// Set Parent Window
		String parent = getWindowsHandle();
		// Number of Windows
		Set<String> s1 = getWindowsHandles();
		// Iterate
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			// If it's not Parent do things
			if (!parent.equals(child_window)) {
				switchWindow(child_window);
				googleSignInPage.signIn(user, password);
			}
		}
		// Switch back to parent window
		switchWindow(parent);
	}
	
	public void navigateToUrl(String url) {
		driver.get(url);
	}
 
	public void quitDriver() {
		driver.quit();
	}
	
	public void restartDriver() {
		driver.close();
		driver.quit();
		driver = null;
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
		if (browserName == "chrome") {
			((ChromeDriver) driver).getSessionStorage().clear();
			((ChromeDriver) driver).getLocalStorage().clear();
		} else if (browserName == "firefox") {
			((FirefoxDriver) driver).getSessionStorage().clear();
			((FirefoxDriver) driver).getLocalStorage().clear();
		}
	}

}
