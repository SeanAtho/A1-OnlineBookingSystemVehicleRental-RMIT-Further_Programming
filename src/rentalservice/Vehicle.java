package rentalservice;

public class Vehicle {
    private String id;                  // unique identifier for the vehicle
    private String brand;               // brand of the vehicle
    private String model;               // model of the vehicle
    private String type;                // type of the vehicle (e.g., sedan, SUV, truck)
    private int year;                   // year the vehicle was manufactured
    private int numSeats;               // number of seats in the vehicle
    private String color;               // color of the vehicle
    private double rentalPrice;         // rental price per day for the vehicle
    private double insurancePrice;      // insurance price per day for the vehicle
    private double servicePrice;        // service fee for renting the vehicle
    private double discount;            // discount percentage for the vehicle

    /**
     * Constructor for the Vehicle class.
     * Initializes all instance variables of the class.
     */
    public Vehicle(String id, String brand, String model, String type, int year, int numSeats, String color,
            double rentalPrice, double insurancePrice, double servicePrice, double discount) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.year = year;
        this.numSeats = numSeats;
        this.color = color;
        this.rentalPrice = rentalPrice;
        this.insurancePrice = insurancePrice;
        this.servicePrice = servicePrice;
        this.discount = discount;
    }

    /**
     * Getter method for the id instance variable.
     * @return id of the vehicle
     */
    public String getId() {
        return id;
    }

    /**
     * Getter method for the brand instance variable.
     * @return brand of the vehicle
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Getter method for the model instance variable.
     * @return model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Getter method for the type instance variable.
     * @return type of the vehicle
     */
    public String getType() {
        return type;
    }

    /**
     * Getter method for the year instance variable.
     * @return year the vehicle was manufactured
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter method for the numSeats instance variable.
     * @return number of seats in the vehicle
     */
    public int getNumSeats() {
        return numSeats;
    }

    /**
     * Getter method for the color instance variable.
     * @return color of the vehicle
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter method for the rentalPrice instance variable.
     * @return rental price per day for the vehicle
     */
    public double getRentalPrice() {
        return rentalPrice;
    }

    /**
     * Getter method for the insurancePrice instance variable.
     * @return insurance price per day for the vehicle
     */
    public double getInsurancePrice() {
        return insurancePrice;
    }

    /**
     * Getter method for the servicePrice instance variable.
     * @return service fee for renting the vehicle
     */
    public double getServicePrice() {
        return servicePrice;
    }

    /**
     * Getter method for the discount instance variable.
     * @return discount percentage for the vehicle
     */
    public double getDiscount() {
        return discount;
    }
}
