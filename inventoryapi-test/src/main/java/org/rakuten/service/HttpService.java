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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("deprecation")
public class HttpService {

	private static final Logger LOG = LoggerFactory.getLogger(HttpService.class);

	private CloseableHttpClient client;
	private final CookieStore cookieStore = new BasicCookieStore();

	public HttpService(){
		client = new  DefaultHttpClient();
	}

	public String get(String uri,String queryString) throws URISyntaxException {
		URI url = new URI(uri+"?"+queryString);
		HttpGet request = new HttpGet(url);
		HttpResponse response = execute(request);
		return getResponseContent(response);
	}

	public String post(String body,String uri) throws UnsupportedEncodingException {
		HttpPost request = new HttpPost(uri);
		HttpEntity entity = new StringEntity(body);
		request.setEntity(entity);
		HttpResponse response = execute(request);
		return getResponseContent(response);
	}

	private String getResponseContent(HttpResponse response) {
		String result = null;
		try {
			BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(response.getEntity());
			result = EntityUtils.toString(bufferedHttpEntity);
			response.setEntity(bufferedHttpEntity);
			return result;
		} catch (IOException e) {
			LOG.error("Error while Getting response body  ",e);
			return result;
		}
	}

	
	private final synchronized HttpResponse execute(HttpUriRequest request) {
		request.addHeader(new BasicHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION_TOKEN));
		HttpClientContext context = HttpClientContext.create();
		context.setCookieStore(cookieStore);
		HttpResponse response = null;
		try {
			LOG.debug("Performing HTTP Request : "+request);
			response = client.execute(request, context);
			LOG.debug("Response for Http Call : "+response);
		} catch (IOException e) {
			LOG.error("Got Exception while performing http call ",e);
		} 
		return response;
	}
}
