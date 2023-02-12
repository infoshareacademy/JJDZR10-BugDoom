package com.infoshareacademy.model;

public class User {
    private int id;
    private String login;
    private String name;
    private String password;

    //Constructor for the User class.
    User(int id, String login, String name, String password) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.password = password;
    }

    //Set getters for them.
//Returns the username for the User object.
    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;

    }
}