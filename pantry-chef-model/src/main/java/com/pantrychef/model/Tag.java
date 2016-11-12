package com.pantrychef.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Tag extends Base {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7249612881753374482L;
	
	abstract String code();
	abstract String name();
	abstract String description();
	
}
