package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.infoshareacademy.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Data {
    public static <T> void appendToFile(T objectToSave) {
        // saving an object to Json
        Gson gson = new Gson();
        String json = gson.toJson(objectToSave);
        // save it to a file, each class has their own file
        try {
            if (objectToSave instanceof User) {
                FileWriter writer = new FileWriter("User.json");
                writer.append(json);
                writer.close();
            }
            if (objectToSave instanceof Track) {
                FileWriter writer = new FileWriter("Track.json");
                writer.append(json);
                writer.close();
            }
            if (objectToSave instanceof ControlPoint) {
                FileWriter writer = new FileWriter("ControlPoint.json");
                writer.append(json);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                                T user = gson.fromJson(line, T.class);
                                return user;
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
                                T track = gson.fromJson(line, T.class);
                                return track;
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
                                T controlPoint = gson.fromJson(line, T.class);
                                return controlPoint;
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
