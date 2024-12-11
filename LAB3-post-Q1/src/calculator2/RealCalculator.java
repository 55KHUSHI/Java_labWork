package calculator2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealCalculator extends JFrame {
    private JTextField displayField;
    private StringBuilder currentInput;
    private double firstOperand = 0;
    private String operator = "";

    // Constructor to set up the GUI
    public RealCalculator() {
        setTitle("Real Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Display Field with Padding
        displayField = new JTextField();
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        displayField.setEditable(false);
        displayField.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10)); // Extra padding: Top, Left, Bottom, Right
        add(displayField, BorderLayout.NORTH);

        currentInput = new StringBuilder();

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    // Handle Button Clicks
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                // Append number to current input
                currentInput.append(command);
                displayField.setText(currentInput.toString());
            } else if ("+-*/".contains(command)) {
                // Store the first operand and operator
                if (currentInput.length() > 0) {
                    firstOperand = Double.parseDouble(currentInput.toString());
                    operator = command;
                    currentInput.setLength(0); // Clear current input
                }
            } else if ("=".equals(command)) {
                // Perform the calculation
                if (currentInput.length() > 0 && !operator.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput.toString());
                    double result = calculate(firstOperand, secondOperand, operator);
                    displayField.setText(String.valueOf(result));
                    currentInput.setLength(0); // Clear current input
                    operator = ""; // Reset operator
                }
            } else if ("C".equals(command)) {
                // Clear everything
                currentInput.setLength(0);
                displayField.setText("");
                firstOperand = 0;
                operator = "";
            }
        }
    }

    // Perform the calculation
    private double calculate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero.", "Math Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
                return operand1 / operand2;
            default: return 0;
        }
    }

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RealCalculator frame = new RealCalculator();
            frame.setVisible(true);
        });
    }
}

