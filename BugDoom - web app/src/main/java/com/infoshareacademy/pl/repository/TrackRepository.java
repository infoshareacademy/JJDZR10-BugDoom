
package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.model.Track;

import java.io.IOException;
import java.util.List;

public interface TrackRepository {
    void saveTracksToFile(List<Track> tracksToSave);

    Track findTrackById(long trackId);

    List<Track> getAllTracks();

    List<Track> findTracksByKeyword(String keyword);

    void addTrack(Track trackToAdd);

    void removeTrackById(long trackId);


    long createRandomId();

    void editTrackById(long trackId, Track track);

    List<Track> filterTracksByDifficulty(String difficulty);

    List<Track> findTracksByEvent(Event event);

    void assignTrackToEvent(Track track, Event event);
}
