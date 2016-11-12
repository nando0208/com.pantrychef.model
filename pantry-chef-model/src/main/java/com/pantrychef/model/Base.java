package com.pantrychef.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6913018526390165420L;

	private UUID id;
	private Date createdTimestamp;
	private Date lastUpdated;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
