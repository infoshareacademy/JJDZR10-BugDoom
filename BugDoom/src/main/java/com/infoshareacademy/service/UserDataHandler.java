package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UserDataHandler <T>{
    public List<T> readUsersFromFile(String path) throws IOException {
        Gson gson = new Gson();
        Path file = Paths.get(path);
        String usersFromFile = Files.readString(file);
        Type type = new TypeToken<List<T>>() {}.getType();
        return gson.fromJson(usersFromFile, type);
    }
}
