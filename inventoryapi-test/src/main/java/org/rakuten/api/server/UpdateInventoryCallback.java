/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 22-Aug-2016
 *  @author kishan
 */
package org.rakuten.api.server;

import java.util.HashMap;
import java.util.Map;

import org.mockserver.mock.action.ExpectationCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.rakuten.model.TestData;
import org.rakuten.request.UpdateInventoryRequest;
import org.rakuten.response.UpdateInventoryResponse;
import org.rakuten.util.ConfigStore;
import org.rakuten.util.Constants;
import org.rakuten.util.Util;
import org.rakuten.util.XLSUtility;

public class UpdateInventoryCallback implements ExpectationCallback{

	Map<UpdateInventoryRequest,UpdateInventoryResponse> requestResponseMap; 

	public UpdateInventoryCallback(){
		requestResponseMap = new HashMap<>();
		XLSUtility xlsUtility = new XLSUtility();
		Map<Integer, TestData> rawRequestResponseMap = xlsUtility.getTestData(Constants.RESOURCE_PATH+ConfigStore.getConfig(Constants.UPDATEAPIFILE));
		if(rawRequestResponseMap!=null && rawRequestResponseMap.size()>0){
			for(TestData values : rawRequestResponseMap.values()){
				requestResponseMap.put((UpdateInventoryRequest)Util.serialize(values.getRequest(), UpdateInventoryRequest.class),
						(UpdateInventoryResponse)Util.serialize(values.getResponse(), UpdateInventoryResponse.class));
			}
		}
	}

	@Override
	public HttpResponse handle(HttpRequest httpRequest) {
		if (httpRequest.getPath().getValue().endsWith("/inventory/update")) {
			return getResponse(httpRequest);
		}else
			return null;
	}

	private HttpResponse getResponse(HttpRequest httpRequest){
		HttpResponse httpResponse = new HttpResponse();
		String body = httpRequest.getBodyAsString();
		UpdateInventoryRequest request =  (UpdateInventoryRequest) Util.serialize(body, UpdateInventoryRequest.class);
		UpdateInventoryResponse response = requestResponseMap.get(request);
		httpResponse.withBody(Util.deserialize(response))
		.withStatusCode(200);
		return httpResponse;
	}
}
