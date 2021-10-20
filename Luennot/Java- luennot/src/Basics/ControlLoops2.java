package Basics;

import java.util.Random;

/**
 * This is a better version of ControlLoops.java.
 *   - All numeric literals made finals --> updating is very easy.
 *   - Made everything to a subroutine --> no need for duplicate code.
 *   - Removed the if-else -clause after recognizing an easier way to update the array.
 *   - Fixed the infinite loop -problem by introducing an upper bound for running rounds.
 * 
 * This also introduces you to the very important thing called speed.
 *   - According to functional programming you always have to make "pure functions" and
 *     never mutate data. This means that your function should always return the same output
 *     with the same input. 
 *   - This in turn means that you can not f.ex draw random numbers in your function.
 *   - It also means, that you can not update an object in your code. This in turn
 *     means that you always have to make a copy of your object.
 * 
 * I tested the running times with an integer array of size 4, 40 and 400. The results in seconds it took the program to run:
 *          mutable     not mutable
 *    4        9           18
 *   40        9           24
 *  400        9          137
 */

public class ControlLoops2 {
  
  // Why must this final be outside the main-method?
  // Why must it be static?
  static final int MIN_MAX_DIFF_TO_STOP = 1; // A very small number --> the program runs STOP_INIFINITE_LOOP rounds. 

  public static void main ( String[] args ) {
    
    final int DIFFERENT_NUMS_TO_DRAW = 4;    // Run with 4, 40 and 400. The bigger the copy, the longer it lasts to make it.
    final int TOTAL_OF_NUMS_TO_DRAW = 100;
    final boolean UPDATE_MUTABLE = false;
    final int STOP_INFINITE_LOOP = 1000000000;
    
    /**
     * When checking for copy speed: Change STOP_INFINITE_LOOP, random seed to 111 and remove the print from line 78:ish.
     */
    
    Random gen = new Random(111);  // Set this to 111 when checking for speed.
    int[] nums = new int[DIFFERENT_NUMS_TO_DRAW];
    for ( int i = 0; i < TOTAL_OF_NUMS_TO_DRAW; i++ ) {
      int nmbr = gen.nextInt(DIFFERENT_NUMS_TO_DRAW);
      if ( UPDATE_MUTABLE )
        updateMutable ( nums, nmbr );
      else
        nums = updateImmutable ( nums, nmbr );
    }
    printArray ( nums );

    int i = 0;
    do {
      int nmbr = gen.nextInt(DIFFERENT_NUMS_TO_DRAW);
      if ( UPDATE_MUTABLE )
        updateMutable ( nums, nmbr );
      else
        nums = updateImmutable ( nums, nmbr );
      i++;
    } while ( !allAreTheSame ( nums ) && ( i < STOP_INFINITE_LOOP ));
    printArray ( nums );
    
    System.out.println ("Everything done in the same place. A good thing to do?");
    int[] total = makeTheWholeDraw ( DIFFERENT_NUMS_TO_DRAW, TOTAL_OF_NUMS_TO_DRAW );
    printArray ( total );
  }
  
  public static boolean allAreTheSame ( int[] n ) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for ( int i = n.length-1; i > 0; i-- ) {
      max = Math.max ( max, Math.max ( n[i], n[i-1] ));
      min = Math.min ( min, Math.min ( n[i], n[i-1] ));
      if ( max - min > MIN_MAX_DIFF_TO_STOP ) {
        //System.out.println ("Noup: " + min + " <--> " + max );  // Comment this for speed check.
        return false;
      }
    }
    System.out.println ("Yes!: " + min + " <--> " + max );
    return true;
  }
  
  /**
   * Updating the array (storage) which comes in as a parameter.
   * Very fast because only the address of the array is passed.
   * @param storage the array to be updated.
   * @param num the index of the array to be updated.
   */
  public static void updateMutable ( int[] storage, int num ) {
    // Can not make an if-clause because we don't know how many numbers we are chekcing.
    storage[num]++;
  }
  
  /**
   * No updating because some idiots say it is good programming
   * practice. First making a copy of the array, then updating the copy
   * and finally returning the copy to the caller.
   * @param storage the array to be updated.
   * @param num the index of the array to be updated.
   * @return the copy of the updated array.
   */
  public static int[] updateImmutable ( int[] storage, int num ) {
    int[] temp = (int[])storage.clone();
    temp[num]++;
    return temp;
  }
  
  public static int[] makeTheWholeDraw ( int differentNums, int totalOfNums ) {
    int[] nums = new int[differentNums];
    Random gen = new Random();
    for ( int i = 0; i < totalOfNums; i++ ) {
      int nmbr = gen.nextInt(differentNums);
      nums[nmbr]++;
    }
    return nums;
  }
  
  public static void printArray ( int[] nums ) {
    int i = 0;
    while ( i < nums.length ) {
      System.out.printf ("%3d = %3d\n", i, nums[i] );
      i++;
    }
  }
}
