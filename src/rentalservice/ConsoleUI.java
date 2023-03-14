package rentalservice;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        System.out.println("Welcome to MyCarApp!");

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Search cars by brand");
            System.out.println("2. Browse cars by type");
            System.out.println("3. Filter cars by number of seats");
            System.out.println("4. View car details");
            System.out.println("5. View available cars");
            System.out.println("6. Book rental");
            System.out.println("7. Exit");

            int choice = readIntInput("Choice");

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
                    viewAvailableCars();
                    break;
                case 6:
                    bookRental();
                    break;
                case 7:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }
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
        int carId = readIntInput("Car ID");
        myCarApp.viewCarDetails(carId);
    }

    private void viewAvailableCars() {
        myCarApp.viewAvailableCars();
    }

    private void bookRental() {
        int carId = readIntInput("Car ID");
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
        System.out.print(prompt + " (yyyy-MM-dd): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateInput = scanner.nextLine();
        return LocalDate.parse(dateInput, formatter);
    }

    private void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}

