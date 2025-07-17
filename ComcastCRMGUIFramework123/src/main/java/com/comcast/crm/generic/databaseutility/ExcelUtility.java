package com.comcast.crm.generic.databaseutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws Throwable, Exception {
		FileInputStream fis=new FileInputStream("./testData/TestScriptData1.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		 wb.close(); 
		return data;
	    
	}
	public int getRowCount(String sheetName) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./testData/TestScriptData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
		}
	public String setDataintoExcel(String sheetName,int rowNum,int celNum,String data) throws IOException {
		FileInputStream fis=new FileInputStream("./testData/TestScriptData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
			wb.getSheet(sheetName).getRow(rowNum).getCell(celNum);
			FileOutputStream fos=new FileOutputStream("./testdata/TestScriptData1.xlsx");
			wb.write(fos);
			wb.close();
		
		return data;
		
	}
	
}



