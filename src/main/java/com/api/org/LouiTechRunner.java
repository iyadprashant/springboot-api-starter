
package com.api.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class LouiTechRunner {

	
	public static void main(String[] args) {
	
	    System.out.println(System.getProperty("java.runtime.version"));
	    

	    SpringApplication app = new SpringApplication(LouiTechRunner.class);

		app.run(LouiTechRunner.class, args);
		
	}
	

}
