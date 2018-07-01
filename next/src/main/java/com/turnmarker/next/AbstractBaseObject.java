package com.turnmarker.next;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractBaseObject implements Serializable {

	
	// ABSTRACT METHOD DECLARATIONS HERE: 

	/** 
	 * This is a global method that provide a convenience mechanism to 'trace' application flow -- this is not an application logger in the classic sense -- 
	 * 
	 * @param message
	 */
	protected void trace(String message) {
		
		System.out.println(String.format("%s --> %s", new Date(), message));
		
	}
	
}
