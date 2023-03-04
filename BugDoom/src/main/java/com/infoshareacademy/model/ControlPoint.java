package com.infoshareacademy.model;

import java.util.Arrays;
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
}
