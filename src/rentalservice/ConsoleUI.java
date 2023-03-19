// This class represents the console user interface for MyCarApp.
// It uses the MyCarApp and Inventory classes to search, browse, filter and book car rentals.
// It reads user input from the console and interacts with MyCarApp accordingly.
// It makes use of several helper methods to validate and parse user input.

package rentalservice;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI {

    private final MyCarApp myCarApp; // instance of MyCarAp
    private final Scanner scanner; // instance of Scanner class to read console input
    
    // constructor to create an instance of MyCarApp and Scanner
    public ConsoleUI() {
        Inventory inventory = new Inventory();
        this.myCarApp = new MyCarApp(inventory);
        this.scanner = new Scanner(System.in);
    }
    
    // Method to start the console user interface and display the menu to the user
    public void start() {
        // Display the welcome message
        System.out.println(System.getProperty("user.dir"));
        System.out.println("---------------------------------------------");
        System.out.println("Welcome to MyCarApp!");
        System.out.println("---------------------------------------------");
        
        // Display the menu and read the user's choice
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Search cars by brand");
            System.out.println("2. Browse cars by type");
            System.out.println("3. Filter cars by number of seats");
            System.out.println("4. View car details");
            System.out.println("5. Book rental");
            System.out.println("6. Exit");
            System.out.println("---------------------------------------------");
    
            int choice = readValidIntInput("> Choice", 1, 6); // helper method to read valid integer input from user
            
            // Process the user's choice
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
   
    // helper method to read valid integer input from user within a given range 
    private int readValidIntInput(String prompt, int min, int max) {
        int choice = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt + ": ");
            try {
                choice = scanner.nextInt(); // read integer input from user
                if (choice >= min && choice <= max) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max);
                scanner.nextLine(); // consume the invalid input
            }
            scanner.nextLine(); // consume the newline character
        } while (!validInput);
        return choice;
    }
    
    
    // helper method to search cars by brand
    private void searchCarsByBrand() {
        String brand = readStringInput("Brand"); // helper method to read string input from user
        myCarApp.searchByBrand(brand); // call method in MyCarApp to search for cars by brand
    }

    // helper method to browse cars by type
    private void browseCarsByType() {
        String type = readStringInput("Type");// helper method to read string input from user
        myCarApp.browseByType(type); // call method in MyCarApp to search for cars by type
    }

    // helper method to browse cars by seats
    private void filterCarsBySeats() {
        int numSeats = readIntInput("Number of seats"); // helper method to read string input from user
        myCarApp.filterBySeats(numSeats); // call method in MyCarApp to search for cars by seats
    }

    // helper method to browse cars by Car ID
    private void viewCarDetails() {
        String carId = readStringInput("Car ID"); // helper method to read string input from user
        myCarApp.viewCarDetails(carId); // call method in MyCarApp to search for cars by Car ID
    }
    
    /**
    * Prompts the user to input rental details and books a rental for the specified car.
    * */
    private void bookRental() {
        // Prompt user to input car ID, first name, surname, email, and number of passengers
        String carId = readStringInput("Car ID");
        String firstName = readStringInput("Please provide your given name");
        String surName = readStringInput("Please provide your surname");
        String email = readStringInput("Please provide your email address");
        int numPassengers = readIntInput("Number of passengers");

        // Create a new customer object with the inputted details
        Customer customer = new Customer(firstName, surName, email, numPassengers);

         // Prompt user to input pick-up date and return date
        LocalDate startDate = readDateInput("Please provide pick-up date (dd/mm/yyyy)");
        LocalDate endDate = readDateInput("Please provide return date (dd/mm/yyyy)");

        // Book the rental for the specified car using the customer and date information
        myCarApp.bookRental(carId, customer, startDate, endDate);
    }


    /**
    * Reads an integer input from the user with the provided prompt.
    * @param prompt the message prompt to display to the user
    * @return the integer value entered by the user
    */
    private int readIntInput(String prompt) {
        int value = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt + ": ");
            try {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty");
                }
                value = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Please try again.");
            }
        } while (!validInput);
        return value;
    }
    
    /**
    Reads a string input from the user with the provided prompt.
    @param prompt the message prompt to display to the user
    @return the string value entered by the user
    */
    private String readStringInput(String prompt) {
        String input = null;
        boolean validInput = false;
        do {
            System.out.print(prompt + ": ");
            input = scanner.nextLine().trim(); // Trim the input to remove leading/trailing spaces
            if (!input.isEmpty()) {
                validInput = true;
            } else {
                System.out.println("Error: Input cannot be empty. Please try again.");
            }
        } while (!validInput);
        return input;
    }
    
    
    /**
    Reads a date input from the user with the provided prompt.
    @param prompt the message prompt to display to the user
    @return the LocalDate object representing the date entered by the user
    */
    private LocalDate readDateInput(String prompt) {
        LocalDate date = null;
        boolean validInput = false;
        do {
            System.out.print(prompt + ": ");
            try {
                String input = scanner.nextLine(); // read the actual input
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty");
                }
                date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a date in the format dd/MM/yyyy.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Please try again.");
            }
        } while (!validInput);
        return date;
    }
    
    // The exit() method terminates the program with a message.
    private void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}

