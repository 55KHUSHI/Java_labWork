package studentModified;

import java.util.ArrayList;

public class Student {
    private double id;
    private String name;
    private char gender;
    private String branch;

    // Static list to track all student IDs
    private static ArrayList<Double> studentIds = new ArrayList<>();

    // Setter for ID with validation
    public boolean setId(int id) {
        // Check if the ID already exists
        if (studentIds.contains((double) id)) {
            System.out.println("ID already exists. Please provide a unique 9-digit ID.\n");
            return false;
        } else if (id >= 100000000 && id <= 999999999) {
            this.id = id;
            studentIds.add((double) id);  // Add ID to the list of existing IDs
            return true;
        } else {
            System.out.println("ID must be a 9-digit number.\n");
            return false;
        }
    }

    public double getId() {
        return this.id;
    }

    // Setter for Name with validation
    public void setName(String name) {
        if (name.matches("[a-zA-Z\\s]+")) {
            this.name = name;
        } else {
            System.out.println("Name must not contain special characters or digits.");
            this.name = "Unknown"; // Assigning a default value
        }
    }

    public String getName() {
        return this.name;
    }

    // Setter for Gender with validation
    public void setGender(char gender) {
        if (gender == 'M' || gender == 'm' || gender == 'f' || gender == 'F') {
            this.gender = gender;
        } else {
            System.out.println("Gender must be either M (Male) or F (Female).");
        }
    }

    public char getGender() {
        return this.gender;
    }

    // Setter for Branch with validation
    public void setBranch(String branch) {
        if (branch.equals("ECE") || branch.equals("CSE") || branch.equals("ME") ||
            branch.equals("ECSE") || branch.equals("CE") || branch.equals("BT") || branch.equals("EEE")) {
            this.branch = branch;
        } else {
            System.out.println("Branch must be one of the following: ECE, CSE, ME, ECSE, CE, BT, EEE.");
        }
    }

    public String getBranch() {
        return this.branch;
    }

    // toString method
    @Override
    public String toString() {
        return "ID: " + String.format("%.0f", getId()) + "\n" +
               "Name: " + getName() + "\n" +
               "Gender: " + getGender() + "\n" +
               "Branch: " + getBranch() + "\n";
    }
}
