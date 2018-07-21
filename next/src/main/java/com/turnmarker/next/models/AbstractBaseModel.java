package com.turnmarker.next.models;

import com.turnmarker.next.AbstractBaseObject;

@SuppressWarnings("serial")
public class AbstractBaseModel extends AbstractBaseObject {

	private static final String VERSION = "1.0.0";

	/**
	 * @return the version
	 */
	public static String getVersion() {
		
		return VERSION;
	
	}
		
}
