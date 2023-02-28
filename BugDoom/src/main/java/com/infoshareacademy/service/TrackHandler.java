package com.infoshareacademy.service;

import com.infoshareacademy.model.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrackHandler {
    public static void printAllTracks() throws IOException {
        List<Track> allTracks = getAllTracks();
        allTracks.forEach(System.out::println);
    }

    public static List<Track> getAllTracks() throws IOException {
        DataHandler<Track> dataHandler = new DataHandler<>();
        List <Track> allTracks = new ArrayList<>(dataHandler.readFromFile("Track.json", Track[].class));
        return allTracks;
    }
}