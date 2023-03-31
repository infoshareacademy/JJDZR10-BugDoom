package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/tracks")
    public String getTracksList(Model model) throws IOException {
        Track emptyTrack = new Track();
        model.addAttribute("track", emptyTrack);

        model.addAttribute("tracks", trackService.getAllTracks());
        return "tracks/track";
    }
    @GetMapping("/tracks/{id}")
    public String getTrackDetails(@PathVariable("id") Long id, Model model) throws IOException {
        Track track = trackService.findTrackById(id);

        if (track == null) {
            model.addAttribute("errorMessage", "Track not found!");
            return "tracks/track-error";
        }
        model.addAttribute("track", track);
        return "tracks/track-details";
    }
}

