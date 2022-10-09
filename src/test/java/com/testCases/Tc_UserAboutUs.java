package com.testCases;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.pageObjects.UserAboutUsPage;

public class Tc_UserAboutUs extends BaseClass {
 
	@Test (priority =0)
	public void UserValidEntry() throws InterruptedException {
		driver.get("https://test.openbrix.co.uk/about-us");
		Log.info("URL is opened");
		driver.manage().window().maximize();
	
		UserAboutUsPage ap = new UserAboutUsPage(driver);
		
		ap.SetFirstName("test");
		ap.SetLastName("account");
		ap.SetEmail("testaccount@yopmail.com");
		ap.SetTelephone("789456123");
		ap.ClickSubmit();
		Thread.sleep(1000);
		
		String message =driver.switchTo().alert().getText();
		Assert.assertEquals(message,"Mail sent successfully");
		
	}
     @Test(priority =1)
	public void UserAllBlankEntry() throws InterruptedException {
		driver.get("https://test.openbrix.co.uk/about-us");
		Log.info("URL is opened");
	 
		UserAboutUsPage ap = new UserAboutUsPage(driver);
	
		ap.SetFirstName("");
		ap.SetLastName("");
		ap.SetEmail("");
		ap.SetTelephone("");
		ap.ClickSubmit();
		Thread.sleep(1000);
		
		String FirstMessage =driver.findElement(By.xpath("//div[text()=\"This is a required field\"]")).getText();
		String LastMessage = driver.findElement(By.xpath("//div[text()=\"Last Name\"]//following::div[text()=\"This is a required field\"]")).getText();
		String EmailMessage = driver.findElement(By.xpath("//div[text()=\"Email is a required field\"]")).getText();
		
		Assert.assertEquals(FirstMessage,"This is a required field");
		Assert.assertEquals(LastMessage,"This is a required field");
		Assert.assertEquals(EmailMessage,"Email is a required field");
	}
     @Test(priority =2)
     public void UserEntrywithoutNum() throws InterruptedException {
 		driver.get("https://test.openbrix.co.uk/about-us");
 		Log.info("URL is opened");
 		driver.manage().window().maximize();
 	
 		UserAboutUsPage ap = new UserAboutUsPage(driver);
 		
 		ap.SetFirstName("test");
 		ap.SetLastName("account");
 		ap.SetEmail("testaccount@gmail.com");
 		ap.SetTelephone("");
 		ap.ClickSubmit();
 		Thread.sleep(1000);
        driver.switchTo().alert().accept();
		
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Mail sent successfully']")));
	   	
	    String toastmessage= driver.findElement(By.xpath("//div[text()='Mail sent successfully']")).getText();
		Assert.assertEquals( toastmessage, "Mail sent successfully");
     }
     
     @Test(priority =3)
	public void InvalidEmail() {
		
    	 driver.get("https://test.openbrix.co.uk/about-us");
  		Log.info("URL is opened");
  		driver.manage().window().maximize();
  	
  		UserAboutUsPage ap = new UserAboutUsPage(driver);
  		
  		ap.SetFirstName("test");
  		ap.SetLastName("account");
  		ap.SetEmail("@gmail.com");
  		ap.SetTelephone("");
  		ap.ClickSubmit();
		
  		String message = driver.findElement(By.xpath("//div[text()=\"Please enter a valid email address.\"]")).getText();
		Assert.assertEquals(message, "Please enter a valid email address.");		
	}
}
