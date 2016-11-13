package com.pantrychef.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("COMPOSITE")
public class CompositeComponentTO extends ComponentTO {

    /**
     *
     */
    private static final long serialVersionUID = -5835363539426017623L;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeTO recipeTO;
}
