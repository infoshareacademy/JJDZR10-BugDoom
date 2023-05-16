
package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.util.List;

public interface TrackRepository extends JpaRepository {
    void saveTracksToFile(List<Track> tracksToSave);

    Track findTrackById(long trackId);

    List<Track> getAllTracks();

    List<Track> findTracksByKeyword(String keyword);

    void addTrack(Track trackToAdd);

    void removeTrackById(long trackId);


    long createRandomId();

    void editTrackById(long trackId, Track track);

    List<Track> filterTracksByDifficulty(String difficulty);

    List<Track> findTracksByEventId(long eventId);

    void assignTrackToEvent(Track track, long eventId);
}
