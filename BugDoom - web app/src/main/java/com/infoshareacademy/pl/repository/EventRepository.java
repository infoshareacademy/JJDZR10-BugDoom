package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Event;

import java.io.IOException;
import java.util.List;

public interface EventRepository {
    Event findEventById(long eventId) throws IOException;

    List<Event> getAllEvents() throws IOException;

    void addEvent(Event eventToAdd) throws IOException;

    void removeEventById(long eventId) throws IOException;

    void editEventById(long eventId, Event event) throws IOException;

    long createRandomId();
}
