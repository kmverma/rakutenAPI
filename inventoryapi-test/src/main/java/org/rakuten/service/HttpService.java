package org.rakuten.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.rakuten.util.Constants;

@SuppressWarnings("deprecation")
public class HttpService {

	private CloseableHttpClient client;
	private final CookieStore cookieStore = new BasicCookieStore();

	public HttpService(){
		client = new  DefaultHttpClient();
	}

	/**
	 * @param uri
	 * @param queryString
	 * @return Json String
	 * @throws URISyntaxException
	 * This method take URI and query string as parameter and make http call for GET method and return response body
	 */
	public String get(String uri,String queryString) throws URISyntaxException {
		URI url = new URI(uri+"?"+queryString);
		HttpGet request = new HttpGet(url);
		HttpResponse response = execute(request);
		return getResponseContent(response);
	}

	/**
	 * @param body
	 * @param uri
	 * @return String
	 * @throws UnsupportedEncodingException
	 * This method takes JSON input to use as request body and uri and execute POST http call and return response body
	 */
	public String post(String body,String uri) throws UnsupportedEncodingException {
		HttpPost request = new HttpPost(uri);
		HttpEntity entity = new StringEntity(body);
		request.setEntity(entity);
		HttpResponse response = execute(request);
		return getResponseContent(response);
	}

	/**
	 * @param response
	 * @return String
	 * It consumes HttpResponse and return response body and null will be returned if response is null or body in response is null
	 */
	private String getResponseContent(HttpResponse response) {
		String result = null;
		try {
			BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(response.getEntity());
			result = EntityUtils.toString(bufferedHttpEntity);
			response.setEntity(bufferedHttpEntity);
			return result;
		} catch (IOException e) {
			return result;
		}
	}

	
	/**
	 * @param request
	 * @return HttpResponse
	 * This is final and thread safe method to make execute http call and returns response
	 */
	private final synchronized HttpResponse execute(HttpUriRequest request) {
		request.addHeader(new BasicHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION_TOKEN));
		HttpClientContext context = HttpClientContext.create();
		context.setCookieStore(cookieStore);
		HttpResponse response = null;
		try {
			response = client.execute(request, context);
		} catch (IOException e) {
	
		} 
		return response;
	}
}
