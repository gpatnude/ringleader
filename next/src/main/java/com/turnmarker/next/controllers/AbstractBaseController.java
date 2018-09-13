package com.turnmarker.next.controllers;

import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;

import com.turnmarker.next.AbstractBaseObject;

@SuppressWarnings("serial")
public abstract class AbstractBaseController extends AbstractBaseObject {
	
	public abstract Logger getLogger();

	protected void inspectHeader(HttpHeaders headers) {
		
		for (String s : headers.keySet()) {
			
			trace(String.format("%s :: %s", s, headers.get(s)));
			
		}
		
	}

}
