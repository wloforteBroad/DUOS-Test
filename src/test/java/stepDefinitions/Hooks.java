package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.deps.net.iharder.Base64;

public class Hooks {
	
	TestContext testContext;
	WebDriver driver;
	MySQLDBHelper db = new MySQLDBHelper();
	MongoDBHelper mongodb = new MongoDBHelper();
	 
	public Hooks(TestContext context) {
		testContext = context;
	}
 
	@Before
	public void BeforeSteps() {
	}
	 
	@After (order = 0)
	public void AfterSteps() {
		System.out.println("CLOSING DRIVER---------------------------------------------------------");
		testContext.getWebDriverManager().quitDriver();
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				Reporter.addScreenCaptureFromPath(addScreenshot(testContext.getWebDriverManager().getDriver()));
			} catch (IOException e) {
			} 
		}
	}
	
	private static String addScreenshot(WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(scrFile);
			byte[] bytes = new byte[(int) scrFile.length()];
			fileInputStreamReader.read(bytes);

			encodedBase64 = new String(Base64.encodeBytes(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "data:image/png;base64," + encodedBase64;
	}

}
