package com.crm.autodesk.OrganizationTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class lenscart {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.lenskart.com/");
		
		
		
		driver.findElement(By.name("q")).click();   //WebElement ele = 
	
		
		List<WebElement> ele1 = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']"));
		System.out.println(ele1.size());
		
		for(WebElement b:ele1)
		{
			System.out.println(b.getText());
		}
		driver.close();

	}

}
