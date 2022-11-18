import ba.unsa.etf.rpr.ExpressionEvaluator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * class that tests our program for evaluating expressions
 * @author Tajra Selimovic
 * @version 1.0
 */
public class ExpressionEvaluatorTest {
    /**
     * tests addition
     */
    @Test
    public void EETest1 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( ( 7 + 3 ) + 5 )"), 15);
    }

    /**
     * tests subtraction
     */
    @Test
    public void EETest2 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( 5 - ( 7 - 1 ) )"), -1);
    }

    /**
     * tests multiplication
     */
    @Test
    public void EETest3 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( ( 2 * 4 ) * 7 )"), 56);
    }

    /**
     * tests division
     */
    @Test
    public void EETest4 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( ( 100 / 2 ) / 5 )"), 10);
    }

    /**
     * tests expression with sqrt operator
     */
    @Test
    public void EETest5 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( ( 2 - 20 ) / sqrt ( 9 ) )"), -6);
    }

    /**
     * tests longer expressions
     */
    @Test
    public void EETest6 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( 7 + ( ( ( 2 * 5 * 8 ) / ( 9 + ( 7 + ( 9 + ( ( sqrt ( 4 ) * 8 ) - 1 ) ) ) ) ) ) )"), 9);
    }

    /**
     * tests expression with a lot of brackets
     */
    @Test
    public void EETest7 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( 1 + ( 2 + ( 3 + ( 4 + ( 5 + ( 7 - 3 ) ) ) ) ) )"), 19);
    }

    /**
     * tests an exception in case of invalid input and if it's the right exception pt1
     */
    @Test
    public void EETest8 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> ex.evaluate ("( 100 + 300 - 200 )"));
    }

    /**
     * tests an exception in case of invalid input and if it's the right exception pt2
     */
    @Test
    public void EETest9 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> ex.evaluate ("( saberi 1 i 2 ! )"));
    }

    /**
     * tests an exception in case of invalid input and if it's the right exception pt3
     */
    @Test
    public void EETest10 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> ex.evaluate ("hiii!!!"));
    }
}
