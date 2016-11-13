package com.pantrychef.model;


public abstract class Instruction extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1639633121209851036L;
	
	public abstract String step();
	public abstract Integer order();
}
