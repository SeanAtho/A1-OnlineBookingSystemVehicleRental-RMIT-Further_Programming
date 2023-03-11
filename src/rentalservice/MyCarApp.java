package rentalservice;
// Acts as the controller, orchestrating interactions between the model (Inventory, Rental, Customer)
// and view (ConsoleUI) classes, and implementing program logic such as searching, filtering, and rental booking.
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MyCarApp {
    private Inventory inventory;
    private Scanner scanner;

    public MyCarApp(Inventory inventory) {
        this.inventory = inventory;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to MyCarApp!");
        boolean running = true;
        while (running) {
            System.out.println("Please select an option:");
            System.out.println("1. Search for cars by brand");
            System.out.println("2. Browse cars by type");
            System.out.println("3. Filter cars by number of seats");
            System.out.println("4. View car details");
            System.out.println("5. View available cars");
            System.out.println("6. Rent a car");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Please enter a brand name:");
                    String brand = scanner.nextLine();
                    searchByBrand(brand);
                    break;
                case 2:
                    System.out.println("Please enter a car type:");
                    String type = scanner.nextLine();
                    browseByType(type);
                    break;
                case 3:
                    System.out.println("Please enter the number of seats:");
                    int numSeats = scanner.nextInt();
                    filterBySeats(numSeats);
                    break;
                case 4:
                    System.out.println("Please enter a car ID:");
                    int carId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    viewCarDetails(carId);
                    break;
                case 5:
                    viewAvailableCars();
                    break;
                case 6:
                    System.out.println("Please enter the car ID:");
                    carId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Please enter your name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter your email address:");
                    String email = scanner.nextLine();
                    System.out.println("Please enter the number of passengers:");
                    int numPassengers = scanner.nextInt();
                    System.out.println("Please enter the start date (yyyy-mm-dd):");
                    LocalDate startDate = LocalDate.parse(scanner.next());
                    System.out.println("Please enter the end date (yyyy-mm-dd):");
                    LocalDate endDate = LocalDate.parse(scanner.next());
                    bookRental(carId, new Customer(name, email, numPassengers), startDate, endDate);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        System.out.println("Thanks for using MyCarApp!");
    }

    public void searchByBrand(String brand) {
        List<Car> cars = inventory.searchByBrand(brand);
        if (cars.isEmpty()) {
            System.out.println("No cars found.");
        } else {
            System.out.println("Cars matching " + brand + ":");
            for (Car car : cars) {
                System.out.println(car.toString());
            }
        }
    }

    public void browseByType(String type) {
        List<Car> cars = inventory.filterByType(type);
        if (cars.isEmpty()) {
            System.out.println("No cars found.");
        } else {
            System.out.println("Cars of type " + type + ":");
            for (Car car : cars) {
                System.out.println(car.toString());
            }
        }
    }

    public void filterBySe
