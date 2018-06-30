package com.turnmarker.next.models;

import java.util.UUID;

public class ResponseModel {
	
	private UUID uuid;
	
    private final long id;
    
    private final String content;
    
    private final String token;

    public ResponseModel(long id, String content, String token) {
    
    	this.id = id;
        this.content = content;
        this.token = token;
    
    }

    public long getId() {
    
    	return id;
    
    }

    public String getContent() {
    
    	return content;
    
    }
    
	public String getToken() {
		
		return token;
	
	}

	protected void setUniqueIdentifier(UUID newuid)  {
    	
    	this.uuid = newuid;
    	
    }
    
    public UUID getUniqueIdentifier() {
    	
    	if (null ==  this.uuid) {
    		
    		this.setUniqueIdentifier(UUID.randomUUID());
    		
    	}
    	
    	return this.uuid;
    	
    }

}
