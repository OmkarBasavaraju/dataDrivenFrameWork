package com.w2a.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.Base.TestBase;
import com.w2a.utilities.DataProviderr;

public class OpenAccount extends TestBase{
	
	
//	public void openAccount() {
//		System.out.println("Inside open account");
//		click("addAccountButton");
//		Select select = new Select(driver.findElement(By.cssSelector(config1.getProperty("selectCustomerDropdown"))));
//		System.out.println("Inside open account1");
//		select.selectByIndex(1);
////		select.selectByValue(config1.getProperty("selectCustomerTwoDropdown"));
//		System.out.println("Inside open account2");
//		Select select1 = new Select(driver.findElement(By.cssSelector(config1.getProperty("selectCurrencyDropdown"))));
//		select1.selectByValue("Dollar");
////		select1.selectByIndex(2);
//		click("clickProcessButton");
//		driver.switchTo().alert().accept();
//	}
	
	@Test(dataProviderClass = DataProviderr.class,dataProvider = "dp")
	public void openAccount(String Name,String currency) {
		System.out.println(Name);
		click("addAccountButton");
		System.out.println(currency);
		select("selectCustomerDropdown",Name);
		select("selectCurrencyDropdown",currency);
		click("clickProcessButton");
		driver.switchTo().alert().accept();
	}
}
