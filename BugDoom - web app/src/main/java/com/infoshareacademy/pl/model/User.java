package com.infoshareacademy.pl.model;

import org.springframework.stereotype.Component;

public class User {
    private long userId;
    private String userEmailAddress;
    private String name;
    private String password;

    //Constructor for the User class.
    public User(String userEmailAddress, String password) {
        this.userEmailAddress = userEmailAddress;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
