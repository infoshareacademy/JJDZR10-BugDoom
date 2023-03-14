package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.model.Track;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TrackService {
    private static final String TRACK_FILE_PATH = FilePathConstants.TRACK_FILE_PATH;
    private static final DataService<Track> dataService = new DataService<>();

    public static List<Track> getAllTracks() throws IOException {
        List<Track> allTracks = new ArrayList<>(dataService.readFromFile(TRACK_FILE_PATH, Track[].class));
        return allTracks;
    }

    public static void addTrackToFile(Track trackToAdd) throws IOException {
        List<Track> allTracks = getAllTracks();
        allTracks.add(trackToAdd);
        saveTracksToFile(allTracks);
    }
    public static void deleteTrack(Track trackToDelete) throws IOException {
        List<Track> allTracks = getAllTracks();
        allTracks.remove(trackToDelete);
        saveTracksToFile(allTracks);
    }

    private static void saveTracksToFile(List<Track> tracksToSave) throws IOException {
        dataService.saveToFile(tracksToSave, TRACK_FILE_PATH);
    }

    private static Optional<Track> findTrackById(long trackId) throws IOException {
        List<Track> allTracks = getAllTracks();
        Optional<Track> optionalTrack = allTracks.stream()
                .filter(t -> t.getTrackId() == (trackId))
                .findFirst();
        return optionalTrack;
    }
}
