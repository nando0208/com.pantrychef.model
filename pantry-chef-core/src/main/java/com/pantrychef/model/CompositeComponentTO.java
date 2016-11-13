package com.pantrychef.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("COMPOSITE")
public class CompositeComponentTO extends ComponentTO {

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private RecipeTO recipeTO;
}
