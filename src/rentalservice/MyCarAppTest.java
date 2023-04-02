package rentalservice;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyCarAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private MyCarApp app;

    private Car car1;
    private Car car2;
    private Car car3;

    @Before
    public void setUp() {
        app = new MyCarApp(null);

        car1 = new Car("C001", "Toyota", "Yaris", "Sedan", 2012, 4, "Blue", 50.0, 15.0, 10.0, 10.0);
        car2 = new Car("C004", "Audi", "A3", "Sedan", 2015, 4, "Red", 65.0, 10.0, 20.0, 10.0);
        car3 = new Car("C003", "Toyota", "Kluger", "SUV", 2019, 7, "Grey", 70.0, 20.0, 20.0, 10.);
        List<Car> cars = app.getInventory().getCars();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

   


    @Test
    public void testSearchByBrand() {
        app.searchByBrand("Toyota");
        assertEquals("Searching for cars by brand: Toyota\n" + car1.toString() + "\n" + car3.toString() + "\n", outContent.toString());

        outContent.reset();

        app.searchByBrand("Honda");
        assertEquals("Searching for cars by brand: Honda\n" + car2.toString() + "\n", outContent.toString());

        outContent.reset();

        app.searchByBrand("Ford");
        assertEquals("Searching for cars by brand: Ford\n" + "No cars found with the brand: Ford\n", outContent.toString());
    }

    @Test
    public void testBrowseByType() {
        app.browseByType("Sedan");
        assertEquals("Browsing cars by type: Sedan\n" + car1.toString() + "\n", outContent.toString());

        outContent.reset();

        app.browseByType("Coupe");
        assertEquals("Browsing cars by type: Coupe\n" + car2.toString() + "\n", outContent.toString());

        outContent.reset();

        app.browseByType("SUV");
        assertEquals("Browsing cars by type: SUV\n" + car3.toString() + "\n", outContent.toString());

        outContent.reset();

        app.browseByType("Truck");
        assertEquals("Browsing cars by type: Truck\n" + "No cars found with the type: Truck\n", outContent.toString());
    }

    @Test
    public void testFilterBySeats() {
        app.filterBySeats(4);
        assertEquals("Filtering cars by number of seats: 4\n" + car1.toString() + "\n" + car2.toString() + "\n" + car3.toString() + "\n", outContent.toString());

        outContent.reset();

        app.filterBySeats(7);
        assertEquals("Filtering cars by number of seats: 8\n" + "No cars found with 8 seats\n", outContent.toString());
    }

    @Test
public void testViewCarDetails() {
    app.viewCarDetails("C001");
    assertEquals(car1.toString(), outContent.toString());

    outContent.reset();

    app.viewCarDetails("2");
    assertEquals(car2.toString(), outContent.toString());

    outContent.reset();

    app.viewCarDetails("3");
    assertEquals(car3.toString(), outContent.toString());

    outContent.reset();

    app.viewCarDetails("4");
    assertEquals("No car found with ID: 4\n", outContent.toString());
}

    @Test
    public void testBookRental() {
        // Valid booking
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", 4);
        LocalDate startDate = LocalDate.of(2023, 3, 15);
        LocalDate endDate = LocalDate.of(2023, 3, 20);
        
        // Redirect standard output to a ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Call the method to book the rental
        app.bookRental("C001", customer, startDate, endDate);
        
        // Get the captured output and check if it's correct
        String expectedOutput = "Rental Details:\n" +
            "Car: " + car1.toString() + "\n" +
            "Customer: " + customer.toString() + "\n" +
            "Start Date: " + startDate.toString() + "\n" +
            "End Date: " + endDate.toString() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }





}