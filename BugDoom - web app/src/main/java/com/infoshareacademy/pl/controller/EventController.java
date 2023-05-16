package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.model.Track;
import com.infoshareacademy.pl.service.EventService;
import com.infoshareacademy.pl.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventController {
    private final EventService eventService;
    private final TrackService trackService;

    public EventController(EventService eventService, TrackService trackService) {
        this.eventService = eventService;
        this.trackService = trackService;
    }

    @GetMapping("/events")
    public String getEvents(Model model) {
        Event emptyEvent = new Event();
        model.addAttribute("event", emptyEvent);

        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "events/event";
    }

    @GetMapping("/events/new-event")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/new-event";
    }

    @PostMapping("/events")
    public String createEvent(@Valid @ModelAttribute Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/new-event";
        }
        event.setEventId(eventService.createRandomId());
        eventService.addEvent(event);
        return "redirect:/events/";
    }

    @GetMapping("events/delete/{eventId}")
    public String deleteEvent(@PathVariable long eventId) {
        eventService.removeEventById(eventId);
        return "redirect:/events";
    }

    @GetMapping("/events/{eventId}")
    public String getEventById(@PathVariable("eventId") Long eventId, Model model) {
        List<Track> tracks = trackService.findTracksByEventId(eventId);
        model.addAttribute("event", eventService.findEventById(eventId));
        model.addAttribute("track", tracks);
        return "events/single-event";
    }

    @GetMapping("/events/edition-form/{eventId}")
    public String getEventEditForm(@PathVariable("eventId") Long eventId, Model model) {
        Event event = eventService.findEventById(eventId);
        model.addAttribute("event", event);
        return "events/event-edition";
    }

    @PostMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") Long eventId,
                            @Valid @ModelAttribute Event event,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/event-edition";
        }
        eventService.editEventById(eventId, event);
        return "redirect:/events";
    }
}
