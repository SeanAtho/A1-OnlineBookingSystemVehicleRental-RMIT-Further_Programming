package rentalservice;
// Represents a customer object with personal details such as name, email, and number of passengers.
public class Customer {
    // Instance variables
    private String name;
    private String email;
    private int numPassengers;

    // Constructor
    public Customer(String name, String email, int numPassengers) {
        this.name = name;
        this.email = email;
        this.numPassengers = numPassengers;
    }

    // Getters
    public String getName() {
        return name;
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
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", numPassengers=" + numPassengers +
                '}';
    }
}
