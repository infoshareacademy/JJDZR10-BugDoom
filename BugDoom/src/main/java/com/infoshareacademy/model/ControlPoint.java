package com.infoshareacademy.model;

public class ControlPoint {
    // współrzędne x i y składają się na koordynaty
    int x;
    int y;
    int [][] coordinates;

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
