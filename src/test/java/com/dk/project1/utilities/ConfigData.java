package com.dk.project1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigData {

	Properties prop;
	
	public ConfigData()
	{
		File configFile = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(configFile);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception ex)
		{
			System.out.println("Not able to lod Config File. Error: " + ex.getMessage());
		}
	}
	
	
	public String getPropertyValue(String propertyName)
	{
		return prop.getProperty(propertyName);		
	}
	
	public String getBaseUrl()
	{
		return prop.getProperty("baseUrl");		
	}
	
	public String getBrowserType()
	{
		return prop.getProperty("browser");		
	}

	
	
	
}
