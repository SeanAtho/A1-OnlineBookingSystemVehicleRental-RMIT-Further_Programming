package rentalservice;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI {

    private final MyCarApp myCarApp;
    private final Scanner scanner;

    public ConsoleUI() {
        Inventory inventory = new Inventory();
        this.myCarApp = new MyCarApp(inventory);
        this.scanner = new Scanner(System.in);
    }
    

    public void start() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println("---------------------------------------------");
        System.out.println("Welcome to MyCarApp!");
        System.out.println("---------------------------------------------");
    
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Search cars by brand");
            System.out.println("2. Browse cars by type");
            System.out.println("3. Filter cars by number of seats");
            System.out.println("4. View car details");
            System.out.println("5. View available cars");
            System.out.println("6. Book rental");
            System.out.println("7. Exit");
            System.out.println("---------------------------------------------");
    
            int choice = readValidIntInput("Choice", 1, 6);
    
            switch (choice) {
                case 1:
                    searchCarsByBrand();
                    break;
                case 2:
                    browseCarsByType();
                    break;
                case 3:
                    filterCarsBySeats();
                    break;
                case 4:
                    viewCarDetails();
                    break;
                case 5:
                    bookRental();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }
    }
    
    private int readValidIntInput(String prompt, int min, int max) {
        int choice = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt + ": ");
            try {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max);
                scanner.nextLine(); // consume the invalid input
            }
        } while (!validInput);
        return choice;
    }
    

    private void searchCarsByBrand() {
        String brand = readStringInput("Brand");
        myCarApp.searchByBrand(brand);
    }

    private void browseCarsByType() {
        String type = readStringInput("Type");
        myCarApp.browseByType(type);
    }

    private void filterCarsBySeats() {
        int numSeats = readIntInput("Number of seats");
        myCarApp.filterBySeats(numSeats);
    }

    private void viewCarDetails() {
        String carId = readStringInput("Car ID");
        myCarApp.viewCarDetails(carId);
    }

    private void bookRental() {
        String carId = readStringInput("Car ID");
        String name = readStringInput("Name");
        String email = readStringInput("Email");
        int numPassengers = readIntInput("Number of passengers");
        Customer customer = new Customer(name, email, numPassengers);

        LocalDate startDate = readDateInput("Start date");
        LocalDate endDate = readDateInput("End date");

        myCarApp.bookRental(carId, customer, startDate, endDate);
    }

    private int readIntInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextInt();
    }

    private String readStringInput(String prompt) {
        System.out.print(prompt + ": ");
        scanner.nextLine(); // consume the new line character
        return scanner.nextLine();
    }

    private LocalDate readDateInput(String prompt) {
        LocalDate date = null;
        boolean isValidInput = false;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Error: input cannot be empty. Please try again.");
            } else {
                try {
                    date = LocalDate.parse(input);
                    isValidInput = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Error: invalid date format. Please use the format yyyy-MM-dd.");
                }
            }
        } while (!isValidInput);
        return date;
    }

    private void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}

