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

public class TC_03_CreateContactwithOrganizationTest {
	@Test
	public void contactWithOrganization() throws Throwable
	{
		WebDriver driver=null;
		JSONUtility jsonlib=new JSONUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		

		
		String URL=jsonlib.readdatafromJason("url");
		String BROWSER=jsonlib.readdatafromJason("browser");
		String USERNAME=jsonlib.readdatafromJason("username");
		String PASSWORD=jsonlib.readdatafromJason("password");
		
		String lastName=elib.getExcelData("Sheet1", 1, 3);
		String orgName=elib.getExcelData("Sheet1",1 , 2);
		
		
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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		wlib.switchToWindow(driver,"Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("Skillrary")).click();
		wlib.switchToWindow(driver,"Contacts");
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
	}
	
}
