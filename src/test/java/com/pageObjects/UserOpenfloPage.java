package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserOpenfloPage {

	WebDriver ldriver;
	 public UserOpenfloPage (WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
     }
	

		@FindBy(xpath="//a[@href=\"https://www.youtube.com/watch?v=O18RoDaVYKA&feature=emb_imp_woyt\"]")
		WebElement youtubeLink;
		
		@FindBy(xpath="//div[text()=\"CLICK TO REGISTER/LOGIN\"]")
		WebElement RegisterLoginFirstBtn;
		
		@FindBy(xpath="//div[text()=\"EFFICIENCY\"]//following::div[text()=\"CLICK TO REGISTER/LOGIN\"]")
		WebElement RegisterLoginSecondBtn;
		
		
		public void ClickYoubeLink() {
			youtubeLink.click();
		}
		
		public void ClickFirstBtn() {
			RegisterLoginFirstBtn.click();
		}
		
		
		public void ClickSecondBtn() {
			RegisterLoginSecondBtn.click();
		}
		
		
		
		
		
		
}
