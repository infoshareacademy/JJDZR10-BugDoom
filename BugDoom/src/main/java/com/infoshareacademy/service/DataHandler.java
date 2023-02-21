package com.infoshareacademy.service;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class DataHandler<T> {
    public static <T> void saveToFile(T listToSave, String file) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(listToSave);
        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    public List<T> readFromFile(String file, Class<T[]> classToRead) throws IOException {
        Gson gson = new Gson();
        Path path = Paths.get(file);
        String usersFromFile = Files.readString(path);
        T[] arr = gson.fromJson(usersFromFile, classToRead);
        return Arrays.asList(arr);
    }
}