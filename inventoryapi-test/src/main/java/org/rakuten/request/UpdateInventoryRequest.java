/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.request;

import java.util.List;

import org.rakuten.model.ShopInventory;

public class UpdateInventoryRequest {

	List<ShopInventory> shopInventory;

	/**
	 * @return List<ShopInventory>
	 */
	public List<ShopInventory> getShopInventory() {
		return shopInventory;
	}

	/**
	 * @param shopInventory
	 */
	public void setShopInventory(List<ShopInventory> shopInventory) {
		this.shopInventory = shopInventory;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((shopInventory == null) ? 0 : shopInventory.hashCode());
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
		UpdateInventoryRequest other = (UpdateInventoryRequest) obj;
		if (shopInventory == null) {
			if (other.shopInventory != null)
				return false;
		} else if (!shopInventory.equals(other.shopInventory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateInventoryRequest [shopInventory=")
				.append(shopInventory).append("]");
		return builder.toString();
	}

}
