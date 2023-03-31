package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Track;
import java.io.IOException;

public interface TrackRepository {
    Track findTrackById(long TrackId) throws IOException;
}
