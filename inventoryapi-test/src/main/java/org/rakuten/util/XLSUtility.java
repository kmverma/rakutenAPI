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
