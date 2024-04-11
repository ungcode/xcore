package com.ws.core.response;

import java.util.List;

public class StandardResponse <T>{
	
	
	private int errorCode;
	private int errorLevel;
	private String errorText;

	private List<?> Data ;
	

	public StandardResponse() {
		this.errorCode = 0;
		this.errorLevel = 0;
		this.errorText = "{}";

	}

	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int resultCode) {
		this.errorCode = resultCode;
	}


	public int getErrorLevel() {
		return errorLevel;
	}


	public void setErrorLevel(int level) {
		this.errorLevel = level;
	}


	public String getErrorText() {
		return errorText;
	}


	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public List<?> getData() {
		return Data;
	}

	public void setData(List<?> list) {
		Data = list;
	}
	


}
