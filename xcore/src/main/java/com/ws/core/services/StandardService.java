package com.ws.core.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ws.core.response.StandardResponse;

public class StandardService <T>{

	
	private StandardResponse<?> response;
	
	public void setError(int errorCore, int errorLevel, String errorText) {

		response.setErrorCode(errorCore);
		response.setErrorLevel(errorLevel);
		response.setErrorText(errorText);
		
	}

	public StandardResponse<?> getResponse() {
		return response;
	}

	public void setResponse(StandardResponse<?> response) {
		this.response = response;
	}

	public List<T>asArray(T t){
		return Arrays.asList(t);
	}

	
	

}
