/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.model;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;


public class ShopInventory {
	
	@JsonProperty(value="marketplaceIdentifier")
	String marketplaceIdentifier;
	
	@JsonProperty(value="shopURL")
	String shopUrl;
	
	Map<String,Inventory> inventory;
	
	public String getMarketPlaceIdentifier() {
		return marketplaceIdentifier;
	}
	public String getShopUrl() {
		return shopUrl;
	}
	public Map<String, Inventory> getInventory() {
		return inventory;
	}
	public void setMarketPlaceIdentifier(String marketPlaceIdentifier) {
		this.marketplaceIdentifier = marketPlaceIdentifier;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	public void setInventory(Map<String, Inventory> inventory) {
		this.inventory = inventory;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((inventory == null) ? 0 : inventory.hashCode());
		result = prime
				* result
				+ ((marketplaceIdentifier == null) ? 0 : marketplaceIdentifier
						.hashCode());
		result = prime * result + ((shopUrl == null) ? 0 : shopUrl.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopInventory other = (ShopInventory) obj;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (marketplaceIdentifier == null) {
			if (other.marketplaceIdentifier != null)
				return false;
		} else if (!marketplaceIdentifier.equals(other.marketplaceIdentifier))
			return false;
		if (shopUrl == null) {
			if (other.shopUrl != null)
				return false;
		} else if (!shopUrl.equals(other.shopUrl))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShopInventory [marketplaceIdentifier=")
				.append(marketplaceIdentifier).append(",shopUrl=")
				.append(shopUrl).append(",inventory=").append(inventory)
				.append("]");
		return builder.toString();
	}
	
}
