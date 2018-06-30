package com.turnmarker.next.controllers;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turnmarker.next.models.ResponseModel;

@RestController
public class ResponseController extends AbstractBaseController {

	private static final String template = "connect";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/")
	public ResponseModel responseModel(@RequestParam(value = "name", defaultValue = "dwap") String name, @RequestHeader HttpHeaders headers) {

		// TRACE:
		this.inspectHeader(headers);
		
		if (! headers.containsKey("uid")) {
		
			headers.add("uid", UUID.randomUUID().toString());
			
		}
		

		String token = "";
		return new ResponseModel(counter.incrementAndGet(), template, token);

	}

}
