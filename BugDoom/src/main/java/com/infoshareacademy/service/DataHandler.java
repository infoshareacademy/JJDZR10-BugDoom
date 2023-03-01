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


public class DataHandler<T> {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Path filePath;

    public DataHandler(String fileName) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        Path inputStream = Paths.get(Objects.requireNonNull(classLoader.getResource(fileName)).toURI());
        if (!Files.exists(inputStream)) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        filePath = Paths.get(".").toAbsolutePath().resolve(fileName);
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        File file = new File(filePath.toUri());
    }

    public void saveToFile(List<T> data) throws IOException {
        try (Writer writer = Files.newBufferedWriter(Path.of(filePath.toUri()))) {
            gson.toJson(data, writer);
        }
    }

    public List<T> readFromFile(Class<T[]> clazz) throws IOException {
        String json = Files.readString(Path.of(String.valueOf(filePath)));
        T[] elements = gson.fromJson(json, clazz);
        if (elements == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(elements));
    }
}
