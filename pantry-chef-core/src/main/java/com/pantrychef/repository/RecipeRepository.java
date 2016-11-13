package com.pantrychef.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pantrychef.model.RecipeTO;

public interface RecipeRepository extends JpaRepository<RecipeTO, UUID> {

}
