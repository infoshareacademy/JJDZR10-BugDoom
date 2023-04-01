
package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Track;

import java.io.IOException;
import java.util.List;

public interface TrackRepository {
    public Track findTrackById(long trackId) throws IOException;

    public List<Track> getAllTracks() throws IOException;

    public void addTrack(Track trackToAdd) throws IOException;

    public void removeTrackById(long trackId) throws IOException;
    

    long createRandomId();
}
