package rentalservice;

public class Car {
    private String id;
    private String brand;
    private String model;
    private String type;
    private int year;
    private int seats;
    private String color;
    private double rentalPrice;
    private double insurancePrice;
    private double serviceFee;
    private double discount;

    // Constructor for Car object
    public Car(String id, String brand, String model, String type, int year, int seats, String color, double rentalPrice, double insurancePrice, double serviceFee, double discount) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.year = year;
        this.seats = seats;
        this.color = color;
        this.rentalPrice = rentalPrice;
        this.insurancePrice = insurancePrice;
        this.serviceFee = serviceFee;
        this.discount = discount;
    }

    // Getter methods
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

    public double getRentalPrice() {
        return rentalPrice;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public double getDiscount() {
        return discount;
    }

    // Setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // toString method to return Car object details as a string
    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", seats=" + seats +
                ", color='" + color + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", insurancePrice=" + insurancePrice +
                ", serviceFee=" + serviceFee +
                ", discount=" + discount +
                '}';
    }
}
