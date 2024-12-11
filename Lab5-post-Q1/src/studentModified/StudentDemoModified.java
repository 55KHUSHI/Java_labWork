package studentModified;

import java.util.Scanner;
import java.util.ArrayList;

public class StudentDemoModified {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> studentList = new ArrayList<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a new student");
            System.out.println("2. Print details of all students");
            System.out.println("3. Print details based on ID");
            System.out.println("4. Modify student name based on ID");
            System.out.println("5. Remove a student based on ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1: {
                    // Create new student
                    if (studentList.size() < 10) {
                        Student student = new Student();
                        boolean valid = false;
                        while (!valid) {
                            System.out.println("Enter student ID (9-digit number): ");
                            int id = sc.nextInt();
                            valid = student.setId(id);
                        }
                        System.out.println("Enter student name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        student.setName(name);
                        System.out.println("Enter student gender (M/F): ");
                        char gender = sc.nextLine().charAt(0);
                        student.setGender(gender);
                        System.out.println("Enter student branch (ECE, CSE, ME, ECSE, CE, BT, EEE.): ");
                        String branch = sc.nextLine();
                        student.setBranch(branch);
                        studentList.add(student);
                    } else {
                        System.out.println("Cannot add more students. Maximum limit reached.");
                    }
                    break;
                }
                case 2: {
                    // Print all students
                    System.out.println("\nAll Students:");
                    for (Student student : studentList) {
                        System.out.println(student);
                    }
                    break;
                }
                case 3: {
                    // Print details based on ID
                    System.out.print("Enter student ID to search: ");
                    double searchId = sc.nextDouble();
                    boolean found = false;
                    for (Student student : studentList) {
                        if (student.getId() == searchId) {
                            System.out.println(student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                }
                case 4: {
                    // Modify student name based on ID
                    System.out.print("Enter student ID to modify name: ");
                    double modifyId = sc.nextDouble();
                    sc.nextLine();  // Consume newline
                    boolean modified = false;
                    for (Student student : studentList) {
                        if (student.getId() == modifyId) {
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();
                            student.setName(newName);
                            modified = true;
                            System.out.println("Name updated successfully.");
                            break;
                        }
                    }
                    if (!modified) {
                        System.out.println("Student not found.");
                    }
                    break;
                }
                case 5: {
                    // Remove a student based on ID
                    System.out.print("Enter student ID to remove: ");
                    double removeId = sc.nextDouble();
                    boolean removed = false;
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getId() == removeId) {
                            studentList.remove(i);
                            removed = true;
                            System.out.println("Student removed successfully.");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Student not found.");
                    }
                    break;
                }
                case 6: {
                    // Exit the program
                    exit = true;
                    break;
                }
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }
}


