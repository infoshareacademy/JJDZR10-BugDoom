package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.repository.EventRepository;
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
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public String getEvents(Model model) throws IOException {
        Event emptyEvent = new Event();
        model.addAttribute("event", emptyEvent);

        List<Event> events = eventRepository.getAllEvents();
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
        event.setEventId(eventRepository.createRandomId());
        eventRepository.addEvent(event);
        return "redirect:/events/";
    }

    @GetMapping("events/delete/{eventId}")
    public String deleteEvent(@PathVariable long eventId) throws IOException {
        eventRepository.removeEventById(eventId);
        return "redirect:/events";
    }

    @GetMapping("/events/{eventId}")
    public String getEventById(@PathVariable("eventId") Long eventId, Model model) throws IOException{
        Event event = eventRepository.findEventById(eventId);
        model.addAttribute("event", event);
        return "events/event-edition";
    }

    @PostMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute Event event, BindingResult bindingResult) throws IOException{
        if (bindingResult.hasErrors()) {
            return "events/event-edition";
        }
        eventRepository.editEventById(eventId, event);
        return "redirect:/events";
    }
}
