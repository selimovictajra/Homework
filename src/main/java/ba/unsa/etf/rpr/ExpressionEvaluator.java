package ba.unsa.etf.rpr;
import java.util.Stack;

/**
 * class for evaluating expressions using Dijkstra's Two-Stack Algorithm
 * @author Tajra Selimovic
 * @version 1.0
 */

public class ExpressionEvaluator {
    private final Stack<Double> values = new Stack<>();
    private final Stack<String> operators = new Stack<>();

    /**
     * method that checks if an argument is a number
     * @param str String
     * @return boolean
     */
    private boolean isDigit (String str) {
        if (str == null) return false;
        try {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException exc) {
            return false;
        }
    }

    /**
     * method that gives us evaluated expression using Dijkstra's Two-Stack Algorithm
     * @param str String
     * @return double - value of given expression
     */
    public Double evaluate(String str) {
        String[] strs = str.split(" ");
        for (String passage : strs) {
            if (!isDigit(passage) && !passage.equals("(") && !passage.equals("+") && !passage.equals("*") && !passage.equals("-") && !passage.equals("/") && !passage.equals("sqrt") && !passage.equals(")")) {
                throw new RuntimeException();
            }
            switch (passage) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operators.push(passage);
                    break;
                case ")":
                    String op = operators.pop();
                    Double vl = values.pop();
                    switch (op) {
                        case "+" -> vl += values.pop();
                        case "-" -> vl = values.pop() - vl;
                        case "*" -> vl *= values.pop();
                        case "/" -> vl = values.pop() / vl;
                        case "sqrt" -> vl = Math.sqrt(vl);
                    }
                    values.push(vl);
                    break;
                default:
                    values.push(Double.parseDouble(passage));
                    break;
            }
        }
        return values.pop();
    }
}
