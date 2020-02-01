package com.actitime.tests;

import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackerPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest  extends BaseTest
{
	@Test(priority=1)
	public void testValidLoginLogout()
	{
		logger = extent.createTest("ValidLoginLogoutTest is created");
		logger.info("ValidLoginLogoutTest is started");
		String loginTittle = ExcelData.getData(file_path,"TC01",1,2);
		String un= ExcelData.getData(file_path,"TC01",1,0);
		String pw = ExcelData.getData(file_path, "TC01",1,1);
		String enterTimeTrackerTittle = ExcelData.getData(file_path, "TC01",1,3);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackerPage ep = new EnterTimeTrackerPage(driver);
	
		//Verify Tittle
		lp.verifyPage(loginTittle);
		
		//enter username
		lp.enterUserName(un);

		//Enter Password
		lp.enterPassword(pw);
		
		//Click onLoginBt
		lp.clickOnLogin();
		
		//Verify Enter Time Tracker Page
		ep.verifyTittle(enterTimeTrackerTittle);
		
		//Click on Logout
		ep.clickOnLogout();
		
		//verify loginpage
		lp.verifyPage(loginTittle);
		
	}
}
