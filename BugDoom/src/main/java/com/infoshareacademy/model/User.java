package com.infoshareacademy.model;

public class User {
    private String userId;
    private String login;
    private String name;
    private String password;

    //Constructor for the User class.
    public User(String userId, String login, String name, String password) {
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.password = password;
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
}