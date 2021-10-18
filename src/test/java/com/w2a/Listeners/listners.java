package com.w2a.Listeners;

import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.w2a.utilities.DataProviderr;
import com.w2a.utilities.excelReader;
import com.w2a.utilities.extentReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.Base.TestBase;

public class listners extends TestBase implements ITestListener {
	Date d = new Date();
	extentReports exe = new extentReports();
	ExtentReports abc = exe.ReporterSetup();
	DataProviderr data = new DataProviderr();
	excelReader excl = new excelReader();
	

	public void onTestStart(ITestResult result) {
		extentReports.test = abc.createTest(result.getMethod().getMethodName());
		System.out.println("this is first");
		try {
			if (!data.testRunnable(result.getName(), new excelReader())) {
				throw new SkipException("Skkiped");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onStart(ITestContext context) {
		

	}

	public void onTestSkipped(ITestResult result) {
		extentReports.test.skip("testdgsds");

	}
	public void onTestFailure(ITestResult result) {
		String date = d.toString().replaceAll(":", "_").replaceAll(" ", "_") + "errorg.jpg";
		  String PassSccenpath = ("C:\\Lingaraj\\"+ date);
	    File scrrenshotFailed = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File filestorage = new File(PassSccenpath);
	    try {
			FileUtils.copyFile(scrrenshotFailed,filestorage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Markup m = MarkupHelper.createLabel("Fail", ExtentColor.RED);
		String errorstack = Arrays.toString(result.getThrowable().getStackTrace());
		extentReports.test.fail("<Details><Summary>Click to see the Stack Trace</Summary>"+errorstack+"</Details>");
	    extentReports.test.fail("<a href ="+PassSccenpath + ">Click to see screenshot</a>");
	    extentReports.test.fail(m);
	}
//	
//	}
	public void onTestSuccess(ITestResult result) {
		String date = d.toString().replaceAll(":", "_").replaceAll(" ", "_") + "pass.jpg";
		String ScreenShotPath = ("C:\\Lingaraj\\"+ result.getEndMillis() +date);
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File ScreenshotFile = new File(ScreenShotPath);
		try {
			FileUtils.copyFile(f, ScreenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		reportng report 
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a target ="+"_blank  "+"href =" +ScreenShotPath+">ScreenShotPathPassedLink"+"</a>");
		

//		Extent Report
		Markup m = MarkupHelper.createLabel("Pass", ExtentColor.GREEN);
		extentReports.test.pass("<Details><Summary>Click to see the screenshot</Summary>" + "<a href =" + ScreenShotPath + "><img height = 300 width = 300 src =" +ScreenShotPath+ "></a>" + "</Details>");
		extentReports.test.pass(m);
	}

	public void onFinish(ITestContext context) {
		abc.flush();
	}
}
