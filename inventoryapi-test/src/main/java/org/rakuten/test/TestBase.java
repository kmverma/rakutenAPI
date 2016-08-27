/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 22-Aug-2016
 *  @author kishan
 */
package org.rakuten.test;

import org.rakuten.api.server.MockServer;
import org.rakuten.service.ApiService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	private static MockServer mockServer;
	protected static ApiService apiService;

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite(){
		mockServer = MockServer.getInstance();
		apiService = new ApiService();
		mockServer.start();
	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite(){
		mockServer.stop();
	}


}
