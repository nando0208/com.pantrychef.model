package com.pantrychef.model;

import java.util.List;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Recipe extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2459000317653142473L;

	abstract String name();
	abstract String description();
	abstract List<Component> components();
}
