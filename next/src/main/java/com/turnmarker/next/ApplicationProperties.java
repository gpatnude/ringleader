/**
 * 
 */
package com.turnmarker.next;

import java.util.Properties;
import java.util.UUID;

/**
 * @author Greg Patnude
 *
 */

public class ApplicationProperties extends Properties {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5799484753808227080L;
	
	private static final UUID uuid = UUID.randomUUID();

	public static final String IDENT = String.valueOf(uuid);
	
	/**
	 * 
	 */
	public ApplicationProperties() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param defaults
	 */
	public ApplicationProperties(Properties defaults) {
		super(defaults);
		// TODO Auto-generated constructor stub
	}

}
