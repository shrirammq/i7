package com.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	public static void main(String[] args) throws Exception {

		File file = new File("E:\\Testdata.xls");

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = WorkbookFactory.create(inputStream);

		Sheet sheet = workbook.getSheet("Sheet1");
		
		System.out.println(sheet.getPhysicalNumberOfRows());
		
		System.out.println(sheet.getFirstRowNum());
		
		System.out.println(sheet.getLastRowNum());
		
		Row row = sheet.getRow(0);
		
		System.out.println(row.getPhysicalNumberOfCells());
		
		System.out.println(row.getFirstCellNum());
		
		System.out.println(row.getLastCellNum());
		
		for (int rowIndex = sheet.getFirstRowNum(); rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			for (int colIndex = sheet.getRow(rowIndex).getFirstCellNum(); colIndex <  sheet.getRow(rowIndex).getLastCellNum(); colIndex++) {
				System.out.print(sheet.getRow(rowIndex).getCell(colIndex) + "\t");
			}
			System.out.println();
		}
		
		sheet.getRow(0).createCell(5).setCellValue("Status");
		
		sheet.getRow(1).createCell(5).setCellValue("PASS");
		
		workbook.write(new FileOutputStream(file));
		
		workbook.close();

	}

}
