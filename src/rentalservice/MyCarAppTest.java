package rentalservice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyCarAppTest {

    private Inventory inventory;
    private MyCarApp app;
    private Car car1;
    private Car car2;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Before
    public void setUp() {
        inventory = new Inventory();
        app = new MyCarApp(inventory);
        car1 = new Car("1", "Toyota", "Camry", "sedan", 2019, 5, "blue", 45.0, 10.0, 5.0, 0.1);
        car2 = new Car("2", "Honda", "Accord", "sedan", 2020, 4, "red", 50.0, 12.0, 6.0, 0.2);        
        List<Car> cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        inventory.setCars(cars);
        customer = new Customer("John", "Doe", "john.doe@example.com", 2);
        startDate = LocalDate.of(2023, 3, 10);
        endDate = LocalDate.of(2023, 3, 12);
    }

    @Test
    public void testStart() {
        MyCarApp app = new MyCarApp(inventory);
        app.start();
        assertEquals("Welcome to MyCarApp!\n", outContent.toString());
    }

    @Test
    public void testSearchByBrand() {
        assertEquals("Searching for cars by brand: Toyota\n" + car1.toString() + "\n", app.searchByBrand("Toyota"));
        assertEquals("Searching for cars by brand: Honda\n" + car2.toString() + "\n", app.searchByBrand("Honda"));
        assertEquals("Searching for cars by brand: Ford\n" + "No cars found with the brand: Ford\n", app.searchByBrand("Ford"));
    }

    @Test
    public void testBrowseByType() {
        assertEquals("Browsing cars by type: sedan\n" + car1.toString() + "\n" + car2.toString() + "\n", app.browseByType("sedan"));
        assertEquals("Browsing cars by type: SUV\n" + "No cars found with the type: SUV\n", app.browseByType("SUV"));
    }

    @Test
    public void testFilterBySeats() {
        assertEquals("Filtering cars by number of seats: 5\n" + car1.toString() + "\n", app.filterBySeats(5));
        assertEquals("Filtering cars by number of seats: 3\n" + "No cars found with the type: 3\n", app.filterBySeats(3));
    }

    @Test
    public void testViewCarDetails() {
        assertEquals(car1.toString() + "\n", app.viewCarDetails("1"));
        assertEquals("Car not found\n", app.viewCarDetails("3"));
    }

    @Test
    public void testBookRental() {
        Rental rental = new Rental(car1, customer, startDate, endDate);
        app.bookRental("1", customer, startDate, endDate);
        assertEquals(rental, inventory.getRentalByCarId("1"));
    }
}
