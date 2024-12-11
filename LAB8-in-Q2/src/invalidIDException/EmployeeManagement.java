package invalidIDException;

import java.util.ArrayList;
import java.util.Scanner;

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

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    // toString Method
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}

// Employee Management Class
public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    try {
                        // Input employee details
                        System.out.print("Enter Employee ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        System.out.print("Enter Employee Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Employee Department: ");
                        String department = scanner.nextLine();

                        // Add employee
                        Employee emp = new Employee(id, name, department);
                        employees.add(emp);
                        System.out.println("Employee added successfully!");

                    } catch (InvalidIDException | InvalidNameException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\nAll Employees:");
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

