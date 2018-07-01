package com.turnmarker.next.controllers;

import org.springframework.http.HttpHeaders;

import com.turnmarker.next.AbstractBaseObject;

@SuppressWarnings("serial")
public class AbstractBaseController extends AbstractBaseObject {

	protected void inspectHeader(HttpHeaders headers) {
		
		for (String s : headers.keySet()) {
			
			trace(String.format("%s :: %s", s, headers.get(s)));
			
		}
		
	}

}
