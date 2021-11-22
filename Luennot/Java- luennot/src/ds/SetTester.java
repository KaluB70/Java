package ds;

/** If speed is important use HashSet. 
  * If order is more important use TreeSet.
  *
  * Compared to Lists the Sets are always faster in non-index based search
  */

import java.util.*;

public class SetTester {
  public static void main ( String[] args ) {

    int ROUNDS = 10000000;
    boolean treeSetTest = false; // true = testing TreeSet, false = testing HashSet.

    Set<Integer> ts;

    if ( treeSetTest )
      ts = new TreeSet<>();
    else
      ts = new HashSet<>();
    Integer[] nums = makeAndShuffle ( ROUNDS );
    TimeCounter tc1 = new TimeCounter();
    System.out.println ("Doing the adding...");
    tc1.start();
    for ( int i = 0; i < nums.length; i++ )
      ts.add ( nums[i] );
    tc1.stop();

    TimeCounter tc2 = new TimeCounter();
    System.out.println ("Doing the searching...");
    tc2.start();
    for ( int i = 0; i < nums.length; i++ )
      ts.contains ( nums[i] );
    tc2.stop();

    TimeCounter tc3 = new TimeCounter();
    System.out.println ("Doing the removing...");
    tc3.start();
    for ( int i = 0; i < nums.length; i++ )
      ts.remove ( nums[i] );
    tc3.stop();

    System.out.println ("Adding    : " + tc1 );
    System.out.println ("Searching : " + tc2 );
    System.out.println ("Removing  : " + tc3 );
  }

  public static Integer[] makeAndShuffle ( int size ) {
    Integer[] nums = new Integer[size];
    
    // Nums 0 to size-1.
    for ( int i = 0; i < size; i++ ) nums[i] = i;
    
    // Shuffling.
    for ( int i = 0; i < size / 2; i++ ) {
      int f = (int)(Math.random()*size);
      int s = (int)(Math.random()*size);
      Integer temp = nums[f];
      nums[f] = nums[s];
      nums[s] = temp;
    }
    return nums;
  }
}