package com.crm.autodesk.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 /**
  * We should get error in Listerners , if not getting then right click click on source >override/implements>select first check box and finish
  * in pom testng should be 6.14.3
  * @author mypc
  *
  */
public class Listerners implements ITestListener {

	ExtentReports reports; 
	ExtentTest test; 
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"is passed");
		
	}

	public void onTestFailure(ITestResult result) {    
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+"is failed");
		test.log(Status.FAIL, result.getThrowable());
		
		
		BaseClassUtility baseclass=new BaseClassUtility();
		
		try {
			String path = baseclass.screen(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReportsSDET21/ExtentReports1.html");
		reporter.config().setDocumentTitle("SDET21");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("BuildNo", "5.1");
		reports.setSystemInfo("Env", "Pre-Prod");
		reports.setSystemInfo("Platform", "windows");
		reports.setSystemInfo("Browser Version", "chrome-93");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
	}

	


	
	
}
