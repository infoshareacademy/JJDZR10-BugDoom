package com.infoshareacademy.service;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


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
