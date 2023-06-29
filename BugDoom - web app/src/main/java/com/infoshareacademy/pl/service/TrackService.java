package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.TrackNotFoundException;
import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.model.Location;
import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.repository.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TrackService {
    private final TrackRepository trackRepository;
//    private List<Location>locations = new ArrayList<>();

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public void addTrack(Track trackToAdd){
        trackRepository.save(trackToAdd);
    }

    public void removeTrackById(Long trackId){
        trackRepository.deleteById(trackId);
    }

    public List<Track> findTracksByName(String trackName){
        return trackRepository.findTracksByName(trackName);
    }

    public Track findTrackById(Long trackId){
        return trackRepository.findById(trackId)
                .orElseThrow(() -> new TrackNotFoundException("Track with given id: '%s' not found".formatted(trackId)));
    }

    public void editTrack(Track trackToEdit) {
        trackRepository.save(trackToEdit);
    }

    public List<Track> filterTracksByDifficulty(String difficulty) {
        return trackRepository.filterTracksByDifficulty(difficulty);
    }

    public List<Track> findTracksByEventId(long eventId) {
        return trackRepository.findTracksByEventId(eventId);
    }

//    public List<Location>getLocations(){
//        return locations;
//    }
}
