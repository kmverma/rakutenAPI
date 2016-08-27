/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.response;

import java.util.List;

import org.rakuten.model.Errors;
import org.rakuten.model.Products;

public class GetInventoryResponse {

	List<Errors> errors;
	List<Products> products;
	String totalCount;
	
	
	public List<Errors> getErrors() {
		return errors;
	}

	public List<Products> getProducts() {
		return products;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result
				+ ((products == null) ? 0 : products.hashCode());
		result = prime * result
				+ ((totalCount == null) ? 0 : totalCount.hashCode());
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
		GetInventoryResponse other = (GetInventoryResponse) obj;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (totalCount == null) {
			if (other.totalCount != null)
				return false;
		} else if (!totalCount.equals(other.totalCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetInventoryResponse [errors=").append(errors)
				.append(",products=").append(products).append(",totalCount=")
				.append(totalCount).append("]");
		return builder.toString();
	}
	
}
