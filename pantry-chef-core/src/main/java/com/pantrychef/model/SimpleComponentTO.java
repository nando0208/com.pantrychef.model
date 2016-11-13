package com.pantrychef.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@DiscriminatorValue("RECIPE")
public class SimpleComponentTO extends ComponentTO {

  @ManyToOne
  @JoinColumn(name = "ingredient_id")
  private IngredientTO ingredientTO;
}
