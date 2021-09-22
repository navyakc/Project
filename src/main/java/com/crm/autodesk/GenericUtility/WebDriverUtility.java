package com.crm.autodesk.GenericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	
	public void waitUntilPageLoad(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * maximize window
	 * @param driver
	 */
	public void  maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method wait for the element to be visible
	 */
	
	public void waitForElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method wait for the element to be clicked, its custom wait created to avoid elementInterAcceptable Exception
	 * @throws Throwable 
	 * 
	 */
	
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count=0;
		while(count<20)
		{
			try {
				element.click();
				break;
				
			}catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
		
		
	/**
	 * this method enables user to handle dropdown using visible text	
	 */
		
		public void handleDropDown(WebDriver driver,WebElement element, String option)
		{
			Select select=new Select(element);
			select.selectByVisibleText(option);
			}
		
	/**
	 * this method enables user to handle dropdown using index	
	 */
		
		public void handleDropDown(WebDriver driver,WebElement element, int index)
		{
			Select select=new Select(element);
			select.selectByIndex(index);
			
		}
		
		/**
		 * this method will perform mouse over action
		 */
		
		public void mouseOver(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		
		/**
		 * this method performs right click operation
		 */
		
		public void rightClick(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.contextClick(element);
		}
		
		/**
		 * this method helps to switch from one window to another
		 */
		
		public void switchToWindow(WebDriver driver, String partialWinTitle)
		{
			//String parent = driver.getWindowHandle();
			Set<String> window = driver.getWindowHandles();
			Iterator<String> it = window.iterator();
			while(it.hasNext())
			{
				String winIt = it.next();	
				String title = driver.switchTo().window(winIt).getTitle();
				if(title.contains(partialWinTitle))
				{
					break;
				}
				
				
			}
			//driver.switchTo().window(parent);
		}
		
		/**
		 * switch back to 
		 */
		public void switchToParent(WebDriver driver)
		{
			String parent = driver.getWindowHandle();
			Set<String> window = driver.getWindowHandles();
			Iterator<String> it = window.iterator();
			while(it.hasNext())
			{
				String child = it.next();
				
				if(!parent.equals(child))
				{
					driver.switchTo().window(child);
					driver.close();
				}
			}
			//switch back to window
			driver.switchTo().window(parent);
		}
		
		/**
		 * accept alert
		 */
		
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		
		/**
		 * cancel alert
		 */
		
		public void cancelAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * return alert msg
		 */
		
		public String textFromAlert(WebDriver driver)
		{
			Alert text=driver.switchTo().alert();
			String msg=text.getText();
			text.accept();
			return msg;
		}
		
		
		/**
		 * this method is used for scrolling action in a webpage
		 */
		
		public void scrolltoWebElement(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")",element);
		}
		
		/**
		 * this method is used for switching between frames
		 */
		
		public void switchFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		

		/**
		 * 
		 */
		
		public void switchFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		
		/**
		 * 
		 */
		
		public void switchFrame(WebDriver driver,String idorname)
		{
			driver.switchTo().frame(idorname);
		}
		
		/**
		 * this method is used for taking screen shots
		 * @throws Throwable 
		 */
		
		public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("./screenshot/"+screenshotName+".PNG");
			Files.copy(src, dest);
		}
		
		/**
		 * pass enter key appertain in to browser
		 */
		
		public void passEnterKey(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
		
}
