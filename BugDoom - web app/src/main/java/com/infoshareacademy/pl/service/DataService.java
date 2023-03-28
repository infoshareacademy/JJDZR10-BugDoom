package com.infoshareacademy.pl.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.pl.model.Event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DataService<T> {
    private Gson gson = new Gson();

    public <T> void saveToFile(T listToSave, String file) throws IOException {
        Path path = Paths.get(file);
        if (file.equals(FilePathConstants.EVENT_FILE_PATH)) gson = addLocalDateSerializer();
        String json = gson.toJson(listToSave);
        Files.write(path, json.getBytes());
    }

    public List<T> readFromFile(String file, Class<T[]> classToRead) throws IOException {
        Path path = Paths.get(file);
        String objectsFromFile = Files.readString(path);
        if (file.equals(FilePathConstants.EVENT_FILE_PATH)) gson = addLocalDateDeserializer();
        T[] arr = gson.fromJson(objectsFromFile, classToRead);
        return Arrays.asList(arr);
    }

    private Gson addLocalDateSerializer() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        return gsonBuilder.create();
    }

    private Gson addLocalDateDeserializer() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        return gsonBuilder.create();
    }
}
