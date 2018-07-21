package com.turnmarker.next.models;

import java.util.UUID;

public class ResponseModel extends AbstractBaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8097279154433937277L;

	public static final UUID uuid = UUID.randomUUID();

	private long id;

	private RingGraphModel ringGraphModel = new RingGraphModel();

	public ResponseModel(long id) {

		this.id = id;

	}

	public long getId() {

		return id;

	}

	/**
	 * @return the ringGrapModel
	 */
	public RingGraphModel getRingGraphModel() {

		return ringGraphModel;

	}

	/**
	 * @param ringGrapModel
	 *            the ringGrapModel to set
	 */
	public void setRingGraphModel(RingGraphModel model) {

		this.ringGraphModel = model;

	}

}
