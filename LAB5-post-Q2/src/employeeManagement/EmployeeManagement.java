package employeeManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Display menu options
            System.out.println("\nMenu:");
            System.out.println("1. Create new Employee record");
            System.out.println("2. Update name based on ID");
            System.out.println("3. Print All Employees");
            System.out.println("4. Print Department Specific employees");
            System.out.println("5. Print Employees joined in 2019");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    // Create new employee record
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Date of Joining (YYYY-MM-DD): ");
                    String dateOfJoining = scanner.nextLine();
                    Employee emp = new Employee(id, name, department, dateOfJoining);
                    if (emp.getId() != 0) {  // Check if ID was valid
                        employees.add(emp);
                    }
                    break;

                case 2:
                    // Update employee name based on ID
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    boolean found = false;
                    for (Employee e : employees) {
                        if (e.getId() == updateId) {
                            e.setName(newName);
                            found = true;
                            System.out.println("Employee name updated successfully.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    // Print all employees
                    System.out.println("\nAll Employees:");
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    // Print department-specific employees
                    System.out.print("Enter Department to search for: ");
                    String dept = scanner.nextLine();
                    boolean deptFound = false;
                    System.out.println("\nEmployees in " + dept + " Department:");
                    for (Employee e : employees) {
                        if (e.getDepartment().equalsIgnoreCase(dept)) {
                            System.out.println(e);
                            deptFound = true;
                        }
                    }
                    if (!deptFound) {
                        System.out.println("No employees found in this department.");
                    }
                    break;

                case 5:
                    // Print employees who joined in 2019
                    System.out.println("\nEmployees joined in 2019:");
                    boolean found2019 = false;
                    for (Employee e : employees) {
                        if (e.getDateOfJoining().contains("2019")) {
                            System.out.println(e);
                            found2019 = true;
                        }
                    }
                    if (!found2019) {
                        System.out.println("No employees joined in 2019.");
                    }
                    break;

                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
