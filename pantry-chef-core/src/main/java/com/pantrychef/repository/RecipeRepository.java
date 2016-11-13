package com.pantrychef.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pantrychef.model.RecipeTO;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeTO, UUID> {

}
