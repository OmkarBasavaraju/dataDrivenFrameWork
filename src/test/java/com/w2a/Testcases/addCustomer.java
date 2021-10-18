package com.w2a.Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.Base.TestBase;
import com.w2a.utilities.DataProviderr;
import com.w2a.utilities.excelReader;

public class addCustomer extends TestBase{

	@Test(dataProviderClass = DataProviderr.class,dataProvider="dp")
	public void enterCustomerData(String FirstName,String Surname,String Postcode,String Runnablee){
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(config1.getProperty("addCustomerButton")))).click();
	if (!Runnablee.equalsIgnoreCase("Y")) {
		throw new SkipException("Skipped");
	}
	type("customerFirstNameButton",FirstName);
	type("customerLastNameButton",Surname);
	String postcodes = String.valueOf(Postcode);
	type("customerPostcodeButton",postcodes);
//	Reporter.log("<a target = \"_blank\"  href = \"C:\\Lingaraj\\error.jpg\">Screenshot</a>");
//	Reporter.log("<br>");
//	Reporter.log("<a target = \"_blank\"  href = \"C:\\Lingaraj\\error.jpg\"><img height = 200 width =300 src= \"C:\\Lingaraj\\error.jpg\"></a>");
	click("addCompleteCustomerButton");
	wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
	}
}
