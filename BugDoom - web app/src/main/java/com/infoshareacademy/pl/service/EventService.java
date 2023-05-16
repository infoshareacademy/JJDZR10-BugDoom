package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.EventNotFoundException;
import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void addEvent(Event eventToAdd) {
        eventRepository.save(eventToAdd);
    }

    public void removeEventById(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    public void editEventById(Event eventToEdit){
        eventRepository.save(eventToEdit);
    }

    public Event findEventById(Long eventId){
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event with the following id has not been found: %x".formatted(eventId)));
    }
}
