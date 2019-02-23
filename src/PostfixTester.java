/*
 * Rane Wallin
 * CSC 205
 *
 * This class is based on the provided class in enhanced postfix evaluator assignment.
 *
 * Test cases:
 * 3 4 * 2 5 + - 4 2 / * (Result: 10)
 * 17 5 % (Result: 2)
 * 3 4 ^ (Result: 81)
 * 5 + (Result: Error)
 * 1 2 3 + (Result: Error)
 * 12 ~ (Result: -12)
 * 5 ~ ~ ~ (Result: -5)
 * 6 ! (Result: 720)
 * 3 ! 4 * 5 3 % - 4 2 ~ / * (Result: -44)
 *5 3 > (Result: 1) Anything non-zero is considered true
 * 5 3 < (Result: 0) 0 is considered false
 * 10 5 & (Result: 1)
 * 5 3 > 2 3 > | (Result: 1)
 * 0 0 | (Result: 0)
 * 5 3 < 2 5 = 1 7 < | | 10 20 ? (Result: 10)
 * 1 2 ? (Result: Error)
 */

import java.util.EmptyStackException;
import java.util.Scanner;

public class PostfixTester implements Constants
{
    /**
     * Reads and evaluates multiple postfix expressions.
     */
    public static void main(String[] args)
    {
        String expression, again;
        int result;
    
        Scanner in = new Scanner(System.in);

        System.out.println(INTRO_MESSAGE);
      
        do
        {  
            PostfixEvaluator evaluator = new PostfixEvaluator();
            
			System.out.println(START_MESSAGE);

            expression = in.nextLine();

            try {
                result = evaluator.evaluate(expression);
                System.out.println(RESULT_PREFIX + result);
            } catch (ArithmeticException e) {
                System.out.println(ERROR_MESSAGE + e.getLocalizedMessage());
            }
            catch(EmptyStackException e) {
                System.out.println(ERROR_MESSAGE + NOT_ENOUGH_OPERATORS);
            }
            catch(NumberFormatException e) {
                System.out.println(ERROR_MESSAGE + INVALID_FORMAT);
            }

            System.out.print(CONTINUE_PROMPT);

            again = in.nextLine();
            System.out.println();
        }
        while (again.equalsIgnoreCase(CONTINUE_ACCEPT));
        
        in.close();
  }
}
