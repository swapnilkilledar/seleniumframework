package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAboutUsPage {
	WebDriver ldriver;
	 public UserAboutUsPage (WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
     }
	 
	    @FindBy(xpath="//input[@title='First Name']")
		WebElement firstName;
		
	    @FindBy(xpath="//input[@title='Last Name']")
		WebElement lastName;
		
	    @FindBy(xpath="//input[@title='Email']")
		WebElement email;
	    
	    @FindBy(xpath="//input[@title='Telephone']")
		WebElement telephone;
	 
	    @FindBy(xpath="//div[text()='Submit']")
		WebElement submit;
	 
	    public void SetFirstName(String uname) {
			firstName.sendKeys(uname);
		}
	 
	    public void SetLastName(String lname) {
	    	lastName.sendKeys(lname);
		}
	 
	    public void SetEmail(String ename) {
			email.sendKeys(ename);
		}
	    public void SetTelephone(String num) {
			telephone.sendKeys(num);
		}
	    public void ClickSubmit() {
			submit.click();
		}
}
