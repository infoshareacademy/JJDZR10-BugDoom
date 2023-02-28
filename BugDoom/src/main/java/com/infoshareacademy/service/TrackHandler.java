package com.infoshareacademy.service;

import com.infoshareacademy.model.Track;

import java.io.IOException;
import java.util.List;

public class TrackHandler {
    public static void printAllTracks() throws IOException {
        List<Track> allTracks = getAllTracks();
        System.out.println(allTracks);
    }

    public static List<Track> getAllTracks() throws IOException {
        DataHandler<Track> dataHandler = new DataHandler<>();
        List<Track> allTracks = dataHandler.readFromFile("Track.json", Track[].class);
        System.out.println(allTracks);
        return allTracks;
    }
}