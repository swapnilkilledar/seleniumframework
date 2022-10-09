package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	WebDriver ldriver;
	 public UserHomePage (WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
     }
	 
	 @FindBy(xpath="//div[@class='css-text-901oa' or text()='Login'] ")
	 	WebElement loginTab;
	 
	 @FindBy(xpath ="//div[text()='About Us']")
	 	WebElement aboutUsTab; 
	 
	 @FindBy(xpath="//div[@class='css-text-901oa' or text()='Openflo'] ")
	 	WebElement openFloTab; 
	 
	 @FindBy(xpath="//div[@class='css-text-901oa' or text()='Tlyfe']")
	 	WebElement tlyfeTab; 
	 
	 @FindBy(xpath="//div[text()='Home']")
	 	WebElement HomeTab; 
	 
	 @FindBy(xpath="//div[text()='TENANTS CLICK HERE']")
	 	WebElement TenantClickBtn;
	 
	 @FindBy(xpath="//div[text()='AGENTS CLICK HERE']")
	 	WebElement AgentClickBtn;
	 
	 
	 @FindBy(xpath="//div[text()='RENT']")
	 	WebElement RentTab;
	 
	 
	 @FindBy(xpath="//div[text()='BUY']")
	 	WebElement BuyTab;
	 
	 
	 @FindBy(xpath="//input")
	 	WebElement location;
	 
	 
	
	 
	 
	 public void clickLoginTab() {
			loginTab.click();
		}
	 
	 public void clickAboutUsTab() {
			aboutUsTab.click();
		}
	
	 public void clickOpenFloTab() {
			openFloTab.click();
		}
	 public void clickTlyfeTab() {
		 tlyfeTab.click();
		}
	 public void clickHomeTab() {
		 HomeTab.click();
		}
	 public void clickTenantClickHere() {
		 TenantClickBtn.click();
		}
	 public void clickAgentClickHere() {
		 TenantClickBtn.click();
		}
	 public void clickRentTab() {
		 RentTab.click();
		}
}
