package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Event;

import java.io.IOException;
import java.util.List;

public interface EventRepository {
    Event findEventById(long eventId);

    List<Event> getAllEvents();

    void addEvent(Event eventToAdd);

    void removeEventById(long eventId);

    void editEventById(long eventId, Event event);

    long createRandomId();
}
