/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 23-Aug-2016
 *  @author kishan
 */
package org.rakuten.api.server;

import static org.mockserver.integration.ClientAndProxy.startClientAndProxy;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpCallback;
import org.mockserver.model.HttpRequest;
import org.rakuten.util.ConfigStore;
import org.rakuten.util.Constants;

public class MockServer {

	private ClientAndProxy proxy;
	private ClientAndServer mockServer;
	private static MockServer mockServerInstance;

	public static MockServer getInstance(){
		if(mockServerInstance==null)
			mockServerInstance =new MockServer();
		return mockServerInstance;
	}

	private MockServer(){

	}

	/**
	 *  This method starts http mock server and proxy server on port specified in config file and throw Runtime Exception if fails to start server
	 */
	public void start(){	
		try{
			mockServer = startClientAndServer(Integer.parseInt(ConfigStore.getConfig(Constants.SERVER_PORT)));
			proxy = startClientAndProxy(Integer.parseInt(ConfigStore.getConfig(Constants.PROXY_PORT)));
			mockGetInventory();
			mockUpdateInventory();
		}catch(Exception e){
			throw new RuntimeException("Failed to start mocking server, exiting test");
		}
	}

	/**
	 *  It stops proxy server and http mock server
	 */
	public void stop(){
		try{
			proxy.stop();
			mockServer.stop();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * It listens HTTP request for inventory/get and passes call to specified handlers class after checking authentication token in request header and HTTP method GET
	 */
	public void mockGetInventory(){
		HttpCallback httpCallback = new HttpCallback();
		mockServer.when(new HttpRequest()
		.withMethod("GET")
		.withPath("/inventory/get")
		.withHeader("Authorization", Constants.AUTHORIZATION_TOKEN))
		.callback(httpCallback
				.withCallbackClass("org.rakuten.api.server.GetInventoryCallback"));
	}

	/**
	 * It listens HTTP request for inventory/update and passes call to specified handlers class after checking authentication token in request header and HTTP method POST
	 */
	public void mockUpdateInventory(){
		HttpCallback httpCallback = new HttpCallback();
		mockServer.when(new HttpRequest()
		.withMethod("POST")
		.withPath("/inventory/update")
		.withHeader("Authorization", Constants.AUTHORIZATION_TOKEN))
		.callback(httpCallback
				.withCallbackClass("org.rakuten.api.server.UpdateInventoryCallback"));
	}
}
