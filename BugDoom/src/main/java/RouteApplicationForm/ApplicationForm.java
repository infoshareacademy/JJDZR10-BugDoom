package RouteApplicationForm;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class ApplicationForm {


    public void ApplicationForm() {

        ArrayList<String> items = new ArrayList<String>();
        items.add("łatwa 5 km");
        items.add("normalna 10km");
        items.add("trudna 15km");


        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wybierz poziom trudności trasy z listy: ");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ". " + items.get(i));
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
        System.out.println(choice);

        System.out.println("Określ współrzędne Startu biegu:");
        Scanner scanner3 = new Scanner(System.in);
        String startPoint = scanner3.nextLine();
        System.out.println(startPoint);

        System.out.println("Określ współrzędne Mety biegu:");
        Scanner scanner4 = new Scanner(System.in);
        String finishingPoint = scanner4.nextLine();
        System.out.println(finishingPoint);

        System.out.println("Podaj ilość punktów orientacyjnych:");
        Scanner scanner5 = new Scanner(System.in);
        int checkingPoint = scanner5.nextInt();
        System.out.println(checkingPoint);

        System.out.println("Podaj listę współrzędnych punktów orientacyjnych:");
        Scanner scanner6 = new Scanner(System.in);
        int coordinates = scanner6.nextInt();
        System.out.println(coordinates);

    }
}