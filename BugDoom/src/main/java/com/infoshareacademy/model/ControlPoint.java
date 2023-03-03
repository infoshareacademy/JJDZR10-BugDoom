package com.infoshareacademy.model;

import java.util.Arrays;
import java.util.Scanner;

public class ControlPoint {
    private String controlPointID;
    public int x;
    public int y;

    public String getControlPointID() {
        return controlPointID;
    }

    public void setControlPointID(String controlPointID) {
        this.controlPointID = controlPointID;
    }

    @Override
    public String toString() {
        return "ControlPoint{" +
                "controlPointID='" + controlPointID + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", tablica=" + Arrays.toString(tablica) +
                '}';
    }

    public String[][] tablica;

    public String[][] getTablica() {
        tablica = new String[6][6];
        tablica[0][0] = "0.0";
        tablica[0][1] = "0.1";
        tablica[0][2] = "0.2";
        tablica[0][3] = "0.3";
        tablica[0][4] = "0.4";
        tablica[0][5] = "0.5";
        tablica[1][0] = "1.0";
        tablica[1][1] = "1.1";
        tablica[1][2] = "1.2";
        tablica[1][3] = "1.3";
        tablica[1][4] = "1.4";
        tablica[1][5] = "1.5";
        tablica[2][0] = "2.0";
        tablica[2][1] = "2.1";
        tablica[2][2] = "2.2";
        tablica[2][3] = "2.3";
        tablica[2][4] = "2.4";
        tablica[2][5] = "2.5";
        tablica[3][0] = "3.0";
        tablica[3][1] = "3.1";
        tablica[3][2] = "3.2";
        tablica[3][3] = "3.3";
        tablica[3][4] = "3.4";
        tablica[3][5] = "3.5";
        tablica[4][0] = "4.0";
        tablica[4][1] = "4.1";
        tablica[4][2] = "4.2";
        tablica[4][3] = "4.3";
        tablica[4][4] = "4.4";
        tablica[4][5] = "4.5";
        tablica[5][0] = "5.0";
        tablica[5][1] = "5.1";
        tablica[5][2] = "5.2";
        tablica[5][3] = "5.3";
        tablica[5][4] = "5.4";
        tablica[5][5] = "5.5";

        return tablica;
    }

    public void setTablica(String[][] tablica) {
        this.tablica = tablica;
    }

    public void setCoordinateXY() {
        boolean placeholder = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("podaj współrzedną X");
                x = scanner.nextInt();
                System.out.println("podaj współrzedną Y");
                y = scanner.nextInt();
                if (x >= 0 && x <= 5 && y >= 0 && y <= 5) {
                    placeholder = false;
                } else {
                    System.out.println("zakres współrzędnych <0;5>");
                }
            } catch (Exception e) {
                System.out.println("musisz wprowadzić liczbę");
            }
        } while (placeholder);
        return;
    }
}
