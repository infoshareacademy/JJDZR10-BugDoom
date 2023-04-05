package com.infoshareacademy.pl.controller;


import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.repository.TrackRepository;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


    @GetMapping("/tracks")
    public String getTracks(Model model) throws IOException {
        Track emptyTrack = new Track();
        model.addAttribute("track", emptyTrack);

        List<Track> tracks = trackService.getAllTracks();
        model.addAttribute("tracks",tracks);
        return "tracks/track";
    }
    
    @GetMapping("tracks/delete/{trackId}")
    public String deleteTrack(@PathVariable long trackId) throws IOException{
        trackService.removeTrackById(trackId);
        return "redirect:/tracks";
    }
    @PostMapping("/tracks")
    public String createTrack(@Valid @ModelAttribute Track track, BindingResult bindingResult) throws IOException{
        if (bindingResult.hasErrors()){
            return "tracks/add-track";
        }
        track.setTrackId(trackService.createRandomId());
        trackService.addTrack(track);
        return "redirect:/tracks";
    }

    @GetMapping("/tracks/create")
    public String showCreateForm(Model model){
        model.addAttribute("track", new Track());
        return "tracks/add-track";
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
    @GetMapping("/tracks/edit-track/{trackId}")
    public String getTrackEditForm(@PathVariable("trackId") Long trackId, Model model) throws IOException{
        Track track = trackService.findTrackById(trackId);
        model.addAttribute("track", track);
        return "tracks/edit-track";
    }

    @PostMapping("/tracks/{trackId}/edit")
    public String editTrack(@PathVariable("trackId") Long trackId, @Valid @ModelAttribute Track track, BindingResult bindingResult) throws IOException{
        if (bindingResult.hasErrors()) {
            return "tracks/edit-track";
        }
        trackService.editTrackById(trackId, track);
        return "redirect:/tracks";
    }
}

