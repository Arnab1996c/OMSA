package com.testng;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.remote.ProtocolHandshake.Result;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import DriverFile.BaseClass;
import Method.DiffMethod;

public  class CustomListner extends BaseClass implements ITestListener   {
	 //static  extent;
	 static ExtentTest test;
	 public static ExtentReports extent = ExtentManager.createInstance("test-output/extent.html");
	 //public static MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(DiffMethod.Screenshot()).build();
	//private static String filepath= "D:/Users/XY58270/Downloads/Screenshot"+"/"+DiffMethod.calendar()+".jpg";
	
	
	 
	 //abstract Call createInstance();
	 
	//private static ThreadLocal parentTest = new ThreadLocal();
	  //private static Exten test = new ThreadLocal();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
        
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName(),"Started");
		test.log(Status.PASS, "PASSED"+result.getMethod().getMethodName());
		try {
			test.pass("PASSED", MediaEntityBuilder.createScreenCaptureFromPath(DiffMethod.Screenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Failed Test");
		test=extent.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL, "FAILED"+result.getMethod().getMethodName());
		
		try {
			//test.log(Status.FAIL, (Markup) test.addScreencastFromPath(DiffMethod.Screenshot()));
			test.fail("FAILED", MediaEntityBuilder.createScreenCaptureFromPath(DiffMethod.Screenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			/*try {
				
				Screenshot(result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
			// TODO Auto-generated catch block
			
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.SKIP, "Skipped"+result.getMethod().getMethodName());.
		test=extent.createTest(result.getMethod().getMethodName(),"done");
		test.log(Status.SKIP, "Skipped"+result.getMethod().getMethodName());
		try {
			test.skip("skipped", MediaEntityBuilder.createScreenCaptureFromPath(DiffMethod.Screenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage");
		
		/*try {
			
			Screenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	public static  class ExtentManager {
		 	    
	 public static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        //test=extent.createTest("testName");
	        
	        return extent;
	    }
	}

}

