package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.TrackNotFoundException;
import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.repository.TrackRepository;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.*;

@Service
public class TrackService implements TrackRepository {

    private static final String TRACK_FILE_PATH = FilePathConstants.TRACK_FILE_PATH;
    private final DataService<Track> dataService;

    public TrackService(DataService<Track> dataService) {
        this.dataService = dataService;
    }

    public long createRandomId() {
        return new Random().nextLong(1000);
    }

    @Override
    public List<Track> getAllTracks() throws IOException {
        return new ArrayList<>(dataService.readFromFile(TRACK_FILE_PATH, Track[].class));
    }

    @Override
    public void addTrack(Track trackToAdd) throws IOException {
        List<Track> allTracks = getAllTracks();
        allTracks.add(trackToAdd);
        saveTracksToFile(allTracks);
    }

    @Override
    public void removeTrackById(long trackId) throws IOException {
        List<Track> allTracks = getAllTracks();
        Track trackToDelete = findTrackById(trackId);
        allTracks.remove(trackToDelete);
        saveTracksToFile(allTracks);
    }

    @Override
    public void saveTracksToFile(List<Track> tracksToSave) throws IOException {
        dataService.saveToFile(tracksToSave, TRACK_FILE_PATH);
    }

    @Override
    public List<Track> findTracksByKeyword(String keyword) throws IOException {
        List<Track> allTracks = getAllTracks();
        return allTracks.stream()
                .filter(track -> track.getCompetitionName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    @Override
    public Track findTrackById(long trackId) throws IOException {
        List<Track> allTracks = getAllTracks();
        return allTracks.stream()
                .filter(track -> track.getTrackId() == trackId)
                .findFirst()
                .orElseThrow(() -> new TrackNotFoundException("Track with given id: '%s' not found".formatted(trackId)));
    }

    @Override
    public void editTrackById(long trackId, Track track) throws IOException {
        Track trackToEdit = findTrackById(trackId);
        removeTrackById(trackId);

        trackToEdit.setCompetitionName(track.getCompetitionName());
        trackToEdit.setLength(track.getLength());
        trackToEdit.setTerrain(track.getTerrain());
        trackToEdit.setDifficulty(track.getDifficulty());
        trackToEdit.setStart(track.getStart());
        trackToEdit.setFinish(track.getFinish());

        addTrack(trackToEdit);
    }

    @Override
    public List<Track> filterTracksByDifficulty(String difficulty) throws IOException{
        List<Track>allTracks = getAllTracks();
        return allTracks.stream()
                .filter(track-> track.getDifficulty().equals(difficulty))
                .toList();
    }
}
