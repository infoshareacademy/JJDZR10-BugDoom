package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.TrackNotFoundException;
import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.repository.TrackRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TrackService {
    private final TrackRepository trackRepository;
    private static final Logger logger = LoggerFactory.getLogger(TrackService.class);

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Page<Track> getAllTracks(Pageable pageable) {
        return trackRepository.findAll(pageable);
    }

    public void addTrack(Track trackToAdd){
        logger.info("Adding track: {}", trackToAdd);
        trackRepository.save(trackToAdd);
    }

    public void removeTrackById(Long trackId){
        logger.info("Removing track with id: {}", trackId);
        trackRepository.deleteById(trackId);
    }

    public Page<Track> findTracksByName(Pageable pageable, String trackName){
        return trackRepository.findTracksByName(pageable, trackName);
    }

    public Track findTrackById(Long trackId){
        return trackRepository.findById(trackId)
                .orElseThrow(() -> new TrackNotFoundException("Track with given id: '%s' not found".formatted(trackId)));
    }

    public void editTrack(Track trackToEdit) {
        trackRepository.save(trackToEdit);
    }

    public Page<Track> filterTracksByDifficulty(Pageable pageable, String difficulty) {
        return trackRepository.filterTracksByDifficulty(pageable, difficulty);
    }

    public Page<Track> findTracksByEventId(Pageable pageable, long eventId) {
        return trackRepository.findTracksByEventId(pageable, eventId);
    }
}
