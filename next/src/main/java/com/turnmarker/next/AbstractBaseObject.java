package com.turnmarker.next;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;

@SuppressWarnings("serial")
public abstract class AbstractBaseObject implements Serializable {
	
	protected abstract Logger getLogger();
	
	// ABSTRACT METHOD DECLARATIONS HERE: 

	/** 
	 * This is a global method that provide a convenience mechanism to 'trace' application flow -- this is not an application logger in the classic sense -- 
	 * 
	 * @param message
	 */
	protected void trace(String message) {
		
		getLogger().trace(String.format("%s --> %s", new Date(), message));
		
	}
	
}
