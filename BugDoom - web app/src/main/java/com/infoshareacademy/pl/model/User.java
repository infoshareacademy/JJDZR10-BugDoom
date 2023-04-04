package com.infoshareacademy.pl.model;

import java.util.Objects;

public class User {
    private long userId;
    private String userEmailAddress;
    private String name;
    private String password;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userEmailAddress, user.userEmailAddress) && Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userEmailAddress, name, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmailAddress='" + userEmailAddress + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';


    }

}
