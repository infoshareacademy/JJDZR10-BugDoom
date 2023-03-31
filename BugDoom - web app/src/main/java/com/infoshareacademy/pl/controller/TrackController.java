package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

import java.util.List;


@Controller
public class TrackController {
    private final TrackService trackService;
    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    @GetMapping("/tracks")
    public List<Track> getTrackList() throws IOException {
            return trackService.getAllTracks();
    public String getTracks(Model model){
        Track emptyTrack = new Track();
        model.addAttribute("track", emptyTrack);

        List<Track> tracks = trackService.getAll();
        model.addAttribute("tracks",tracks);
            return "track";
    }
    @GetMapping("/tracks/delete-track/{id}")
    public String deleteTrack(@PathVariable long id){
        trackService.removeTrackById(id);
        return "redirect:/tracks";
    }
    @PostMapping("/tracks")
    public String createTrack(@Valid @ModelAttribute Track track, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "track";
        }
        trackService.addTrack(track);
        return "redirect:/tracks";
    }

}
