package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Event;

import java.io.IOException;
import java.util.List;

public interface EventRepository {
    public Event findEventById(long EventId) throws IOException;
    public List<Event> getAllEvents () throws IOException;
}
