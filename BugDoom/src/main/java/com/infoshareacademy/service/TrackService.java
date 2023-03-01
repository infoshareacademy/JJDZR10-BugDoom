package com.infoshareacademy.service;

import com.infoshareacademy.model.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TrackService {
    private static final String TRACK_FILE_PATH = "src/main/resources/Track.json";

    public static void printAllTracks() throws IOException {
        List<Track> allTracks = getAllTracks();
        allTracks.forEach(System.out::println);
    }
    public static void deleteTrack() throws IOException {
        System.out.println("Wprowadź id trasy, którą chcesz usunąć: ");
        String trackId = getUserChoice();
        List<Track> allTracks = getAllTracks();
        if (allTracks.stream().filter(t -> t.getTrackId().equals(trackId)).findFirst().isPresent()){
            Track trackToDelete = allTracks.stream().filter(t -> t.getTrackId().equals(trackId)).findFirst().get();
            allTracks.remove(trackToDelete);
            saveTracksToFile(allTracks);
            System.out.println("Trasa o numerze id " + trackId + " została usunięta");
            System.out.println();
        } else {
            System.out.println("Żadna z tras nie ma takiego id!");
            System.out.println();
        }
    }

    private static List<Track> getAllTracks() throws IOException {
        DataService<Track> dataService= new DataService<>();
        List <Track> allTracks = new ArrayList<>(dataService.readFromFile(TRACK_FILE_PATH, Track[].class));
        return allTracks;
    }
    private static void saveTracksToFile(List<Track> tracksToSave) throws IOException{
        DataService<Track> dataService = new DataService<>();
        dataService.saveToFile(tracksToSave, TRACK_FILE_PATH);
    }
    private static String getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}