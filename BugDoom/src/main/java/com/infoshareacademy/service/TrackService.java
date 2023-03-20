package com.infoshareacademy.service;

import com.infoshareacademy.model.ControlPoint;
import com.infoshareacademy.model.Track;
import com.infoshareacademy.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.infoshareacademy.service.FilePathConstants.CONTROL_POINT_FILE_PATH;

public class TrackService {
    private static final String TRACK_FILE_PATH = FilePathConstants.TRACK_FILE_PATH;

    public static void printAllTracks() throws IOException {
        List<Track> allTracks = getAllTracks();
        allTracks.forEach(System.out::println);
    }

    public static void createTrack() throws IOException {
        Track newTrack = new Track();
        newTrack.setId(String.valueOf(TrackForm.setId()));
        newTrack.setCompetitionName(TrackForm.setCompetitionName());
        newTrack.setLength(TrackForm.setCompetitionLength());
        newTrack.setDifficulty(TrackForm.setCompetitionDifficulty(newTrack.getLength()));
        newTrack.setLocation(TrackForm.setCompetitionLocation());

        newTrack.setStartPoint(TrackForm.setCompetitionStartPoint());
        newTrack.setEndPoint(TrackForm.setCompetitionEndPoint());
        newTrack.setCheckpoints(TrackForm.setCheckpoint());

        TrackService.addTrackToFile(newTrack);
        System.out.println("Dziękujemy za wypełnienie formularza! :) ");
    }

    public static void addTrackToFile(Track trackToAdd) throws IOException {
        DataService<Track> dataHandler = new DataService<>();
        List<Track> allTracks = getAllTracks();
        allTracks.add(trackToAdd);
        dataHandler.saveToFile(allTracks, TRACK_FILE_PATH);
    }

    public static void deleteTrack(Track trackToDelete) throws IOException {
        List<Track> allTracks = getAllTracks();
        System.out.println(allTracks.contains(trackToDelete));
        allTracks.remove(trackToDelete);
        saveTracksToFile(allTracks);
        System.out.println("Trasa o numerze id " + trackToDelete.getTrackId() + " została usunięta");
        System.out.println();
    }

    private static List<Track> getAllTracks() throws IOException {
        DataService<Track> dataService = new DataService<>();
        List<Track> allTracks = new ArrayList<>(dataService.readFromFile(TRACK_FILE_PATH, Track[].class));
        return allTracks;
    }

    private static void saveTracksToFile(List<Track> tracksToSave) throws IOException {
        DataService<Track> dataService = new DataService<>();
        dataService.saveToFile(tracksToSave, TRACK_FILE_PATH);
    }

    public static Optional<Track> findTrackById(String trackId) throws IOException {
        List<Track> allTracks = getAllTracks();
        Optional<Track> optionalTrack = allTracks.stream()
                .filter(t -> t.getTrackId().equals(trackId))
                .findFirst();
        return optionalTrack;
    }
}