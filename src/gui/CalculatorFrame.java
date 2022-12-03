package gui;

import api.CalculatorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Κλάση που υλοποιεί μια απλή αριθμομηχανή για δύο αριθμούς. Δημιουργήστε ένα παράθυρο 300x80 που περιέχει δύο text
 * fields για τους δύο αριθμούς, radio buttons για την επιλογή μίας εκ των τριών πράξεων της CalculatorService, ένα
 * κουμπί για την εκτέλεση της επιλεγμένης πράξης, έκα κουμπί για την εμφάνιση του ιστορικού των αποτελεσμάτων και ένα
 * text area για την εμφάνιση είτε του αποτελέσματος της πράξης είτε του ιστορικού των αποτελεσμάτων. Προτείνεται η
 * χρήση του FlowLayout. Παράδειγμα: https://drive.google.com/file/d/1MDA9VYuVau2k5SVQbtQrnTgVIvSSMO1f/view?usp=sharing
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
        this.setSize(300, 120);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout());

        button_calculate = new JButton("Calculate");
        button_calculate.addActionListener(this);
        button_log = new JButton("Log");
        button_log.addActionListener(this);

        textField_number1 = new JTextField();
        textField_number1.setPreferredSize(new Dimension(50, textField_number1.getPreferredSize().height));
        textField_number2 = new JTextField();
        textField_number2.setPreferredSize(new Dimension(50, textField_number2.getPreferredSize().height));
        textArea_results = new JTextArea();
        textArea_results.setPreferredSize(new Dimension(50, textArea_results.getPreferredSize().height));

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

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: check for empty or non-number values
//        int x = Integer.parseInt(textField_number1.getText());
//        int y = Integer.parseInt(textField_number2.getText());
//        if (e.getActionCommand().equals("+")) {
//            resultText.setText(x + y + "");
//        } else {
//            resultText.setText(x - y + "");
//        }
    }

    public static void main(String[] args) {
        new CalculatorFrame().startGUI();
    }
}
