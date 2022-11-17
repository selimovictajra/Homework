package ba.unsa.etf.rpr;

/**
 * class that represents entry point for our program
 * @author Tajra Selimovic
 * @version 1.0
 */
public class App {
    /**
     * the main method that parses the input from the console and using the ExpressionEvaluator class and its evaluate method prints the solution of the expression
     * @param args String[]
     */
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        try {
            for (String passage : args) {
                if (args.length % 2 == 0) throw new RuntimeException();
                s.append(passage).append(" ");
                ExpressionEvaluator ee = new ExpressionEvaluator();
                System.out.println(ee.evaluate(String.valueOf(s)));
            }
        }
        catch (RuntimeException exception) {
            System.out.println("Error");
        }
    }
}