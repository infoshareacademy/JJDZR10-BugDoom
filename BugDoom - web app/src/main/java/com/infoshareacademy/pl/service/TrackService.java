package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.TrackNotFoundException;
import com.infoshareacademy.pl.model.Track;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class TrackService {
    private List<Track>tracks = new ArrayList<>();
    public List<Track> getAll(){return tracks;}
    public void removeTrackById(Long id){
        Track foundTrack = findById(id);
        tracks.remove(foundTrack);
    }
    public void addTrack(Track track){
        tracks.add(track);
    }

    public Track findById(Long id){
        return tracks.stream().filter(track -> track.getId() == id)
                .findFirst().orElseThrow(() -> new TrackNotFoundException("Nie ma trasy o takim ID: %s".formatted(id)));
    }
}
