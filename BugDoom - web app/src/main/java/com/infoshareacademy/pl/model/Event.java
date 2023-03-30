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
    private Integer eventPrize;
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

    public Integer getEventPrize() {
        return eventPrize;
    }

    public void setEventPrize(Integer eventPrize) {
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

        if (eventId != event.eventId) return false;
        if (!Objects.equals(eventName, event.eventName)) return false;
        if (!Objects.equals(eventDescription, event.eventDescription))
            return false;
        if (!Objects.equals(tracks, event.tracks)) return false;
        if (!Objects.equals(participants, event.participants)) return false;
        if (!Objects.equals(eventPrize, event.eventPrize)) return false;
        if (!Objects.equals(eventDate, event.eventDate)) return false;
        return eventType == event.eventType;
    }

    @Override
    public int hashCode() {
        int result = (int) (eventId ^ (eventId >>> 32));
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (eventDescription != null ? eventDescription.hashCode() : 0);
        result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
        result = 31 * result + (participants != null ? participants.hashCode() : 0);
        result = 31 * result + (eventPrize != null ? eventPrize.hashCode() : 0);
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        return result;
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
