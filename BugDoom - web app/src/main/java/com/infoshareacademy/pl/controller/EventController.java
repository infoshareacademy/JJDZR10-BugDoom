package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public List<Event> getEventList() throws IOException {
        return eventRepository.getAllEvents();
    }
}
