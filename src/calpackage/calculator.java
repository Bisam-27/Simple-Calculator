package calpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator {

    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea resultArea;

    public calculator() {
        frame = new JFrame("Simple Calculator");
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        resultArea = new JTextArea(5, 20);
        JButton addButton = new JButton("Add");
        JButton multiplyButton = new JButton("Multiply");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2)); // Set up grid layout with 2 columns
        panel.add(new JLabel("Number 1:"));
        panel.add(textField1);
        panel.add(new JLabel("Number 2:"));
        panel.add(textField2);
        panel.add(addButton);
        panel.add(multiplyButton);
        panel.add(new JScrollPane(resultArea));

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Add button event handler
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCalculation("add");
            }
        });

        // Multiply button event handler
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCalculation("multiply");
            }
        });
    }

    private void handleCalculation(String operation) {
        try {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());

            if (num1 < 0 || num2 < 0) {
                resultArea.append("Error: Inputs must be non-negative.\n");
                return;
            }

            int result;
            if ("add".equals(operation)) {
                result = addition(num1, num2);
                resultArea.append("Addition Result: " + result + "\n");
            } else if ("multiply".equals(operation)) {
                result = multiplication(num1, num2);
                resultArea.append("Multiplication Result: " + result + "\n");
            }
        } catch (NumberFormatException ex) {
            resultArea.append("Error: Please enter valid numbers.\n");
        }
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public boolean validateUser(String username, String password) {
        // Check username length (between 5 and 15 characters) and no special characters
        if (username.length() < 5 || username.length() > 15) {
            System.out.println("Error: Username must be between 5 and 15 characters.");
            return false;
        }
        if (containsSpecialCharacter(username)) {
            System.out.println("Error: Username should not contain special characters.");
            return false;
        }

        // Check if password contains at least one special character and at least one digit
        if (!containsSpecialCharacter(password) || !containsDigit(password)) {
            System.out.println("Error: Password must contain at least one special character and one digit.");
            return false;
        }

        return true; // Validation passed
    }

    private boolean containsSpecialCharacter(String input) {
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";
        for (char c : input.toCharArray()) {
            if (specialCharacters.indexOf(c) >= 0) {
                return true; // Found a special character
            }
        }
        return false; // No special characters found
    }

    private boolean containsDigit(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true; // Found a digit
            }
        }
        return false; // No digits found
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new calculator());
    }
}
