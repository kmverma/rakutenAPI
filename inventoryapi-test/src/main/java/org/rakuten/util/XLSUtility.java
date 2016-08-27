/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 24-Aug-2016
 *  @author kishan
 */
package org.rakuten.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.rakuten.model.TestData;

public class XLSUtility {

	/**
	 * @param file
	 * @return map of testData 
	 * 
	 * This method take file name for test data and convert it into map of testCaseId and Object of testData
	 * Excel file is expected to have at-least 3 columns else that row will be skipped, testCase id is supposed 
	 * to be unique other wise test data will be overridden
	 * This method will return null if file does not exists or if file does not contains any data row
	 */
	public Map<Integer,TestData> getTestData(String file){
		Iterator<Row> rows = getSheetData(file);
		DataFormatter fmt = new DataFormatter();
		if(rows == null )
			return null;
		Map<Integer,TestData> testData = new HashMap<>();
		while(rows.hasNext()){
			Row nextRow = rows.next();
			if(nextRow.getPhysicalNumberOfCells()>=3){
				try{
					Cell testCaseId = nextRow.getCell(0,Row.RETURN_BLANK_AS_NULL);
					Cell request = nextRow.getCell(1);
					Cell response = nextRow.getCell(2);
					TestData testData2 = new TestData(request.getStringCellValue(),response.getStringCellValue());
					testData.put(Integer.parseInt(fmt.formatCellValue(testCaseId)),testData2 );
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return testData;
	}

	/**
	 * @param fileLocation
	 * @return Iterator of Row
	 * This method take file path as input and return iterator or rows, it will return null if file does not exists or its corrupted
	 * 
	 */
	private Iterator<Row> getSheetData(String fileLocation){
		File file = new File(fileLocation);
		if(!file.exists())
			return null;
		try {
			FileInputStream fileStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			try{
				workbook.close();	
			}catch(Exception e){
				e.printStackTrace();
			}
			return iterator;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
