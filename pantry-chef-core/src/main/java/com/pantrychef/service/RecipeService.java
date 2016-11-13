package com.pantrychef.service;

import java.util.List;
import java.util.UUID;

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
	
	private RecipeTO get(UUID id){
		return repository.findOne(id);
	}
	
	public Recipe fetch(UUID id){
		Recipe recipe = get(id).build();
		List<Component> components = componentService.findComponents(recipe);
		recipe = ImmutableRecipe
				.builder()
				.from(recipe)
				.components(components)
				.build();
		return recipe;
	}
}
