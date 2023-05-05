package com.infoshareacademy.pl.model;

import java.util.Objects;

public class Location {
    private double x;
    private double y;
    private String pointName;


    public Location() {
    }

    public Location(double x, double y, String pointName) {
        this.x = x;
        this.y = y;
        this.pointName = pointName;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.x, x) != 0) return false;
        if (Double.compare(location.y, y) != 0) return false;
        return Objects.equals(pointName, location.pointName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pointName != null ? pointName.hashCode() : 0);
        return result;
    }
}


