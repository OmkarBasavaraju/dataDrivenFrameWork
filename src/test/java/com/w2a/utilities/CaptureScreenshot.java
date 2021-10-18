package com.w2a.utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w2a.Base.TestBase;

public class CaptureScreenshot extends TestBase {
	
	public static void captureScreenShot() throws IOException {
		 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 String shf = ("C:\\Lingaraj\\"+"error.png");
		 File Sccrenshot = new File(shf);
		 FileUtils.copyFile(src, Sccrenshot);
	}

}
