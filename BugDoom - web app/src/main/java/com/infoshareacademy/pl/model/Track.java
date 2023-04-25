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

    public List<Location> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Location> checkpoints) {
        this.checkpoints = checkpoints;
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
                '}';
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
        if (!Objects.equals(start, track.start)) return false;
        if (!Objects.equals(finish, track.finish)) return false;
        if (!Objects.equals(checkpoints, track.checkpoints)) return false;
        if (!Objects.equals(difficulty, track.difficulty)) return false;
        return Objects.equals(terrain, track.terrain);
    }

    @Override
    public int hashCode() {
        int result = (int) (trackId ^ (trackId >>> 32));
        result = 31 * result + (competitionName != null ? competitionName.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (finish != null ? finish.hashCode() : 0);
        result = 31 * result + (checkpoints != null ? checkpoints.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        result = 31 * result + (terrain != null ? terrain.hashCode() : 0);
        return result;
    }
}
