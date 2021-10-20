package Basics;

public class Methods {
  public static void main ( String[] args ) throws Exception {
    print("Let's do some simple method calling:");
    int sumOfThree = sum ( 1, 2, 3 );  // You can save the value returned from a method.
    print ( sumOfThree );
    print ( sum ( 3, 4, 5 ));  // You can use the value returned form a method directly.
    print ("+: " + intCalculator ('+', 100, 30 ));
    print ("-: " + intCalculator ('-', 100, 30 ));
    print ("/: " + intCalculator ('/', 100, 30 ));
    print ("*: " + intCalculator ('*', 100, 30 ));
    print ("?: " + intCalculator ('?', 100, 30 ));
    print("");
    
    print("Let's do a bit more complicated method calling:");
    // Chaining two calls. First call summing, then call subtracting, lastly multiply the results of the previous calls.
    int theResult = intCalculator ('+', 2, 2 ) * intCalculator ('-', 4, 1 );
    print ("(2+2)*(4-1) = " + theResult );
    
    /* Parenthesis can be used to instruct the order of execution.
       Usually everything is executed from left to right and top down.
       Here we seem to call the intCalculator to multiply two numbers. However that is not even possible
       before we first call the summer and the subtracter. We need those values to be able
       to perform the multiplication. So this is what happens:
    
      First the summer is called and after it returns the clause looks like:
        theResult = intCalculator ('*', 4, intCalculator ('-', 4, 1 ));
      Then the subtracter is called and after it returns the clause looks like:
        theResult = intCalculator ('*', 4, 3 );
      Finally the multiplier can be called and the result saved in the variable theResult.
    
      Remember that you can have as many method calls inside each other as you want.
    
      In my opinion you'd be better off chaining the calls - the construction is easier to handle.
    */
    theResult = intCalculator ('*', intCalculator ('+', 2, 2 ), intCalculator ('-', 4, 1 ));
    print ("(2+2)*(4-1) = " + theResult );
    theResult = intCalculator ('+', 2, intCalculator('*', 4, intCalculator ('-', 3, intCalculator ('/', 4, 2 ))));
    print ("(2+(4*(3-(4/2))) = " + theResult );
    print("");
    
    // Exercise: make calls to intCalculator to compute (2+2)*4/((2-3)*(4-2)). The result should be -8.

    print("Using the double-value calculator (reckon the numbers are ints, but the result is double):");
    print ("+: " + doubleCalculator ('+', 100, 30 ));
    print ("-: " + doubleCalculator ('-', 100, 30 ));
    print ("/: " + doubleCalculator ('/', 100, 30 ));
    print ("*: " + doubleCalculator ('*', 100, 30 ));
    
    /* The program crashes when executing the call to doubleCalculator.
       This is because the method throws an exception.
       An execption is thrown when something unexpected is happening - usually some kind of errorish thing.
    
       Find out how you can prevent the program from crashing.
    */
    print ("?: " + doubleCalculator ('?', 100, 30 ));
  }
  
  /**
   * This program sums the values of the parameters and returns the result to the caller.
   * @param n1 the numbers coming in
   * @param n2
   * @param n3
   * @return the sum of the values of the parameters.
   */
  public static int sum ( int n1, int n2, int n3 ) {
    return ( n1 + n2 + n3 );
  }
  
  /**
   * These two methods are almost the same - only the type of the parameter is different.
   * If the parameter is numeric (int) the first one is called. If the parameter
   * is a string then the second one is called.
   * What happens if we call the print method with a double value as a parameter.
   * @param nmbr 
   */
  public static void print ( int nmbr ) {
    System.out.println ( nmbr );
  }
  
  public static void print ( String info ) {
    System.out.println ( info );
  }
  
  public static int intCalculator ( char operator, int operand1, int operand2 ) {
    if ( operator == '+' ) return operand1 + operand2;
    else if ( operator == '-' ) return operand1 - operand2;
    else if ( operator == '/' ) return operand1 / operand2;
    else if ( operator == '*' ) return operand1 * operand2;
    else return Integer.MIN_VALUE;
  }
  
  public static double doubleCalculator ( char operator, double operand1, double operand2 ) throws Exception {
    if ( operator == '+' ) return operand1 + operand2;
    else if ( operator == '-' ) return operand1 - operand2;
    else if ( operator == '/' ) return operand1 / operand2;
    else if ( operator == '*' ) return operand1 * operand2;
    else throw new Exception("I did not recognize the operator. Have you invented your own?");
  }
}
