package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Location;
import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
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
    @GetMapping("tracks/delete/{trackId}")
    public String deleteTrack(@PathVariable long trackId) throws IOException{
        trackRepository.removeTrackById(trackId);
        return "redirect:/tracks";
    }
    @PostMapping("/tracks")
    public String createTrack(@Valid @ModelAttribute Track track, BindingResult bindingResult) throws IOException{
        if (bindingResult.hasErrors()){
            return "tracks/track";
        }
        track.setTrackId(trackRepository.createRandomId());
        trackRepository.addTrack(track);
        return "redirect:/tracks";
    }



    @GetMapping("/tracks/create")
    public String showCreateForm(Model model){
        model.addAttribute("track", new Track());
        return "tracks/add-track";
    }

    @GetMapping("/map")
    public String getMap(Location start, Location finish, Model model){
        List<Location> controlPointList = new ArrayList<>();
        controlPointList.add(new Location(54.35, 18.65, "start"));
        controlPointList.add(new Location(54.35, 18.59, "meta"));
        model.addAttribute("controlPointList", controlPointList);
        return "map";
    }
    @GetMapping("/tracks/{id}")
    public String getTrackDetails(@PathVariable("id") Long id, Model model) throws IOException {
        Track track = trackRepository.findTrackById(id);

        if (track == null) {
            model.addAttribute("errorMessage", "Track not found!");
            return "tracks/track-error";
        }
        model.addAttribute("track", track);
        return "tracks/track-details";
    }
}
