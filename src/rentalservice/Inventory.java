package rentalservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



// Maintains a list of all the cars in the fleet, allowing for operations such as searching and filtering based on various criteria.
/**
 * The Inventory class maintains a list of all the cars in the fleet, allowing for operations such as
 * searching and filtering based on various criteria.
 */
public class Inventory {
    private List<Car> cars;

    /**
     * Constructs a new Inventory object.
     */
    public Inventory() {
        cars = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("fleet.csv"));
            scanner.nextLine(); // skip header row
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                String id = fields[0];
                String brand = fields[1];
                String model = fields[2];
                String type = fields[3];
                int year = fields[4].equals("N/A") ? 0 : Integer.parseInt(fields[4]);
                int seats = fields[5].equals("N/A") ? 0 : Integer.parseInt(fields[5]);
                String color = fields[6];
                double rentalFee = fields[7].equals("N/A") ? 0 : Double.parseDouble(fields[7]);
                double insuranceFee = fields[8].equals("N/A") ? 0 : Double.parseDouble(fields[8]);
                double serviceFee = fields[9].equals("N/A") ? 0 : Double.parseDouble(fields[9]);
                double discount = fields[10].equals("N/A") ? 0 : Double.parseDouble(fields[10]);

            Car car = new Car(id, brand, model, type, year, seats, color, rentalFee, insuranceFee, serviceFee, discount);
            cars.add(car);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: fleet.csv file not found.");
        }
    }

    /**
     * Searches for all cars in the inventory with a matching brand.
     * @param brand the brand to search for
     * @return a list of cars with a matching brand
     */
    public List<Car> searchByBrand(String brand) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        return result;
    }

    /**
     * Filters the inventory by type of car.
     * @param type the type of car to filter by
     * @return a list of cars with the matching type
     */
    public List<Car> filterByType(String type) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getType().equalsIgnoreCase(type)) {
                result.add(car);
            }
        }
        return result;
    }

    /**
     * Filters the inventory by number of seats.
     * @param numSeats the number of seats to filter by
     * @return a list of cars with the matching number of seats
     */
    public List<Car> filterBySeats(int numSeats) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getSeats() == numSeats) {
                result.add(car);
            }
        }
        return result;
    }  
   

    /**
     * Retrieves a car object from the inventory by its unique ID.
     * @param id the ID of the car to retrieve
     * @return the car object with the matching ID, or null if not found
     */
    public Car getCarById(String CarId) {
        for (Car car : cars) {
            if (car.getId() == CarId) {
                return car;
            }
        }
        return null;
    }

    /**
     * 
     * @return the list of cars from the iventory object and returns it.
    */
    public List<Car> getCars() {
        return cars;
    }
    
}

