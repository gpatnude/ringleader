package com.turnmarker.next.models;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetaModel extends AbstractBaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6218643012921480597L;
	
	public static final String key = "meta-model";
	
	protected long identity = RandomUtils.nextLong();
	
	protected ZonedDateTime timestamp = ZonedDateTime.now(ZoneOffset.UTC);
	
	protected Properties metaTags = new Properties();
	
	protected List<?> collection = new ArrayList<>(); 
	
	protected Logger logger = LoggerFactory.getLogger(MetaModel.class);
	
	
	protected Logger getLogger() {
	
		return logger;
	}


	
	protected void setLogger(Logger logger) {
	
		this.logger = logger;
	}


	public List<?> getCollection() {
	
		return collection;
		
	}

	
	public void setCollection(List<?> collection) {
	
		this.collection = collection;

	}

	public MetaModel() {
		
		this.getMetaTags().put(key, String.valueOf(MetaModel.serialVersionUID));
		
	}
	
	public Properties getMetaTags() {
	
		return metaTags;
		
	}

	
	public void setMetaTags(Properties metaTags) {
	
		this.metaTags = metaTags;
		
	}

	/**
	 * @return the identity
	 */
	public long getIdentity() {
	
		return identity;
		
	}
	
	/**
	 * @param identity the identity to set
	 */
	public void setIdentity(long identity) {
	
		this.identity = identity;

	}
	
	/**
	 * @return the timestamp
	 */
	public ZonedDateTime getTimestamp() {
		
		return timestamp;
		
	}

	
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(ZonedDateTime timestamp) {
	
		this.timestamp = timestamp;
		
	}

	/**
	 * @return the hashCode
	 */
	public int getHashCode() {

		return HashCodeBuilder.reflectionHashCode(this);

	}
	
}
