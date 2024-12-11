package employeeManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class Employee {
    private int id;
    private String name;
    private String department;
    private String dateOfJoining;

    // Static list to track all employee IDs (ensures unique IDs)
    private static ArrayList<Integer> employeeIds = new ArrayList<>();

    // Default Constructor
    public Employee() {
        this.id = 0;
        this.name = "#";
        this.department = "#";
        this.dateOfJoining = "Unknown";
    }

    // Parameterized Constructor
    public Employee(int id, String name, String department, String dateOfJoining) {
        if (isValidId(id) && isValidDate(dateOfJoining) && isValidName(name) && isValidDepartment(department)) {
            this.id = id;
            employeeIds.add(id);  // Add ID to the list of existing IDs
            this.name = name;
            this.department = department;
            this.dateOfJoining = dateOfJoining;
        } else {
            this.id = 0;  // Invalid ID, Name, or Date; don't consider this entry
            this.dateOfJoining = "Invalid Date";
            this.name = "Invalid Name";
            this.department = "Invalid Department";
        }
    }

    // ID Validation Method
    public boolean isValidId(int id) {
        if (id > 0 && !employeeIds.contains(id)) {  // Check if ID already exists
            return true;
        } else {
            System.out.println("Invalid ID: ID should be a positive number and unique.");
            return false;
        }
    }

    // Date of Joining Validation Method
    public boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);  // Disallow lenient date parsing

        try {
            dateFormat.parse(date);  // Try to parse the given date
            return true;  // Date is valid
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return false;  // Date is invalid
        }
    }

    // Name Validation Method
    public boolean isValidName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            return true;
        } else {
            System.out.println("Invalid Name: Name cannot be empty.");
            return false;
        }
    }

    // Department Validation Method
    public boolean isValidDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            return true;
        } else {
            System.out.println("Invalid Department: Department cannot be empty.");
            return false;
        }
    }

    // Getter and Setter methods for ID with validation
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (isValidId(id)) {
            this.id = id;
            employeeIds.add(id);  // Add ID to the list of existing IDs
        } else {
            System.out.println("ID not set due to validation failure.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (isValidDepartment(department)) {
            this.department = department;
        }
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        if (isValidDate(dateOfJoining)) {
            this.dateOfJoining = dateOfJoining;
        } else {
            System.out.println("Invalid date of joining. Please use YYYY-MM-DD.");
        }
    }

    // toString method to display Employee details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Date of Joining: " + dateOfJoining;
    }
}
