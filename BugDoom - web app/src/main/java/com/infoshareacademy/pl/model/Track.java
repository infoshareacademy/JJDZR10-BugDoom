package com.infoshareacademy.pl.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Objects;

public class Track {
    private long trackId;
    @NotEmpty(message ="Podaj nazwę biegu")
    private String competitionName;
    @NotNull(message = "Podaj współrzędne startu")
    private Location start;
    @NotNull(message = "Podaj współrzędne mety")
    private Location finish;
    private List<Location> checkpoints;
    @Positive (message = "Długość biegu musi być większa od 0")
    private int length;
    @NotEmpty (message = "Wybierz trudność trasy")
    private String difficulty;
    @NotEmpty (message = "Wybierz lokalizację")
    private String terrain;
    private long eventId;

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

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getFinish() {
        return finish;
    }

    public void setFinish(Location finish) {
        this.finish = finish;
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

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", competitionName='" + competitionName + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                ", checkpoints=" + checkpoints +
                ", length=" + length +
                ", difficulty='" + difficulty + '\'' +
                ", terrain='" + terrain + '\'' +
                ", eventId=" + eventId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return trackId == track.trackId && length == track.length && eventId == track.eventId && Objects.equals(competitionName, track.competitionName) && Objects.equals(start, track.start) && Objects.equals(finish, track.finish) && Objects.equals(checkpoints, track.checkpoints) && Objects.equals(difficulty, track.difficulty) && Objects.equals(terrain, track.terrain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackId, competitionName, start, finish, checkpoints, length, difficulty, terrain, eventId);
    }
}
