package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.EventNotFoundException;
import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Page<Event> getPage(Pageable pageable) {
        return eventRepository.findAll(pageable);
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
