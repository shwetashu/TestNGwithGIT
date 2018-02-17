package com.mercury.utilities;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelUtility {

	static HSSFWorkbook book;
	static HSSFSheet sheet;
	static HSSFRow row;
	public static void ExcelInitialzation()
	{
		try
		{
			File f=new File("D:/workspace/TestNGwithGIT/com_mercury_test_data/MercuryTestDataSheet.xls");
			FileInputStream fis=new FileInputStream(f);
			book=new HSSFWorkbook(fis);
		}
		catch(Exception e){}
	}

	public static void getSheet(String SheetName)
	{
		sheet=book.getSheet(SheetName);
	}

	public static void getRow(int RowNum)
	{
		row=sheet.getRow(RowNum);
	}

	/*
	public static void getRow(String RowData,int ColIndex)
	{

	}*/

	public static String getCellData(int ColNum)
	{
		return row.getCell(ColNum).getStringCellValue();
	}
	public static String getCellData(int RowNum,int ColNum)
	{
		getRow(RowNum);
		return getCellData(ColNum);
	}
	public static int getColumnIndex(String ColumnName)
	{
		int colIndex=-1;
		HSSFRow r=sheet.getRow(0);
		int colCount=r.getLastCellNum();
		for (int i = 0; i <colCount; i++) {
			if(ColumnName.equalsIgnoreCase(r.getCell(i).getStringCellValue()))
			{
				colIndex=i;
				break;
			}
		}
		return colIndex;
	}
	public static String getCellData(int RowNum,String ColumnName)
	{
		return getCellData(RowNum,getColumnIndex(ColumnName));
	}
	public static String getCellData(String ColumnName)
	{
		return getCellData(getColumnIndex(ColumnName));
	}

	public static int getRowCount()
	{
		return sheet.getLastRowNum();
	}





}
