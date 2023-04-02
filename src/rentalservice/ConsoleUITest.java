package rentalservice;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class ConsoleUITest {

    private ConsoleUI consoleUI;
    private Inventory inventory;
    private MyCarApp myCarApp;
    private InputStream stdin;

    @Before
    public void setUp() throws Exception {
        inventory = new Inventory();
        myCarApp = new MyCarApp(inventory);
        consoleUI = new ConsoleUI(myCarApp);
    }

    @Test
    public void testReadValidIntInput() {
        stdin = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(stdin);
        int choice = consoleUI.readValidIntInput("Enter a number between 1 and 3", 1, 3);
        assertEquals(2, choice);
    }

    @Test
    public void testreadStringInput() {
        stdin = new ByteArrayInputStream("Toyota\n".getBytes());
        System.setIn(stdin);
        String brand = consoleUI.readStringInput("Enter the car brand");
        assertEquals("Toyota", brand);
    }

    @Test
    public void testReadDateInput() {
        stdin = new ByteArrayInputStream("10/03/2023\n".getBytes());
        System.setIn(stdin);
        LocalDate result = consoleUI.readDateInput("Enter a date");
        assertEquals(LocalDate.of(2022, 12, 31), result);
    }

    @Test
    public void testSearchCarsByBrand() {
        // Assuming the inventory has at least one car of brand "Toyota"
        stdin = new ByteArrayInputStream("Toyota\n".getBytes());
        System.setIn(stdin);
        consoleUI.searchCarsByBrand();
        assertNotNull(inventory.searchByBrand("Toyota"));
    }

    @Test
    public void testBrowseCarsByType() {
        // Assuming the inventory has at least one car of type "Sedan"
        stdin = new ByteArrayInputStream("Sedan\n".getBytes());
        System.setIn(stdin);
        consoleUI.browseCarsByType();
        assertNotNull(inventory.filterByType("Sedan"));
    }

    @Test
    public void testFilterCarsBySeats() {
        // Assuming the inventory has at least one car with 4 seats
        stdin = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(stdin);
        consoleUI.filterCarsBySeats();
        assertNotNull(inventory.filterBySeats(4));
    }

    @Test
    public void testViewCarDetails() {
        // Assuming the inventory has at least one car with ID "C001"
        stdin = new ByteArrayInputStream("C001\n".getBytes());
        System.setIn(stdin);
        consoleUI.viewCarDetails();
        assertNotNull(inventory.getCarById("C001"));
    }

    
}
