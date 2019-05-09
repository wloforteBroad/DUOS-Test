package runners;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests", 
		glue = { "stepDefinitions" },
		tags = { "~@ignore", "~@tbd", "@run"},
		plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"},
		monochrome = true
		)

public class TestRunner {
	
	@BeforeClass
	public static void setup() {
		Date date = new Date();
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = fmt.format(date);
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("target/cucumber-reports/Test-Report_"+newDate+".html");
	}
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	}
}
