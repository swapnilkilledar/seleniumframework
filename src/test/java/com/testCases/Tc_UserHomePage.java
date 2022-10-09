package com.testCases;



import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.UserHomePage;

public class Tc_UserHomePage extends BaseClass{

	@Test(priority =0)
	public void UserLoginClick() {
		driver.get("https://openbrix.co.uk/home");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserHomePage hp = new UserHomePage(driver);	
		hp.clickLoginTab();
		Assert.assertEquals(driver.getTitle(),"Sign in");
	}

	
	@Test(priority =1)
	public void UserAboutUsClick() {
		driver.get("https://openbrix.co.uk/home");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserHomePage hp = new UserHomePage(driver);	
		hp.clickAboutUsTab();
		Assert.assertEquals(driver.getTitle(),"About Us");
	}
	
	@Test(priority =2)
	public void UserOpenFloClick() {
		driver.get("https://openbrix.co.uk/home");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserHomePage hp = new UserHomePage(driver);	
		hp.clickOpenFloTab();
	    Assert.assertEquals(driver.getTitle(),"landingOpenflo");
	}  
	
	@Test(priority =3)
	public void UserTlyfeClick() {
		driver.get("https://openbrix.co.uk/home");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserHomePage hp = new UserHomePage(driver);	
	    hp.clickTlyfeTab();
	    Assert.assertEquals(driver.getTitle(),"landingTlyfe");
	}
	
	@Test(priority =4)
	public void UserHomeClick() {
		driver.get("https://openbrix.co.uk/home");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserHomePage hp = new UserHomePage(driver);	
	    hp.clickHomeTab();
	    Assert.assertEquals(driver.getTitle(),"landingSearch");
	}
	
	@Test(priority =5)
	public void UserTenantClickHere() {
		driver.get("https://openbrix.co.uk/home");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserHomePage hp = new UserHomePage(driver);	
	    hp.clickTenantClickHere();
	    Assert.assertEquals(driver.getTitle(),"Sign in");
	}
	
	@Test(priority =6)
	public void UserAgentClickHere() throws InterruptedException {
		driver.get("https://openbrix.co.uk/home");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserHomePage hp = new UserHomePage(driver);	
	    hp.clickAgentClickHere();
	    Thread.sleep(1000);
	    String message = driver.getTitle();
	    System.out.println("message");
	    Assert.assertEquals(message,"OpenBrix");
	}
	
	@Test(priority =7)
	public void UserPropertySearch() throws InterruptedException {
		driver.get("https://openbrix.co.uk/home");
		Log.info("URL is opened");
		driver.manage().window().maximize(); 
		UserHomePage hp = new UserHomePage(driver);	
	    hp.clickRentTab();
	    driver.findElement(By.xpath("//input")).sendKeys("London");
	    System.out.println("******1");
	    Thread.sleep(1000);
	    
	   Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[7]/div/div[9]/div[2]/div/div[2]/div/div[2]/div")));
	    

	    
	    Select sc = new Select(driver.findElement(By.id("guarantorTitle")));
	    sc.selectByValue("1");
	    sc.selectByValue("5");
	    sc.selectByIndex(3); 
	  
	    sc.selectByIndex(5); 
	    sc.selectByIndex(6);
	    System.out.println("******2");
	    
	    driver.findElement(By.xpath("//div[text()=\"All\"]")).click();
	    sc.selectByIndex(2);
	    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[7]/div/div[9]/div[2]/div/div[2]/div/div[12]/div/div/div[1]")).click();
	    driver.findElement(By.xpath("//div[text()=\"Search\"]")).click();
	    Assert.assertEquals(driver.getTitle(),"Search");
	
	}
}
