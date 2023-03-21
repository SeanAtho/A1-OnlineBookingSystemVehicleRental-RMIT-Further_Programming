// The Rental class which represents a rental object that contains details such as the car being rented, rental duration, rental fee, insurance fee, and any discounts applied.
package rentalservice;
import java.time.LocalDate;

public class Rental {
    // Instance variables
    private Car car;
    private Customer customer;
    private double rentalFee;
    private double insuranceFee;
    private LocalDate startDate;
    private LocalDate endDate;

    // Constructor
    public Rental(Car car, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        // Calculate rental fee and insurance fee based on car type and rental duration
        this.rentalFee = calculateRentalFee();
        this.insuranceFee = calculateInsuranceFee();
    }

    // Getters
    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public double getInsuranceFee() {
        return insuranceFee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    // Calculate rental fee based on car type and rental duration
    private double calculateRentalFee() {
        int rentalDuration = endDate.getDayOfYear() - startDate.getDayOfYear();
        double baseRentalFee = car.getRentalFee();
        // Apply discounts for long-term rentals
        if (rentalDuration >= 7) {
            return baseRentalFee * rentalDuration * (1 - car.getDiscount());
        } else {
            return baseRentalFee * rentalDuration;
        }
    }

    // Calculate insurance fee based on car type and rental duration
    private double calculateInsuranceFee() {
        int rentalDuration = endDate.getDayOfYear() - startDate.getDayOfYear();
        double baseInsuranceFee = car.getInsuranceFee();
        return baseInsuranceFee * rentalDuration;
    }
}

