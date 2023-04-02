package rentalservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
    private Inventory inventory;
    private List<Car> cars;

    @Before
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("1", "Toyota", "Camry", "Sedan", 2021, 5, "Red", 30.0, 10.0, 5.0, 0.1));
        cars.add(new Car("2", "Honda", "Accord", "Sedan", 2022, 5, "Blue", 35.0, 10.0, 5.0, 0.2));
        cars.add(new Car("3", "Toyota", "Highlander", "SUV", 2020, 7, "Black", 50.0, 20.0, 10.0, 0.3));
        inventory = new Inventory();
        inventory.setCars(cars);
    }

    @Test
    public void testSearchByBrand() {
        List<Car> expectedCars = new ArrayList<>();
        expectedCars.add(cars.get(0));
        expectedCars.add(cars.get(2));
        List<Car> result = inventory.searchByBrand("Toyota");
        assertEquals(expectedCars, result);
    }

    @Test
    public void testFilterByType() {
        List<Car> expectedCars = new ArrayList<>();
        expectedCars.add(cars.get(0));
        expectedCars.add(cars.get(1));
        List<Car> result = inventory.filterByType("Sedan");
        assertEquals(expectedCars, result);
    }

    @Test
    public void testFilterBySeats() {
        List<Car> expectedCars = new ArrayList<>();
        expectedCars.add(cars.get(0));
        expectedCars.add(cars.get(1));
        List<Car> result = inventory.filterBySeats(5);
        assertEquals(expectedCars, result);
    }

    @Test
    public void testGetCarById() {
        Car expectedCar = cars.get(1);
        Car result = inventory.getCarById("2");
        assertEquals(expectedCar, result);
    }

    @Test
    public void testGetCarByIdNotFound() {
        Car result = inventory.getCarById("4");
        assertNull(result);
    }
}
