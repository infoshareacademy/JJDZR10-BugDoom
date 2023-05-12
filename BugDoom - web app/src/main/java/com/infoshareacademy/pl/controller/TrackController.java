package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.EventService;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class TrackController {
    private final TrackService trackService;
    private final EventService eventService;

    public TrackController(TrackService trackService, EventService eventService) {
        this.trackService = trackService;
        this.eventService = eventService;
    }


    @GetMapping("/tracks")
    public String getTracks(Model model, String name, String difficulty) throws IOException {
        Track emptyTrack = new Track();
        model.addAttribute("track", emptyTrack);

        if (name != null && !name.isBlank()) {
            model.addAttribute("tracks", trackService.findTracksByKeyword(name));
            model.addAttribute("name", name);
        } else if (difficulty != null) {
            model.addAttribute("tracks", trackService.filterTracksByDifficulty(difficulty));
            model.addAttribute("difficulty", difficulty);
        } else {
            model.addAttribute("tracks", trackService.getAllTracks());
        }
        return "tracks/track";
    }

    @GetMapping("tracks/delete/{trackId}")
    public String deleteTrack(@PathVariable long trackId) throws IOException {
        trackService.removeTrackById(trackId);
        return "redirect:/tracks";
    }

    @PostMapping("/tracks")
    public String createTrack(@Valid @ModelAttribute Track newTrack,
                              BindingResult bindingResult,
                              @RequestParam("event.eventId") long eventId) throws IOException {
        if (bindingResult.hasErrors()) {
            return "tracks/add-track";
        }
        newTrack.setTrackId(trackService.createRandomId());
        Event event = eventService.findEventById(eventId);
        newTrack.setEvent(event);

        trackService.addTrack(newTrack);
        return "redirect:/tracks";
    }

    @GetMapping("/tracks/create")
    public String showCreateForm(Model model) throws IOException{
        model.addAttribute("track", new Track());
        model.addAttribute("allEvents", eventService.getAllEvents());
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
    public String getTrackEditForm(@PathVariable("trackId") Long trackId, Model model) throws IOException {
        Track track = trackService.findTrackById(trackId);
        model.addAttribute("track", track);
        model.addAttribute("allEvents", eventService.getAllEvents());
        return "tracks/edit-track";
    }

    @PostMapping("/tracks/{trackId}/edit")
    public String editTrack(@PathVariable("trackId") Long trackId,
                            @Valid @ModelAttribute Track track,
                            BindingResult bindingResult,
                            @RequestParam("event.eventId") long eventId) throws IOException {
        if (bindingResult.hasErrors()) {
            return "tracks/edit-track";
        }
        if (track.getEvent().getEventId() != eventId) {

        }
        trackService.editTrackById(trackId, track);
        return "redirect:/tracks";
    }
}

