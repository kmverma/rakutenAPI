/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.model;

import java.util.List;

public class Products {

	String baseSku;
	List<Variants> variants;
	
	public String getBaseSku() {
		return baseSku;
	}

	public List<Variants> getVariants() {
		return variants;
	}

	public void setBaseSku(String baseSku) {
		this.baseSku = baseSku;
	}

	public void setVariants(List<Variants> variants) {
		this.variants = variants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseSku == null) ? 0 : baseSku.hashCode());
		result = prime * result
				+ ((variants == null) ? 0 : variants.hashCode());
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
		Products other = (Products) obj;
		if (baseSku == null) {
			if (other.baseSku != null)
				return false;
		} else if (!baseSku.equals(other.baseSku))
			return false;
		if (variants == null) {
			if (other.variants != null)
				return false;
		} else if (!variants.equals(other.variants))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Products [baseSku=").append(baseSku)
				.append(",variants=").append(variants).append("]");
		return builder.toString();
	}
	
}
