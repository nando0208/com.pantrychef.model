package com.pantrychef.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3512503608094343023L;
	
	abstract UUID id();
	abstract Date createdTimestamp();
	abstract Date lastUpdated();
	
}
