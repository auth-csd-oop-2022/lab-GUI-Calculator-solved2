package api;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CalculatorServiceTest {

    @Test
    public void add() {
        CalculatorService service = new CalculatorService();
        int r = service.add(10, 20);
        assertEquals(r, 30);

        r = service.add(1, 2);
        assertEquals(r, 3);

        List<Integer> log = service.getLog();
        assertEquals(log.size(), 2);
        assertEquals((long) log.get(0), 30);
        assertEquals((long) log.get(1), 3);
    }

    @Test
    public void subtract() {
        CalculatorService service = new CalculatorService();
        int r = service.subtract(10, 20);
        assertEquals(r, -10);

        r = service.subtract(1, 2);
        assertEquals(r, -1);

        List<Integer> log = service.getLog();
        assertEquals(log.size(), 2);
        assertEquals((long) log.get(0), -10);
        assertEquals((long) log.get(1), -1);
    }

    @Test
    public void multiply() {
        CalculatorService service = new CalculatorService();
        int r = service.multiply(10, 20);
        assertEquals(r, 200);

        r = service.multiply(1, 2);
        assertEquals(r, 2);

        List<Integer> log = service.getLog();
        assertEquals(log.size(), 2);
        assertEquals((long) log.get(0), 200);
        assertEquals((long) log.get(1), 2);
    }

}