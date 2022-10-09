package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentRegistration {
	WebDriver ldriver;
	 public AgentRegistration (WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
     }
	 
	 @FindBy(id="first_name")
		WebElement firstName;
	 
	 @FindBy(id="last_name")
		WebElement lastName;
	 
	 @FindBy(id="email")
		WebElement emailReg;
	 
	 
	 @FindBy(id="password")
		WebElement passwordReg;
	 
	 @FindBy(id="confirm-password")
		WebElement confirmPassword;
	 
	 @FindBy(xpath="//button[text()=\"Sign up\"]")
	 WebElement signUpBtn;
	 
	 
	 
	 public void setFirstName(String firstname) {
		 	firstName.sendKeys(firstname);
		}
	 public void setlastName(String lastname) {
			lastName.sendKeys(lastname);
		}
	 public void setEmail(String email) {
			emailReg.sendKeys(email);
		}
	 public void setRegPassword(String pswd) {
			passwordReg.sendKeys(pswd);
		}
	 
	 public void setRegConfirmPwd(String cpwd) {
		 confirmPassword.sendKeys(cpwd);
	 }
	 public void signUpClick() {
			signUpBtn.click();
		}
}
