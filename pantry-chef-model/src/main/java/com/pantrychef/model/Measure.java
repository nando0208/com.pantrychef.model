package com.pantrychef.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Measure extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -448611568198741770L;

	abstract String name();
	abstract String abbreviation();
	abstract String code();
}
