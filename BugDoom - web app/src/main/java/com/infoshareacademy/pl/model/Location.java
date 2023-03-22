package com.infoshareacademy.pl.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

public class Location {
    private long controlPointID;
    private BigDecimal coordinateX;
    private BigDecimal coordinateY;

    public Location(long controlPointID, BigDecimal coordinateX, BigDecimal coordinateY) {
        this.controlPointID = controlPointID;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public long getControlPointID() {
        return controlPointID;
    }

    public void setControlPointID(long controlPointID) {
        this.controlPointID = controlPointID;
    }

    public BigDecimal getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(BigDecimal coordinateX) {
        this.coordinateX = coordinateX;
    }

    public BigDecimal getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(BigDecimal coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return controlPointID == location.controlPointID && Objects.equals(coordinateX, location.coordinateX) && Objects.equals(coordinateY, location.coordinateY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controlPointID, coordinateX, coordinateY);
    }

    @Override
    public String toString() {
        return "Location{" +
                "controlPointID=" + controlPointID +
                ", coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }
}
