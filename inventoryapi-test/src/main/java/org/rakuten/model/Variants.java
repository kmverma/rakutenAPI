/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.model;

import java.util.List;

public class Variants {
	
	String sku;
	List<VariantListedShops> variantListedShops;
	
	public String getSku() {
		return sku;
	}
	public List<VariantListedShops> getVariantListedShops() {
		return variantListedShops;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public void setVariantListedShops(List<VariantListedShops> variantListedShops) {
		this.variantListedShops = variantListedShops;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime
				* result
				+ ((variantListedShops == null) ? 0 : variantListedShops
						.hashCode());
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
		Variants other = (Variants) obj;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (variantListedShops == null) {
			if (other.variantListedShops != null)
				return false;
		} else if (!variantListedShops.equals(other.variantListedShops))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Variants [sku=").append(sku)
				.append(",variantListedShops=").append(variantListedShops)
				.append("]");
		return builder.toString();
	}
	
	
}
