/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 24-Aug-2016
 *  @author kishan
 */
package org.rakuten.model;

public class TestData {

	String request;
	String response;

	public TestData(){

	}
	
	public TestData(String request,String response){
		this.request=request;
		this.response=response;
	}

	public String getRequest() {
		return request;
	}
	public String getResponse() {
		return response;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TestData [request=")
		.append(request).append(",response=").append(response)
		.append("]");
		return builder.toString();
	}


}
