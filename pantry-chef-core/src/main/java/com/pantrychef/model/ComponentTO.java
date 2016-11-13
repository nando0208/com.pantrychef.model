package com.pantrychef.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name="components")
@Inheritance
@DiscriminatorColumn(name = "TYPE")
public class ComponentTO extends BaseTO {

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
