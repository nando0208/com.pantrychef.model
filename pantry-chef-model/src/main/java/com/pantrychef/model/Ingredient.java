package com.pantrychef.model;

import java.util.List;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Ingredient extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3467041004296560644L;
	
	abstract String name();
	abstract String description();
	abstract String about();
	abstract Tag mainTag();
	abstract List<Tag> tags();
}
