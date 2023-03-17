package rentalservice;
/**
 * Represents a single car object with properties such as brand, model, type of vehicle, year of manufacture,
 * number of seats, and color.
 */
public class Car {
    
    // Properties of the Car class
    private String id;
    private String brand;
    private String model;
    private String type;
    private int year;
    private int seats;
    private String color;
    private double rentalFee;
    private double insuranceFee;
    private double serviceFee;
    private double discount;
    private boolean available;
    
    /**
     * Constructor for the Car class.
     */
    public Car(String id, String brand, String model, String type, int year, int seats, String color, double rentalFee,
               double insuranceFee, double serviceFee, double discount) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.year = year;
        this.seats = seats;
        this.color = color;
        this.rentalFee = rentalFee;
        this.insuranceFee = insuranceFee;
        this.serviceFee = serviceFee;
        this.discount = discount;
    }
    
    // Getters for the properties of the Car class

    public String getId() {
        return id;
    }
    
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public double getInsuranceFee() {
        return insuranceFee;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public double getDiscount() {
        return discount;
    }
    
    
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Returns a string representation of the Car object.
     */
    @Override
    public String toString() {
        return "Car ID: " + this.id + "\nBrand: " + this.brand + "\nModel: " + this.model + "\nType: " + this.type + 
               "\nYear: " + this.year + "\nSeats: " + this.seats + "\nColor: " + this.color + 
               "\nRental Fee: $" + this.rentalFee + "/day" + "\nInsurance Fee: $" + this.insuranceFee + "/day" + 
               "\nService Fee: $" + this.serviceFee + "/day" + "\nDiscount: " + this.discount + "%";
    }
    
}

