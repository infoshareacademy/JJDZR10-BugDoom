package com.infoshareacademy.pl.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Location {
    private double x;
    private double y;
    private String text;


    public Location() {
    }

    public Location(double x, double y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


