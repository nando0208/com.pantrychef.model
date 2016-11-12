package com.pantrychef.model;

import java.math.BigDecimal;
import java.util.List;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Component extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423195038668544717L;

	abstract BigDecimal quantity();
	abstract Measure measure();
	abstract List<String> qualifiers();
	abstract List<Substitute> substitutes();
	abstract Integer order();
	abstract String name();
}
