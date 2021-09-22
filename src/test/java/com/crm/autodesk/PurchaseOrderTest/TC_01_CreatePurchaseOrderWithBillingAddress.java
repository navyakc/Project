package com.crm.autodesk.PurchaseOrderTest;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClassUtility;
import com.crm.autodesk.GenericUtility.ExcelFileUtility;
import com.crm.autodesk.GenericUtility.JSONUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.autodesk.elementRepository.BillingAddress;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

public class TC_01_CreatePurchaseOrderWithBillingAddress extends  BaseClassUtility{


	
	@Test   //(groups="RegressionSuite",retryAnalyzer=com.crm.autodesk.GenericUtility.RetryAnalyser.class)
	public void createPurchaseOrderwithBA() throws Throwable
	{
		int randonInt=jLib.getRandomNum();
		String SBN=eLib.getExcelData("Sheet3", 1, 0)+ randonInt;
		System.out.println(SBN);
		String BAD=eLib.getExcelData("Sheet3", 1, 1)+randonInt;
		//String SAD=eLib.getExcelData("Sheet3", 1, 2);
		String IN=eLib.getExcelData("Sheet3", 1, 3)+randonInt;
		int qN = eLib.getExcelData1("Sheet3", 1, 4);
	
		
		
		
		HomePage Hp=new HomePage(driver);
		Hp.more(driver);
		Hp.clickcreate();
		
		BillingAddress Ba=new BillingAddress(driver);
		Ba.create1();
		Ba.create(SBN,BAD,qN);
		Ba.create2();
		
		
		String errorMsg = wLib.textFromAlert(driver);
		Thread.sleep(10);
		String experrorMsg = eLib.getExcelData("Sheet3",1,5);
		Assert.assertTrue(errorMsg.contains(experrorMsg));
		System.out.println(errorMsg);
		
		//Assert.assertEquals(true,false);
		
	}
	
}
