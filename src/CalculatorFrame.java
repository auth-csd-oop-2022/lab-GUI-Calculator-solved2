import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Κλάση που υλοποιεί μια απλή αριθμομηχανή για προσθέσεις και αφαιρέσεις. Δημιουργήστε ένα παράθυρο 300x80 που περιέχει
 * δύο text fields για τους αριθμούς που θα προστεθούν ή θα αφαιρεθούν, ένα κουμπί πρόσθεσης και ένα αφαίρεσης, καθώς
 * και ένα text field για το αποτέλεσμα της πράξης. Προτείνεται η χρήση του FlowLayout. Παράδειγμα:
 * https://drive.google.com/file/d/1MDA9VYuVau2k5SVQbtQrnTgVIvSSMO1f/view?usp=sharing
 *
 * <p>
 * Class that implements a simple calculator for additions and subtractions. Create a frame 300x80 that contains two
 * text fields for the two numbers of the arithmetic operations, one button for the addition and one for the
 * subtractions, as well as one text field for the results. It is recommended to use the FlowLayout. Example:
 * https://drive.google.com/file/d/1MDA9VYuVau2k5SVQbtQrnTgVIvSSMO1f/view?usp=sharing
 */
public class CalculatorFrame extends JFrame implements ActionListener {

    JTextField text1, text2, resultText;
    JButton plusBtn, minusBtn;

    public void startGUI() {
        this.setTitle("My Calculator");
        this.setSize(300, 80);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout());

        plusBtn = new JButton("+");
        plusBtn.addActionListener(this);
        minusBtn = new JButton("-");
        minusBtn.addActionListener(this);

        text1 = new JTextField();
        text1.setPreferredSize(new Dimension(50, text1.getPreferredSize().height));
        text2 = new JTextField();
        text2.setPreferredSize(new Dimension(50, text2.getPreferredSize().height));
        resultText = new JTextField();
        resultText.setPreferredSize(new Dimension(50, resultText.getPreferredSize().height));

        this.add(text1);
        this.add(text2);
        this.add(plusBtn);
        this.add(minusBtn);
        this.add(resultText);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: check for empty or non-number values
        int x = Integer.parseInt(text1.getText());
        int y = Integer.parseInt(text2.getText());
        if (e.getActionCommand().equals("+")) {
            resultText.setText(x + y + "");
        } else {
            resultText.setText(x - y + "");
        }
    }

    public static void main(String[] args) {
        new CalculatorFrame().startGUI();
    }
}
