package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.EventService;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class TrackController {
    private final TrackService trackService;
    private final EventService eventService;

    public TrackController(TrackService trackService, EventService eventService) {
        this.trackService = trackService;
        this.eventService = eventService;
    }


    @GetMapping("/tracks")
    public String getTracks(Model model, String name, String difficulty) {
        Track emptyTrack = new Track();
        model.addAttribute("track", emptyTrack);

        if (name != null && !name.isBlank()) {
            model.addAttribute("tracks", trackService.findTracksByName(name));
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
    public String deleteTrack(@PathVariable Long trackId, RedirectAttributes redirectAttributes) {
        trackService.removeTrackById(trackId);

        redirectAttributes.addFlashAttribute("trackDeletionSuccess", "Trasa została usunięta poprawnie!");
        return "redirect:/tracks";

    }

    @PostMapping("/tracks")
    public String createTrack(@Valid @ModelAttribute Track newTrack,
                              BindingResult bindingResult,
                              @RequestParam("event.eventId") long eventId,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "tracks/add-track";
        }
        newTrack.setEvent(eventService.findEventById(eventId));
        trackService.addTrack(newTrack);
        redirectAttributes.addFlashAttribute("trackAdditionSuccess", "Dodawanie trasy wykonana poprawnie!");
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
                            @RequestParam("track.eventId") long eventId, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("trackEditionFail", "Edycja trasy nie powiodła się");
            return "tracks/edit-track";
        }
        track.setEvent(eventService.findEventById(eventId));
        trackService.editTrack(track);
        redirectAttributes.addFlashAttribute("trackEditionSuccess", "Edycja trasy wykonana poprawnie!");
        return "redirect:/tracks";
    }
    }


