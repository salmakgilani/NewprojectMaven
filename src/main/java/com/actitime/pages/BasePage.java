package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void verifyTittle(String eTittle)
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTittle));
			Reporter.log("Tittle is matching :"+eTittle,true);
		}
		catch (Exception e) 
		{
			Reporter.log("Tittle is not matching : Expected tittle is :"+eTittle,true);
			Reporter.log("Actual tittle is :"+driver.getTitle(),true);
			Assert.fail();
		}
	}
	
	public void verifyElement(WebElement element)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is Present",true);
		} 
		catch (Exception e)
		{
			Reporter.log("Element is not Present",true);
			Assert.fail();
		}
	}
}
