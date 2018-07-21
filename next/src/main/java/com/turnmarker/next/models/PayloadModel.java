package com.turnmarker.next.models;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PayloadModel extends AbstractBaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7666041748795452529L;
	
	public static final String key = "payload-model";
	
	public static final String version = "1.0.0";
	
	protected long identity = RandomUtils.nextLong();
	
	protected ZonedDateTime timestamp = ZonedDateTime.now(ZoneOffset.UTC);

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
	 * @return the key
	 */
	public static String getKey() {
		
		return key;
		
	}

	/**
	 * @return the version
	 */
	public static String getVersion() {
		
		return version;
		
	}

	/**
	 * @return the hashCode
	 */
	public int getHashCode() {

		return HashCodeBuilder.reflectionHashCode(this);

	}
	
}
