package sum_fileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SumFromFile {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try {
            // Step 1: Read integers from input file
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);
            
            // Assume the file contains two integers
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            scanner.close();

            // Calculate the sum
            int sum = num1 + num2;

            // Step 2: Write the sum to the output file
            FileWriter writer = new FileWriter(outputFileName);
            writer.write("The sum of " + num1 + " and " + num2 + " is: " + sum);
            writer.close();

            System.out.println("Sum has been written to " + outputFileName);

        } catch (IOException e) {
            System.out.println("An error occurred while handling files: " + e.getMessage());
        }
    }
}
