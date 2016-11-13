package com.pantrychef.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pantrychef.model.Component;
import com.pantrychef.model.ImmutableRecipe;
import com.pantrychef.model.Instruction;
import com.pantrychef.model.Recipe;
import com.pantrychef.model.RecipeTO;
import com.pantrychef.repository.RecipeRepository;

@Service
public class RecipeService {

	private RecipeRepository repository;
	private ComponentService componentService;
	private InstructionService instructionService;
	
	@Autowired 
	public RecipeService(RecipeRepository repository,
			ComponentService componentService,
			InstructionService instructionService){
		this.repository = repository;
		this.componentService = componentService;
		this.instructionService = instructionService;
	}
	
	private RecipeTO fetch(UUID id){
		return repository.findOne(id);
	}
	
	/**
	 * 
	 * @return Recipes without ingredients/instructions
	 */
	public List<Recipe> findByComponents(List<UUID> components){
		List<UUID> recipeIds = componentService.findRecipes(components);
		List<Recipe> recipes = recipeIds
				.stream()
				.map(id -> getSimpleRecipe(id))
				.collect(Collectors.toList());
		return recipes;
	}
	
	public Recipe getSimpleRecipe(UUID id){
		Recipe recipe = fetch(id).build();
		return recipe;
	}
	
	public Recipe get(UUID id){
		Recipe recipe = getSimpleRecipe(id);
		List<Component> components = componentService.findComponents(recipe);
		List<Instruction> instructions = instructionService.findInstructions(recipe);
		recipe = ImmutableRecipe
				.builder()
				.from(recipe)
				.components(components)
				.instructions(instructions)
				.build();
		return recipe;
	}
}
