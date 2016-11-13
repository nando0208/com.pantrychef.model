package com.pantrychef.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pantrychef.model.Component;
import com.pantrychef.model.ImmutableRecipe;
import com.pantrychef.model.Recipe;
import com.pantrychef.model.RecipeTO;
import com.pantrychef.repository.RecipeRepository;

@Service
public class RecipeService {

	private RecipeRepository repository;
	private ComponentService componentService;
	
	@Autowired 
	public RecipeService(RecipeRepository repository,
			ComponentService componentService){
		this.repository = repository;
		this.componentService = componentService;
	}
	
	private RecipeTO fetch(UUID id){
		return repository.findOne(id);
	}
	
	public List<Recipe> findByComponents(List<UUID> components){
		List<UUID> recipeIds = componentService.findRecipes(components);
		List<Recipe> recipes = recipeIds
				.stream()
				.map(id -> getWithoutIngredients(id))
				.collect(Collectors.toList());
		return recipes;
	}
	
	public Recipe getWithoutIngredients(UUID id){
		Recipe recipe = fetch(id).build();
		return recipe;
	}
	
	public Recipe get(UUID id){
		Recipe recipe = getWithoutIngredients(id);
		List<Component> components = componentService.findComponents(recipe);
		recipe = ImmutableRecipe
				.builder()
				.from(recipe)
				.components(components)
				.build();
		return recipe;
	}
}
