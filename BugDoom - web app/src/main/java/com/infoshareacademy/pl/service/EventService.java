package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.EventNotFoundException;
import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventService {
    private final EventRepository eventRepository;
    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

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
        logger.info("Added event: {}", eventToAdd);
        eventRepository.save(eventToAdd);
    }

    public void removeEventById(Long eventId) {
        logger.info("Removing event with id: {}", eventId);
        eventRepository.deleteById(eventId);
    }

    public void editEventById(Event eventToEdit){
        logger.info("Replacing event with id: {}, with event {}", findEventById(eventToEdit.getEventId()), eventToEdit);
        eventRepository.save(eventToEdit);
    }

    public Event findEventById(Long eventId){
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event with the following id has not been found: %x".formatted(eventId)));
    }
}
