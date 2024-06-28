package calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PercentageCalculator extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color background = null;
	private JComboBox<String> calculationTypeCombo;
    private JTextField input1Field;
    private JTextField input2Field;
    private JLabel resultLabel;
   
     PercentageCalculator() {
        setTitle("Percentage Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));
        
        
        
        
        //CREATING A COMPONENT BOX CONTAINING DIFFERNT COMPONENTS
        calculationTypeCombo = new JComboBox<String>(new String[] {
            "Calculate Percentage", "percentage Increase", "percentage Decrease", "Whole"
        });
        calculationTypeCombo.setForeground(Color.CYAN);
        calculationTypeCombo.setBackground(Color.BLACK);

        input1Field = new JTextField();
        input1Field.setForeground(Color.cyan);
        input1Field.setSize(100,20);
        input1Field.setBackground(Color.BLACK);
        input2Field = new JTextField();
        input2Field.setForeground(Color.cyan);
        input2Field.setBackground(Color.BLACK);
        resultLabel = new JLabel("Result:");
        resultLabel.setBackground(Color.BLACK);

        JButton calculateButton = new JButton("Calculate");
        Object color;
		calculateButton.setBackground(Color.cyan);
        
        calculateButton.addActionListener(new CalculateButtonListener());

        // Add components to the frame
        
        add(new JLabel("Type of calculation:"));
        add(calculationTypeCombo);
        add(new JLabel("Input 1:"));
        add(input1Field);
        add(new JLabel("Input 2:"));
        add(input2Field);
        add(new JLabel(""));
        add(calculateButton);
        add(new JLabel(""));
        add(resultLabel);

        setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String calculationType = (String) calculationTypeCombo.getSelectedItem();
                double input1 = Double.parseDouble(input1Field.getText());
                double input2 = Double.parseDouble(input2Field.getText());
                double result = 0;

                switch (calculationType) {
                    case "Calculate Percentage":
                        result = calculatePercentage(input1, input2);
                        break;
                    case "Calculate Increase":
                        result = calculateIncrease(input1, input2);
                        break;
                    case "Calculate Decrease":
                        result = calculateDecrease(input1, input2);
                        break;
                    case "Find Whole":
                        result = findWhole(input1, input2);
                        break;
                }

                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter  a valid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private double calculatePercentage(double part, double whole) {
        return (part / whole) * 100;
    }

    private double calculateIncrease(double original, double increase) {
        return ((increase - original) / original) * 100;
    }

    private double calculateDecrease(double original, double decrease) {
        return ((original - decrease) / original) * 100;
    }

    private double findWhole(double part, double percentage) {
        return (part * 100) / percentage;
    }

    public static void main(String[] args) {
        new PercentageCalculator();
    }
}

