package com.infoshareacademy.pl.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "is_finish")
    private boolean isTrackFinish;

    @Column(name = "is_start")
    private boolean isTrackStart;

    @Column(name = "is_checkpoint")
    private boolean isCheckpoint;

    @ManyToOne
    private Track track;

    public Location() {
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isTrackFinish() {
        return isTrackFinish;
    }

    public void setTrackFinish(boolean trackFinish) {
        isTrackFinish = trackFinish;
    }

    public boolean isTrackStart() {
        return isTrackStart;
    }

    public void setTrackStart(boolean trackStart) {
        isTrackStart = trackStart;
    }

    public boolean isCheckpoint() {
        return isCheckpoint;
    }

    public void setCheckpoint(boolean checkpoint) {
        isCheckpoint = checkpoint;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;

        if (Double.compare(location.latitude, latitude) != 0) return false;
        if (Double.compare(location.longitude, longitude) != 0) return false;
        if (isTrackFinish != location.isTrackFinish) return false;
        if (isTrackStart != location.isTrackStart) return false;
        if (isCheckpoint != location.isCheckpoint) return false;
        if (!Objects.equals(id, location.id)) return false;
        return Objects.equals(track, location.track);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isTrackFinish ? 1 : 0);
        result = 31 * result + (isTrackStart ? 1 : 0);
        result = 31 * result + (isCheckpoint ? 1 : 0);
        result = 31 * result + (track != null ? track.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}