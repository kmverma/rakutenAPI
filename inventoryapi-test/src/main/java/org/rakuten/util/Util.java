/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;

public class Util {

	public static ObjectMapper mapper = new ObjectMapper();

	public static String getUriFromParams(Map<String,Set<String>> params){
		StringBuilder queryString = new StringBuilder();
		if(params != null && params.size()>0){
			for(Entry<String, Set<String>> entry:params.entrySet()){
				for(String queryValue : entry.getValue()){
					queryString.append(entry.getKey())
					.append("=")
					.append(queryValue)
					.append("&");
				}
			}
			return queryString.substring(0,queryString.length()-1);
		}
		return queryString.toString();
	}

	public static Object serialize(String json,Class<?> className){
		try{
			return mapper.readValue(json, className);
		}catch(Exception e){
			System.out.println(json);
			e.printStackTrace();
			return null;
		}
	}

	public static String deserialize(Object object){
		try{
			return mapper.writeValueAsString(object);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public static Map<String,Set<String>> getParametersFromJson(String request){
		Map<String,Set<String>> data = new HashMap<>();
		try {
			JsonNode node = mapper.readTree(request);

			Iterator<Entry<String, JsonNode>> iterator = node.getFields();
			while(iterator.hasNext()){
				Entry<String, JsonNode> next  = iterator.next();
				String key =next.getKey();
				Set<String> value = new HashSet<>();
				if(next.getValue() instanceof ArrayNode){
					ArrayNode nodevalue = (ArrayNode) next.getValue();
					Iterator<JsonNode> itr  = nodevalue.getElements();
					while(itr.hasNext())
						value.add(itr.next().asText());
				}else {
					value.add(next.getValue().getValueAsText());
				}
				data.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
