package com.pratik.framework.utilities.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.ss.usermodel.Sheet;

public class ExcelUtils {
	
	public static Workbook getWorkbook(String filePath) throws IOException {

	    try (FileInputStream fileInputStream =
	            new FileInputStream(filePath)) {

	        return WorkbookFactory.create(fileInputStream);
	    }
	}
	
	public static Sheet getSheet(
	        Workbook workbook, String sheetName) {

	    return workbook.getSheet(sheetName);
	}
	
	public static int getRowCount(Sheet sheet) {

	    return sheet.getPhysicalNumberOfRows();
	}
	
	public static String getCellValue(
	        Sheet sheet, int rowNumber, int columnNumber) {

	    if (sheet.getRow(rowNumber) == null) {
	        return "";
	    }

	    if (sheet.getRow(rowNumber).getCell(columnNumber) == null) {
	        return "";
	    }

	    return sheet
	            .getRow(rowNumber)
	            .getCell(columnNumber)
	            .toString();
	}

}
