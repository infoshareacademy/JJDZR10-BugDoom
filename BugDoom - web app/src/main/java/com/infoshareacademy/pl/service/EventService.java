package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.model.Event;
import com.infoshareacademy.pl.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventService implements EventRepository {
        private static final String EVENT_FILE_PATH = FilePathConstants.EVENT_FILE_PATH;
        private final DataService<Event> dataService = new DataService<>();

        public List<Event> getAllEvents() throws IOException {
            return new ArrayList<>(dataService.readFromFile(EVENT_FILE_PATH, Event[].class));
        }

        public void addEvent(Event eventToAdd) throws IOException {
            List<Event> allEvents= getAllEvents();
            allEvents.add(eventToAdd);
            saveEventsToFile(allEvents);
        }

        public void removeEventById(long eventId) throws IOException {
            List<Event> allEvents = getAllEvents();
            Event eventToDelete = findEventById(eventId);
            allEvents.remove(eventToDelete);
            saveEventsToFile(allEvents);
        }

        private void saveEventsToFile(List<Event> eventsToSave) throws IOException {
            dataService.saveToFile(eventsToSave, EVENT_FILE_PATH);
        }

        @Override
        public Event findEventById(long eventId) throws NoSuchElementException, IOException {
            List<Event> allEvents = getAllEvents();
            return allEvents.stream()
                    .filter(t -> t.getEventId() == (eventId))
                    .findFirst()
                    .orElseThrow();
        }
}
