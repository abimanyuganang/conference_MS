package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String role;
    private String affiliation;

    // Getters and Setters
    public Long getUserID(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public String getEmailId(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){
        return role;
    }

    public String getAffiliation(){
        return affiliation;
    }

    public void setUserId (Long newUserId){
        this.userId = newUserId;
    }

    public void setName (String newName){
        this.name = newName;
    }

    public void setEmail (String newEmail){
        this.email = newEmail;
    }

    public void setPassword (String newPassword){
        this.password = newPassword;
    }

    public void setRole (String newRole){
        this.role = newRole;
    }

    public void setAffiliation (String newAffiliation){
        this.affiliation = newAffiliation;
    }
}