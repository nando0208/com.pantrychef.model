package com.pantrychef.model;

import javax.persistence.Entity;

@Entity(name = "measures")
public class MeasureTO extends BaseTO {
    /**
     *
     */
    private static final long serialVersionUID = -596205517167777773L;
    private String name;
    private String abbreviation;
    private String code;

    public MeasureTO(String name, String abbreviation, String code) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.code = code;
    }

    public MeasureTO(Measure measure) {
        setAbbreviation(measure.abbreviation());
        setCode(measure.code());
        setCreatedTimestamp(measure.createdTimestamp());
        setId(measure.id());
        setLastUpdated(measure.lastUpdated());
        setName(measure.name());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public Measure build(){
        Measure measure = ImmutableMeasure
                .builder()
                .id(getId())
                .createdTimestamp(getCreatedTimestamp())
                .lastUpdated(getLastUpdated())
                .abbreviation(getAbbreviation())
                .code(getCode())
                .name(getName())
                .build();
        return measure;
    }
}
