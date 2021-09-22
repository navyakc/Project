package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.ExcelFileUtility;

import com.crm.autodesk.GenericUtility.JSONUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class TC_01_CreateOrganizationTest {
	WebDriver driver;
	@Test
	public void createContactWithOrganizationTest() throws Throwable
	{
	//read all the necessary data
		
		JSONUtility jsonlib=new JSONUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		

		int randonInt=jlib.getRandomNum();
		String URL=jsonlib.readdatafromJason("url");
		String BROWSER=jsonlib.readdatafromJason("browser");
		String USERNAME=jsonlib.readdatafromJason("username");
		String PASSWORD=jsonlib.readdatafromJason("password");
		
		String orgName=elib.getExcelData("Sheet1", 1, 3);
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid");
		}
		wlib.waitUntilPageLoad(driver);
		
		
		driver.get(URL);
		
		//login
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+randonInt);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
	
}
