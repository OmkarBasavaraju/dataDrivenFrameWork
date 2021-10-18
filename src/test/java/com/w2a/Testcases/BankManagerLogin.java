package com.w2a.Testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.w2a.Base.TestBase;
import com.w2a.utilities.extentReports;

public class BankManagerLogin extends TestBase {
	
	extentReports tst = new extentReports();
	@Test
	public void loginsa() throws IOException {

//		SoftAssert soft = new SoftAssert();
//		soft.assertEquals("axc","jsd");
		System.out.println(config.getProperty("testurl"));
		log.debug("Testcase stared!");
		driver.get(config.getProperty("testurl"));
		click("bankManagerLoginButton");
//		tst.test.log(Status.INFO, "Clicking the");
		log.debug("Testcase exeecuted!");
		log.debug("login successful");
		Reporter.log("Test passed");
		System.out.println("done");
//		soft.assertAll();
	}
}
