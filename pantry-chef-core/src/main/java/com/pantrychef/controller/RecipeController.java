package com.pantrychef.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pantrychef.model.Recipe;
import com.pantrychef.service.RecipeService;

@RestController
@RequestMapping(name="/recipes")
public class RecipeController {

	private RecipeService service;
	
	@Autowired
	public RecipeController(RecipeService service){
		this.service = service;
	}
	
    public List<Recipe> get (
        @RequestParam(name = "components", required = false) List<UUID> components,
        @RequestParam(name = "limit", required = false, defaultValue = "50") Integer limit,
        @RequestParam(name = "offset", required = false, defaultValue = "1") Integer offset){

    	//TODO limit, offset
        List<Recipe> recipes = service.findByComponents(components);
        return recipes;
    }

    @RequestMapping(name="/{id}")
    public Recipe get (
            @PathVariable(value = "id") UUID id){
        Recipe recipe = service.get(id);
        return recipe;
    }
}
