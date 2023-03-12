package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class DataService<T> {
    Gson gson = new Gson();

    public <T> void saveToFile(T listToSave, String file) throws IOException {
        String json = gson.toJson(listToSave);
        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    public List<T> readFromFile(String file, Class<T[]> classToRead) throws IOException {
        Path path = Paths.get(file);
        String objectsFromFile = Files.readString(path);
        T[] arr = gson.fromJson(objectsFromFile, classToRead);
        return Arrays.asList(arr);
    }
}
