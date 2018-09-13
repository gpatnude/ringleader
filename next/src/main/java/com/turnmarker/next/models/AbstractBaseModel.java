package com.turnmarker.next.models;

import org.slf4j.Logger;

import com.turnmarker.next.AbstractBaseObject;

@SuppressWarnings("serial")
public abstract class AbstractBaseModel extends AbstractBaseObject {

	private static final String VERSION = "1.0.0";

	/**
	 * @return the version
	 */
	public static String getVersion() {
		
		return VERSION;
	
	}

	@Override
	protected
	abstract Logger getLogger();
		
}
