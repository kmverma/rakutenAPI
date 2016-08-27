/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class VariantListedShops {
	
	@JsonProperty(value="marketplaceIdentifier")
	String marketPlaceIdentifier;
	
	@JsonProperty(value="shopURL")
	String shopUrl;
	Inventory inventory;
	
	public String getMarketPlaceIdentifier() {
		return marketPlaceIdentifier;
	}
	public String getShopUrl() {
		return shopUrl;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setMarketPlaceIdentifier(String marketPlaceIdentifier) {
		this.marketPlaceIdentifier = marketPlaceIdentifier;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	public void setInventory(Inventory inventory) {
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
				+ ((marketPlaceIdentifier == null) ? 0 : marketPlaceIdentifier
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
		VariantListedShops other = (VariantListedShops) obj;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (marketPlaceIdentifier == null) {
			if (other.marketPlaceIdentifier != null)
				return false;
		} else if (!marketPlaceIdentifier.equals(other.marketPlaceIdentifier))
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
		builder.append("VariantListedShops [marketPlaceIdentifier=")
				.append(marketPlaceIdentifier).append(",shopUrl=")
				.append(shopUrl).append(",inventory=").append(inventory)
				.append("]");
		return builder.toString();
	}
	
}
