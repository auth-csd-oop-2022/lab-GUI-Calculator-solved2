package gui;

import api.CalculatorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Κλάση που υλοποιεί μια απλή αριθμομηχανή για δύο αριθμούς. Δημιουργήστε ένα παράθυρο 300x300 που περιέχει δύο text
 * fields για τους δύο αριθμούς, radio buttons για την επιλογή μίας εκ των τριών πράξεων της CalculatorService, ένα
 * κουμπί για την εκτέλεση της επιλεγμένης πράξης, έκα κουμπί για την εμφάνιση του ιστορικού των αποτελεσμάτων και ένα
 * text area για την εμφάνιση είτε του αποτελέσματος της πράξης είτε του ιστορικού των αποτελεσμάτων. Προτείνεται η
 * χρήση του FlowLayout. Παράδειγμα: https://drive.google.com/file/d/1TG-HxKpy80iQhzddJOd6f4wRRaih_qbF/view?usp=sharing
 * <p>
 * Class that implements a simple calculator for two numbers. Create a frame with dimensions 300x300 that contains two
 * text fields for the two numbers, radio buttons for selecting one calculation from the CalculationServices, one button
 * for running the selected calculation, one button for viewing the logs of calculations and one text area for showing
 * either the results of the selected calculation or the history / log. You can use the FlowLayout for simplicity.
 * Example:  https://drive.google.com/file/d/1TG-HxKpy80iQhzddJOd6f4wRRaih_qbF/view?usp=sharing
 */
public class CalculatorFrame extends JFrame implements ActionListener {

    JTextField textField_number1, textField_number2;
    JTextArea textArea_results;
    JRadioButton radio_button_add, radio_button_subtract, radio_button_multiply;
    JButton button_calculate, button_log;

    CalculatorService service;

    public void startGUI() {
        service = new CalculatorService();

        this.setTitle("My Calculator");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout());

        // buttons
        button_calculate = new JButton("Calculate");
        button_log = new JButton("Log");

        // text fields and area
        textField_number1 = new JTextField(10);
        textField_number2 = new JTextField(10);
        textArea_results = new JTextArea(10, 10);

        // radio buttons
        radio_button_add = new JRadioButton("add");
        radio_button_add.setSelected(true);
        radio_button_subtract = new JRadioButton("subtract");
        radio_button_multiply = new JRadioButton("multiply");
        ButtonGroup group = new ButtonGroup();
        group.add(radio_button_add);
        group.add(radio_button_multiply);
        group.add(radio_button_subtract);

        // add to the panel
        this.add(textField_number1);
        this.add(textField_number2);
        this.add(radio_button_add);
        this.add(radio_button_subtract);
        this.add(radio_button_multiply);
        this.add(button_calculate);
        this.add(button_log);
        this.add(textArea_results);

        // add action listeners
        button_calculate.addActionListener(this);
        button_log.addActionListener(this);

        /**
         // δημιουργία ανώνυμης κλάσης
         button_calculate.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
        int x = Integer.parseInt(textField_number1.getText());
        int y = Integer.parseInt(textField_number2.getText());
        if (radio_button_add.isSelected()) {
        textArea_results.setText(service.add(x, y) + "");
        } else if (radio_button_subtract.isSelected()) {
        textArea_results.setText(service.subtract(x, y) + "");
        } else if (radio_button_multiply.isSelected()) {
        textArea_results.setText(service.multiply(x, y) + "");
        }
        }
        });
         */

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = Integer.parseInt(textField_number1.getText());
        int y = Integer.parseInt(textField_number2.getText());
        if (e.getActionCommand().equals("Calculate")) {
            if (radio_button_add.isSelected()) {
                textArea_results.setText(service.add(x, y) + "");
            } else if (radio_button_subtract.isSelected()) {
                textArea_results.setText(service.subtract(x, y) + "");
            } else if (radio_button_multiply.isSelected()) {
                textArea_results.setText(service.multiply(x, y) + "");
            }
        } else if (e.getActionCommand().equals("Log")) {
            textArea_results.setText(service.getLog() + "");
        }
    }

    public static void main(String[] args) {
        new CalculatorFrame().startGUI();
    }
}
