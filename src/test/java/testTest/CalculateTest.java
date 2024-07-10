package testTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateTest {
    private Calculate calculate;
    @BeforeEach
    void setCalculate(){
        calculate = new Calculate();
    }
    @Test
    public void add() {
        double sum = calculate.add(10,15);
        Assertions.assertEquals(25,sum);
    }

    @Test
    public void evenOrOdd_EvenNumber(){
        Assertions.assertTrue(calculate.evenOrOdd(4));
    }
    @Test public void evenOrOdd_OddNumber(){
        Assertions.assertFalse(calculate.evenOrOdd(11));
    }
    @Test
    public void subtract() {

    }
    @Test
    public void multiply() {
    }

    @Test
    public void divideByZero() {
        Assertions.assertThrows(ArithmeticException.class,() -> calculate.divide(10,0));
    }
}
