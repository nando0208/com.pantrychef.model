package com.pantrychef.model;

import java.util.List;

public class Recipe extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2459000317653142473L;

	private String name;
	private String description;
	private List<Component> components;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Component> getComponents() {
		return components;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}
}
