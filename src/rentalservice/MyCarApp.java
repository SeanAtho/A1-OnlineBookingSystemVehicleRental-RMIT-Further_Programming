/**
This class represents the main application for the MyCar rental service.
It provides methods to search, browse and book cars, as well as view rental details.
*/
package rentalservice;
import java.time.LocalDate;

public class MyCarApp {

    /**
    * The inventory of cars managed by the application.
    */
    private Inventory inventory;

    /**
    * Constructs a new instance of the MyCarApp class with the specified inventory.
    * @param inventory The inventory of cars to be managed by the application.
    */
    public MyCarApp(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
    * Prints a welcome message to the console.
    */
    public void start() {
        System.out.println("Welcome to MyCarApp!");
    }

    /**
    * Searches for cars in the inventory by brand and prints them to the console.
    * @param brand The brand of the cars to search for.
    */
    public void searchByBrand(String brand) {
        System.out.println("Searching for cars by brand: " + brand);
        boolean foundCars = false;
        for (Car car : inventory.getCars()) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(car);
                foundCars = true;
            }
        }
        if (!foundCars) {
            System.out.println("No cars found with the brand: " + brand);
        }
    }
    
    /**
    * Browses the inventory of cars by type and prints them to the console.
    * @param type The type of the cars to browse for.
    */
    public void browseByType(String type) {
        System.out.println("Browsing cars by type: " + type);
        boolean foundCars = false;
        for (Car car : inventory.getCars()) {
            if (car.getType().equalsIgnoreCase(type)) {
                System.out.println(car);
                foundCars = true;
            }
        } 
        if (!foundCars) {
            System.out.println("No cars found with the type: " + type);
        }
    }

    /**
    * Filters the inventory of cars by number of seats and prints the results to the console.
    * @param numSeats The minimum number of seats required for a car to be included in the results.
    */
    public void filterBySeats(int numSeats) {
        System.out.println("Filtering cars by number of seats: " + numSeats);
        boolean foundCars = false;
        for (Car car : inventory.getCars()) {
            if (car.getSeats() >= numSeats) {
                System.out.println(car);
                foundCars = true;
            }
        }
        if (!foundCars) {
            System.out.println("No cars found with the type: " + numSeats);
        }
    }

    /**
    * Displays the details of a car with the specified ID.
    * @param carId The ID of the car to display details for.
    */
    public void viewCarDetails(String carId) {
        Car car = inventory.getCarById(carId);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Car not found");
        }
    }

    /**
    * Books a rental for the specified car and customer, starting on the specified start date and ending on the specified end date.
    * @param carId The ID of the car to book a rental for.
    * @param customer The customer who will rent the car.
    * @param startDate The start date of the rental.
    * @param endDate The end date of the rental.
    */
    public void bookRental(String carId, Customer customer, LocalDate startDate, LocalDate endDate) {
        Car car = inventory.getCarById(carId);
        if (car == null) {
            System.out.println("Car not found");
            return;
        }

        Rental rental = new Rental(car, customer, startDate, endDate);
        viewRentalDetails(rental);
    }


    /**
    Displays the details of a rental, including the car brand and model, renter's name and email,
    rental period, rental fee, and insurance fee.
    @param rental The Rental object containing the rental details to display.
    */
    public void viewRentalDetails(Rental rental) {
        System.out.println("---------------------------------------------");
        System.out.println("Rental details:");
        System.out.println("---------------------------------------------");
        System.out.println("Car: " + rental.getCar().getBrand() + " " + rental.getCar().getModel());
        System.out.println("Renter: " + rental.getCustomer().getFirstName() + " " + rental.getCustomer().getSurName() + " (" + rental.getCustomer().getEmail() + ")");
        System.out.println("Rental period: " + rental.getStartDate() + " to " + rental.getEndDate());
        System.out.println("Rental fee: $" + rental.getRentalFee());
        System.out.println("Insurance fee: $" + rental.getInsuranceFee());
        System.out.println("---------------------------------------------");
    }
}