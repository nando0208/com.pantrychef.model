package com.pantrychef.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Substitute extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8322121916083270939L;

	abstract Double similitude();
	abstract Component component();
	
}
