package com.pantrychef.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.eam.model.User;

@Entity
@Table(name="d_user")
public class UserTO extends BaseTO implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3739177568476220034L;

    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @Column(name="birthdate")
    private Date birthdate;
    
    @Column(name="per_id")
    private UUID personId;
    
    public UserTO(User user) {
		super();
		setBirthdate(user.getBirthdate());
		setLastUpdated(new Date());
		setPassword(user.getPassword());
		setUsername(user.getUsername());
		declare();
	}

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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public User build(){
		User u = new User();
		u.setId(getId());
		u.setUsername(username);
		u.setBirthdate(birthdate);
		return u;
	}
	
	public User build(Ingredient person){
		User u = build();
		u.setPerson(person);
		return u;
	}
}
