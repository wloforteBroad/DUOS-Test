package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs/Configurations.properties";
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("urlDev");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getAdminUserName() {
		String userName = properties.getProperty("userNameAdmin");
		if(userName != null) return userName;
		else throw new RuntimeException("adminUserName not specified in the Configuration.properties file.");
	}
	
	public String getAdminPassword() {
		String password = properties.getProperty("passwordAdmin");
		if(password != null) return password;
		else throw new RuntimeException("adminPassword not specified in the Configuration.properties file.");
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
		
	public String getDbUrl(){
		String dbUrl = properties.getProperty("dbUrl");
		if(dbUrl!= null) return dbUrl;
		else throw new RuntimeException("dbUrl not specified in the Configuration.properties file for the Key:dbUrl");		
	}
	
	public String getDbUser(){
		String dbUser = properties.getProperty("dbUser");
		if(dbUser!= null) return dbUser;
		else throw new RuntimeException("dbUser not specified in the Configuration.properties file for the Key:dbUser");		
	}
	
	public String getDbPass(){
		String dbPass = properties.getProperty("dbPass");
		if(dbPass!= null) return dbPass;
		else throw new RuntimeException("dbPass not specified in the Configuration.properties file for the Key:dbPass");		
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("firefox")) return DriverType.FIREFOX;
		else if(browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("chrome_headless")) return DriverType.CHROME_HEADLESS;
		else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else if(browserName.equals("safari")) return DriverType.SAFARI;
		else if(browserName.equals("firefox_headless")) return DriverType.FIREFOX_HEADLESS;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
 
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("dev")) return EnvironmentType.DEV;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}
	
	public String getMongoDbUrl(){
		String mongoDbUrl = properties.getProperty("mongoDbUrl");
		if(mongoDbUrl!= null) return mongoDbUrl;
		else throw new RuntimeException("mongoDbUrl not specified in the Configuration.properties file for the Key:mongoDbUrl");		
	}
	
	public String getMongoDbUser(){
		String mongoDbUser = properties.getProperty("mongoDbUser");
		if(mongoDbUser!= null) return mongoDbUser;
		else throw new RuntimeException("mongoDbUser not specified in the Configuration.properties file for the Key:mongoDbUser");		
	}
	
	public String getMongoDbPass(){
		String mongoDbPass = properties.getProperty("mongoDbPass");
		if(mongoDbPass!= null) return mongoDbPass;
		else throw new RuntimeException("mongoDbPass not specified in the Configuration.properties file for the Key:mongoDbPass");		
	}

}
