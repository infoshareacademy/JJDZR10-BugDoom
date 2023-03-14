package com.infoshareacademy.pl.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class DataService<T> {
    private final Gson gson = new Gson();

    public <T> void saveToFile(T listToSave, String file) throws IOException {
        Path path = Paths.get(file);
        String json = gson.toJson(listToSave);
        Files.write(path, json.getBytes());
    }

    public List<T> readFromFile(String file, Class<T[]> classToRead) throws IOException {
        Path path = Paths.get(file);
        String objectsFromFile = Files.readString(path);
        T[] arr = gson.fromJson(objectsFromFile, classToRead);
        return Arrays.asList(arr);
    }
}
