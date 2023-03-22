package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TrackController {
    @GetMapping("/tracks")
    public String getTracks(Model model){
        Track track = new Track();
        model.addAttribute("track", track);
            return "track";
    }
}
