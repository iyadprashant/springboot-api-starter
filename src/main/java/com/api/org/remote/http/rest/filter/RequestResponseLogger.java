package com.api.org.remote.http.rest.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class RequestResponseLogger implements Filter {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	       HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        logger.info(
	          "Logging Request  {} : {}", req.getMethod(), 
	          req.getRequestURI());
	        
	        Enumeration<String> headers =  req.getHeaderNames();
	     
	        StringBuilder sbr = new StringBuilder();
	   
	        
	        while(headers.hasMoreElements()) {
	        	String headerName = headers.nextElement();
	        	sbr.append("\n");
	        	sbr.append(headerName);
	        	sbr.append(" : ");
	        	sbr.append(req.getHeader(headerName));
	        }
	        
	        
	        logger.info(sbr.toString());
	        
	        chain.doFilter(request, response);
	        logger.info(
	          "Logging Response :{}", 
	          res.getContentType());
		
	}

    // other methods
}


