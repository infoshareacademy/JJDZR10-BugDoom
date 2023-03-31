package com.infoshareacademy.pl.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Component
public class Track {
    private long trackId;
    private String competitionName;
    private Location start;
    private Location finish;
    private List<Location> checkpoints;
    private int length;
    private String difficulty;
    private String terrain;
    private LocalDateTime startOfCompetition;

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

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public List<Location> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Location> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public LocalDateTime getStartOfCompetition() {
        return startOfCompetition;
    }

    public void setStartOfCompetition(LocalDateTime startOfCompetition) {
        this.startOfCompetition = startOfCompetition;
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
                ", startOfCompetition=" + startOfCompetition +
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
        if (!Objects.equals(terrain, track.terrain)) return false;
        return Objects.equals(startOfCompetition, track.startOfCompetition);
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
        result = 31 * result + (startOfCompetition != null ? startOfCompetition.hashCode() : 0);
        return result;
    }
}
