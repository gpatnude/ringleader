

package com.turnmarker.next.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turnmarker.next.enums.AvailableList;
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
	
	protected Logger logger = LoggerFactory.getLogger(ResponseController.class);
	
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
	
	@RequestMapping("/list")
	public ResponseModel getGeneralList(@RequestParam(value = "alist", defaultValue = "EVERYTHING") AvailableList alist) {
		
		// GENERATE THE RESPONSE:		
		ResponseModel rm = new ResponseModel(counter.incrementAndGet());
		
		// REJUVENATE:
		rm.setRingGraphModel(rmc);
		
		switch (alist) {

			case GAMES_PENDING:
			case GAMES_FINISHED:
			case GAMES_INPLAY:
				
				// rm.getRingGraphModel().getMetaModel().setCollection(al);
				// rm.getRingGraphModel().getMetaModel().getCollection().clear();
				trace("This isn't funny...");
				
				break;

			// LAST:
			default:
			case EVERYTHING:
			
				List<AvailableList> al = Arrays.asList(AvailableList.values());
				rm.getRingGraphModel().getMetaModel().setCollection(al);				
				break;
				
		}
		
		if (alist == AvailableList.EVERYTHING) {
			
			// 
			String s = "AvailableList.EVERYTHING: ";
			trace(s);
			
			// RETAIN:
			getLogger().trace(s);
			
			
		} // ELSE:
		
		// AND RETURN:
		return rm;
		
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

	@Override
	public Logger getLogger() {

		// 
		return logger;
		
	}

}
