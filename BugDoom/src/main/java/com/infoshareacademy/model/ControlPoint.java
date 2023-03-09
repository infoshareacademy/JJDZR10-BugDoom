package com.infoshareacademy.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ControlPoint {
    private String controlPointID;
    private String coordinateXY;


    public String getControlPointID() {
        return controlPointID;
    }

    public void setControlPointID(String controlPointID) {
        this.controlPointID = controlPointID;
    }


    public String getCoordinateXY() {
        return coordinateXY;
    }

    public void setCoordinateXY(String coordinateXY) {
        this.coordinateXY = coordinateXY;
    }

    @Override
    public String toString() {
        return "ControlPoint{" +
                "controlPointID='" + controlPointID + '\'' +
                ", coordinateXY='" + coordinateXY + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControlPoint that = (ControlPoint) o;
        return Objects.equals(controlPointID, that.controlPointID) && Objects.equals(coordinateXY, that.coordinateXY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controlPointID, coordinateXY);
    }
}
