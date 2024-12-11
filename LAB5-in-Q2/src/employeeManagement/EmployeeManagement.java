package employeeManagement;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;

    // Default Constructor
    public Employee() {
        this.id = 0;
        this.name = "#";
        this.department = "#";
    }

    // Parameterized Constructor
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // toString method to display Employee details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Create new Employee record");
            System.out.println("2. Update name based on ID");
            System.out.println("3. Print All Employees");
            System.out.println("4. Print Department Specific employees");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    Employee emp = new Employee(id, name, department);
                    employees.add(emp);
                    break;
                case 2:
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
                    System.out.println("\nAll Employees:");
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;
                case 4:
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
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

