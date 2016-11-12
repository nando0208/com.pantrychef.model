package com.pantrychef.model;

public class SimpleComponent extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1555488393973876527L;

	private Ingredient ingredient;

	@Override
	public String getName() {
		String name = "";
		if(ingredient != null && ingredient.getName() != null){
			name = ingredient.getName();
		}
		return name;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	public Ingredient getIngredient(){
		return ingredient;
	}
}
