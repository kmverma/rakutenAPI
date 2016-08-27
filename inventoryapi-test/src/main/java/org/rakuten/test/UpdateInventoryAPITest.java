/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.test;

import java.util.Map;

import org.rakuten.model.TestData;
import org.rakuten.request.UpdateInventoryRequest;
import org.rakuten.response.UpdateInventoryResponse;
import org.rakuten.util.ConfigStore;
import org.rakuten.util.Constants;
import org.rakuten.util.Util;
import org.rakuten.util.XLSUtility;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdateInventoryAPITest extends TestBase{

	Map<Integer, TestData> requestResponseMap;

	@BeforeTest(alwaysRun=true)
	public void BeforeTest(){
		XLSUtility xlsUtility = new XLSUtility();
		requestResponseMap = xlsUtility.getTestData(Constants.RESOURCE_PATH+ConfigStore.getConfig(Constants.UPDATEAPIFILE));
		if(requestResponseMap == null)
			throw new RuntimeException("Failed to load test Data");
	}

	@DataProvider(parallel=true)
	public Object[][] getDataForValidUpdatesForSingleShop(){
		int testCaseId=1;
		Object[][] object = new Object[1][1];
		object[0][0]=testCaseId;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataForValidUpdatesForSingleShop",testName="Test for update request for single shop",groups={"sanity","positive"},
			description="This method will pass update request for only one shop in a request")
	public void testValidUpdatesForSingleShop(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataForValidUpdatesForMultipleShop(){
		int testCaseId=2;
		Object[][] object = new Object[1][1];
		object[0][0]=testCaseId;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataForValidUpdatesForMultipleShop",testName="Test for update request for multiple shop",groups="positive",
			description="This method will pass update request for multiple shops in a request")
	public void testValidUpdatesForMultipleShop(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataForValidAndInvalidRequest(){
		int testCaseId=3;
		Object[][] object = new Object[1][1];
		object[0][0]=testCaseId;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataForValidAndInvalidRequest",testName="Test for update request for multiple shop with valid and invalid request",groups="positive",
			description="This method will pass update request for multiple shops in which some are valid and some or invalid")
	public void testUpdatesForValidAndInvalidRequest(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataFor30Shops(){
		int testCaseId=4;
		Object[][] object = new Object[1][1];
		object[0][0]=testCaseId;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataFor30Shops",testName="Test for request contains update for exact 30 shops",groups="positive",
			description="This method will pass update request for exact 30 shops, api should give be successful")
	public void testFor30Shops(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataForMoreThan30Shops(){
		int testCaseId=5;
		Object[][] object = new Object[1][1];
		object[0][0]=testCaseId;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataForMoreThan30Shops",testName="Test for request contains update for more than 30 shops",groups="negative",
			description="This method will pass update request for more than 30 shops, api should give error")
	public void testForMoreThan30Shops(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataForQuantityInGreaterThanAllowed(){
		int testCaseId=6;
		Object[][] object = new Object[1][1];
		object[0][0]=testCaseId;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataForQuantityInGreaterThanAllowed",testName="Test for request contains update for more than 30 shops",groups="post",
			description="This method will pass update request which contain quantity of some sku in range and for some sku out of range")
	public void testForQuantityInGreaterThanAllowed(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=false)
	public Object[][] getDataForInvalidRequest(){
		int totalCase=9;
		int startCaseId=7;
		Object[][] object = new Object[totalCase][1];
		for(int i=0;i<totalCase;i++){
			object[i][0]=i+startCaseId;
		}
		return object;
	}

	@Test(enabled=true,dataProvider="getDataForInvalidRequest",testName="Test for invalid request",groups="negative",
			description="This method will pass update request which is invalid according to validation rule")
	public void testForInvalidRequest(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataForMoreThan1000SkusPerShops(){
		int testCaseId=50;
		Object[][] object = new Object[1][1];
		object[0][0]=testCaseId;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataForMoreThan1000SkusPerShops",testName="Test for request contains update for more than 1000 skus for a shop",groups="negative",
			description="This method will pass update request for more than 1000 uniq skus for a shops")
	public void testForMoreThan1000SkusPerShops(int testCaseId){
		performTest(testCaseId);
	}


	/**
	 * @param testCaseId
	 * This method perform all actual test, it makes call to web server to get actual response and generated expected response and assert response 
	 */
	private void performTest(int testCaseId){
		TestData testData = requestResponseMap.get(testCaseId);
		UpdateInventoryResponse response = apiService.updateInventory((UpdateInventoryRequest) Util.serialize(testData.getRequest(), UpdateInventoryRequest.class));
		UpdateInventoryResponse expectedResponse = (UpdateInventoryResponse) Util.serialize(testData.getResponse(), UpdateInventoryResponse.class);
		SoftAssert assertion = new SoftAssert();
		Reporter.log("Actual Request "+response);
		Reporter.log("Expected  Request "+expectedResponse);
		assertion.assertTrue(expectedResponse.equals(response));
		assertion.assertAll();
	}

}
