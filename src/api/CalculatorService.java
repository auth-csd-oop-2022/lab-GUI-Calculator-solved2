package api;

import java.util.ArrayList;
import java.util.List;

/**
 * Κλάση που υλοποιεί πράξεις ακεραίων για μια αριθμομηχανή. Επίσης, κρατάει ένα ιστορικό το αποτελεσμάτων σε μια λίστα
 * <p>
 * Class that implements integer calculations. It also stores the history (list) with the results
 */

public class CalculatorService {

    // History of results
    List<Integer> log;

    // Constructor
    public CalculatorService() {
        log = new ArrayList<>();
    }

    /**
     * Πρόσθεση / Addition
     *
     * @param n1 Πρώτος ακέραιος / first integer
     * @param n2 Δεύτερος ακέραιος / second integer
     * @return Αποτέλεσμα / Result
     */
    public int add(int n1, int n2) {
        int r = n1 + n2;
        log.add(r);
        return r;
    }

    /**
     * Αφαίρεση / Subtraction
     *
     * @param n1 Πρώτος ακέραιος / first integer
     * @param n2 Δεύτερος ακέραιος / second integer
     * @return Αποτέλεσμα / Result
     */
    public int subtract(int n1, int n2) {
        int r = n1 - n2;
        log.add(r);
        return r;
    }

    /**
     * Πολλαπλασιασμός / Multiplication
     *
     * @param n1 Πρώτος ακέραιος / first integer
     * @param n2 Δεύτερος ακέραιος / second integer
     * @return Αποτέλεσμα / Result
     */
    public int multiply(int n1, int n2) {
        int r = n1 * n2;
        log.add(r);
        return r;
    }

    /**
     * Επιστρέφει το ιστορικό των αποτελεσμάτων.
     * <p>
     * Returns the log
     *
     * @return Λίστα με το ιστορικό / The log
     */
    public List<Integer> getLog() {
        return log;
    }

    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();

        service.add(1, 2);
        service.subtract(1, 2);
        service.multiply(1, 2);
        System.out.println(service.getLog());
    }
}
