package com.infoshareacademy;

public class User {
    private String username;
    private String password;
//Constructor for the User class.
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
//Set getters for them.
//Returns the username for the User object.
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}