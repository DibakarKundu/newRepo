package com.dk.project1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dk.project1.interactions.Interaction;
import com.dk.project1.utilities.ConfigData;

public class BasePage {

	//Added coomet
	WebDriver Driver;
	Interaction interaction;
	
	public BasePage(WebDriver Driver)
	{
		this.Driver = Driver;
		interaction = new Interaction(Driver);
		PageFactory.initElements(Driver, this); 
	}
	
	
	
	/*Below are values for different wait period.
     * Same Wait period is present in TestBase class. Both should be in synchronization
     * These times are in Seconds
     */

    public int Wait_VeryShortDelay = 2;
    public int Wait_ShortDelay = 5;
    public int Wait_Short = 10;
    public int Wait_Medium = 30;
    public int Wait_Long = 60;
    public int Wait_VeryLong = 120;
    public int Wait_PageLoad = 60;
    
    
    
    public void NavigateToBaseUrl()
    {
    	ConfigData config = new ConfigData();
    	String baseUrl = config.getPropertyValue("url");
    	Driver.get(baseUrl);
    }

	
}
