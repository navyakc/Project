package com.crm.autodesk.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

/**
 * This class contains all the basic configuration annotations
 * @author Navya
 *
 */

public class BaseClassUtility {

	public DatabaseUtility dbLib=new DatabaseUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public JSONUtility jsonLib=new JSONUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public PropertyFileUtility pLib=new PropertyFileUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;   //this is used for screen shot
	
	@BeforeSuite  //(groups= {"SmokeSuite","RegressionSuite"})
	public void dbConnection()
	{
		System.out.println("connect to database");
		//dbLib.connectToDB();
	}
	//@Parameters("Browser")
	@BeforeClass //(groups={"SmokeSuite","RegressionSuite"})
	public void launchBrowser() throws Throwable  //we need to pass argument when using compatability
	{
	
		System.out.println("launch browser");
		String URL=jsonLib.readdatafromJason("url");
		String BROWSER=jsonLib.readdatafromJason("browser"); //we need to comment this line when doing compatability 
		
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
		
		wLib.maximizeWindow(driver);
		wLib.waitUntilPageLoad(driver);
		driver.get(URL);
		staticdriver=driver;  //for screenshot
	}
		
		@BeforeMethod  //(groups={"SmokeSuite","RegressionSuite"})
		public void loginToApp() throws Throwable
		{
			System.out.println("login to app");
			String USERNAME=jsonLib.readdatafromJason("username");
			String PASSWORD=jsonLib.readdatafromJason("password");
			
			LoginPage lp=new LoginPage(driver);
			lp.login(USERNAME, PASSWORD);
		}
		
		@AfterMethod  //(groups="SmokeSuite")
		public void logoutToApp()
		{
			System.out.println("logout from app");
			HomePage Hp=new HomePage(driver);
			Hp.signout(driver);
		}
		
		@AfterClass //(groups="SmokeSuite")
		public void closeBrowser()
		{
			System.out.println("close browser");
			driver.close();
		}
		
		@AfterSuite  //(groups={"SmokeSuite","RegressionSuite"})
		public void closeDB()
		{
			//dbLib.closeDB();
			System.out.println("close database");
		}
		
		public String screen(String name) throws IOException
		{
			
		File srcfile=((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"/Screenshots/"+name+".png";  //user.dir gives current directory/project path
		File finaldest=new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		return destfile;
		//TakesScreenshot ts=(TakesScreenshot)driver;
		//File src = ts.getScreenshotAs(OutputType.FILE);
		//File dest=new File("./Photo/myntra.png");
		//FileUtils.copyFile(src, dest);
		}
		
	}


