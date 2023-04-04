package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

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
}