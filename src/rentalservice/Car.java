package rentalservice;

public class Car {
    // Instance variables
    private String vehicleID;           // unique ID of the car
    private String brand;               // brand of the car
    private String model;               // model of the car
    private String type;                // type of the car (e.g. sedan, SUV, sports car)
    private int yearOfManufacture;      // year of manufacture of the car
    private int numOfSeats;             // number of seats in the car
    private String color;               // color of the car

    // Constructor
    public Car(String vehicleID, String brand, String model, String type, int yearOfManufacture, int numOfSeats, String color) {
        // Initialize instance variables with constructor parameters
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
        this.numOfSeats = numOfSeats;
        this.color = color;
    }

    // Getters and setters for instance variables
    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Override the toString() method to provide a string representation of a Car object
    @Override
    public String toString() {
        return "Car{" +
                "vehicleID='" + vehicleID + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", numOfSeats=" + numOfSeats +
                ", color='" + color + '\'' +
                '}';
    }
}
