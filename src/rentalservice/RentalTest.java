package rentalservice;
import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;

public class RentalTest {
    
    @Test
    public void testCalculateRentalFee() {
        Car car = new Car("C001", "Toyota", "Yaris", "Sedan", 2012, 4, "Blue", 50.0, 15, 10.0, 10.0);
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", 4);
        LocalDate startDate = LocalDate.of(2023, 3, 1);
        LocalDate endDate = LocalDate.of(2023, 3, 5);
        Rental rental = new Rental(car, customer, startDate, endDate);
        assertEquals(200.0, rental.getRentalFee(), 0.01);
    }
    
    @Test
    public void testCalculateInsuranceFee() {
        Car car = new Car("C002", "Toyota", "Corolla", "Hatch", 2020, 4, "White", 45.0, 20.0, 10.0, 10.0);
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", 3);
        LocalDate startDate = LocalDate.of(2023, 3, 1);
        LocalDate endDate = LocalDate.of(2023, 3, 5);
        Rental rental = new Rental(car, customer, startDate, endDate);
        assertEquals(80.0, rental.getInsuranceFee(), 0.01);
    }
    
}
