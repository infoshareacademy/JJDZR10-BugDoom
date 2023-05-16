package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.exception.EventNotFoundException;
import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class EventService {
    private static final String EVENT_FILE_PATH = FilePathConstants.EVENT_FILE_PATH;
    private final DataService<Event> dataService;
    private final EventRepository eventRepository;

    public EventService(DataService<Event> dataService, EventRepository eventRepository) {
        this.dataService = dataService;
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void addEvent(Event eventToAdd) {
        List<Event> allEvents = getAllEvents();
        allEvents.add(eventToAdd);
        saveEventsToFile(allEvents);
    }

    public void removeEventById(long eventId) {
        List<Event> allEvents = getAllEvents();
        Event eventToDelete = findEventById(eventId);
        allEvents.remove(eventToDelete);
        saveEventsToFile(allEvents);
    }

    @Override
    public void editEventById(long eventId, Event event) throws IOException{
        Event eventToEdit = findEventById(eventId);
        removeEventById(eventId);

        eventToEdit.setEventName(event.getEventName());
        eventToEdit.setEventDescription(event.getEventDescription());
        eventToEdit.setEventPrize(event.getEventPrize());
        eventToEdit.setEventType(event.getEventType());
        eventToEdit.setEventDate(event.getEventDate());
        addEvent(eventToEdit);
    }

    private void saveEventsToFile(List<Event> eventsToSave) throws IOException {
        dataService.saveToFile(eventsToSave, EVENT_FILE_PATH);
    }

    @Override
    public Event findEventById(long eventId) throws IOException {
        List<Event> allEvents = getAllEvents();
        return allEvents.stream()
                .filter(t -> t.getEventId() == (eventId))
                .findFirst()
                .orElseThrow(() -> new EventNotFoundException("Event with the following id has not been found: %x".formatted(eventId)));
    }
    public long createRandomId() {
        return new Random().nextLong(1001);
    }
}
