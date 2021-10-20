package Basics;

public class ArrayHandling {
  public static void main ( String[] args ) {
    
    final int LEN = 10;
    
    // Making an array of static length 3.
    int[] arr = {1,2,3};
    System.out.println ("The length of variable arr is: " + arr.length );
    
    // Making an array of variable length.
    int len = LEN;
    int[] arr2 = new int[len];
    System.out.println ("The length of variable arr2 is: " + arr2.length );
    
    // Printing the "addresses" of these arrays.
    System.out.println ("The \"addresses\" of arr and arr2: ");
    System.out.println ( arr );
    System.out.println ( arr2 );
    
    // Let's put something into arr2.
    for ( int i = 0; i < LEN; i++ ) {
      arr2[i] = i * i;
    }
    
    // Let's see the something.
    System.out.println ("\nThe values stored in arr2: ");
    for ( int i = 0; i < LEN; i++ ) {
      System.out.println ("Index " + i + ": " + arr2[i] );
    }
    
    // What happens now??
    arr = arr2;
    arr2[5] = 100000000;
    System.out.println ("\nThe values stored in the arrays: ");
    for ( int i = 0; i < LEN; i++ ) {
      System.out.println ("Index " + i + ": " + arr[i] + " <--> " + arr2[i] );
    }
    
    System.out.println ("\nThe \"addresses\" of arr and arr2: ");
    System.out.println ( arr );
    System.out.println ( arr2 );
  }
}
