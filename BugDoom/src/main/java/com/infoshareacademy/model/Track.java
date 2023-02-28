package com.infoshareacademy.model;

public class Track {
    private String trackId;
    private ControlPoint startPoint;
    private ControlPoint endPoint;
    private ControlPoint checkpoint;
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

    public ControlPoint getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(ControlPoint checkpoint) {
        this.checkpoint = checkpoint;
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
}
