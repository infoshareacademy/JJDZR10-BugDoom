package com.infoshareacademy.pl.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Event {
    private long eventId;
    private String eventName;
    private String eventDescription;
    private List<Track> tracks;
    private List<User> participants;
    private int eventPrize;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;
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

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
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

    public int getEventPrize() {
        return eventPrize;
    }

    public void setEventPrize(int eventPrize) {
        this.eventPrize = eventPrize;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId == event.eventId && eventPrize == event.eventPrize && Objects.equals(eventName, event.eventName) && Objects.equals(eventDescription, event.eventDescription) && Objects.equals(tracks, event.tracks) && Objects.equals(participants, event.participants) && Objects.equals(eventDate, event.eventDate) && eventType == event.eventType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventName, eventDescription, tracks, participants, eventPrize, eventDate, eventType);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", tracks=" + tracks +
                ", participants=" + participants +
                ", eventPrize=" + eventPrize +
                ", eventDate=" + eventDate +
                ", eventType=" + eventType +
                '}';
    }
}
