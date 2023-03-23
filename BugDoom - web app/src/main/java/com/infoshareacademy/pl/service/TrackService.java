package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.model.Track;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class TrackService {
    private static final String TRACK_FILE_PATH = FilePathConstants.TRACK_FILE_PATH;
    private static final DataService<Track> dataService = new DataService<>();

    public static List<Track> getAllTracks() throws IOException {
        return new ArrayList<>(dataService.readFromFile(TRACK_FILE_PATH, Track[].class));
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

    private static Track findTrackById(long trackId) throws NoSuchElementException, IOException {
        List<Track> allTracks = getAllTracks();
        return allTracks.stream()
                .filter(t -> t.getTrackId() == (trackId))
                .findFirst()
                .orElseThrow();
    }
    private List<Track>tracks = new ArrayList<>();
    public List<Track> getAll(){return tracks;}
    public void removeTrackById(Long id){
        Track foundTrack = tracks.stream().filter(track -> track.getTrackId() ==id)
                .findFirst().orElseThrow(IllegalArgumentException::new);
        tracks.remove(foundTrack);
    }
    public void addTrack(Track track){
        track.setId(new Random().nextLong(1000));
        tracks.add(track);
    }
}
