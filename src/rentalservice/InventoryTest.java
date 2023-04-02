package rentalservice;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testSearchByBrand() {
        List<Car> result = inventory.searchByBrand("Toyota");
        assertEquals(3, result.size());
        for (Car car : result) {
            assertEquals("Toyota", car.getBrand());
        }
    }

    @Test
    public void testFilterByType() {
        List<Car> result = inventory.filterByType("Sedan");
        assertEquals(4, result.size());
        for (Car car : result) {
            assertEquals("Sedan", car.getType());
        }
    }

    @Test
    public void testFilterBySeats() {
        List<Car> result = inventory.filterBySeats(4);
        assertEquals(6, result.size());
        for (Car car : result) {
            assertEquals(4, car.getSeats());
        }
    }

    @Test
    public void testGetCarById() {
        Car car = inventory.getCarById("C002");
        assertNotNull(car);
        assertEquals("C002", car.getId());
        assertEquals("Honda", car.getBrand());
        assertEquals("Civic", car.getModel());
    }

    @Test
    public void testGetCars() {
        List<Car> result = inventory.getCars();
        assertNotNull(result);
        assertEquals(10, result.size());
    }
}

