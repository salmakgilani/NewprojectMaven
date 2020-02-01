package com.actitime.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	public static String getData(String file_path,String sheetName,int rn,int cn)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(file_path);
			Workbook wb = WorkbookFactory.create(fis);
			Row r = wb.getSheet(sheetName).getRow(rn);
			String data = r.getCell(cn).getStringCellValue();
			return data;
		} 
		catch (Exception e) 
		{
			return " "; 
		}
	}
	public static int getRowCount(String file_path,String sheetName)
	{
		try
		{
			FileInputStream fis  = new FileInputStream(file_path);
			Workbook wb = WorkbookFactory.create(fis);
			int rc = wb.getSheet(sheetName).getLastRowNum();
			return rc;
		} 
		catch (Exception e) 
		{
			return -1;
		}
	}
	public static int getCellCount(String file_path,String sheetName,int rn)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(file_path);
			Workbook wb = WorkbookFactory.create(fis);
			int cc = wb.getSheet(sheetName).getRow(rn).getLastCellNum();
			return cc;
		} 
		catch (Exception e)
		{
			return -1;
		}
	}
}
