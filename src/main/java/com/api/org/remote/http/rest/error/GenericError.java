package com.api.org.remote.http.rest.error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericError {
	
	Boolean errored = true;
	String errorCode = "";
	String errorMessage = "";
	Map<String, Object> data = new HashMap<>();
	List<GenericError> errorStack = new ArrayList<>();
	
	
	public void addNestedError(GenericError error) {
		errorStack.add(error);
	}
	
	public GenericError addNestedError(String errorCode, String errorMessage) {
		
		GenericError err = new GenericError();
		err.setErrorCode(errorCode);
		err.setErrorMessage(errorMessage);
		errorStack.add(err);
		return err;
	}
	
	
	public GenericError addNestedError(String errorCode, String errorMessage, Map<String, Object> data) {
		
		GenericError err = new GenericError();
		err.setErrorCode(errorCode);
		err.setErrorMessage(errorMessage);
		err.setData(data);
		errorStack.add(err);
		return err;
	}
	
	

	public Boolean getErrored() {
		return errored;
	}

	public void setErrored(Boolean errored) {
		this.errored = errored;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<GenericError> getErrorStack() {
		return errorStack;
	}

	public void setErrorStack(List<GenericError> errorStack) {
		this.errorStack = errorStack;
	}
	
	
	
	
	
	
	

}
