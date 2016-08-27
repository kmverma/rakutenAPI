/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 22-Aug-2016
 *  @author kishan
 */
package org.rakuten.api.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.mockserver.mock.action.ExpectationCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.NottableString;
import org.mockserver.model.Parameter;
import org.rakuten.model.TestData;
import org.rakuten.response.GetInventoryResponse;
import org.rakuten.util.ConfigStore;
import org.rakuten.util.Constants;
import org.rakuten.util.Util;
import org.rakuten.util.XLSUtility;


public class GetInventoryCallback implements ExpectationCallback{

	Map<Map<String,Set<String>>,GetInventoryResponse> requestResponseMap; 

	public GetInventoryCallback(){
		requestResponseMap = new HashMap<>();
		XLSUtility xlsUtility = new XLSUtility();
		Map<Integer, TestData> rawRequestResponseMap = xlsUtility.getTestData(Constants.RESOURCE_PATH+ConfigStore.getConfig(Constants.GETAPIFILE));
		for(TestData values : rawRequestResponseMap.values()){
			requestResponseMap.put(Util.getParametersFromJson(values.getRequest()),
					(GetInventoryResponse)Util.serialize(values.getResponse(), GetInventoryResponse.class));
		}	
	}

	/* (non-Javadoc)
	 * @see org.mockserver.mock.action.ExpectationCallback#handle(org.mockserver.model.HttpRequest)
	 */
	@Override
	public HttpResponse handle(HttpRequest httpRequest) {
		if (httpRequest.getPath().getValue().endsWith("/inventory/get")) {
			return getResponse(httpRequest);
		}else
			return null;
	}

	/**
	 * @param httpRequest
	 * @return HttpResponse
	 * It take httpRequest as input and after processing return response for request of get inventory api 
	 */
	private HttpResponse getResponse(HttpRequest httpRequest){
		Map<String,Set<String>> request = new HashMap<String, Set<String>>();
		HttpResponse httpResponse = new HttpResponse();
		for( Parameter params : httpRequest.getQueryStringParameters()){
			Set<String> value = new HashSet<String>();
			for(NottableString val : params.getValues()){
				value.add(val.getValue());
			}
			request.put(params.getName().getValue(), new HashSet<String>(value));
		}
		GetInventoryResponse response = requestResponseMap.get(request);
		httpResponse.withBody(Util.deserialize(response))
		.withStatusCode(200);
		return httpResponse;
	}

}
