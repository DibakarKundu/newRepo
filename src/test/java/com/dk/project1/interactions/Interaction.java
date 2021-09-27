package com.dk.project1.interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Interaction {

	WebDriver Driver;

	public Interaction(WebDriver Driver)
	{
		this.Driver = Driver;
	}

	//Type in a field
	public void Type(WebElement e, String text)
	{
		e.sendKeys(text);
	}
	
	//Wait
	public void Wait(int waitTime)
	{
		int waitTimeinMilliSeconds = waitTime * 1000;
		try {
			Thread.sleep(waitTimeinMilliSeconds);
		} catch (InterruptedException e) {
			System.out.println("Waited for "+ Integer.toString(waitTime) +" seconds");
		}
	}


	//Click and wait
	public void ClickAndWaitForPageLoad(WebElement e, int waitTime)
	{
		e.click();
		WaitForPageload(waitTime);		
	}

	//Waits for page to load
	public void WaitForPageload(int waitTime)
	{
		JavascriptExecutor js = (JavascriptExecutor)Driver;
		if(js.executeScript("return document.readyState").toString().equals("complete"))
		{
			return;			
		}

		for(int i = 0; i<waitTime; i++) 
		{
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException ex) {}

			if(js.executeScript("return document.readyState").toString().equals("complete"))
			{
				break;			
			}
		}

	}

	//Wait for element Clickable
	public void WaitUntilElementClickable(WebElement e,int waitTime)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(Driver, waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(e));
		}
		catch(Exception ex)
		{
			System.out.println("Error while clicking element. Error: " +ex.getMessage());
			throw ex;
		}

	}	
	
	//Click using JavaScript
	public void clickUsingJavaScript(WebElement e)
	{
		JavascriptExecutor js = (JavascriptExecutor)Driver;
		js.executeScript("arguments[0].click();", e);
		
	}
	
	
	//Wait for element Visible
	public void waitUntilElementVisible(WebElement e, int waitTime)
	{
		WebDriverWait wait = new WebDriverWait(Driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(e));
				
	}
	
	
	
	
	//Scroll to view element
	public void ScrollToViewElement(WebElement e)
	{
		
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView(true)", e);
	}

	
	//Check if alert present
		public boolean isAlertPresent()
		{
			try
			{
				Driver.switchTo().alert();
				return true;
			}
			catch(NoAlertPresentException ex)
			{
				return false;
			}
		}
	
	//Check if alert present
	public boolean isAlertPresent(int waitTime)
	{
		WebDriverWait wait =  new WebDriverWait(Driver, waitTime);
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		{
			return false;
		}
		return true;
	}

	//Dismiss Alert
	public void alertDismiss()
	{
		Driver.switchTo().alert().dismiss();
		System.out.println("Alert Dismiss");
	}


	//Get Text from WebElement
	public String getText(WebElement e)
	{
		return e.getText();
	}
	
	//Mouse hover on an Element
	public void mouseHoverOnElement(WebElement e)
	{
		Actions action = new Actions(Driver);
		action.moveToElement(e).build().perform();
		
	}
	
	//Mouse hover on an Element and click on that element
	public void mouseHoverOnElementAndClick(WebElement e)
	{
		Actions action = new Actions(Driver);
		action.moveToElement(e);
		action.click(e).build().perform();
		
	}
	

	
}
