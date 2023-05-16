package com.infoshareacademy.pl.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventId;

    @NotEmpty(message = "Podaj nazwę wydarzenia")
    @Column(name = "event_name", nullable = false)
    private String eventName;

    @NotEmpty(message = "Podaj opis wydarzenia")
    @Column(name = "event_description", nullable = false)
    private String eventDescription;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Track> tracks;

    @OneToMany(mappedBy = "event")
    private List<User> participants;

    @PositiveOrZero(message = "Wartość nagrody nie może być ujemna")
    @Column(name = "event_prize")
    private int eventPrize;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Podaj datę wydarzenia")
    @FutureOrPresent(message = "Wybierz poprawną datę wydarzenia")
    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @NotNull(message = "Podaj rodzaj wydarzenia")
    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventType eventType;

    public Event() {
    }

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

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (eventId != event.eventId) return false;
        if (eventPrize != event.eventPrize) return false;
        if (!Objects.equals(eventName, event.eventName)) return false;
        if (!Objects.equals(eventDescription, event.eventDescription))
            return false;
        if (!Objects.equals(tracks, event.tracks)) return false;
        if (!Objects.equals(participants, event.participants)) return false;
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
        result = 31 * result + eventPrize;
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
