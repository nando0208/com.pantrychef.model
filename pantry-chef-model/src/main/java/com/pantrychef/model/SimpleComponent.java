package com.pantrychef.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class SimpleComponent extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1555488393973876527L;

	abstract Ingredient ingredient();

	@Override
	public String name() {
		String name = "";
		if(ingredient() != null && ingredient().name() != null){
			name = ingredient().name();
		}
		return name;
	}
}
