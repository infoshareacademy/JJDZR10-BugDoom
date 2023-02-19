package com.infoshareacademy.model;

public class User {
    private String id;
    private String login;
    private String name;
    private String password;

    //Constructor for the User class.
    User(int id, String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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