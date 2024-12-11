package studentData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CombineStudentData {
    public static void main(String[] args) {
        String namesFile = "Names.txt";      // File containing ID and student names
        String addressFile = "Address.txt";  // File containing ID and addresses

        try {
            // Read data from Names.txt
            Scanner namesScanner = new Scanner(new File(namesFile));
            // Read data from Address.txt
            Scanner addressScanner = new Scanner(new File(addressFile));

            System.out.println("Combined Student Details:");
            System.out.println("ID: Name: Address:");

            // Process both files line by line
            while (namesScanner.hasNextLine() && addressScanner.hasNextLine()) {
                String namesLine = namesScanner.nextLine();
                String addressLine = addressScanner.nextLine();

                // Split lines into parts (Assume ID is the first column in both files)
                String[] namesParts = namesLine.split("\\s+", 2);   // Split by whitespace
                String[] addressParts = addressLine.split("\\s+", 2);

                // Extract and combine data
                String id = namesParts[0];
                String name = namesParts[1];
                String address = addressParts[1];

                // Print combined details
                System.out.println(id + ": " + name + ": " + address);
            }

            // Close scanners
            namesScanner.close();
            addressScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: One or more files not found. " + e.getMessage());
        }
    }
}



