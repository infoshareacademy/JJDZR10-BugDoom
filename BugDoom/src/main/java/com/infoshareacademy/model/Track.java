package com.infoshareacademy.model;

import java.util.List;
import java.util.Objects;

public class Track {
    private String trackId;
    private String competitionName;
    private ControlPoint startPoint;
    private ControlPoint endPoint;
    private List<ControlPoint> checkpoints;
    private int length;
    private String difficulty;
    private String location;

    public String getTrackId() {
        return trackId;
    }

    public void setId(String trackId) {
        this.trackId = trackId;
    }

    public ControlPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(ControlPoint startPoint) {
        this.startPoint = startPoint;
    }

    public ControlPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(ControlPoint endPoint) {
        this.endPoint = endPoint;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public List<ControlPoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<ControlPoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId='" + trackId + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", length=" + length +
                ", location='" + location + '\'' +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", checkpoint=" + checkpoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return length == track.length && Objects.equals(trackId, track.trackId) && Objects.equals(competitionName, track.competitionName) && Objects.equals(startPoint, track.startPoint) && Objects.equals(endPoint, track.endPoint) && Objects.equals(checkpoints, track.checkpoints) && Objects.equals(difficulty, track.difficulty) && Objects.equals(location, track.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackId, competitionName, startPoint, endPoint, checkpoints, length, difficulty, location);
    }
}
