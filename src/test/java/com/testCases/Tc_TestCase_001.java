package com.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

public class Tc_TestCase_001 extends BaseClass {
   @Test
	public void LoginTest() {
		
		driver.get(baseURL);
		Log.info("URL is Opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		Log.info("Entered Username");
		
		lp.setPassword(password);
		Log.info("Entered Password");
		
		
		lp.clickSubmit();
		 
		if(driver.getTitle().equals("OpenBrix")) {
			Assert.assertTrue(true);
			Log.info("Login test pass");
		}else {
			Assert.assertTrue(false);
			Log.info("Login test fails");
		}
	}
   @Test
   public void InvalidEmail() {
	    driver.get(baseURL);
		Log.info("URL is Opened");
		
		LoginPage lp = new LoginPage(driver);
	   lp.setUserName("xyz");
	   lp.setPassword("123456");
	   lp.clickSubmit();
	   WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
	   
	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("client-snackbar"))));
	   String act = driver.findElement(By.id("email-helper-text")).getText();
	   Assert.assertEquals(act,"Email is not valid");
	   
   }

}

