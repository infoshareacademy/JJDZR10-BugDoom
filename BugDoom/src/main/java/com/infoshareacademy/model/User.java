package com.infoshareacademy.model;

import javax.management.relation.Role;

public class User {
    private String userId;
    private String login;
    private String name;
    private String password;

    String role;

    //Constructor for the User class.
    public User(String name, String password, String role) {
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.password = password;
        this.role = role;

    }

    public User(String name, String password) {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}