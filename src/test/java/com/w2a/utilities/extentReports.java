package com.w2a.utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReports {
	
public static ExtentSparkReporter htmlreporterd;
public static ExtentReports extentReport;
public static ExtentTest test;

public static ExtentReports ReporterSetup() {
	Date d = new Date();
	String filename = (d.toString().replace(":", "_").replace(" ", "_")+"report.html");
	htmlreporterd = new ExtentSparkReporter("C:\\Users\\IGSA937002\\eclipse-workspace\\DataDrivenFrameWork\\Reports\\"+filename);
	htmlreporterd.config().setEncoding("UTF-8");
	htmlreporterd.config().setTheme(Theme.STANDARD);
	htmlreporterd.config().setReportName("Datadriven approach TestNG frame work reports");
	extentReport = new ExtentReports();
	extentReport.attachReporter(htmlreporterd);
	return extentReport;
	}
}

