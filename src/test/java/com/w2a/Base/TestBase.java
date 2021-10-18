package com.w2a.Base;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.Status;
import com.w2a.utilities.extentReports;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.w2a.utilities.CaptureScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties config;
	public static Properties config1;
	public static Logger log = Logger.getLogger("dev");
	public static WebDriverWait wait;
	extentReports tst = new extentReports();
	public static String browser;

	@BeforeSuite
	public void setup() throws IOException {
		config = new Properties();
		config1 = new Properties();
		String propertiesPath = (System.getProperty("user.dir")
				+ "\\src\\test\\resources\\properties\\Config.properties");
		String ORPath = (System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		File fOne = new File(propertiesPath);
		File fTwo = new File(ORPath);
		FileInputStream fiOne = new FileInputStream(fOne);
		FileInputStream fiTwo = new FileInputStream(fTwo);
		config.load(fiOne);
		config1.load(fiTwo);
		
		
		if (((System.getenv("browser") != null)) && (!(System.getenv().isEmpty()))) {
			browser = System.getenv("browser");
		} else {
			browser = config.getProperty("browser");
		}

		config.setProperty("browser", browser);

		if (config.getProperty("browser").equals("chrome")) {
			System.out.println("test1");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
//		WebDriverManager.chromedriver().setup();
			System.out.println("test2t");
			driver.manage().window().maximize();
			System.out.println(config.getProperty("time"));
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("time")), TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, (Integer.parseInt(config.getProperty("time"))));
			System.out.println("test2");
		}
	}

	public void click(String locator) {
		driver.findElement(By.cssSelector(config1.getProperty(locator))).click();
	}

	public void type(String locator, String Info) {
		driver.findElement(By.cssSelector(config1.getProperty(locator))).sendKeys(Info);
		tst.test.log(Status.INFO, "Clicking the" + locator + "and typing the :" + Info);
	}

	public boolean isElementPresent(String locator) {
		try {
			driver.findElement(By.cssSelector(locator));
			return true;
		} catch (Exception e) {
			System.out.println("Element not present");
			return false;
		}
	}

	public void verifyEquals(String Expected, String Actual) throws IOException {
		try {
			System.out.println("hfhf");
			Assert.assertEquals(Expected, Actual);
		} catch (Throwable t) {
			System.out.println("hfhfff");
			CaptureScreenshot.captureScreenShot();
			System.out.println("hff");
			tst.test.log(Status.FAIL, "Taking the screenshot ");
		}
	}

	public WebElement abc;

	public void select(String locator, String Value) {
		abc = driver.findElement(By.cssSelector(config1.getProperty(locator)));
		Select select = new Select(abc);
		select.selectByVisibleText(Value);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
