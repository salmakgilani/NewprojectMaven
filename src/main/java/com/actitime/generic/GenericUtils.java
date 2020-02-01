package com.actitime.generic;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils 
{
	public static void getscreenshots(WebDriver driver,String name)
	{
		try
		{
			TakesScreenshot t = (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/"+name+".png");
			FileUtils.copyFile(src, dest);
		}
		catch (Exception e) 
		{
			
		}
	}
	public static void selectByIndex(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public static void selectByValue(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public static void selectByVisibletext(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}	
}
