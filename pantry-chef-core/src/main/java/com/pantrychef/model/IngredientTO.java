package com.pantrychef.model;

import javax.persistence.Entity;

@Entity(name = "ingredients")
public class IngredientTO extends BaseTO {

    /**
     *
     */
    private static final long serialVersionUID = 5620092402195950733L;

    private String name;
    private String description;
    private String about;
    private String tag;
    
    public IngredientTO(Ingredient ingredient){
        setAbout(ingredient.about());
        setCreatedTimestamp(ingredient.createdTimestamp());
        setDescription(ingredient.description());
        setId(ingredient.id());
        setLastUpdated(ingredient.lastUpdated());
        setName(ingredient.name());
        setTag(ingredient.tag());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Ingredient build(){
        Ingredient ingredient = ImmutableIngredient
                .builder()
                .id(getId())
                .createdTimestamp(getCreatedTimestamp())
                .lastUpdated(getLastUpdated())
                .about(getAbout())
                .description(getDescription())
                .name(getName())
                .tag(getTag())
                .build();
        return ingredient;
    }
}