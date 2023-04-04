package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.service.EventService;
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
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String getEvents(Model model) throws IOException {
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
    public String createEvent(@Valid @ModelAttribute Event event, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "events/new-event";
        }
        event.setEventId(eventService.createRandomId());
        eventService.addEvent(event);
        return "redirect:/events/";
    }

    @GetMapping("events/delete/{eventId}")
    public String deleteEvent(@PathVariable long eventId) throws IOException {
        eventService.removeEventById(eventId);
        return "redirect:/events";
    }

    @GetMapping("/events/{eventId}")
    public String getEventById(@PathVariable("eventId") Long eventId, Model model) throws IOException{
        Event event = eventService.findEventById(eventId);
        model.addAttribute("event", event);
        return "events/single-event";
    }

    @GetMapping("/events/edition-form/{eventId}")
    public String getEventEditForm(@PathVariable("eventId") Long eventId, Model model) throws IOException{
        Event event = eventService.findEventById(eventId);
        model.addAttribute("event", event);
        return "events/event-edition";
    }

    @PostMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute Event event, BindingResult bindingResult) throws IOException{
        if (bindingResult.hasErrors()) {
            return "events/event-edition";
        }
        eventService.editEventById(eventId, event);
        return "redirect:/events";
    }
}
