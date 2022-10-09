package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class UserLoginPage {
	WebDriver ldriver;
	 public UserLoginPage (WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
    }
	 
	 @FindBy(id="login-Email")
	 	WebElement loginEmail;
	 
	 @FindBy(id="login-Password")
	 	WebElement loginPassword;
	 
	 @FindBy(xpath="/html/body/div[1]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div[1]/div/div[3]")
	 	WebElement loginBtn;
	 
	 @FindBy(id="register")
	 	WebElement userRegister;
	 
	 @FindBy(xpath="//div[text()=\"Forgotten Password?\"]")
	 	WebElement forgotPassword;
	 
	 
	 
	 
	 public void setEmail(String email) {
		loginEmail.clear();
		 loginEmail.sendKeys(email);
		}
	 public void setPassword(String password) {
			loginPassword.sendKeys(password);
		}
	 public void ClickLogin() {
			loginBtn.click();
		}
	 public void ClickRegister() {
			userRegister.click();
		}
	 public void forgottenPassword() {
			forgotPassword.click();
		}
}
