package com.dk.project1.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GoogleTest extends TestBase{

	//String browserType = configData.getBrowserType(); 
	
		@Test
		public void NavigatetoGoogle()
		{
			WebDriver Driver = null;
			logger = report.createTest("NavigatetoGoogle");
			try 
			{
				Driver = driverSetup(browserType);
				Driver.get("https://www.google.co.in");
				Thread.sleep(5000);
				logger.log(Status.INFO, "Google");
			}
			catch(Exception ex)
			{
				Assert.fail("Failed in catch block. Error: "+ex.getMessage());
			}
			finally
			{
				driverCleanUp(Driver);
			}
			
		}
		
		
		@Test
		public void NavigatetoGoogle2nd()
		{
			WebDriver Driver = null;
			logger = report.createTest("NavigatetoGoogle2nd");
			try 
			{
				Driver = driverSetup(browserType);
				Driver.get("https://www.google.co.in");
				Thread.sleep(5000);
				logger.log(Status.INFO, "Google");
				
			}
			catch(Exception ex)
			{
				Assert.fail("Failed in catch block. Error: "+ex.getMessage());
			}
			finally
			{
				driverCleanUp(Driver);
			}
			
		}
	
}
