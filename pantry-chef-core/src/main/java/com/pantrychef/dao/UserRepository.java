package com.pantrychef.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pantrychef.model.UserTO;

@Repository
public interface UserRepository extends
        JpaRepository<UserTO, UUID> {

    @Query("FROM UserTO WHERE username = ?1")
    UserTO findByUsername(String username);

    @Query("FROM UserTO WHERE username = ?1 AND password = ?2")
    UserTO findByUsernameAndPassword(String username,
            String password);

}
