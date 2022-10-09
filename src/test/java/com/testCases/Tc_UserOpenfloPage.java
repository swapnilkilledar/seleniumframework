package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.UserOpenfloPage;

public class Tc_UserOpenfloPage extends BaseClass {

	@Test (priority = 0)
	public void ClickYoutubeLink () {
		driver.get("https://test.openbrix.co.uk/openflo");
		Log.info("URL is opened");
		driver.manage().window().maximize();
		
		UserOpenfloPage op = new UserOpenfloPage(driver);
		op.ClickYoubeLink();
		String title = driver.findElement(By.xpath("//a[@class=\"ytp-impression-link\"]")).getText();
		Assert.assertEquals(title, "openflo intro video!- YouTube");
	}
	@Test (priority = 1)
	public void ClickFirstBtn () {
		driver.get("https://test.openbrix.co.uk/openflo");
		Log.info("URL is opened");
		driver.manage().window().maximize();
		
		UserOpenfloPage op = new UserOpenfloPage(driver);
		op.ClickFirstBtn();
		Assert.assertEquals(driver.getTitle(), "OpenBrix");	
	}
	
	@Test (priority = 2)
	public void ClickSecondBtn () {
		driver.get("https://test.openbrix.co.uk/openflo");
		Log.info("URL is opened");
		driver.manage().window().maximize();
		
		UserOpenfloPage op = new UserOpenfloPage(driver);
		op.ClickSecondBtn();
		Assert.assertEquals(driver.getTitle(), "OpenBrix");	
	}
}
