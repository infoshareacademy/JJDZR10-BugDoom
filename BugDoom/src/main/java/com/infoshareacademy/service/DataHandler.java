package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.infoshareacademy.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataHandler {
    public static <T> void appendToFile(T objectToSave) {
        // saving an object to Json
        Gson gson = new Gson();
        String json = gson.toJson(objectToSave);
        // save it to a file, each class has their own file
        try {
            if (objectToSave instanceof User) {
                writeToFile(json, "User.json");
            }
            if (objectToSave instanceof Track) {
                writeToFile(json, "Track.json");
            }
            if (objectToSave instanceof ControlPoint) {
                writeToFile(json, "ControlPoint.json");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String json, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.append(json + "\n");
        writer.close();
    }

    public static <T> T findInFile (T objectToFind, String id) {
        Gson gson = new Gson();
        try {
            if (objectToFind instanceof User) {
                File file = new File("User.json");
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] fields = line.split(",");
                    for (String field : fields) {
                        if (field.contains("id")) {
                            String[] idInFile = field.split(":");
                            if (idInFile[1].equals(id)) {
                                User user = gson.fromJson(line, User.class);
                                return (T) user;
                            }
                        }
                    }
                }
            }
            if (objectToFind instanceof Track) {
                File file = new File("Track.json");
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] fields = line.split(",");
                    for (String field : fields) {
                        if (field.contains("id")) {
                            String[] idInFile = field.split(":");
                            if (idInFile[1].equals(id)) {
                                Track track = gson.fromJson(line, Track.class);
                                return (T) track;
                            }
                        }
                    }
                }
            }
            if (objectToFind instanceof ControlPoint) {
                File file = new File("ControlPoint.json");
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] fields = line.split(",");
                    for (String field : fields) {
                        if (field.contains("id")) {
                            String[] idInFile = field.split(":");
                            if (idInFile[1].equals(id)) {
                                ControlPoint controlPoint = gson.fromJson(line, ControlPoint.class);
                                return (T) controlPoint;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
