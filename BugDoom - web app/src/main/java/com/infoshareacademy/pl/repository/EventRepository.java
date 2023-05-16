package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event findEventById(long eventId);

    List<Event> getAllEvents();

    void addEvent(Event eventToAdd);

    void removeEventById(long eventId);

    void editEventById(long eventId, Event event);

    long createRandomId();
}
