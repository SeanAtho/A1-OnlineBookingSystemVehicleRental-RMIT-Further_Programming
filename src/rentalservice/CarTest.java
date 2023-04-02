package rentalservice;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void testCarConstructor() {
        String id = "CAR001";
        String brand = "Toyota";
        String model = "Corolla";
        String type = "Sedan";
        int year = 2020;
        int seats = 5;
        String color = "Red";
        double rentalFee = 50.00;
        double insuranceFee = 10.00;
        double serviceFee = 5.00;
        double discount = 5.00;

        Car car = new Car(id, brand, model, type, year, seats, color, rentalFee, insuranceFee, serviceFee, discount);

        Assert.assertEquals(id, car.getId());
        Assert.assertEquals(brand, car.getBrand());
        Assert.assertEquals(model, car.getModel());
        Assert.assertEquals(type, car.getType());
        Assert.assertEquals(year, car.getYear());
        Assert.assertEquals(seats, car.getSeats());
        Assert.assertEquals(color, car.getColor());
        Assert.assertEquals(rentalFee, car.getRentalFee(), 0.001);
        Assert.assertEquals(insuranceFee, car.getInsuranceFee(), 0.001);
        Assert.assertEquals(serviceFee, car.getServiceFee(), 0.001);
        Assert.assertEquals(discount, car.getDiscount(), 0.001);
    }

    @Test
    public void testCarToString() {
        String id = "CAR001";
        String brand = "Toyota";
        String model = "Corolla";
        String type = "Sedan";
        int year = 2020;
        int seats = 5;
        String color = "Red";
        double rentalFee = 50.00;
        double insuranceFee = 10.00;
        double serviceFee = 5.00;
        double discount = 5.00;

        Car car = new Car(id, brand, model, type, year, seats, color, rentalFee, insuranceFee, serviceFee, discount);
        String expected = "---------------------------------------------\n" +
                          "Car ID: " + id + "\n" +
                          "Brand: " + brand + "\n" +
                          "Model: " + model + "\n" +
                          "Type: " + type + "\n" +
                          "Year: " + year + "\n" +
                          "Seats: " + seats + "\n" +
                          "Color: " + color + "\n" +
                          "Rental Fee: $" + rentalFee + "/day" + "\n" +
                          "Insurance Fee: $" + insuranceFee + "/day" + "\n" +
                          "Service Fee: $" + serviceFee + "/day" + "\n" +
                          "Discount: " + discount + "%" + "\n" +
                          "---------------------------------------------";

        Assert.assertEquals(expected, car.toString());
    }
}
