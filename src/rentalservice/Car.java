package rentalservice;

public class Car {
    // Fields to represent the characteristics of a car
    private String carID;
    private String brand;
    private String model;
    private String vehicleType;
    private int numOfPassengers;
    private int yearOfManufacture;
    private String color;

    // Constructor to create a Car object with the given characteristics
    public Car(String carID, String brand, String model, String vehicleType, int numOfPassengers, int yearOfManufacture, String color) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.vehicleType = vehicleType;
        this.numOfPassengers = numOfPassengers;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
    }

    // Getter and setter methods for each field
    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
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
                "carID='" + carID + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", numOfPassengers=" + numOfPassengers +
                ", yearOfManufacture=" + yearOfManufacture +
                ", color='" + color + '\'' +
                '}';
    }
}
