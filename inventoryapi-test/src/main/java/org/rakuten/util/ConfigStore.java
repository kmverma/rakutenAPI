/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigStore {

	private static Properties properties;

	/**
	 * @param key
	 * @return property value 
	 * This method will be used to get config value for given keys, and before
	 * getting key, it loads config if not loaded already 
	 */
	public static String getConfig(String key) {
		if (properties == null) {
			loadConfig();
		}
		return (String) properties.get(key);
	}

	/**
	 * This method will load config from specified file exists in class path
	 */
	private static void loadConfig() {
		InputStream stream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(Constants.CONFIG);
		try {
			properties = new Properties();
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
