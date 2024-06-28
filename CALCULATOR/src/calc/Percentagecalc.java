package calc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Percentagecalc extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> calculationTypeCombo;
    private JTextField input1Field;
    private JTextField input2Field;
    private JLabel resultLabel;

    public Percentagecalc() {
        setTitle("Percentage Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Initialize components
        calculationTypeCombo = new JComboBox<>(new String[] {
            "Calculate Percentage", "Calculate Increase", "Calculate Decrease", " Whole"
        });
        calculationTypeCombo.setForeground(Color.BLUE);

        input1Field = new JTextField();
        input1Field.setForeground(Color.green);
        input1Field.setBackground(Color.DARK_GRAY);

        input2Field = new JTextField();
        input2Field.setForeground(Color.green);
        input2Field.setBackground(Color.DARK_GRAY);

        resultLabel = new JLabel("Result:");
        resultLabel.setForeground(Color.BLACK);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setForeground(Color.MAGENTA);
        calculateButton.addActionListener(new CalculateButtonListener());

        // Add components to the frame
        JLabel calculationTypeLabel = new JLabel("Calculation Type:");
        calculationTypeLabel.setForeground(Color.BLACK);

        JLabel input1Label = new JLabel("First input:");
        input1Label.setForeground(Color.BLACK);

        JLabel input2Label = new JLabel("Second input:");
        input2Label.setForeground(Color.BLACK);

        add(calculationTypeLabel);
        add(calculationTypeCombo);
        add(input1Label);
        add(input1Field);
        add(input2Label);
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
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
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
        new Percentagecalc();
    }
}

