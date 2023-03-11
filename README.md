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
1. Car.java: Represents a single car object with properties such as brand, model, type of vehicle, year of manufacture, number of seats, and color.
2. Inventory.java: Maintains a list of all the cars in the fleet, allowing for operations such as searching and filtering based on various criteria.
3. Rental.java: Represents a rental object that contains details such as the car being rented, rental duration, rental fee, insurance fee, and any discounts applied.
4. Customer.java: Represents a customer object with personal details such as name, email, and number of passengers.
5. ConsoleUI.java: Handles the user interface and allows users to interact with the program through the console.
6. Main.java: Entry Point for MyCar Application.
7. MyCarApp.java: Acts as the controller, orchestrating interactions between the model (Inventory, Rental, Customer) and view (ConsoleUI) classes, and implementing program logic such as searching, filtering, and rental booking.
