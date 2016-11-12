package com.pantrychef.model;

public class Measure extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -448611568198741770L;

	private String name;
	private String abbreviation;
	private String code;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
