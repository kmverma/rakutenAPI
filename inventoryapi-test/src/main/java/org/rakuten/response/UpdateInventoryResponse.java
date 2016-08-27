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

public class UpdateInventoryResponse {

	List<Errors> errors;
	String operationId;
	String operationStatus;
	String operationType;
	
	public List<Errors> getErrors() {
		return errors;
	}
	public String getOperationId() {
		return operationId;
	}
	public String getOperationStatus() {
		return operationStatus;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result
				+ ((operationId == null) ? 0 : operationId.hashCode());
		result = prime * result
				+ ((operationStatus == null) ? 0 : operationStatus.hashCode());
		result = prime * result
				+ ((operationType == null) ? 0 : operationType.hashCode());
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
		UpdateInventoryResponse other = (UpdateInventoryResponse) obj;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (operationId == null) {
			if (other.operationId != null)
				return false;
		} else if (!operationId.equals(other.operationId))
			return false;
		if (operationStatus == null) {
			if (other.operationStatus != null)
				return false;
		} else if (!operationStatus.equals(other.operationStatus))
			return false;
		if (operationType == null) {
			if (other.operationType != null)
				return false;
		} else if (!operationType.equals(other.operationType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateInventoryResponse [errors=").append(errors)
				.append(",operationId=").append(operationId)
				.append(",operationStatus=").append(operationStatus)
				.append(",operationType=").append(operationType).append("]");
		return builder.toString();
	}
	
	
}
