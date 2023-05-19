package com.infoshareacademy.pl.model;

import java.util.Objects;

public class Location {

    private String locationName;
    private double x;
    private double y;


    public Location() {
    }

    public Location(String locationName, double x, double y) {
        this.locationName = locationName;
        this.x = x;
        this.y = y;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.x, x) != 0) return false;
        if (Double.compare(location.y, y) != 0) return false;
        return Objects.equals(locationName, location.locationName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = locationName != null ? locationName.hashCode() : 0;
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}


