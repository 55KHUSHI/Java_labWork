package studentRegistrationForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationForm extends JFrame {
    private JTextField idField, nameField;
    private JRadioButton maleButton, femaleButton;
    private JComboBox<String> departmentComboBox;
    private JButton submitButton, resetButton;

    // Constructor to set up the GUI
    public StudentRegistrationForm() {
    	setVisible(true);    	
    	setTitle("Student Registration Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ID Field
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        // Name Field
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        // Gender Buttons
        inputPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        inputPanel.add(genderPanel);

        // Department Dropdown
        inputPanel.add(new JLabel("Department:"));
        String[] departments = {"CSE", "ECE", "EEE", "ME", "CE"};
        departmentComboBox = new JComboBox<>(departments);
        inputPanel.add(departmentComboBox);

        // Add input panel to the frame
        add(inputPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");
        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleReset();
            }
        });
    }

    // Handle Submit Button Click
    private void handleSubmit() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "Not Selected");
        String department = (String) departmentComboBox.getSelectedItem();

        // Validate inputs
        if (id.isEmpty() || name.isEmpty() || gender.equals("Not Selected")) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Display the details
        String message = "Student Details:\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Department: " + department;
        JOptionPane.showMessageDialog(this, message, "Student Details", JOptionPane.INFORMATION_MESSAGE);
    }

    // Handle Reset Button Click
    private void handleReset() {
        idField.setText("");
        nameField.setText("");
        maleButton.setSelected(false);
        femaleButton.setSelected(false);
        departmentComboBox.setSelectedIndex(0);
    }

    // Main Method
    public static void main(String[] args) {
    	StudentRegistrationForm frame = new StudentRegistrationForm();
                
    }
}
