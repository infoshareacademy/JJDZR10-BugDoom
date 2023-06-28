package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.model.Location;
import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.EventService;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class TrackController {
    private final TrackService trackService;
    private final EventService eventService;

    public TrackController(TrackService trackService, EventService eventService) {
        this.trackService = trackService;
        this.eventService = eventService;
    }


    @GetMapping("/tracks")
    public String getTracks(Model model,
                            String name,
                            String difficulty,
                            @RequestParam(value = "eventId", required = false) Long eventId) {
        Track emptyTrack = new Track();
        List<Event> allEvents = eventService.getAllEvents();
        model.addAttribute("track", emptyTrack);
        model.addAttribute("allEvents", allEvents);

        if (name != null && !name.isBlank()) {
            model.addAttribute("tracks", trackService.findTracksByName(name));
            model.addAttribute("name", name);
        } else if (difficulty != null) {
            model.addAttribute("tracks", trackService.filterTracksByDifficulty(difficulty));
            model.addAttribute("difficulty", difficulty);
        } else if (eventId != null) {
            model.addAttribute("tracks", trackService.findTracksByEventId(eventId));
            model.addAttribute("eventId", eventId);
            model.addAttribute("selectedEvent", eventService.findEventById(eventId));
        } else {
            model.addAttribute("tracks", trackService.getAllTracks());
        }
        return "tracks/track";
    }

    @GetMapping("tracks/delete/{trackId}")
    public String deleteTrack(@PathVariable Long trackId) {
        trackService.removeTrackById(trackId);
        return "redirect:/tracks";
    }

    @PostMapping("/tracks")
    public String createTrack(@Valid @ModelAttribute Track newTrack,
                              BindingResult bindingResult,
                              @RequestParam("event.eventId") long eventId) {
        if (bindingResult.hasErrors()) {
            return "tracks/add-track";
        }
        newTrack.setEvent(eventService.findEventById(eventId));
        trackService.addTrack(newTrack);
        return "redirect:/tracks";
    }

    @GetMapping("/tracks/create")
    public String showCreateForm(Model model) {
        model.addAttribute("track", new Track());
        model.addAttribute("allEvents", eventService.getAllEvents());
        return "tracks/add-track";
    }

    @GetMapping("/tracks/{id}")
    public String getTrackDetails(@PathVariable("id") long id, Model model) {
        Track track = trackService.findTrackById(id);

        if (track == null) {
            model.addAttribute("errorMessage", "Track not found!");
            return "tracks/track-error";
        }
        model.addAttribute("track", track);
        model.addAttribute("event", eventService.findEventById(track.getEvent().getEventId()));
        return "tracks/track-details";
    }

    @GetMapping("/tracks/edit-track/{trackId}")
    public String getTrackEditForm(@PathVariable("trackId") long trackId, Model model) {
        Track track = trackService.findTrackById(trackId);
        model.addAttribute("track", track);
        model.addAttribute("currentEvent", eventService.findEventById(track.getEvent().getEventId()));
        model.addAttribute("allEvents", eventService.getAllEvents());
        return "tracks/edit-track";
    }

    @PostMapping("/tracks/{trackId}/edit")
    public String editTrack(@PathVariable("trackId") long trackId,
                            @Valid @ModelAttribute Track track,
                            BindingResult bindingResult,
                            @RequestParam("track.eventId") long eventId) {
        if (bindingResult.hasErrors()) {
            return "tracks/edit-track";
        }
        track.setEvent(eventService.findEventById(eventId));
        trackService.editTrack(track);
        return "redirect:/tracks";
    }

    @GetMapping("/tracks/{trackId}/location")
    public String getLocations(@PathVariable("trackId")long trackId, Model model) {
        Track track = trackService.findTrackById(trackId);
        model.addAttribute("track", track);
        List<Location> locations = trackService.getLocations();
        model.addAttribute("locations", locations);
        return "tracks/location";
    }
    @PostMapping("/tracks/{trackId}/location")
    public String addLocations(@PathVariable("trackId")long trackId, @Valid @ModelAttribute Track track, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tracks/add-location";
        }
        trackService.findTrackById(trackId);
        track.getLocations();
        return "redirect:/tracks/location";
    }
}

