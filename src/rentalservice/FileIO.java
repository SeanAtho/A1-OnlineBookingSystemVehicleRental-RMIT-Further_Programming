package rentalservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    // This method reads a csv file and returns a list of vehicle objects
    public static List<Vehicle> readCSV(String fileName) throws FileNotFoundException {
        List<Vehicle> vehicleList = new ArrayList<>();

        File file = new File(fileName);

        // Use try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(file)) {
            // Skip the header row
            scanner.nextLine();

            // Read each row of the csv file and create a Vehicle object from it
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");

                // Create a new Vehicle object from the data in the csv file
                Vehicle vehicle = new Vehicle(
                        tokens[0],
                        tokens[1],
                        tokens[2],
                        tokens[3],
                        Integer.parseInt(tokens[4]),
                        Integer.parseInt(tokens[5]),
                        tokens[6],
                        Double.parseDouble(tokens[7]),
                        Double.parseDouble(tokens[8]),
                        Double.parseDouble(tokens[9]),
                        Double.parseDouble(tokens[10])
                );

                // Add the new Vehicle object to the list
                vehicleList.add(vehicle);
            }
        }

        return vehicleList;
    }
}

