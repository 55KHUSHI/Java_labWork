package calculatorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    private JTextField number1Field, number2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, clearButton;

    // Constructor to set up the GUI
    public CalculatorGUI() {
    	setVisible(true);
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Number 1:"));
        number1Field = new JTextField();
        inputPanel.add(number1Field);

        inputPanel.add(new JLabel("Number 2:"));
        number2Field = new JTextField();
        inputPanel.add(number2Field);

        inputPanel.add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false); // Result field is read-only
        inputPanel.add(resultField);

        add(inputPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("C");
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners for Buttons
        addButton.addActionListener(new ArithmeticAction("+"));
        subtractButton.addActionListener(new ArithmeticAction("-"));
        multiplyButton.addActionListener(new ArithmeticAction("*"));
        divideButton.addActionListener(new ArithmeticAction("/"));
        clearButton.addActionListener(e -> handleClear());
    }

    // ActionListener class for arithmetic operations
    private class ArithmeticAction implements ActionListener {
        private final String operation;

        public ArithmeticAction(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int num1 = Integer.parseInt(number1Field.getText().trim());
                int num2 = Integer.parseInt(number2Field.getText().trim());
                int result = 0;

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            throw new ArithmeticException("Cannot divide by zero.");
                        }
                        result = num1 / num2;
                        break;
                }

                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(CalculatorGUI.this, "Please enter valid integers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(CalculatorGUI.this, ex.getMessage(), "Math Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Handle Clear Button Action
    private void handleClear() {
        number1Field.setText("");
        number2Field.setText("");
        resultField.setText("");
    }

    // Main Method
    public static void main(String[] args) {
            CalculatorGUI frame = new CalculatorGUI();
    }
}


