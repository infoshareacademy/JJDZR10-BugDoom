package com.infoshareacademy.service;

import com.infoshareacademy.model.Track;
import com.infoshareacademy.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrackService {
    private static final String TRACK_FILE_PATH = "src/main/resources/Track.json";
    public static void printAllTracks() throws IOException {
        List<Track> allTracks = getAllTracks();
        allTracks.forEach(System.out::println);
    }

    private static List<Track> getAllTracks() throws IOException {
        DataService<Track> dataHandler = new DataService<>();
        List <Track> allTracks = new ArrayList<>(dataHandler.readFromFile(TRACK_FILE_PATH, Track[].class));
        return allTracks;
    }
}