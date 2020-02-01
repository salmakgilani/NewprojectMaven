package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class VerfiyVersionTest extends BaseTest{
	@Test(priority = 3)
	public void testVerifyVersion()
	{
		logger = extent.createTest("VerfiyVersionTest is created");
		logger.info("VerfiyVersionTest is started");
		String loginTittle = ExcelData.getData(file_path, "TC01",1, 2);
		String Eversion = ExcelData.getData(file_path, "TC03", 1, 0);
		LoginPage lp = new LoginPage(driver);
		//verify Tittle
		lp.verifyTittle(loginTittle);
		
		// verify Version
		String AVersion = lp.verifyVersion();
		
		Reporter.log("Actual Version is : "+AVersion,true);
		Reporter.log("Expected Version is : "+Eversion,true);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(AVersion, Eversion);
		sa.assertAll();
		Reporter.log("Version is matching :",true);
		
	}
}
