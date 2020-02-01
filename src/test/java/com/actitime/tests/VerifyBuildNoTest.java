package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.BasePage;
import com.actitime.pages.EnterTimeTrackerPage;
import com.actitime.pages.LoginPage;

public class VerifyBuildNoTest extends BaseTest
{
	@Test(priority=4)
	public  void testVerifyBuildNo() throws InterruptedException
	{
		logger = extent.createTest("testVerifyBuildNo is created");
		logger.info("testVerifyBuildNo is started");
		String loginTittle = ExcelData.getData(file_path, "TC01",1, 2);		
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String enterTimeTrackTittle = ExcelData.getData(file_path, "TC01",1 , 3);
		String eBuildNo = ExcelData.getData(file_path, "TC04", 1, 0);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackerPage ep = new EnterTimeTrackerPage(driver);
		
		//verify LoginPage
		lp.verifyPage(loginTittle);
		
		//Enter UN
		lp.enterUserName(un);
		
		//Enter PW
		lp.enterPassword(pw);
		
		//click on Login
		lp.clickOnLogin();
		
		//Verify Tittle
		lp.verifyTittle(enterTimeTrackTittle);
		Thread.sleep(3000);
		
		//Click On Help
		ep.clickOnHelp();
		Thread.sleep(3000);
		
		//Click On About your Actitime
		ep.clickOnAboutYourActitime();
		Thread.sleep(3000);
		
		//verify Build No
		String actualbuildno = ep.verifyBuildNo();
		
		Reporter.log("Expected Build No :"+eBuildNo,true);
		Reporter.log("Actual Build No :"+actualbuildno,true);
		
		Assert.assertEquals(actualbuildno, eBuildNo);
		Reporter.log("Build No is matching",true);
	}
}
