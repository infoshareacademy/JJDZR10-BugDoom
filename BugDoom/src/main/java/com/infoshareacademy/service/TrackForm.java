package com.infoshareacademy.service;

import com.infoshareacademy.model.ControlPoint;

import java.util.*;

public class TrackForm {
    private static List<String> points = new ArrayList<>();

    private static void printPoints() {
        System.out.println(points.subList(0, 6));
        System.out.println(points.subList(6, 12));
        System.out.println(points.subList(12, 18));
        System.out.println(points.subList(18, 24));
        System.out.println(points.subList(24, 30));
        System.out.println(points.subList(30, 36));
    }
    private static List<String> resetControlPoints() {
        return new ArrayList<>(List.of(
                "0.0", "0.1", "0.2", "0.3", "0.4", "0.5",
                "1.0", "1.1", "1.2", "1.3", "1.4", "1.5",
                "2.0", "2.1", "2.2", "2.3", "2.4", "2.5",
                "3.0", "3.1", "3.2", "3.3", "3.4", "3.5",
                "4.0", "4.1", "4.2", "4.3", "4.4", "4.5",
                "5.0", "5.1", "5.2", "5.3", "5.4", "5.5"));
    }

    public static int setId(){
        int TrackId = new Random().nextInt(1000);
        return TrackId;
            }

    public static String setCompetitionName() {
        System.out.println("Witaj w formularzu zgłoszeniowym do Twojej nowej trasy :) ");
        boolean nameFormatIncorrect = true;
        while (nameFormatIncorrect) {
            System.out.println("Podaj nazwę Twojego biegu:");

            Scanner scanner1 = new Scanner(System.in);
            String competitionName = scanner1.nextLine();
            if (containsIntegers(competitionName)) {
                System.out.println("Podana wartość musi zostać zapisana w formie tekstu! Spróbuj ponownie.");

            } else {
                return competitionName;
            }
        }
        return "";
    }

    public static int setCompetitionLength() {

        ArrayList<String> items = new ArrayList<>();
        items.add("łatwa 5 km");
        items.add("normalna 10km");
        items.add("trudna 15km");

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wybierz poziom trudności trasy z listy: ");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        int choice = 0;
        boolean validChoice = false;
        do {
            try {
                choice = scanner2.nextInt();
                if (choice >= 1 && choice <= items.size()) {
                    validChoice = true;
                } else {
                    System.out.println("Niepoprawna wartość! Wybierz numer pomiędzy 1 a " + items.size() + ".");
                }
            } catch (Exception e) {
                System.out.println("Niepoprawna wartość! Wybierz numer.");
                scanner2.nextLine();
            }
        } while (!validChoice);


        return switch (choice) {
            case 1 -> 5;
            case 2 -> 10;
            case 3 -> 15;
            default -> 0;
        };
    }

    public static String setCompetitionDifficulty(int length) {
        return switch (length) {
            case 5 -> "łatwa";
            case 10 -> "średnia";
            case 15 -> "trudna";
            default -> "";
        };
    }

    public static String setCompetitionLocation() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Wybierz lokalizację biegu:
                    1 -> Las
                    2 -> Miasto
                    3 -> Góry""");
            try {
                int choice = scanner.nextInt();
                return switch (choice) {
                    case 1 -> "las";
                    case 2 -> "miasto";
                    case 3 -> "góry";
                    default -> "nieokreślono";
                };
            } catch (InputMismatchException e) {
                System.out.println("Musisz wybrać liczbę od 1 do 3");
            }
        }
    }

    public static ControlPoint setCompetitionStartPoint() {
        points = resetControlPoints();
        printPoints();

        ControlPoint controlPoint = new ControlPoint();
        boolean placeholder = true;
        while (placeholder) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybierz współrzędne startu:");
            String start = scanner.nextLine();
            if (points.contains(start)) {
                placeholder = false;
                points.set(points.indexOf(start), "STR");
            } else {
                System.out.println("należy wybrać współrzęne z podanego zakresu");
            }

            controlPoint.setControlPointID("001");
            controlPoint.setCoordinateXY(start);


        }
        return controlPoint;
    }

    public static ControlPoint setCompetitionEndPoint() {
        printPoints();

        ControlPoint controlPoint = new ControlPoint();
        boolean placeholder = true;
        while (placeholder) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybierz współrzędne mety:");
            String end = scanner.nextLine();
            if (points.contains(end)) {
                placeholder = false;
                points.set(points.indexOf(end), "END");
            } else {
                System.out.println("należy wybrać współrzęne z podanego zakresu");
            }

            controlPoint.setControlPointID("002");
            controlPoint.setCoordinateXY(end);


        }
        return controlPoint;
    }

    public static List<ControlPoint> setCheckpoint() {
        printPoints();

        List<ControlPoint> controlPoints = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        ControlPoint controlPoint = new ControlPoint();

        int checkpointCount = 0;
        int numberOfCheckpoints;
        do {
            System.out.println("Ile chcesz stworzyć punktów orientacyjnych (maksymalnie 8):");
            numberOfCheckpoints = scanner.nextInt();
            if (numberOfCheckpoints > 8) {
                System.out.println("Wprowadź poprawną wartość mniejszą niż 8.");
            }
        } while (numberOfCheckpoints > 8);

        while (checkpointCount < numberOfCheckpoints) {
            System.out.println("Wybierz współrzędne checkpointu " + (checkpointCount + 1) + ":");
            scanner = new Scanner(System.in);
            String checkpoint = scanner.nextLine();
            if (points.contains(checkpoint)) {
                points.set(points.indexOf(checkpoint), "CH" + (checkpointCount + 1));

                controlPoint.setControlPointID("00" + (checkpointCount + 3));
                controlPoint.setCoordinateXY(checkpoint);
                controlPoints.add(controlPoint);
                checkpointCount++;
            } else {
                System.out.println("należy wybrać współrzęne z podanego zakresu z pominięciem wcześniej zdefiniwanych");
            }

        }
        printPoints();
        return controlPoints;
    }

    private static boolean containsIntegers(String s) {
        boolean containsIntegers = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                containsIntegers = true;
                break;
            }
        }
        return containsIntegers;
    }
}
