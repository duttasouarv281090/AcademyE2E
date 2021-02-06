package HelperClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Reports.ExtentReportGenerator;
import Resource.base;

public class Listener implements ITestListener{

	base bobj=new base();
	ExtentReports extent;
     ExtentTest test;
	public void onTestStart(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		 extent=ExtentReportGenerator.getExtentReport(testName);
		 test=extent.createTest(testName);
		 //Passing TestObject to Base Class method to reuse test logging in Class or Method level.
		 bobj.extentTestObject(test);
		 
		
	}

	public void onTestSuccess(ITestResult result) {
		WebDriver  driver=null;
		String testName = result.getMethod().getMethodName();
		test.log(Status.PASS,"Successful");
		Object testObject = result.getInstance();
		Class clasname=result.getTestClass().getRealClass();
		try {
			driver=(WebDriver) clasname.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Capture Screenshot on Test Pass
		try {
			bobj.getScreenshotOnPass(driver,testName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//Add Screenshot to Extent Report
		try {
			test.addScreenCaptureFromPath(bobj.getPassScreenshotPath(driver,testName), testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		WebDriver  driver=null;
		String testName = result.getMethod().getMethodName();
		test.fail(result.getThrowable());
		Object testObject = result.getInstance();
		Class clasname=result.getTestClass().getRealClass();
		try {
			driver=(WebDriver) clasname.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			bobj.getScreenshotOnFailure(driver,testName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			test.addScreenCaptureFromPath(bobj.getFailScreenshotPath(driver,testName), testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
