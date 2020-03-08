package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputAssistance {

   static Scanner sc = new Scanner(System.in);

    public static String stringInput() {
        String input = sc.nextLine();
        return input;
    }

    public static LocalDate localDateInput(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        boolean loop = localDateValidator(date);
        while (!loop) {
            System.out.println("Date need to be entered as 'yyyy-mm-dd', try again");
            System.out.print("Enter input: ");
            date = stringInput();
            loop = localDateValidator(date);
        }
        return LocalDate.parse(date, formatter);
    }

    public static boolean localDateValidator(String date) {
        if (date == null) {
            return false;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }

    }
    
    public static int intInput() {
        int inputReturn = -1;
        boolean loop = true;
        while (loop) {
            String input = sc.nextLine();
            boolean checker = intValidator(input);
            if (checker) {
                inputReturn = Integer.parseInt(input);
                loop = false;
            } else {
                System.out.println("Illegal input, please try again.");
            }
        }

        return inputReturn;
    }

    public static boolean intValidator(String input) {
        if (input == null) {
            return false;
        }
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
