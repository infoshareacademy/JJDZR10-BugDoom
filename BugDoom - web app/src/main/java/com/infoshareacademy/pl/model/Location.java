package com.infoshareacademy.pl.model;

import java.util.Objects;

public class Location {
    private double latitude;
    private double longitude;
    private String pointName;


    public Location() {
    }

    public Location(double latitude, double longitude, String pointName) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.pointName = pointName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.latitude, latitude) != 0) return false;
        if (Double.compare(location.longitude, longitude) != 0) return false;
        return Objects.equals(pointName, location.pointName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pointName != null ? pointName.hashCode() : 0);
        return result;
    }
}


