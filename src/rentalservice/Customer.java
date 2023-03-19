package rentalservice;
// Represents a customer object with personal details such as name, email, and number of passengers.
public class Customer {
    // Instance variables
    private String firstName;
    private String surName;
    private String email;
    private int numPassengers;

    // Constructor
    public Customer(String firstName, String surName, String email, int numPassengers) {
        this.firstName = firstName;
        this.surName = surName;
        this.email = email;
        this.numPassengers = numPassengers;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }
    
    public String getSurName() {
        return surName;
    }

    public String getEmail() {
        return email;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    // toString method to display customer information
    @Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", surName=" + surName + ", email=" + email + "]";
    }

}
