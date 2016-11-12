package com.pantrychef.model;

public class CompositeComponent extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5610374833473746415L;

	private Recipe recipe;
	
	@Override
	public String getName() {
		String name = "";
		if(recipe != null && recipe.getName() != null){
			name = recipe.getName();
		}
		return name;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
