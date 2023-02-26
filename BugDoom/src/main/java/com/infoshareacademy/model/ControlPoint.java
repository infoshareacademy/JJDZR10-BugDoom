package com.infoshareacademy.model;

public class ControlPoint {
    private String controlPointID;
    private int x;
    private int y;
    private int [][] coordinates;

    public String getControlPointID() {
        return controlPointID;
    }

    public void setControlPointID(String controlPointID) {
        this.controlPointID = controlPointID;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[][] coordinates) {
        this.coordinates = coordinates;
    }
}
