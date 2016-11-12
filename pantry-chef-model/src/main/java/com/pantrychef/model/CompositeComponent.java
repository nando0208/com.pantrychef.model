package com.pantrychef.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class CompositeComponent extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5610374833473746415L;

	abstract Recipe recipe();
	
	@Override
	public String name() {
		String name = "";
		if(recipe() != null && recipe().name() != null){
			name = recipe().name();
		}
		return name;
	}
}
