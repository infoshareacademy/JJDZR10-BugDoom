package com.infoshareacademy.pl.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static java.math.BigDecimal.*;

public class Track {
    private long trackId;
    private String competitionName;
    private Location start;
    private Location finish;
    private List<Location> checkpoints;
    private int length;
    private String difficulty;
    private String terrain;
    public Track(){
        competitionName= "bug doom runners";
        start = new Location(1, valueOf(54.40332401279688), valueOf(54.40332401279688));
        finish = new Location(2, valueOf(54.414917663548685), valueOf(18.625340640820358));
        difficulty = "bardzo trudny";
        length = 15;
        terrain = "miejska dżungla";
    }

    public long getTrackId() {
        return trackId;
    }

    public void setId(long trackId) {
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

    @Override
    public String toString() {
        return "Track{" +
                "trackId='" + trackId + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", length=" + length +
                ", terrain='" + terrain + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                ", checkpoint=" + checkpoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return length == track.length && Objects.equals(trackId, track.trackId) && Objects.equals(competitionName, track.competitionName) && Objects.equals(start, track.start) && Objects.equals(finish, track.finish) && Objects.equals(checkpoints, track.checkpoints) && Objects.equals(difficulty, track.difficulty) && Objects.equals(terrain, track.terrain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackId, competitionName, start, finish, checkpoints, length, difficulty, terrain);
    }
}
