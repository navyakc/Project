package com.crm.autodesk.PurchaseOrderTest;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClassUtility;
import com.crm.autodesk.GenericUtility.ExcelFileUtility;
import com.crm.autodesk.GenericUtility.JSONUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;

import com.crm.autodesk.elementRepository.CopyShippingAddress;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

public class TC_03_CreatePurchaseOrderCopyShippingAddress extends BaseClassUtility {

	
	@Test(groups="RegressionSuite")
	public void createPurchaseOrderwithCopySA() throws Throwable
	{
		
		int randonInt=jLib.getRandomNum();
		String SBN=eLib.getExcelData("Sheet3", 1, 0)+randonInt;
		
		String SAD=eLib.getExcelData("Sheet3", 1, 2)+randonInt;
		String IN=eLib.getExcelData("Sheet3", 1, 3)+randonInt;
		int qN=eLib.getExcelData1("Sheet3", 1, 4);
		
		
		
		HomePage Hp=new HomePage(driver);
		Hp.more(driver);
		Hp.clickcreate();
		
		CopyShippingAddress ca=new CopyShippingAddress(driver);
		ca.create1();
		ca.create(SBN,SAD,qN);
		ca.create2();
		
		String errorMsg = wLib.textFromAlert(driver);
		Thread.sleep(10);
		String experrorMsg = eLib.getExcelData("Sheet3",1,6);
		Assert.assertTrue(errorMsg.contains(experrorMsg));
		System.out.println(errorMsg);
		
		//String actual = ca.getinfo(driver);
		//Assert.assertTrue(actual.contains("Purchase Order"));
		//System.out.println(actual);
		
		
		
	}
	
}
