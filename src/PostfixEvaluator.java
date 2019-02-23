/*
 * Rane Wallin
 * CSC 205
 *
 * Postfix evaluator based on PostfixEvaluator.java provided in class assignment
 */

import java.util.Stack;
import java.util.Scanner;

public class PostfixEvaluator {
    private final static char ADD      = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE   = '/';
    private final static char MODULUS = '%';
    private final static char POWER = '^';
    private final static String BINARY_OPERATORS = "+-*/%^";

    private Stack<Integer> stack;

    public PostfixEvaluator() {
        stack = new Stack<>();
    }

	public int evaluate(String expr) {
        int op1, op2, result = 0;
        String token;
        Scanner parser = new Scanner(expr);

        while (parser.hasNext()) {
            token = parser.next();

            if (isOperator(token)) {
                op2 = (stack.pop()).intValue();
                op1 = (stack.pop()).intValue();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push(result);
            }
            else
                stack.push(Integer.parseInt(token));
        }

        parser.close();

        if (stack.size() == 1)
            return (stack.pop());
        else throw new ArithmeticException();
    }

    private boolean isOperator(String token) {
        return (BINARY_OPERATORS.indexOf(token) >= 0);

    }

    private int evaluateSingleOperator(char operation, int op1, int op2) {
        int result = 0;

        switch (operation) {
            case ADD:
                result = op1 + op2;
                break;
                
            case SUBTRACT:
                result = op1 - op2;
                break;
                
            case MULTIPLY:
                result = op1 * op2;
                break;
                
            case DIVIDE:
                result = op1 / op2;
                break;
            case MODULUS:
                result = op1 % op2;
                break;
            case POWER:
                result = (int) Math.pow(op1, op2);
        }

        return result;
    }
}
