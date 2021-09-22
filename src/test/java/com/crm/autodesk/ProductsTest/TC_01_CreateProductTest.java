package com.crm.autodesk.ProductsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.ExcelFileUtility;
import com.crm.autodesk.GenericUtility.JSONUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class TC_01_CreateProductTest {

	@Test
	public void createProductsTest() throws Throwable
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
		
		String PRODUCTNAME=elib.getExcelData("Sheet2", 1, 0);
		 double PARTNUMBER = elib.getExcelData1("Sheet2",1 , 1);
		
		
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
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
		driver.findElement(By.id("productcode")).sendKeys(""+PARTNUMBER);
		driver.findElement(By.name("button")).click();
		
		
	}
	
}
