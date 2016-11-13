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

    public IngredientTO getIngredientTO() {
        return ingredientTO;
    }

    public void setIngredientTO(IngredientTO ingredientTO) {
        this.ingredientTO = ingredientTO;
    }

    public SimpleComponent build(){
        SimpleComponent component = ImmutableSimpleComponent
                .builder()
                .id(getId())
                .createdTimestamp(getCreatedTimestamp())
                .lastUpdated(getLastUpdated())
                .ingredient(getIngredientTO().build())
                .measure(getMeasure().build())
                .order(getOrderInRecipe())
                .qualifier(getQualifier())
                .quantity(getQuantity())
                .build();
        return component;
    }
}
