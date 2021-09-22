package com.crm.autodesk.OrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/s?k=phone+below+5000&ref=nb_sb_noss_1");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phone below 5000");
		driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
		

	}

}
