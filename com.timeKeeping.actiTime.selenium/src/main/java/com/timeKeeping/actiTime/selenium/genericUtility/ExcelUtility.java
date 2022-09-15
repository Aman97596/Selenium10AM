package com.timeKeeping.actiTime.selenium.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String fetchDataFromExcelSheet(String sheetname, int rowNo,int cellNo) throws EncryptedDocumentException, IOException{
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/ExcelData10AM.xlsx");
		Workbook workbook = WorkbookFactory.create(fisExcel);
		Sheet sheet=workbook.getSheet(sheetname);
	
		return sheet.getRow(rowNo).getCell(cellNo).toString();
		
		
	}

	

}
