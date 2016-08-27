/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Inventory {

	int quantity;
	@JsonProperty(value="returnProductsToInventoryOnCanceledOrders")
	boolean returnProductsToInventoryOnCancelOrder;
	
	public int getQuantity() {
		return quantity;
	}
	public boolean isReturnProductsToInventoryOnCancelOrder() {
		return returnProductsToInventoryOnCancelOrder;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setReturnProductsToInventoryOnCancelOrder(
			boolean returnProductsToInventoryOnCancelOrder) {
		this.returnProductsToInventoryOnCancelOrder = returnProductsToInventoryOnCancelOrder;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
		result = prime * result
				+ (returnProductsToInventoryOnCancelOrder ? 1231 : 1237);
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
		Inventory other = (Inventory) obj;
		if (quantity != other.quantity)
			return false;
		if (returnProductsToInventoryOnCancelOrder != other.returnProductsToInventoryOnCancelOrder)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Inventory [quantity=").append(quantity)
				.append(",returnProductsToInventoryOnCancelOrder=")
				.append(returnProductsToInventoryOnCancelOrder).append("]");
		return builder.toString();
	}
	
}
