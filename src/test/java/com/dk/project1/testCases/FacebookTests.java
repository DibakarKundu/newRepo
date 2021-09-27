package com.dk.project1.testCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.dk.project1.pages.Login;

public class FacebookTests extends TestBase{

	//String browserType = configData.getBrowserType();
	
		@Test
		public void PostFacebookStatus()
		{
			WebDriver Driver = null;
			
			try 
			{
				logger = report.createTest("PostFacebookStatus");
				Driver = driverSetup(browserType);
				
				//logger = extent.createTest("TestName1");
				Login login = new Login(Driver);
				logger.log(Status.INFO, "ObjectCreated");
				
				Driver.get("https://www.facebook.com");
				login.logInToFacebook("testface117@gmail.com", "Admin@11");
				login.waitforSomeTime(5);
				logger.log(Status.INFO, "Again");
				
				
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				Assert.fail("Posting status is NOT successful. Error: " + ex.getMessage());		
				//logger.log(Status.FAIL, "Failed to post status. Error: "+ex.getMessage());
			}
			finally
			{
				//LogOut from Facebook
				//facebookHomePage.ClickOnAccount();
				//facebookHomePage.ClickOnLogout();
				//logger.info("loggedout from facebook");
				driverCleanUp(Driver);
			}
		}
			
			
			@Test
			public void PostFacebookStatus2()
			{
				WebDriver Driver = null;
				logger = report.createTest("PostFacebookStatus2");
				try 
				{
					Driver = driverSetup(browserType);
					
					//logger = extent.createTest("TestName1");
					Login login = new Login(Driver);
					logger.log(Status.INFO, "Hello");
					
					Driver.get("https://www.facebook.com");
					login.logInToFacebook("testface117@gmail.com", "Admin@11");
					login.waitforSomeTime(2);
					logger.log(Status.INFO, "Hello 2");
					
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
					Assert.fail("Posting status is NOT successful. Error: " + ex.getMessage());		
					//logger.log(Status.FAIL, "Failed to post status. Error: "+ex.getMessage());
				}
				finally
				{
					//LogOut from Facebook
					//facebookHomePage.ClickOnAccount();
					//facebookHomePage.ClickOnLogout();
					//logger.info("loggedout from facebook");
					driverCleanUp(Driver);
				}
					
		}

	
}
