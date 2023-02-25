package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.model.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataHandler {
    private static final String USERS_FILE_PATH = "users.json";

    public User[] readUsers() {
        try (FileReader reader = new FileReader(USERS_FILE_PATH)) {
            Gson gson = new Gson();
            User[] users = gson.fromJson(reader, User[].class);
            if (users == null) {
                users = new User[0];
            }
            return users;
        } catch (IOException e) {
            e.printStackTrace();
            return new User[0];
        }
    }
    public void writeUsers(User[] users) {
        try (FileWriter writer = new FileWriter(USERS_FILE_PATH)) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}