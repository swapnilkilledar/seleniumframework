package com.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

public class Tc_TestCase_001 extends BaseClass {
   @Test(priority = 0)
	public void ValidAgentLoginTest() {//pass
		
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
   @Test(priority = 2)
   public void InvalidAgentLoginEmail() {//pass
	    driver.get(baseURL);
		Log.info("URL is Opened");
		
	LoginPage lp = new LoginPage(driver);
	   	lp.setUserName("xyz@gmail.com");
	   	lp.setPassword("123456");
	   	lp.clickSubmit();
		String exp ="User not Found";
	   	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-snackbar")));
	   	String act = driver.findElement(By.id("client-snackbar")).getText();
	   	Assert.assertEquals(act,exp); 
   }
   @Test(priority = 1)
    public void AgentLoginWithoutCredentials() {// pass
	   driver.get(baseURL);
	   Log.info("URL is Opened");
	   LoginPage lp = new LoginPage(driver);
 	   lp.setUserName("");
 	   lp.setPassword("");
 	   lp.clickSubmit();
 	   String act = driver.findElement(By.xpath("//p[text()=\"This field is required\"]")).getText();
 	   Assert.assertEquals(act, "This field is required");
    }
   @Test (priority = 3)
   public void InvalidAgentLoginPassword() {//pass
	   driver.get(baseURL);
	   Log.info("URL is Opened");
	   LoginPage lp = new LoginPage(driver);
	   lp.setUserName("athosuser@yopmail.com");
	   lp.setPassword("12345");
	   lp.clickSubmit();
	   String exp = "Username or Password Mis-matched.";
	   WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(1000));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-snackbar")));
	   String act = driver.findElement(By.id("client-snackbar")).getText();
	   Assert.assertEquals(act,exp);    
   }
   @Test (priority = 4)
   public void InvalidAgentBothLoginCredentials() {//pass
	   driver.get(baseURL);
	   Log.info("URL is Opened");
	   LoginPage lp = new LoginPage(driver);
	   lp.setUserName("athosuse@yopmail.com");
	   lp.setPassword("12345");
	   lp.clickSubmit();
	   String exp ="User not Found";
	   WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(1000));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-snackbar")));
	   String act = driver.findElement(By.id("client-snackbar")).getText();
	   Assert.assertEquals(act,exp); 
   }
   @Test (priority = 5)
   public void AgentPropertySearchBtn() throws InterruptedException {//fail //ok
	   driver.get(baseURL);
	   Log.info("URL is Opened");
	   LoginPage lp = new LoginPage(driver);
	   lp.clickPropertySearch();
	   Thread.sleep(1000);
	  String act = driver.getTitle();
	  System.out.println(act);//OpenBrix
	   String exp = "OpenBrix - Property Portal for the new generation";
	   Assert.assertEquals(act,exp);  
   }
   @Test (priority = 6)
   public void AgentResetPassword() {//pass
	   driver.get(baseURL);
	   Log.info("URL is Opened");
	   LoginPage lp = new LoginPage(driver);
	   lp.clickResetPassword();
	   String exp = "OpenBrix";
	   Assert.assertEquals(driver.getTitle(),exp);
   }
  @Test (priority = 7)
   public void AgentDontHaveAccount() {//pass
	   driver.get(baseURL);
	   Log.info("URL is Opened");
	   LoginPage lp = new LoginPage(driver);
	   lp.clickDonthavAccount();
	   String exp = "OpenBrix";
	   String act = driver.getTitle();
	   System.out.println(act);//openbrix
	   Assert.assertEquals(driver.getTitle(),exp);
	   
   }
   }


