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

 */

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
            } catch(Exception e) {
                System.out.println(ERROR_MESSAGE);
            }

            System.out.print(CONTINUE_PROMPT);

            again = in.nextLine();
            System.out.println();
        }
        while (again.equalsIgnoreCase(CONTINUE_ACCEPT));
        
        in.close();
  }
}
