package com.turnmarker.next.models;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

@Component
public class RingGraphModel extends AbstractBaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9017174880293254886L;

	public static final String key = "ring-graph-model";
	
	protected long identity = RandomUtils.nextLong();
	
	protected ZonedDateTime timestamp = ZonedDateTime.now(ZoneOffset.UTC);
	
	protected PayloadModel payloadModel = new PayloadModel();
	
	private MetaModel metaModel = new MetaModel();

	// LOCAL SINGLETON:
	private static RingGraphModel _INSTANCE = new RingGraphModel();

	public static RingGraphModel getFactory() {

		return _INSTANCE;

	}
	
	public void doSomething() {

		this.trace("I need to do something...");

	}

	public static String getKey() {
		
		return key;
				
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
		
		if (null == timestamp) {
			
			timestamp = ZonedDateTime.now(ZoneOffset.UTC);
			
		}
	
		return timestamp;
	}

	
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(ZonedDateTime timestamp) {
	
		this.timestamp = timestamp;
	}

	/**
	 * @return the payloadModel
	 */
	public PayloadModel getPayloadModel() {

		return payloadModel;

	}

	/**
	 * @param payloadModel
	 *            the payloadModel to set
	 */
	public void setPayloadModel(PayloadModel payloadModel) {

		this.payloadModel = payloadModel;

	}

	/**
	 * @return the hashCode
	 */
	public int getHashCode() {

		return HashCodeBuilder.reflectionHashCode(this);

	}

	/**
	 * @return the metaModel
	 */
	public MetaModel getMetaModel() {

		return metaModel;
		
	}

	/**
	 * @param metaModel the metaModel to set
	 */
	public void setMetaModel(MetaModel metaModel) {

		this.metaModel = metaModel;
		
	}
	
}
