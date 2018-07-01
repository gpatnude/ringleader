package com.turnmarker.next.models;

import java.util.UUID;

public class ResponseModel extends AbstractBaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9033531652815075843L;

	public static final UUID uuid = UUID.randomUUID();
	
	private long id;
	
    public ResponseModel(long id) {
    
    	this.id = id;

    }

    public long getId() {
    
    	return id;
    
    }

}
