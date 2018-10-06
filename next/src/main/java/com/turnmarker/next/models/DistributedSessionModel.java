package com.turnmarker.next.models;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DistributedSessionModel extends AbstractBaseModel {

	protected static Map<String, Object> cache = Collections.synchronizedSortedMap(new TreeMap<>());
	
	protected static DistributedSessionModel _INSTANCE = new DistributedSessionModel();
	
	private DistributedSessionModel () {
		
		// AND ?
		
	}
	
	public static DistributedSessionModel getInstance() {
		
		// SANITY TEST:
		if (null == _INSTANCE) {_INSTANCE = new DistributedSessionModel();}
		
		// AND:
		return _INSTANCE;
				
	}
	
	public boolean contains(String key) {

		// TODO Auto-generated method stub
		return cache.containsKey(key);
	
	}
	
	public Object and(Object obj) {
		
		return obj;
		
	}
	
	public Object wait(int howlong) {
		
		try {
			
			Thread.currentThread().wait(howlong);
			
		} catch (InterruptedException iex) {
			
			getLogger().error("How rude of you to interrupt: " + iex.getMessage());
			
		}
		
		return this;
		
	}
	
	public Object get(String key) {
		
		return locate(key);
		
	}
	
	public Object locate(String key) {
		
		// LOCATE OR CREATE: 
		Object obj = cache.containsKey(key) ? cache.get(key) : create(key);
		
		// CHECK
		
		// AND RETURN:
		return obj;
		
	}
	
	public Object create(String key) {
		
		Object obj = new Object();
		
		// COLLECT:
		cache.put(key, obj);
		
		// AND RETURN:
		return obj;
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3968212813690216341L;
	
	// LOGGER IMPLEMENTATION:
	protected Logger _LOGGER = LoggerFactory.getLogger(DistributedSessionModel.class);

	protected void setLogger(Logger logger) {

		this._LOGGER = logger;

	}

	@Override
	protected Logger getLogger() {

		// TODO Auto-generated method stub
		return _LOGGER;
		
	}

}
