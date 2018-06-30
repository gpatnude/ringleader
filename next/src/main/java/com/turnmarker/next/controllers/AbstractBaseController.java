package com.turnmarker.next.controllers;

import java.util.Date;

import org.springframework.http.HttpHeaders;

public class AbstractBaseController {

	protected void inspectHeader(HttpHeaders headers) {
		
		for (String s : headers.keySet()) {
			
			log(String.format("%s :: %s", s, headers.get(s)));
			
		}
		
	}
	
	protected void log(String message) {
		
		System.out.println(String.format("%s --> %s", new Date(), message));
		
	}
	
}
