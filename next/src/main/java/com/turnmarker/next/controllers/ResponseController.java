package com.turnmarker.next.controllers;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turnmarker.next.models.ResponseModel;
import com.turnmarker.next.models.RingGraphModel;

@RestController
public class ResponseController extends AbstractBaseController {
	
	@Autowired
	RingGraphModel rmc;

	/**
	 * 
	 */
	private static final long serialVersionUID = -8440168441437111107L;

	private final AtomicLong counter = new AtomicLong();
	
	  @Autowired
	  private HttpSession httpSession;	

	@RequestMapping("/")
	public ResponseModel responseModel(@RequestParam(value = "name", defaultValue = "dwap") String name, @RequestHeader HttpHeaders headers) {

		// VALIDATION:
		this.inspectHeader(headers);

		// CALL:
		rmc.doSomething();

		// GENERATE THE RESPONSE:		
		ResponseModel rm = new ResponseModel(counter.incrementAndGet());
		
		// EXECUTE:
		
		// REJUVENATE:
		rm.setRingGraphModel(rmc);
		
		// AND RETURN:
		return rm;
		
		// return new ResponseModel(counter.incrementAndGet());

	}

	@RequestMapping("/dev/null")
	public ResponseModel devNull(@RequestParam(value = "name", defaultValue = "dwap") String name, @RequestHeader HttpHeaders headers) {

		// VALIDATION:
		this.inspectHeader(headers);

		// CALL:
		rmc.saySomething("I really need to pee...");

		// 
		return new ResponseModel(counter.incrementAndGet());

	}

}
