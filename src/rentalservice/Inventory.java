package rentalservice;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> availableCars;
    private ArrayList<Car> cars;
    private double rentalPrice;
    private double insurancePrice;
    private double serviceFee;
    private double discount;

    public Inventory(ArrayList<Car> cars, double rentalPrice, double insurancePrice, double serviceFee, double discount) {
        this.cars = cars;
        this.availableCars = new HashMap<>();
        for (Car car : cars) {
            this.availableCars.put(car.getVehicleID(), 1);
        }
        this.rentalPrice = rentalPrice;
        this.insurancePrice = insurancePrice;
        this.serviceFee = serviceFee;
        this.discount = discount;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public HashMap<String, Integer> getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(HashMap<String, Integer> availableCars) {
        this.availableCars = availableCars;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isCarAvailable(Car car) {
        return this.availableCars.get(car.getVehicleID()) != null && this.availableCars.get(car.getVehicleID()) > 0;
    }

    public void rentCar(Car car) {
        if (isCarAvailable(car)) {
            int available = this.availableCars.get(car.getVehicleID());
            this.availableCars.put(car.getVehicleID(), available - 1);
        } else {
            throw new IllegalArgumentException("Car is not available for rent.");
        }
    }

    public void returnCar(Car car) {
        int available = this.availableCars.get(car.getVehicleID());
        this.availableCars.put(car.getVehicleID(), available + 1);
    }

    public double calculateRentalFee(int numOfDays) {
        return (this.rentalPrice + this.insurancePrice) * numOfDays * (1 - this.discount) + this.serviceFee;
    }
}
