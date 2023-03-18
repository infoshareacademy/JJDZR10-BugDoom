package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Track;

public interface TrackRepository {
    Track findTrackById(long TrackId);
}
