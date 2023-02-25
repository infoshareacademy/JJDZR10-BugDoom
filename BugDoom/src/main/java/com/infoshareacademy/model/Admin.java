package com.infoshareacademy.model;

public class Admin extends User {
    private User[] users;
    public Admin(String name, String password,  User[] users) {
        super(name, password);
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }
}
