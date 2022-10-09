package com.testCases;



import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.UserLoginPage;

public class Tc_UserLoginPage extends BaseClass{

	@Test
	public void validUserLoginUser() throws InterruptedException {
		driver.get("https://test.openbrix.co.uk/sign-in/undefined");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserLoginPage lp = new UserLoginPage(driver);
		lp.setEmail("testaccount1@yopmail.com");
		lp.setPassword("obxt123");
		lp.ClickLogin();
		Thread.sleep(3000);
		String message = driver.getTitle();
		
		System.out.println(message);
		Assert.assertEquals(message, "IdentityAndFinance");
	}
	@Test
	public void UserloginWithoutCredentials() throws InterruptedException {
		driver.get("https://test.openbrix.co.uk/sign-in/undefined");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserLoginPage lp = new UserLoginPage(driver);
		lp.setEmail("");
		lp.setPassword("");
		lp.ClickLogin();
		Thread.sleep(1000);
		//String emailMessage = driver.findElement(By.xpath("//div[text()='Email is a required field']")).getText();
		
		Thread.sleep(1000);
	    String passwordMessage = driver.findElement(By.xpath("//div[text()='Password is a required field']")).getText();
	    //Assert.assertEquals(emailMessage, "Email is a required field");
	    Assert.assertEquals(passwordMessage, "Password is a required field");
	}
	
	@Test
	
	public void UserRegister() throws InterruptedException {
		driver.get("https://test.openbrix.co.uk/sign-in/undefined");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserLoginPage lp = new UserLoginPage(driver);
		lp.ClickRegister();
		Thread.sleep(1000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Register");
	}
	
	@Test
	public void UserClickForgotPassword() throws InterruptedException {
		driver.get("https://test.openbrix.co.uk/sign-in/undefined");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserLoginPage lp = new UserLoginPage(driver);
		lp.forgottenPassword();
		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Password Reset");
		
		
		
	}
	
	
	
	
	
	
}
