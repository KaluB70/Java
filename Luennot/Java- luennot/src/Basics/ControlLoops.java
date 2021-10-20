package Basics;

import java.util.Random;

public class ControlLoops {
  
  public static void main ( String[] args ) {
    
    /*
    This is a crappily coded program. Why?
    Hopefully I remember to go through this next time.
    */
    Random gen = new Random();
    int[] nums = new int[4];
    for ( int i = 0; i < 100; i++ ) {
      int nmbr = gen.nextInt(4);
      if ( nmbr == 0 ) nums[0]++;
      else if ( nmbr == 1 ) nums[1]++;
      else if ( nmbr == 2 ) nums[2]++;
      else if ( nmbr == 3 ) nums[3]++;
    }
    int i = 0;
    while ( i < 4 ) {
      System.out.printf ("%3d = %3d\n", i, nums[i] );
      i++;
    }

    i = 0;
    do {
      int nmbr = gen.nextInt(4);
      if ( nmbr == 0 ) nums[0]++;
      else if ( nmbr == 1 ) nums[1]++;
      else if ( nmbr == 2 ) nums[2]++;
      else if ( nmbr == 3 ) nums[3]++;
    } while ( !allAreTheSame ( nums ));
    i = 0;
    while ( i < 4 ) {
      System.out.printf ("%3d = %3d\n", i, nums[i] );
      i++;
    }
  }
  
  public static boolean allAreTheSame ( int[] n ) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for ( int i = n.length-1; i > 0; i-- ) {
      max = Math.max ( max, Math.max ( n[i], n[i-1] ));
      min = Math.min ( min, Math.min ( n[i], n[i-1] ));
      if ( max - min > 10 ) {
        System.out.println ("Noup: " + min + " <--> " + max );
        return false;
      }
    }
    System.out.println ("Yes!: " + min + " <--> " + max );
    return true;
  }
}
