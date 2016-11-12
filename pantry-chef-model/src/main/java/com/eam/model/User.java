package com.eam.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.pantrychef.model.Ingredient;

public class User implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3739177568476220034L;

    private UUID id;
    
    private String username;
    
    private String password;
    
    private Date birthdate;
    
    private Ingredient person;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Ingredient getPerson() {
		return person;
	}

	public void setPerson(Ingredient person) {
		this.person = person;
	}

}
