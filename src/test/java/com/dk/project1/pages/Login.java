package com.dk.project1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dk.project1.interactions.Interaction;

public class Login extends BasePage{

	
	WebDriver Driver;
	
	public Login(WebDriver Driver)
	{
		super(Driver);
	}
	
	//=============================================================================================
		//Objects
		//=============================================================================================
		@FindBy(id="email")
		WebElement txbUserName;
		
		@FindBy(id="pass")
		WebElement txbPassword;
		
		@FindBy(name="login")
		WebElement btnLogin;
		
		
		
		//=============================================================================================
		//Related Methods
		//=============================================================================================
		
		
		//Type UserName
		public void typeUserName(String userName)
		{
			interaction.WaitUntilElementClickable(txbUserName, Wait_Medium);
			txbUserName.sendKeys(userName);
		}
		
		//Type UserName
		public void typePassword(String password)
		{
			interaction.WaitUntilElementClickable(txbPassword, Wait_Medium);
			txbPassword.sendKeys(password);
		}
		
		//Click on LogIn button
		public void clickOnLogin()
		{
			interaction.WaitUntilElementClickable(btnLogin, Wait_Medium);
			interaction.ClickAndWaitForPageLoad(btnLogin, Wait_PageLoad);
		}
		
		public void logInToFacebook(String userName, String password)
		{
			typeUserName(userName);
			typePassword(password);
			clickOnLogin();
			waitforSomeTime(5);
			interaction.WaitForPageload(Wait_Long);
			
		}
		
		public void waitforSomeTime(int waitTime)
		{
			interaction.Wait(waitTime);
		}
	

}
