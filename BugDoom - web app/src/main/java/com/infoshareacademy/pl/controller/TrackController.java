package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.repository.TrackRepository;
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
    private final TrackRepository trackRepository;

    public TrackController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @GetMapping("/tracks")
    public String getTracks(Model model) throws IOException {
        Track emptyTrack = new Track();
        model.addAttribute("track", emptyTrack);

        List<Track> tracks = trackRepository.getAllTracks();
        model.addAttribute("tracks",tracks);
        return "tracks/track";
    }
    @GetMapping("/tracks/delete-track/{trackId}")
    public String deleteTrack(@PathVariable long trackId) throws IOException{
        trackRepository.removeTrackById(trackId);
        return "redirect:/tracks";
    }
    @PostMapping("/tracks")
    public String createTrack(@Valid @ModelAttribute Track track, BindingResult bindingResult) throws IOException{
        if (bindingResult.hasErrors()){
            return "tracks/track";
        }
        trackRepository.addTrack(track);
        return "redirect:/tracks";
    }



    @GetMapping("/tracks/create")
    public String showCreateForm(Model model){
        model.addAttribute("track", new Track());
        return "tracks/add-track";
    }
}
