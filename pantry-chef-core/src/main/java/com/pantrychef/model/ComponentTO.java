package com.pantrychef.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="components")
@Inheritance
@DiscriminatorColumn(name = "TYPE")
public class ComponentTO extends BaseTO {

    /**
     * 
     */
    private static final long serialVersionUID = -2493265831622475549L;

    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "measure_id")
    private MeasureTO measure;

    private String qualifier;

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
