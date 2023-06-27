package com.infoshareacademy.pl.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Objects;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trackId;

    @NotEmpty(message ="Podaj nazwę biegu")
    @Column(name = "competition_name", nullable = false)
    private String competitionName;

    @OneToMany(mappedBy = "track")
    private List<Location> locations;

    @Positive(message = "Długość biegu musi być większa od 0")
    @Column(name = "track_length")
    private int length;

    @NotEmpty (message = "Wybierz trudność trasy")
    @Column(name = "track_difficulty", nullable = false)
    private String difficulty;

    @NotEmpty(message = "Wybierz lokalizację")
    @Column(name = "track_terrain")
    private String terrain;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Track() {
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Location getFinish() {
        return locations.stream()
                .filter(Location::isTrackFinish)
                .findFirst().orElse(new Location(0.0, 0.0));
    }

    public Location getStart() {
        return locations.stream()
                .filter(Location::isTrackStart)
                .findFirst().orElse(new Location(0.0, 0.0));
    }

    public List<Location> getCheckpoints() {
        return locations.stream()
                .filter(Location::isCheckpoint)
                .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (trackId != track.trackId) return false;
        if (length != track.length) return false;
        if (!Objects.equals(competitionName, track.competitionName))
            return false;
        if (!Objects.equals(locations, track.locations)) return false;
        if (!Objects.equals(difficulty, track.difficulty)) return false;
        if (!Objects.equals(terrain, track.terrain)) return false;
        return Objects.equals(event, track.event);
    }

    @Override
    public int hashCode() {
        int result = (int) (trackId ^ (trackId >>> 32));
        result = 31 * result + (competitionName != null ? competitionName.hashCode() : 0);
        result = 31 * result + (locations != null ? locations.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        result = 31 * result + (terrain != null ? terrain.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", competitionName='" + competitionName + '\'' +
                ", locations=" + locations +
                ", length=" + length +
                ", difficulty='" + difficulty + '\'' +
                ", terrain='" + terrain + '\'' +
                ", event=" + event +
                '}';
    }
}
