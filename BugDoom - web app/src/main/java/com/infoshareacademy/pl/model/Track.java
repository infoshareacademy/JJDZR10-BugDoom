package com.infoshareacademy.pl.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Component
public class Track {
    private long trackId;
    @NotEmpty
    private String competitionName;
    private Location start;
    private Location finish;
    private List<Location> checkpoints;
    @Positive
    private int length;
    @NotEmpty (message = "musisz wybrać poziom trudności")
    private String difficulty;
    @NotEmpty (message = "musisz wybrać lokalizację)")
    private String terrain;

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
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


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDifficulty() {
        return difficulty;
    }


    public String getTerrain() {
        return terrain;
    }


    public String getCompetitionName() {
        return competitionName;
    }


    public List<Location> getCheckpoints() {
        return checkpoints;
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
