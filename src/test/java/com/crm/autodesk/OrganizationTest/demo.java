package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.GenericUtility.ExcelFileUtility;

public class demo {
	
	public static void main(String[] args) throws Throwable {
		

		WebDriver driver=new ChromeDriver();

		driver.get("http://localhost:8888/index.php?module=PurchaseOrder&action=EditView&return_action=DetailView&parenttab=Inventory");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.name("subject")).sendKeys("ad");
	ExcelFileUtility eLib=new ExcelFileUtility();
	
	String SBN=eLib.getExcelData("Sheet3", 1, 0);
	String BAD=eLib.getExcelData("Sheet3", 1, 1);
	//String SAD=elib.getExcelData("Sheet3", 1, 2);
	String IN=eLib.getExcelData("Sheet3", 1, 3);
	int qN = eLib.getExcelData1("Sheet3", 1, 4);
	
	System.out.println(SBN);
	System.out.println(BAD);
	System.out.println(IN);
	System.out.println(qN);
}
}
