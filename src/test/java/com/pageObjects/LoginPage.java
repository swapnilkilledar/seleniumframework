package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver ldriver;
	 public LoginPage (WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
      }
	
	
	@FindBy(id="email")
	WebElement loginEmail;
	
	@FindBy(id="password")
	WebElement loginPassword;
	
	@FindBy(id="sign-in-agent")
	WebElement loginSignIn;
	
	@FindBy(xpath="//button[text()=\"Property Search\"]")
	WebElement propertySearchBtn;
	
	@FindBy(xpath="//h5[text()=\"Reset Password\"]")
	WebElement resetPasswordBtn;
	
	@FindBy(xpath="//h5[text()=\"Don't have an account? Sign Up\"]")
	WebElement donthavaccntBtn;
	

	
	public void setUserName(String uname) {
		loginEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		loginPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		loginSignIn.click();
	}
	
	public void clickPropertySearch() {
	   propertySearchBtn.click();
	}
	public void clickResetPassword() {
		resetPasswordBtn.click();
	}
	public void clickDonthavAccount() {
		donthavaccntBtn.click();
	}

	}
