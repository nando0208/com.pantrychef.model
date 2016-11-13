package com.pantrychef.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Recipe extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2459000317653142473L;

	abstract String name();
	abstract String description();
	abstract String about();
	abstract List<Component> components();
	abstract String yeld();
	abstract BigDecimal preparationTime();
	abstract TimeUnit unit();
	abstract String author();
	abstract List<Instruction> instructions();
	abstract String difficulty();
}
