package com.testCases;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.utility.ReadConfig;

public class BaseClass {
    
	ReadConfig readconfig = new ReadConfig();
    public String baseURL=readconfig.getApplicationURL();
	public String userName= readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Log;
	
	@BeforeClass
public void Setup() {
	System.setProperty("Webdriver.chrome.driver", "chromeDriver.exe");
	driver = new ChromeDriver();
	
	 Log = Logger.getLogger("openbrix");
	PropertyConfigurator.configure("Log4j.properties");		
}
	
@AfterClass
	public void TearDown() {
		driver.quit();	
	}	
}
