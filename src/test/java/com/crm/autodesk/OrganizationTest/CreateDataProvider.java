package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClassUtility;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.LoginPage;

public class CreateDataProvider extends BaseClassUtility{

	WebDriver driver;
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eLib.getExcelData2("Sheet4");
	}
	@Test(dataProvider="getData")
	public void createOrgwithMultipleData(String OrgName, String intType)
	{
		//navigate to Organisations
	
		//driver.get("http://localhost:8888");	
		//driver.findElement(By.name("user_name")).sendKeys("admin");
		//driver.findElement(By.name("user_password")).sendKeys("admin");
		//driver.findElement(By.id("submitButton")).click();
		CreateOrganizationPage co=new CreateOrganizationPage(driver);
		co.create();
		
	}
}
