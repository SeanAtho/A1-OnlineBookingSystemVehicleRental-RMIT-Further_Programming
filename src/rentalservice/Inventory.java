package rentalservice;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Car> cars;
    private double rentalPrice;
    private double insurancePrice;
    private double serviceFee;
    private double discount;

    public Inventory(ArrayList<Car> cars, double rentalPrice, double insurancePrice, double serviceFee, double discount) {
        this.cars = cars;
        this.rentalPrice = rentalPrice;
        this.insurancePrice = insurancePrice;
        this.serviceFee = serviceFee;
        this.discount = discount;
    }

    public ArrayList<Car> getCars() {
        return cars;
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

    public double calculateRentalFee(int numOfDays) {
        return (this.rentalPrice + this.insurancePrice) * numOfDays * (1 - this.discount) + this.serviceFee;
    }
}
