package ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;


class TimeCounterComparatorDescending implements Comparator<TimeCounter> {
  @Override
  public int compare ( TimeCounter tc1, TimeCounter tc2 ) {
    if ((( tc1.s > 0 ) && ( tc1.e >= tc1.s )) && 
        (( tc2.s > 0 ) && ( tc2.e >= tc2.s ))) {
      long diffTc1 = tc1.e - tc1.s;
      long diffTc2 = tc2.e - tc2.s;
      if ( diffTc1 > diffTc2 ) return -1;
      else if ( diffTc1 < diffTc2 ) return 1;
      else return 0;
    }
    else return 0;
  }
}

class TimeCounterComparatorStart implements Comparator<TimeCounter> {
  @Override
  public int compare ( TimeCounter tc1, TimeCounter tc2 ) {
    if (  tc1.s > tc2.s ) return 1;
    else if ( tc1.s < tc2.s ) return -1;
    else return 0;
  }
}



public class DS_Testing {
  final static int NUM = 10;
  static Random gen = new Random(100);
  public static void main ( String[] args ) throws InterruptedException {
    
    TimeCounter[] t = new TimeCounter[NUM];
    
    ArrayList<TimeCounter> al = new ArrayList<>();
    LinkedList<TimeCounter> ll = new LinkedList<>();
    HashSet<TimeCounter> hs = new HashSet<>();
    
    // A TreeSet must always have a comparer. Do not be confused with the fact that some classes
    // have default ones.
    TreeSet<TimeCounter> ts = new TreeSet<>( new TimeCounterComparatorDescending());
    
     //Creating all objects.
    for ( int i = 0; i < NUM; i++ ) {
      System.out.println ("Running round: " + ( i+1 ));
      TimeCounter tc = new TimeCounter ();
      tc.start();
      int sleepTime = ThreadLocalRandom.current().nextInt ( 500, 3000 );
      Thread.sleep ( sleepTime );
      tc.stop();
      t[i] = tc;
      al.add ( tc );
      ll.add ( tc );
      hs.add ( tc );
      ts.add ( tc );  // Poista konstruktorista Comparator niin näet mitä tapahtuu.
    }
    System.out.println ();
    
    
    // Lets go through all the data structures with different methods.
    System.out.println ("ArrayList and TimeCounter-array. They are the same - surprise.");
    for ( int i = 0; i < al.size(); i++ )
      System.out.println ( al.get ( i ) + " : " + t[i] );
    System.out.println ("--------------------------------------------------");
    
    // You can fetch things from a LinkedList with indexes, but here we'll use enhanced for.
    System.out.println ("LinkedList with enhanced for.");
    for ( TimeCounter time : ll )
      System.out.println ( time );
    System.out.println ("--------------------------------------------------");

    System.out.println ("HashSet is in no special order.");
    for ( TimeCounter time : hs )
      System.out.println ( time );
    System.out.println ("--------------------------------------------------");
    
    System.out.println ("TreeSet is in the order defined with a comparator. Using Iterator.");
    Iterator<TimeCounter> it = ts.iterator();
    while ( it.hasNext())
      System.out.println ( it.next());
    System.out.println ("--------------------------------------------------");
    System.out.println ("TreeSet with enhanced for.");
    for ( TimeCounter time : ts )
      System.out.println ( time );
    System.out.println ("--------------------------------------------------");

    // Lets order all collections.
    TimeCounterComparatorDescending tccd = new TimeCounterComparatorDescending();
    Collections.sort ( al, tccd );  // Sorting al with the help of tccd.
    Collections.sort ( ll, tccd );
    System.out.println ("ArrayList and LinkedList ordered:");
    for ( int i = 0; i < al.size(); i++ ) {
      System.out.println ( al.get ( i ) + " : " + ll.get(i));
    }
    System.out.println ("--------------------------------------------------");
    
    // Lets use another comparator.
    TimeCounterComparatorStart tcs = new TimeCounterComparatorStart();
    TreeSet<TimeCounter> sortedHash = new TreeSet<> ( tcs );
    sortedHash.addAll ( hs );
    System.out.println ("TreeSet made out of the HashSet with a different comparator.");
    for ( TimeCounter temp : sortedHash ) {
      System.out.println ( temp.getStart());
    }
    System.out.println ("--------------------------------------------------");
    
    // Lets play with references cause we haven't for a while. What happens?
    System.out.println ( t[3] );
    t[3].start();
    t[3].stop();
    System.out.println ("TreeSet is in order... or is it and why");
    it = ts.iterator();
    while ( it.hasNext())
      System.out.println ( it.next());
    System.out.println ("--------------------------------------------------");
    
    // Printing the ArrayList just to check that it has also changed.
    for ( int i = 0; i < al.size(); i++ )
      System.out.println ( al.get ( i ));
    System.out.println ("--------------------------------------------------");
    
    
  }
}
