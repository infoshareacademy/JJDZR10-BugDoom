package com.infoshareacademy.model;

import java.util.List;

public class Track extends ControlPoint {
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
}
