package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

import java.io.IOException;
import java.util.List;


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
