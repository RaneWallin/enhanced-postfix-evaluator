public interface Constants {
    String INTRO_MESSAGE = "Postfix Expression Evaluator - R. Wallin\n\n";
    String START_MESSAGE =  "Enter a valid post-fix expression one token " +
            "at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)\n\n" +
            "Each token must be an integer or an operator (+,-,*,/)";
    String CONTINUE_PROMPT = "Evaluate another expression [Y/N]? ";
    String RESULT_PREFIX = "That expression equals ";
    String CONTINUE_ACCEPT = "y";
    String ERROR_MESSAGE = "Invalid Postfix Expression!";

    // Binary operators
    char ADD      = '+';
    char SUBTRACT = '-';
    char MULTIPLY = '*';
    char DIVIDE   = '/';
    char MODULUS = '%';
    char POWER = '^';
    char GT = '>';
    char LT = '<';
    String BINARY_OPERATORS = "+-*/%^><";

    // Unary operators
    char MINUS = '~';
    char FACTORIAL = '!';
    String UNARY_OPERATORS = "~!";

}
