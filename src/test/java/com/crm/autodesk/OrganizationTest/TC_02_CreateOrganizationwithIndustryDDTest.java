package com.crm.autodesk.OrganizationTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClassUtility;
import com.crm.autodesk.GenericUtility.ExcelFileUtility;
import com.crm.autodesk.GenericUtility.JSONUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.LoginPage;

public class TC_02_CreateOrganizationwithIndustryDDTest extends BaseClassUtility {
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eLib.getExcelData2("Sheet4");
	}
	
	
	@Test(dataProvider="getData")
	//public void withIndustryTest() throws Throwable
	//{
		//WebDriver driver=null;
		//JSONUtility jsonlib=new JSONUtility();
		//JavaUtility jlib=new JavaUtility();
		//WebDriverUtility wlib=new WebDriverUtility();
		//ExcelFileUtility elib=new ExcelFileUtility();
		

		//int randonInt=jlib.getRandomNum();
		//String URL=jsonlib.readdatafromJason("url");
		//String BROWSER=jsonlib.readdatafromJason("browser");
		//String USERNAME=jsonlib.readdatafromJason("username");
		//String PASSWORD=jsonlib.readdatafromJason("password");
		
		//String orgName=elib.getExcelData("Sheet1", 1, 3);
		
		//if(BROWSER.equalsIgnoreCase("chrome"))
		//{
			//driver=new ChromeDriver();
		//}
		//else if (BROWSER.equalsIgnoreCase("firefox"))
		//{
		//	driver=new FirefoxDriver();
		//}
		//else
		//{
		//	System.out.println("invalid");
		//}
		//wlib.waitUntilPageLoad(driver);
		
		
		//driver.get(URL);
		
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		//driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//driver.findElement(By.name("accountname")).sendKeys(orgName+randonInt);
		//WebElement dd = driver.findElement(By.name("industry"));
		//wlib.handleDropDown(driver,dd,"Education");
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
		
	//}
	
	
public void createOrgwithMultipleData(String OrgName, String IndustryType)
	{
	driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		CreateOrganizationPage cp=new CreateOrganizationPage(driver);
		cp.createOrganizationwithIndustry(OrgName, IndustryType);
		String act = cp.createOrganizationinfo();
		Assert.assertTrue(act.contains(OrgName));
		System.out.println(OrgName);
		
		}
	
	
	
	
	
}
