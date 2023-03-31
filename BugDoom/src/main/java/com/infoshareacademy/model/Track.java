package com.infoshareacademy.model;

import java.time.LocalDate;
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
    private LocalDate trackDate;

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
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

    public LocalDate getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(LocalDate trackDate) {
        this.trackDate = trackDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (length != track.length) return false;
        if (!Objects.equals(trackId, track.trackId)) return false;
        if (!Objects.equals(competitionName, track.competitionName))
            return false;
        if (!Objects.equals(startPoint, track.startPoint)) return false;
        if (!Objects.equals(endPoint, track.endPoint)) return false;
        if (!Objects.equals(checkpoints, track.checkpoints)) return false;
        if (!Objects.equals(difficulty, track.difficulty)) return false;
        if (!Objects.equals(location, track.location)) return false;
        return Objects.equals(trackDate, track.trackDate);
    }

    @Override
    public int hashCode() {
        int result = trackId != null ? trackId.hashCode() : 0;
        result = 31 * result + (competitionName != null ? competitionName.hashCode() : 0);
        result = 31 * result + (startPoint != null ? startPoint.hashCode() : 0);
        result = 31 * result + (endPoint != null ? endPoint.hashCode() : 0);
        result = 31 * result + (checkpoints != null ? checkpoints.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (trackDate != null ? trackDate.hashCode() : 0);
        return result;
    }
}
