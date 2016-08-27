/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

import org.rakuten.request.UpdateInventoryRequest;
import org.rakuten.response.GetInventoryResponse;
import org.rakuten.response.UpdateInventoryResponse;
import org.rakuten.util.ConfigStore;
import org.rakuten.util.Constants;
import org.rakuten.util.Util;
import org.testng.Reporter;

public class ApiService {

	private static String endPoint;
	HttpService httpService;

	public ApiService(){
		endPoint = (String) ConfigStore.getConfig(Constants.ENDPOINT);
		httpService = new HttpService();
	}

	/**
	 * @param request
	 * @return UpdateInventoryResponse 
	 * This method take object of UpdateInventoryRequest as input and make http call to web server for update api and return UpdateInventoryResponse as response
	 */
	public UpdateInventoryResponse updateInventory(UpdateInventoryRequest request){
		String uri=endPoint+"inventory/update";
		Reporter.log("Request : "+request);
		UpdateInventoryResponse response = null ;
		try {
			String responseBody = httpService.post(Util.deserialize(request), uri);
			response = (UpdateInventoryResponse) Util.serialize(responseBody, UpdateInventoryResponse.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * @param params
	 * @return GetInventoryResponse
	 * This method take object of request params  as input and make http call to web server for get api and return object of GetInventoryResponse as response
	 */
	public GetInventoryResponse getInventory(Map<String,Set<String>> params){
		String uri=endPoint+"inventory/get";
		Reporter.log("Request Parameters : "+params);
		GetInventoryResponse response = null;
		try {
			String responseBody = httpService.get(uri,Util.getUriFromParams(params));
			response = (GetInventoryResponse) Util.serialize(responseBody, GetInventoryResponse.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return response;
	}
}
