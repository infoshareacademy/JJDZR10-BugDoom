package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public String getEvents(Model model) throws IOException{
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
    public String createEmployee(@ModelAttribute Event event, BindingResult bindingResult) throws IOException{
        eventRepository.addEvent(event);
        return "redirect:/events/";
    }
}
