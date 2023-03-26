package com.infoshareacademy.pl.model;

import java.time.LocalDate;
import java.util.List;

public class Event {
    private long eventId;
    private String eventName;
    private String description;
    private List<Track> tracks;
    private List<User> participants;
    private int eventPrice;
//    private LocalDate eventDate;
    private EventType eventType;

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
    public int getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(int eventPrice) {
        this.eventPrice = eventPrice;
    }

//    public LocalDate getEventDate() {
//        return eventDate;
//    }
//
//    public void setEventDate(LocalDate eventDate) {
//        this.eventDate = eventDate;
//    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
