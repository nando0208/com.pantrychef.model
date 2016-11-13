package com.pantrychef.model;

import javax.persistence.*;

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
