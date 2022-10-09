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
	
	public void setUserName(String uname) {
		loginEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		loginPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		loginSignIn.click();
	}
	
	}
