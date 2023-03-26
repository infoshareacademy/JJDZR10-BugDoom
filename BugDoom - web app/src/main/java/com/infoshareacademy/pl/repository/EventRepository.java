package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Event;

import java.io.IOException;

public interface EventRepository {
    public Event findEventById(long EventId) throws IOException;
}
