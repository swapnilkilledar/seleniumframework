package user;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class openbrix {
	public static void main(String[] args) {
		
	
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);

		//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
		WebDriver driver = new ChromeDriver(options);
		//WebDriver driver = new ChromeDriver();
		driver.get("https://test.agent.openbrix.co.uk/");
		driver.manage().window().maximize();
		
	    driver.findElement(By.id("email")).sendKeys("athosuser@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("obxa123");
		driver.findElement(By.id("sign-in-agent")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myProperties")));
	    driver.findElement(By.id("myProperties")).click();
	   
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Sales\"]")));
	    driver.findElement(By.xpath("//span[text()=\"Sales\"]")).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Add new \"]")));
	    driver.findElement(By.xpath("//span[text()=\"Add new \"]")).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("let-enterFullPostCode")));
	    driver.findElement(By.id("let-enterFullPostCode")).sendKeys("e14obd");
	    
	    
	
	
	
	
	
}
}
