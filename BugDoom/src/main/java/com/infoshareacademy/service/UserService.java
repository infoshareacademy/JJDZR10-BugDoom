package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.util.List;

public class UserService {
    public static User findUserById(String id, List<User> users) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return new User();
    }
}
