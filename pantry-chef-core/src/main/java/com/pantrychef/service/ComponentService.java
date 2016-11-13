package com.pantrychef.service;

import com.pantrychef.model.Component;
import com.pantrychef.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComponentService {

    public List<Component> findComponents(Recipe recipe) {
        //TODO
        return null;
    }

    public List<UUID> findRecipes(List<UUID> components) {
        //TODO
        return null;
    }
}
