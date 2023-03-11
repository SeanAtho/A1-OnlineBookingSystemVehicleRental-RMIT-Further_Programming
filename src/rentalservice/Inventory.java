package rentalservice;

import java.util.ArrayList;
import java.util.List;

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
    public Car getCarById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }
}

