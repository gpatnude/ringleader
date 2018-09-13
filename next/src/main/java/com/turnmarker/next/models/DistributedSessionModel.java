package com.turnmarker.next.models;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class DistributedSessionModel extends AbstractBaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3968212813690216341L;
	
	protected static Map<String, HttpSession> cache = Collections.synchronizedMap(new LinkedHashMap<>(1024, 100.00f));
	
	protected static DistributedSessionModel _INSTANCE = new DistributedSessionModel();
	
	private DistributedSessionModel () {
		
		
	}
	
	public static DistributedSessionModel getInstance() {
		
		if (null == _INSTANCE) {
			
			_INSTANCE = new DistributedSessionModel(); 
			
		}		
		
		return _INSTANCE;
		
	}
	
	// LOGGER IMPLEMENTATION:
	protected Logger logger = LoggerFactory.getLogger(DistributedSessionModel.class);

	protected void setLogger(Logger logger) {

		this.logger = logger;

	}

	@Override
	protected Logger getLogger() {

		// TODO Auto-generated method stub
		return null;
	}

	public boolean contains(String id) {

		// TODO Auto-generated method stub
		return cache.containsKey(id);
		
	}

}
