package ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * LinkedList should be chosen if insertions to the beginning of
 * the list are important. The LinkedList is always very fast
 * in such operations and not dependent of the size of the list.
 * 
 * ArrayList is a better choice for all the other cases. You can increase
 * the size of an ArrayList as much as you want and it will still
 * be very fast in index search. And that happens to be the most important
 * operation of any list.
 */

public class ListTester {
  public static void main ( String[] args ) {

    final int ROUNDS = 100000;
    boolean arrListTest = true; //  true = testing ArrayList, false = testing LinkedList.

    TimeCounter tcWhole = new TimeCounter();
    tcWhole.start();
    TimeCounter tc = new TimeCounter();

    /*** TEST 1: Adding/Removing from beginning of list. ***/
    tc.start();
    List<Integer> coll1;
    if ( arrListTest )
      coll1 = new ArrayList<>();
    else
      coll1 = new LinkedList<>();
    for ( int i = 0; i < ROUNDS; i++ )
      coll1.add ( 0, i );
    tc.stop();
    System.out.println ("Adding to beginning         : " + tc );
    tc.start();
    for ( int i = ROUNDS-1; i >= 0;  i-- )
      coll1.remove ( 0 );
    tc.stop();
    System.out.println ("Removing from beginning     : " + tc );

    /*** TEST 2: Adding/Removing from end of list.  ***/
    tc.start();
    List<Integer> coll2;
    if ( arrListTest )
      coll2 = new ArrayList<>();
    else
      coll2 = new LinkedList<>();
    for ( int i = 0; i < ROUNDS; i++ )
      coll2.add ( i );
    tc.stop();
    System.out.println ("Adding to end               : " + tc );
    tc.start();
    for ( int i = ROUNDS-1; i >= 0;  i-- )
      coll2.remove ( i );
    tc.stop();
    System.out.println ("Removing from end           : " + tc );

    /*
    Making the insertion places random. The array p holds the insertion places
    and array nums the numbers to be inserted The nums must all be different nums
    to be able to check the search.
    */
    int[] p = new int[ROUNDS];
    p[0] = 0;
    Integer[] nums = new Integer[ROUNDS];
    nums[0] = 0;
    Random r = new Random ();
    for ( int i = 1; i < ROUNDS; i++ ) {
      nums[i] = i;
      p[i] = r.nextInt(i);  // The insertion place can not be farther away than the length of the array so far.
    }

    /*** TESTI 3: Insertion to a random place, searching and removing. ***/
    tc.start();
    List<Integer> coll3;
    if ( arrListTest )
      coll3 = new ArrayList<>();
    else
      coll3 = new LinkedList<>();

    for ( int i = 0; i < ROUNDS; i++ )
      coll3.add ( p[i], i );
    tc.stop();
    System.out.println ("Adding to a random place    : " + tc );

    // Reckon that we search for every single number.
    tc.start();
    for ( int i = 0; i < ROUNDS; i++ )
      coll3.contains ( nums[i] );
    tc.stop();
    System.out.println ("Search for a random number  : " + tc );
    
    // Indeksihaku.
    tc.start();
    for ( int i = 0; i < ROUNDS; i++ )
      coll3.get ( i );
    tc.stop();
    System.out.println ("Index search                : " + tc );

    tc.start();
    for ( int i = ROUNDS-1; i >= 0;  i-- )
      coll3.remove ( p[i] );
    tc.stop();
    System.out.println ("Removing from a random place: " + tc );

    tcWhole.stop();
    System.out.println ("The whole program           : " + tcWhole );
  }
}