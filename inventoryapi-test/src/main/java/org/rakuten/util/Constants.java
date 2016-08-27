/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.util;

public interface Constants {

	public static final String ENDPOINT="api.endpoint";
	public static final String PROXY_PORT="proxy.port";
	public static final String SERVER_PORT="server.port";
	public static final String AUTHORIZATION_TOKEN="ESA cTB2YXdoY3lDNzE2aFRscTpPa1R5bFJKc215YXAyZTRX";
	public static final String CONFIG="app.properties";
	public static final String user_dir = System.getProperty("user.dir");
	public static final String separator = System.getProperty("file.separator");
	public static final String RESOURCE_PATH = new StringBuilder(user_dir)
	.append(separator).append("src").append(separator).append("main").append(separator).append("resources").append(separator).toString();
	public static final String GETAPIFILE="api.get.testFileName";
	public static final String UPDATEAPIFILE="api.update.testFileName";
}
