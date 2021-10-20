package Basics;

public class MathMethods {
  public static void main ( String[] args ) {
    int x = 7;
    int fx = x*x + 3*x - 4; // No method, just computing the value of the function.
    System.out.println ("Norm: " + fx );
    int fxMethod = f ( x ); // The value inside x goes to the method. In this case 7.
    System.out.println ("With the method: " + fxMethod );
    
    x = 5;
    int y = 4;
    int fxy = x*x + 4*y - 2*x*y + 7;
    System.out.println ("Norm: " +  fxy );
    int fxyMethod = f ( x, y );
    System.out.println ("With the method: " + fxyMethod );
  }
  
  public static int f ( int x ) {  // Defining variable x which takes in the value transferred.
    int theValue = x*x + 3*x - 4;  // Computing the value and saving the value into the variable theValue.
    return theValue;  // Returning the value in theValue.
  }
  public static int f ( int x, int y ) {
    return x*x + 4*y - 2*x*y + 7;  // No need to save the computed value anywhere. Just compute and return it.
  }
}