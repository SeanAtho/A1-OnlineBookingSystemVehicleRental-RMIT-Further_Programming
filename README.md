# Assignment 1: Online Booking System for Vehicle Rentals 
## Algorithm
1.	Read the CSV file and store the vehicle data into an appropriate data structure, such as an ArrayList of objects.
2.	Display the main menu with the following options: a. Search by Brand b. Browse by vehicle type c. Filter by number of passengers d. Exit
3.	If the user selects "Search by Brand," prompt the user to enter the brand name and display all the vehicles matching the brand name.
4.	If the user selects "Browse by vehicle type," display a list of all vehicle types and prompt the user to select a vehicle type. Then display all the vehicles matching the selected type.
5.	If the user selects "Filter by number of passengers," prompt the user to enter the number of passengers and display all the vehicles that can carry at least that many passengers.
6.	Once the user selects a vehicle, prompt the user to provide pick-up and return dates.
7.	Calculate the total rental price without discount for the period of rental with price breakdown (i.e., rental per day * number of days), total rental price with discount for the period of rental with price breakdown (i.e., discounted price per day * number of days), total insurance with fee breakdown (i.e., insurance per day * number of days), total service fee, and the final total payment using the formula provided in the problem statement.
8.	Print the information of the selected vehicle, including the ID of the vehicle, brand, model, type of vehicle, year of manufacture, no. of seats, color, and the calculated rental, insurance, and service fees.
9.	Prompt the user to reserve the vehicle or go back to the main menu.
10.	If the user chooses to reserve, prompt the user to provide personal information, including the given name, surname, email address, and number of passengers for the rental.
11.	Prompt the user to confirm and pay.
12.	Print the reservation details and exit the program.


## Overview of what each class in the current design does:
The current classes in the provided program are:

    Car - Represents a single car object with properties such as brand, model, type of vehicle, year of manufacture, number of seats, and color.
    Inventory - Maintains a list of all the cars in the fleet, allowing for operations such as searching and filtering based on various criteria.
    Rental - Represents a rental object that contains details such as the car being rented, rental duration, rental fee, insurance fee, and any discounts applied.
    Customer - Represents a customer object with personal details such as name, email, and number of passengers.
    ConsoleUI - Handles the user interface and allows users to interact with the program through the console.
    Main - Acts as the entry point of the program.
    MyCarApp - Acts as the controller, orchestrating interactions between the model (Inventory, Rental, Customer) and view (ConsoleUI) classes, and implementing program logic such as searching, filtering, and rental booking.



    In this diagram, the Car class represents a single car object with its properties. The Inventory class maintains a list of all the cars in the fleet, allowing for operations such as searching and filtering based on various criteria. The Rental class represents a rental object that contains details such as the car being rented, rental duration, rental fee, insurance fee, and any discounts applied. The Customer class represents a customer object with personal details such as name, email, and number of passengers. The ConsoleUI class handles the user interface and

    +---------------------+               +-------------------+                  +-------------------+
|       Car           |               |     Inventory     |                  |      Rental       |
+---------------------+               +-------------------+                  +-------------------+
| -id: int            |               | -cars: List<Car>  |                  | -car: Car         |
| -brand: String      |               |                   |                  | -duration: int    |
| -model: String      |               |                   |                  | -rentalFee: float |
| -type: String       |               |                   |                  | -insuranceFee: float |
| -year: int          |               |                   |                  | -discount: float  |
| -numSeats: int      |               |                   |                  |                   |
| -color: String      |               |                   |                  |                   |
| -rentalPrice: float |               |                   |                  |                   |
| -insurancePrice: float|             |                   |                  |                   |
+---------------------+               +-------------------+                  +-------------------+
| +Car()              |               | +Inventory()      |                  | +Rental()         |
| +getId(): int       |               | +addCar(Car): void|                  | +calculateFee(): void |
| +getBrand(): String |               | +removeCar(Car): void|                | +getDuration(): int |
| +getModel(): String |               | +searchCarsByBrand(String): List<Car>| +setDuration(int): void |
| +getType(): String  |               | +filterCarsByType(String): List<Car>| +getRentalFee(): float |
| +getYear(): int     |               | +filterCarsBySeats(int): List<Car>| +getInsuranceFee(): float |
| +getNumSeats(): int |               | +getAvailableCars(): List<Car>| +getDiscount(): float |
| +getColor(): String |               |                   |                  |                   |
| +getRentalPrice(): float|           |                   |                  |                   |
| +getInsurancePrice(): float|        |                   |                  |                   |
+---------------------+               +-------------------+                  +-------------------+
             |
             |
             |
+---------------------+
|       Customer      |
+---------------------+
| -id: int            |
| -name: String       |
| -email: String      |
| -numPassengers: int |
+---------------------+
| +Customer()         |
| +getId(): int       |
| +getName(): String  |
| +getEmail(): String |
| +getNumPassengers(): int |
+---------------------+
               |
               |
               |
+---------------------+
|      ConsoleUI      |
+---------------------+
| +run(): void        |
+---------------------+
               |
               |
               |
+---------------------+
|        Main         |
+---------------------+
| +main(args: String[]): void |
+---------------------+
