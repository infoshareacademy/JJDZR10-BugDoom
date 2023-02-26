package RouteApplicationForm;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Witaj w formularzu zgłoszeniowym do Twojej nowej trasy :) ");
        System.out.println("Podaj nazwę Twojego biegu:");

        Scanner scanner1 = new Scanner(System.in);
        String competitionName = scanner1.nextLine();
        System.out.println(competitionName);

        if (ExcludeIntegers.containsIntegers(competitionName)) {
            System.out.println("Podana wartość musi zostać zapisana w formie tekstu! Spróbuj ponownie.");
            return;
        }


        ApplicationForm diffType = new ApplicationForm();
        diffType.ApplicationForm();

        System.out.println("Dziękujemy za wypełnienie formularza! :) ");

    }
}
