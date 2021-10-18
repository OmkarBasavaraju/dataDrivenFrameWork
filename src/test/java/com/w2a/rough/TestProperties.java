package com.w2a.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestProperties {

	public static FileInputStream fiExcel;
	public static XSSFWorkbook avc;
	public static XSSFSheet sheet;
	public static XSSFRow r;
	public static int colNumber;
	public static int rowlastnumber;
	public static XSSFCell ce;

	public int rownumber(String SheetName) throws IOException {
		File fg = new File("C:\\Users\\IGSA937002\\Documents\\tet.xlsx");
		fiExcel = new FileInputStream(fg);
		avc = new XSSFWorkbook(fiExcel);
		sheet = avc.getSheet(SheetName);
		rowlastnumber = sheet.getLastRowNum();
		System.out.println(rowlastnumber);
		return rowlastnumber;
	}

	public int Columnnumber(String SheetName) throws IOException {
		r = sheet.getRow(0);
		colNumber = r.getLastCellNum();
		return colNumber;
	}

	public String getCellData(String SheetName, int rownumber, int colNumber) {

		r = sheet.getRow(rownumber);
		ce = r.getCell(colNumber);
		if (ce.getCellType() == CellType.STRING)
			return ce.getStringCellValue();
		else if (ce.getCellType() == CellType.NUMERIC)
			return String.valueOf(ce.getNumericCellValue());
		else if (ce.getCellType() == CellType.BOOLEAN)
			return String.valueOf(ce.getBooleanCellValue());
		else
			return "Number is not a String or numeric or boolena in excel sheet";
	}
}
