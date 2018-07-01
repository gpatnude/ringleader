package com.turnmarker.next;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

@SpringBootApplication(scanBasePackages = { "com.turnmarker.next" })
public class ApplicationRunner implements ServletContextInitializer {

	/** 
	 * This is the 'main' entry point for the 'turnmarker'
	 * 	
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(ApplicationRunner.class, args);

	}
	
	@Override
    public void onStartup(ServletContext sc) throws ServletException {

		// INIT: HOW DO YOU LIKE THEM BEANS ?
		// sc.addFilter(arg0, arg1)
    
	}

}
