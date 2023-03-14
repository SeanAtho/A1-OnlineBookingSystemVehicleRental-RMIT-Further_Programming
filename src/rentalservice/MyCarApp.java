package rentalservice;
import java.time.LocalDate;

public class MyCarApp {
    private Inventory inventory;

    public MyCarApp(Inventory inventory) {
        this.inventory = inventory;
    }

    public void start() {
        System.out.println("Welcome to MyCarApp!");
    }

    public void searchByBrand(String brand) {
        System.out.println("Searching for cars by brand: " + brand);
        for (Car car : inventory.getCars()) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(car);
            }
        }
    }

    public void browseByType(String type) {
        System.out.println("Browsing cars by type: " + type);
        for (Car car : inventory.getCars()) {
            if (car.getType().equalsIgnoreCase(type)) {
                System.out.println(car);
            }
        }
    }

    public void filterBySeats(int numSeats) {
        System.out.println("Filtering cars by number of seats: " + numSeats);
        for (Car car : inventory.getCars()) {
            if (car.getSeats() >= numSeats) {
                System.out.println(car);
            }
        }
    }

    public void viewCarDetails(int carId) {
        Car car = inventory.getCarById(carId);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Car not found");
        }
    }

    public void viewAvailableCars() {
        System.out.println("Available cars:");
        for (Car car : inventory.getAvailableCars()) {
            System.out.println(car);
        }
    }

    public void bookRental(int carId, Customer customer, LocalDate startDate, LocalDate endDate) {
        Car car = inventory.getCarById(carId);
        if (car == null) {
            System.out.println("Car not found");
            return;
        }

        if (!inventory.isCarAvailable(car, startDate, endDate)) {
            System.out.println("Car is not available for rental during the specified dates");
            return;
        }

        Rental rental = new Rental(car, customer, startDate, endDate);
        viewRentalDetails(rental);
    }

    public void viewRentalDetails(Rental rental) {
        System.out.println("Rental details:");
        System.out.println("Car: " + rental.getCar().getBrand() + " " + rental.getCar().getModel());
        System.out.println("Renter: " + rental.getCustomer().getName() + " (" + rental.getCustomer().getEmail() + ")");
        System.out.println("Rental period: " + rental.getStartDate() + " to " + rental.getEndDate());
        System.out.println("Rental fee: $" + rental.getRentalFee());
        System.out.println("Insurance fee: $" + rental.getInsuranceFee());
    }
    
}