package com.pantrychef.model;

import java.math.BigDecimal;
import java.util.List;

public abstract class Component extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423195038668544717L;

	private BigDecimal quantity;
	private Measure measure;
	private List<String> qualifiers;
	private List<Substitute> substitutes;
	private Integer order;

	public abstract String getName();
	
	BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public Measure getMeasure() {
		return measure;
	}
	public void setMeasure(Measure measure) {
		this.measure = measure;
	}
	public List<String> getQualifiers() {
		return qualifiers;
	}
	public void setQualifiers(List<String> qualifiers) {
		this.qualifiers = qualifiers;
	}
	public List<Substitute> getSubstitutes() {
		return substitutes;
	}
	public void setSubstitutes(List<Substitute> substitutes) {
		this.substitutes = substitutes;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	
}
