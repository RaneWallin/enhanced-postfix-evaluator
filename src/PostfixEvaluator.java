/*
 * Rane Wallin
 * CSC 205
 *
 * Postfix evaluator based on PostfixEvaluator.java provided in class assignment
 */

import java.util.Stack;
import java.util.Scanner;

public class PostfixEvaluator implements Constants {

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

            if (isBinaryOperator(token)) {
                op2 = (stack.pop()).intValue();
                op1 = (stack.pop()).intValue();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push(result);
            } else if (isUnaryOperator(token)) {
                op1 = (stack.pop()).intValue();
                result = evaluateSingleOperator(token.charAt(0), op1);
                stack.push(result);
            }
            else
                stack.push(Integer.parseInt(token));
        }

        parser.close();

        if (stack.size() == 1)
            return (stack.pop());
        else throw new ArithmeticException(TOO_MANY_OPERANDS);
    }

    private boolean isBinaryOperator(String token) {
        return (BINARY_OPERATORS.indexOf(token) >= 0);

    }

    private boolean isUnaryOperator(String token) {
        return (UNARY_OPERATORS.indexOf(token) >= 0);
    }

    private int evaluateSingleOperator(char operation, int ... ops) {
        int result = 0;
        int op1 = ops[0], op2 = 0, op3 = 0;

        if (ops.length > 1) {
            op2 = ops[1];
        }

        if (ops.length > 2){
            op3 = ops[2];
        }

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
                break;

            case MINUS:
                result = op1 * -1;
                break;

            case FACTORIAL:
                result = 1;
                for(int i = op1; i > 0; i--) result *= i;
                break;

            case GT:
                result = op1 > op2 ? 1 : 0;
                break;

            case LT:
                result = op2 > op1 ? 1 : 0;
                break;

            case EQUAL:
                result = op2 == op1 ? 1 : 0;
                break;

            case OR:
                result = (op1 + op2 != 0) ? 1 : 0;
                break;

            case AND:
                result = (op1 != 0 && op2 != 0) ? 1 : 0;
                break;

        }

        return result;
    }
}
