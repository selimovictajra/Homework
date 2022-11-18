package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 *class for evaluating expressions using Dijkstra's Two-Stack Algorithm
 *@author Tajra Selimovic
 *@version 1.0
 */
public class ExpressionEvaluator {
    private final Stack<String> operators = new Stack<>();
    private final Stack<Double> values = new Stack<>();

    /**
     * method that checks if an argument is a number
     * @param str String
     * @return boolean
     */
    public static boolean isNumber(String str){
        if(str == null || str.equals("")) return false;
        try{
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    /**
     * method gives us evaluated expression using Dijkstra's Two-Stack Algorithm
     * @param str String
     * @return double - value of given expression
     */
    public Double evaluate(String str) {
        String[] ss = str.split(" ");
        for (String passage : ss) {
            if (!passage.equals("(") && !passage.equals("+") && !passage.equals("-") && !passage.equals("*") && !passage.equals("/") && !passage.equals("sqrt") && !passage.equals(")") && !isNumber(passage)) {
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