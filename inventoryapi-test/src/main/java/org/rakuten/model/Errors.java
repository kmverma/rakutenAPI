/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 20-Aug-2016
 *  @author kishan
 */
package org.rakuten.model;

public class Errors {

	String errorCode;
    String shortMessage;
	String longMessage;
	
	public String getErrorCode() {
		return errorCode;
	}
	public String getShortMessage() {
		return shortMessage;
	}
	public String getLongMessage() {
		return longMessage;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}
	public void setLongMessage(String longMessage) {
		this.longMessage = longMessage;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorCode == null) ? 0 : errorCode.hashCode());
		result = prime * result
				+ ((longMessage == null) ? 0 : longMessage.hashCode());
		result = prime * result
				+ ((shortMessage == null) ? 0 : shortMessage.hashCode());
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
		Errors other = (Errors) obj;
		if (errorCode == null) {
			if (other.errorCode != null)
				return false;
		} else if (!errorCode.equals(other.errorCode))
			return false;
		if (longMessage == null) {
			if (other.longMessage != null)
				return false;
		} else if (!longMessage.equals(other.longMessage))
			return false;
		if (shortMessage == null) {
			if (other.shortMessage != null)
				return false;
		} else if (!shortMessage.equals(other.shortMessage))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Errors [errorCode=").append(errorCode)
				.append(",shortMessage=").append(shortMessage)
				.append(",longMessage=").append(longMessage).append("]");
		return builder.toString();
	}
	
}
