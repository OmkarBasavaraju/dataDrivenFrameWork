package com.w2a.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.w2a.Base.TestBase;

public class DataProviderr extends TestBase {
	public static int rownumber;
	public static int Columnnumber;
	excelReader excel = new excelReader();

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) throws IOException {
		String SheetName = m.getName();
		System.out.println(SheetName);
		rownumber = excel.rownumber(SheetName);
		Columnnumber = excel.Columnnumber(SheetName);
		Object[][] obj = new Object[rownumber][Columnnumber];

		for (int i = 1; i < rownumber + 1; i++) {
			for (int j = 0; j < Columnnumber; j++) {
				System.out.println(obj[i - 1][j] = excel.getCellData(SheetName, i, j));
			}
		}
		return obj;
	}

	public boolean testRunnable(String TestName, excelReader excel) throws IOException {
		String SheetName = "TestSuite";
		int row = excel.rownumber(SheetName);// 3
		int cols = excel.Columnnumber(SheetName);// 2
		for (int i = 1; i < row + 1; i++) {// 3
			String testcase = excel.getCellData(SheetName, i, 0);
			System.out.println(testcase);

			if (testcase.equalsIgnoreCase(TestName)) {
				String RunnableStatus = excel.getCellData(SheetName, i, 1);
				System.out.println(RunnableStatus);
				if (RunnableStatus.equalsIgnoreCase("Y")) {
					return true;
				}
				return false;
			}

		}
		return false;
	}
}
