package com.pantrychef.model;

public class Substitute extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8322121916083270939L;

	private Double similitude;
	private Component component;
	
	public Double getSimilitude() {
		return similitude;
	}
	public void setSimilitude(Double similitude) {
		this.similitude = similitude;
	}
	public Component getComponent() {
		return component;
	}
	public void setComponent(Component component) {
		this.component = component;
	}
}
