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
import org.rakuten.response.GetInventoryResponse;
import org.rakuten.util.ConfigStore;
import org.rakuten.util.Constants;
import org.rakuten.util.Util;
import org.rakuten.util.XLSUtility;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetInventoryAPITest extends TestBase{

	Map<Integer, TestData> requestResponseMap;

	@BeforeClass(alwaysRun=true)
	public void beforeClass(){
		XLSUtility xlsUtility = new XLSUtility();
		requestResponseMap = xlsUtility.getTestData(Constants.RESOURCE_PATH+ConfigStore.getConfig(Constants.GETAPIFILE));
		if(requestResponseMap == null)
			throw new RuntimeException("Failed to load test Data");
	}

	@DataProvider(parallel=true)
	public Object[][] getDataForBaseSkus(){
		Object[][] object = new Object[1][1];
		object[0][0]=1;
		return object;
	}

	@Test(enabled=true,testName="test get Api For baseSkus",dataProvider="getDataForBaseSkus",groups={"positive","sanity"},
			description="This method will if getInventory api contain baseSkus in query string")
	public void testForBaseSkus(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataForSkus(){
		Object[][] object = new Object[1][1];
		object[0][0]=2;
		return object;
	}

	@Test(enabled=true,testName="test get Api For Skus",dataProvider="getDataForSkus",groups={"positive","sanity"},
			description="This method will if getInventory api contain skus in query string")
	public void testForSkus(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataForInvalidRequest(){
		Object[][] object = new Object[1][1];
		object[0][0]=3;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataForInvalidRequest",testName="test get Api for Invalid Request",groups="negative",
			description="This method will pass parameters which make request invalid")
	public void testInvalidRequest(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataNonExistingProductsForBaseSku(){
		Object[][] object = new Object[1][1];
		object[0][0]=4;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataNonExistingProductsForBaseSku",testName="test get Api for request for which products do not exists",groups="negative",
			description="This method will pass baseSku parameters for which productds do not exists")
	public void testForNonExistingProductsForBaseSkus(int testCaseId){
		performTest(testCaseId);
	}

	@DataProvider(parallel=true)
	public Object[][] getDataNonExistingProductsForSku(){
		Object[][] object = new Object[1][1];
		object[0][0]=5;
		return object;
	}

	@Test(enabled=true,dataProvider="getDataNonExistingProductsForSku",testName="test get Api for request for which products do not exists",groups="negative",
			description="This method will pass skus parameters for which productds do not exists")
	public void testForNonExistingProductsForSkus(int testCaseId){
		performTest(testCaseId);
	}

	/**
	 * @param testCaseId
	 * This method perform all actual test, it makes call to web server to get actual response and generated expected response and assert response 
	 */
	private void performTest(int testCaseId){
		TestData testData = requestResponseMap.get(testCaseId);
		GetInventoryResponse response = apiService.getInventory(Util.getParametersFromJson(testData.getRequest()));
		GetInventoryResponse expectedResponse = (GetInventoryResponse) Util.serialize(testData.getResponse(), GetInventoryResponse.class); 
		Reporter.log("\nActual Response : "+response);
		Reporter.log("\nExpected Response : "+expectedResponse);
		SoftAssert assertion = new SoftAssert();
		assertion.assertNotNull(response);
		assertion.assertTrue(expectedResponse.equals(response));
		assertion.assertAll();
	}
}
