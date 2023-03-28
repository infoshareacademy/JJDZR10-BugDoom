package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Event;

import java.io.IOException;
import java.util.List;

public interface EventRepository {
    public Event findEventById(long eventId) throws IOException;
    public List<Event> getAllEvents () throws IOException;
    public void addEvent(Event eventToAdd) throws IOException;
    public void removeEventById (long eventId) throws IOException;
    public void editEventById (long eventId, Event event) throws IOException;
    public long createRandomId();
}
