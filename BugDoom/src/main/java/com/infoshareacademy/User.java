package com.infoshareacademy;

public class User {
    private String username;
    private String userLastName;
    private String password;
//Constructor for the User class.
    User(String username, String userLastName, String password) {
        this.username = username;
        this.userLastName = userLastName;
        this.password = password;
    }
//Set getters for them.
//Returns the username for the User object.
    public String getUsername() {
        return username;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getPassword() {
        return password;
    }

}