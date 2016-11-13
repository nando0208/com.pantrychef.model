package com.pantrychef.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("SIMPLE")
public class SimpleComponentTO extends ComponentTO {

    /**
     *
     */
    private static final long serialVersionUID = 9204687048762128932L;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientTO ingredientTO;
}
