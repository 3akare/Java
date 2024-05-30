import Calculator.Calc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    Calc calculator = new Calc();
    @Test
    public void sumTest() {
        assertEquals(3, calculator.sum(1, 2), ()->"Calculator Addition Failed");
    }

    @Test
    public void subTest() {
       assertEquals(-1, calculator.sub(1, 2), ()->"Calculator Subtraction Failed");
    }

    @Test
    public void divTest() {
        assertEquals(0, calculator.div(1, 2), ()->"Calculator Division Failed");
    }

    @Test
    public void mulTest() {
        assertEquals(2, calculator.mul(1, 2), ()->"Calculator Multiplication Failed");
    }
}
