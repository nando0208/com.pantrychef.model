package com.pantrychef.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "components")
@Inheritance
@DiscriminatorColumn(name = "TYPE")
public abstract class ComponentTO extends BaseTO {

    /**
     *
     */
    private static final long serialVersionUID = -2493265831622475549L;

    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "measure_id")
    private MeasureTO measure;

    private String qualifier;

    @Column(name = "order_in_recipe")
    private Integer orderInRecipe;

    public ComponentTO(BigDecimal quantity, MeasureTO measure, String qualifier, Integer orderInRecipe) {
        this.quantity = quantity;
        this.measure = measure;
        this.qualifier = qualifier;
        this.orderInRecipe = orderInRecipe;
    }

    public ComponentTO() {
        

    }

    BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public MeasureTO getMeasure() {
        return measure;
    }

    public void setMeasure(MeasureTO measure) {
        this.measure = measure;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public Integer getOrderInRecipe() {
        return orderInRecipe;
    }

    public void setOrderInRecipe(Integer orderInRecipe) {
        this.orderInRecipe = orderInRecipe;
    }
    
}
