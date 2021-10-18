package com.w2a.rough;

import java.io.IOException;

public class callXcel {

	TestProperties t = new TestProperties();
	String SheetName = "Apoorva";

	public static void main(String[] args) throws IOException {
		callXcel sc= new callXcel();
		sc.getcelldata();
	}

	public void getcelldata() throws IOException {
		int row = t.rownumber(SheetName);
		int col = t.Columnnumber(SheetName);
		System.out.println(row);
		System.out.println(col);
		Object[][] obj = new Object[row][col];
		for (int i = 1; i < row+1 ; i++) { //3
			for (int j = 0; j < col; j++) {//2
				System.out.println(obj[i-1][j]=t.getCellData(SheetName, i, j));
			}
		}
	}
}
