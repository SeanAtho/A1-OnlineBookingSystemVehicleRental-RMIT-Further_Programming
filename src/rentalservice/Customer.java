package rentalservice;
// The Customer class represents a customer object with personal details such as name, email, and number of passengers.
public class Customer {
    // Instance variables
    private String firstName; // stores the first name of the customer.
    private String surName; // stores the surname of the customer.
    private String email; // stores the email address of the customer.
    private int numPassengers; // stores the number of passengers the customer plans to have.

    // Constructor
    // Initializes a new Customer object with the given firstName, surName, email, and numPassengers values.
    public Customer(String firstName, String surName, String email, int numPassengers) {
        this.firstName = firstName;
        this.surName = surName;
        this.email = email;
        this.numPassengers = numPassengers;
    }

    // Getters
    public String getFirstName() {
        return firstName; // returns the first name of the customer.
    }
    
    public String getSurName() {
        return surName; // returns the surname of the customer.
    }

    public String getEmail() {
        return email; // returns the email address of the customer.
    }

    public int getNumPassengers() {
        return numPassengers; // returns the number of passengers the customer plans to have.
    }

    // toString method to display customer information
    // Overrides the toString() method to display the customer's first name, surname, and email address.
    @Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", surName=" + surName + ", email=" + email + "]";
    }

}
