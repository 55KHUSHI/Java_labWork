package employeeFileReader;

import java.io.*;
import java.util.ArrayList;

// User-defined exception for invalid ID
class InvalidIDException extends Exception {
    public InvalidIDException(String message) {
        super(message);
    }
}

// User-defined exception for invalid Name
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

// Employee Class
class Employee {
    private int id;
    private String name;
    private String department;

    // Constructor
    public Employee(int id, String name, String department) throws InvalidIDException, InvalidNameException {
        if (id < 0) {
            throw new InvalidIDException("ID cannot be negative.");
        }
        if (!isValidName(name)) {
            throw new InvalidNameException("Name cannot contain special characters or digits.");
        }
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Method to validate name
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z\\s]+");
    }

    // toString Method
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}

// Employee Management Class
public class EmployeeFileReader {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        BufferedReader reader = null;

        try {
            // Reading data from the file
            File file = new File("employee_data.txt");  // Replace with your file path
            reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    // Split the line into employee details
                    String[] details = line.split(",");
                    int id = Integer.parseInt(details[0].trim());
                    String name = details[1].trim();
                    String department = details[2].trim();

                    // Add employee to the list
                    Employee emp = new Employee(id, name, department);
                    employees.add(emp);

                } catch (InvalidIDException | InvalidNameException | NumberFormatException e) {
                    System.out.println("Invalid data in file: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();  // Ensure the file is closed
                }
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }

        // Display valid employees
        System.out.println("\nValid Employee Records:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

