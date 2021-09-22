package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	
	 public String getExcelData(String sheetName, int rownum, int cellnum) throws Throwable
	 {
		 FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		 Workbook workbook=WorkbookFactory.create(fis);
		
		 Sheet sheet = workbook.getSheet(sheetName);
		 Row row = sheet.getRow(rownum);
		 Cell cell = row.getCell(cellnum);
		 String value = cell.getStringCellValue();
		 
		 return value;
	 }

	 public int getExcelData1(String sheetName, int rownum, int cellnum) throws Throwable
	 {
		 FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		 Workbook workbook=WorkbookFactory.create(fis);
		
		 Sheet sheet = workbook.getSheet(sheetName);
		 Row row = sheet.getRow(rownum);
		 Cell cell = row.getCell(cellnum);
		double value = cell.getNumericCellValue();
		 int value2 = (int)value; 
		 return value2;
	 }
	
	 
	 public Object[][] getExcelData2(String SheetName) throws Throwable
	 {
		 FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		 Workbook workbook=WorkbookFactory.create(fis);
			
		 Sheet sheet = workbook.getSheet(SheetName);
		 int lastRow = sheet.getLastRowNum();
		 short lastCell = sheet.getRow(0).getLastCellNum();
		 
		 Object[][] data=new Object[lastRow][lastCell];
		 
		 for(int i=0;i<lastRow;i++)
		 {
			 for (int j=0;j<lastCell;j++)
			 {
				 data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			 }
		 }
		 return data;
	 }
}
