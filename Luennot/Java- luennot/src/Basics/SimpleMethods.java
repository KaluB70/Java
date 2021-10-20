package Basics;

public class SimpleMethods {
  public static void main ( String[] args ) {
    
    int i = 1;
    int j = 2;
    int k = 3;
    int sum = i+j+k;
    System.out.println ( sum );
    
    sum = 4 + 5 + 6;
    System.out.println ( sum );
    
    sum = sumThree ( i, j, k );  // sumThree ( 1, 2, 3 );
    System.out.println ( sum );
    
    sum = sumThree ( 4, 5, 6 );
    System.out.println ( sum );
  }
  
  // The names of the parameters has nothing to do with the names in the caller.
  public static int sumThree ( int ii, int jii, int koo ) {
    int sum = ii+jii+koo;
    return sum;
  }
}
