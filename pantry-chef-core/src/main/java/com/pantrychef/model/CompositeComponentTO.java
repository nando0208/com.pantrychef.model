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
    
    public RecipeTO getRecipeTO() {
        return recipeTO;
    }



    public void setRecipeTO(RecipeTO recipeTO) {
        this.recipeTO = recipeTO;
    }

    public CompositeComponent build(){
        CompositeComponent component = ImmutableCompositeComponent
                .builder()
                .id(getId())
                .createdTimestamp(getCreatedTimestamp())
                .lastUpdated(getLastUpdated())
                .measure(getMeasure().build())
                .order(getOrderInRecipe())
                .qualifier(getQualifier())
                .recipe(recipeTO.build())
                .build();
        return component;
    }
}
