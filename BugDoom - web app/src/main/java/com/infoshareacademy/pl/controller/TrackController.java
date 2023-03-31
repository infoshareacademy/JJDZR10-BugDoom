package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TrackController {
    private final TrackService trackService;
    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    @GetMapping("/tracks/create")
    public String showCreateForm(Model model){
        model.addAttribute("track", new Track());
        return "tracks/add-track";
    }

}
