package com.pantrychef.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eam.model.User;
import com.pantrychef.dao.UserRepository;
import com.pantrychef.model.UserTO;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    @Transactional
    private UserTO fetch(UUID id){
    	return repository.findOne(id);
    }
    
    @Transactional
    private UserTO persist(UserTO user){
    	return repository.save(user);
    }
    
    public User get(UUID id) {
        return fetch(id).build();
    }
    
    public User save(User user){
    	return persist(new UserTO(user)).build();
    }
    
    public User get(String username, String password){
    	UserTO u = repository.findByUsernameAndPassword(username, password);
    	return u.build();
    }
    
    public User get(String username){
    	UserTO u = repository.findByUsername(username);
    	return u.build();
    }
    
    @Transactional
    public void delete(UUID id){
    	repository.delete(id);
    }

    @Transactional
    public void delete(String username) {
    	User user = get(username);
    	repository.delete(user.getId());
    }

}
