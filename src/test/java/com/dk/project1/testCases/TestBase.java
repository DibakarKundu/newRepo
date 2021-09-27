package com.dk.project1.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.dk.project1.utilities.ConfigData;


public class TestBase {

	//WebDriver Driver = null;
	public ConfigData configData;
	public String browserType;  
	public ExtentReports report;
	public ExtentTest logger;
	String reportPath;
	
	public WebDriver driverSetup(String browserType)
	{
		WebDriver Driver;
		ChromeOptions chromeOptions;
		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--start-maximized");
			Driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable-notifications");
			firefoxOptions.addArguments("--start-maximized");
			Driver = new FirefoxDriver(firefoxOptions);
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--start-maximized");
			Driver = new ChromeDriver(chromeOptions);
			break;
		}
		
		return Driver;
	}
	
	
	
	@AfterMethod
	public void afterMetod()
	{
		report.flush();
	}
	
	
	
	public void driverCleanUp(WebDriver Driver)
	{
		Driver.close();
	}
	
	@BeforeClass
	public void ClassLevelSetUp()
	{
		configData = new ConfigData();
		browserType = configData.getBrowserType();
		setUpReport();
	}
	
	
	
	
	public void setUpReport()
	{
		reportPath = System.getProperty("user.dir") + "/ExtentReports/"+"Testing.html";
		ExtentReporter extent = new ExtentHtmlReporter(reportPath);
		
		report = new ExtentReports();
		report.attachReporter(extent);
		
	}
	
	
}
