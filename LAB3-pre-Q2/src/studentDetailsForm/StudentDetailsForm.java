package studentDetailsForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDetailsForm extends JFrame {
    private JTextField idField, nameField, ageField, genderField;
    private JButton submitButton, clearButton;
    private JTextArea outputArea;

    // Constructor to set up the GUI
    public StudentDetailsForm() {
        // Set the frame properties
    	setVisible(true);
        setTitle("Student Details Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create input fields and labels
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Student Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Student Gender (M/F):"));
        genderField = new JTextField();
        inputPanel.add(genderField);

        // Add the input panel to the frame
        add(inputPanel, BorderLayout.NORTH);

        // Create buttons
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Create output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createTitledBorder("Output"));
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // Add action listeners
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClear();
            }
        });
    }

    // Handle the Submit button action
    private void handleSubmit() {
        try {
            String id = idField.getText();
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText().toUpperCase();

            if (!gender.equals("M") && !gender.equals("F")) {
                throw new IllegalArgumentException("Gender must be M or F.");
            }

            // Display the student details in the output area
            outputArea.setText("Student Details:\n");
            outputArea.append("ID: " + id + "\n");
            outputArea.append("Name: " + name + "\n");
            outputArea.append("Age: " + age + "\n");
            outputArea.append("Gender: " + gender + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid age. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Handle the Clear button action
    private void handleClear() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        genderField.setText("");
        outputArea.setText("");
    }

    // Main method to run the program
    public static void main(String[] args) {
    	StudentDetailsForm f = new StudentDetailsForm();
    }
}

