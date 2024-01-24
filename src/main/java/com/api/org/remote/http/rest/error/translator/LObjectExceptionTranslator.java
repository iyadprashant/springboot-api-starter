package com.api.org.remote.http.rest.error.translator;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.api.org.exception.transformer.BaseErrorMessage;


@ControllerAdvice
public class LObjectExceptionTranslator {
	
	public static final String ERROR_CODE = "errorCode";
	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String ROOT_ERROR_MESSAGE = "rootErrorMessage";
	
	Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	
	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<BaseErrorMessage> lobjectGenericException(RuntimeException ex, WebRequest request){
		
		
		LOGGER.error("Exception when handling LObject operation", ex);
		
		BaseErrorMessage error = new BaseErrorMessage();
		
		
		
		return new ResponseEntity<BaseErrorMessage>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
