package com.turnmarker.next.models;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class MetaModel extends AbstractBaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6218643012921480597L;
	
	public static final String key = "meta-model";
	
	protected long identity = RandomUtils.nextLong();
	
	protected ZonedDateTime timestamp = ZonedDateTime.now(ZoneOffset.UTC);
	
	protected Properties metaTags = new Properties();
	
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
