package RouteApplicationForm;

import com.infoshareacademy.model.ControlPoint;
import com.infoshareacademy.model.Track;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void createTrack() {
        Track newTrack = new Track();

        newTrack.setCompetitionName(setCompetitionName());
        newTrack.setLength(setCompetitionLength());
        newTrack.setDifficulty(setCompetitionDifficulty(newTrack.getLength()));
        newTrack.setLocation(setCompetitionLocation());
        newTrack.setStartPoint(setCompetitionStartPoint());
        // meta
        // punkty kontrolne

        System.out.println(newTrack);
//        ApplicationForm diffType = new ApplicationForm();
//        diffType.ApplicationForm();
//        newTrack.createMap();
        System.out.println("Dziękujemy za wypełnienie formularza! :) ");
    }

    private static String setCompetitionName() {
        System.out.println("Witaj w formularzu zgłoszeniowym do Twojej nowej trasy :) ");
        boolean nameFormatIncorrect = true;
        while (nameFormatIncorrect) {
            System.out.println("Podaj nazwę Twojego biegu:");

            Scanner scanner1 = new Scanner(System.in);
            String competitionName = scanner1.nextLine();
            if (ExcludeIntegers.containsIntegers(competitionName)) {
                System.out.println("Podana wartość musi zostać zapisana w formie tekstu! Spróbuj ponownie.");

            } else {
                return competitionName;
            }
        }
        return "";
    }

    private static int setCompetitionLength() {

        ArrayList<String> items = new ArrayList<String>();
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

    private static String setCompetitionDifficulty(int length) {
        return switch (length) {
            case 5 -> "łatwa";
            case 10 -> "średnia";
            case 15 -> "trudna";
            default -> "";
        };
    }

    private static String setCompetitionLocation() {
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

    private static ControlPoint setCompetitionStartPoint() {
        List<String> points = new ArrayList<>();
        points.add(0, "0.0");
        points.add(1, "0.1");
        points.add(2, "0.2");
        points.add(3, "0.3");
        points.add(4, "0.4");
        points.add(5, "0.5");

        points.add(6, "1.0");
        points.add(7, "1.1");
        points.add(8, "1.2");
        points.add(9, "1.3");
        points.add(10, "1.4");
        points.add(11, "1.5");

        points.add(12, "2.0");
        points.add(13, "2.1");
        points.add(14, "2.2");
        points.add(15, "2.3");
        points.add(16, "2.4");
        points.add(17, "2.5");

        points.add(18, "3.0");
        points.add(19, "3.1");
        points.add(20, "3.2");
        points.add(21, "3.3");
        points.add(22, "3.4");
        points.add(23, "3.5");

        points.add(24, "4.0");
        points.add(25, "4.1");
        points.add(26, "4.2");
        points.add(27, "4.3");
        points.add(28, "4.4");
        points.add(29, "4.5");

        points.add(30, "5.0");
        points.add(31, "5.1");
        points.add(32, "5.2");
        points.add(33, "5.3");
        points.add(34, "5.4");
        points.add(35, "5.5");

        System.out.println(points.subList(0, 6));
        System.out.println(points.subList(6, 12));
        System.out.println(points.subList(12, 18));
        System.out.println(points.subList(18, 24));
        System.out.println(points.subList(24, 30));
        System.out.println(points.subList(30, 36));

        ControlPoint controlPoint = new ControlPoint();
        boolean placeholder = true;
        while (placeholder) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybierz współrzędne startu:");
            String start = scanner.nextLine();
            if (points.contains(start)) {
            placeholder=false;
            points.set(points.indexOf(start), "STR")
            } else {
                System.out.println("należy wybrać współrzęne z podanego zakresu");
            }

            controlPoint.setControlPointID("001");
            controlPoint.setCoordinateXY(start);


        }return controlPoint;
    }
}