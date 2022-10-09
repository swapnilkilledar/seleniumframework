package com.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.AgentRegistration;

public class Tc_AgentRegistration extends BaseClass {
  
	@Test(priority = 8)
	public void validRegistrationAgent() throws InterruptedException {//pass
		
		driver.get(baseURL);
		Log.info("URL is opened");
		
		driver.findElement(By.xpath("//h4[text()=\"Agent Registration\"]")).click();
		
		AgentRegistration rp = new AgentRegistration(driver);
		rp.setFirstName("test");
		rp.setlastName("account10");
		rp.setEmail("testaccount181@yopmail.com"); // change email id while running new test case each time
		rp.setRegPassword("obxa123");
		rp.setRegConfirmPwd("obxa123");
		rp.signUpClick();
		String exp ="Registration successful, please login";
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-snackbar")));
		String act= driver.findElement(By.id("client-snackbar")).getText();
		
		System.out.println(act);
		Assert.assertEquals(act, exp);
	}
	@Test (priority = 9)
	public void allFieldBlankAgent() {//fail ok
		
		driver.get(baseURL);
		Log.info("URL is opened");
		
		driver.findElement(By.xpath("//h4[text()=\"Agent Registration\"]")).click();
		
		AgentRegistration rp = new AgentRegistration(driver);
		rp.setFirstName("");
		rp.setlastName("");
		rp.setEmail("");
		rp.setRegPassword("");
		rp.setRegConfirmPwd("");
		rp.signUpClick();
		String expFirstName = driver.findElement(By.id("first_name-helper-text")).getText();
		String explastName = driver.findElement(By.id("last_name-helper-text")).getText();
		String expEmail = driver.findElement(By.id("email-helper-text")).getText();
		String expPassword = driver.findElement(By.id("password-helper-text")).getText();
		String expConfirmPassword = driver.findElement(By.id("confirm-password-helper-text")).getText();
		Assert.assertEquals(expFirstName, "This field is required");
		Assert.assertEquals(explastName, "This field is required");
		Assert.assertEquals(expEmail, "This field is required");
		Assert.assertEquals(expPassword, "This field is required");
		Assert.assertEquals(expConfirmPassword, "This field is required");
		System.out.println(expConfirmPassword);	
	}
	@Test (priority = 10)
	public void InvalidAgentEmail() {//pass
		driver.get(baseURL);
		Log.info("URL is opened");
		
		driver.findElement(By.xpath("//h4[text()=\"Agent Registration\"]")).click();
		
		AgentRegistration rp = new AgentRegistration(driver);
		rp.setFirstName("test");
		rp.setlastName("account");
		rp.setEmail("invalid");
		rp.setRegPassword("obxa123");
		rp.setRegConfirmPwd("obxa123");
		rp.signUpClick();
		String act = driver.findElement(By.xpath("//p[text()=\"Email is not valid\"]")).getText();
		Assert.assertEquals(act, "Email is not valid");
	}
	@Test (priority = 11)
	public void AgentPasswordNotSame() {//pass
		driver.get(baseURL);
		Log.info("URL is opened");
		
		driver.findElement(By.xpath("//h4[text()=\"Agent Registration\"]")).click();
		
		AgentRegistration rp = new AgentRegistration(driver);
		rp.setFirstName("test");
		rp.setlastName("account");
		rp.setEmail("invalid");
		rp.setRegPassword("obxa123");
		rp.setRegConfirmPwd("obxa13");
		rp.signUpClick();
		String act = driver.findElement(By.xpath("//p[text()=\"Both Password not match\"]")).getText();
		Assert.assertEquals(act, "Both Password not match");
	}
	@Test (priority = 12)
	public void AgentAlreadyRegister() {//pass
		driver.get(baseURL);
		Log.info("URL is opened");
		
		driver.findElement(By.xpath("//h4[text()=\"Agent Registration\"]")).click();
		
		AgentRegistration rp = new AgentRegistration(driver);
		rp.setFirstName("test");
		rp.setlastName("account");
		rp.setEmail("athosuser@yopmail.com");
		rp.setRegPassword("obxa123");
		rp.setRegConfirmPwd("obxa123");
		rp.signUpClick();
		String exp = "User already Exists";
		System.out.println(exp);
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-snackbar")));
		String act = driver.findElement(By.id("client-snackbar")).getText();
		
		System.out.println(act);
		Assert.assertEquals(act, exp);
	}
}



