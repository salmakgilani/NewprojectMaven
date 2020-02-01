package com.actitime.pages;

import java.awt.print.Pageable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	@FindBy(id="username")
	private WebElement usernameTB;
	
	@FindBy(name="pwd")
	private WebElement passwordTB;
	
	@FindBy(id="loginButton")
	private WebElement loginBT;
	
	@FindBy(xpath = "//span[.='Username or Password is invalid. Please try again.']")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//nobr[.='actiTIME 2019.1 Pro']")
	private WebElement version;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	
	
	public void verifyPage(String eTittle)
	{
		verifyTittle(eTittle);
	}
	public void enterUserName(String un)
	{
		usernameTB.sendKeys(un);
	}
	public void enterPassword(String pw)
	{
		passwordTB.sendKeys(pw);
	}
	public void clickOnLogin()
	{
		loginBT.click();
	}
	public String verifyErrorMessage()
	{
		verifyElement(errorMessage);
		String aErrorMessage = errorMessage.getText();
		return aErrorMessage;
	}
	public String verifyVersion() 
	{
		verifyElement(version);
		String aVersion = version.getText();
		return aVersion;
		
	}

}
