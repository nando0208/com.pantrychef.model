package com.pantrychef.repository;

import com.pantrychef.model.RecipeTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeTO, UUID> {

}
