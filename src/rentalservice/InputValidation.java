package rentalservice;

import java.util.Scanner;

public class InputValidation {

    // This method reads and validates integer input from the user
    public static int getValidIntInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) { // check if input is an integer
                input = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // consume the invalid input
            }
        }
        scanner.close(); // close the scanner to avoid resource leak
        return input;
    }

    // This method reads and validates double input from the user
    public static double getValidDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double input;

        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) { // check if input is a double
                input = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume the invalid input
            }
        }
        scanner.close(); // close the scanner to avoid resource leak
        return input;
    }

    // This method reads and validates yes/no input from the user
    public static boolean getValidYesNoInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                scanner.close(); // close the scanner before returning
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                scanner.close(); // close the scanner before returning
                return false;
            } else {
                System.out.println("Invalid input. Please enter y/yes or n/no.");
            }
        }
    }
}





