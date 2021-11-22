package ds;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This is a very simple class to measure time elapsed.
 * I have also used it to present the function of data structures.
 * 
 */
public class TimeCounter implements Comparable<TimeCounter> {
  long s;
  long e;
  public TimeCounter () {
    s = 0;
    e = 0;
  }
  public void start () {
    s = System.currentTimeMillis();
  }
  public void stop () {
    e = System.currentTimeMillis();
  }
  public long getStart () {
    return s;
  }
  @Override
  public String toString () {
    if (( s > 0 ) && ( e >= s )) {
      long diff = e - s;
      return String.format("%6.2f", diff / (double)1000);
    }
    else return "Pösilö";
      
  }
  @Override
  // Ordering the shorter time elapsed before the longer time elapsed.
  // Can only make one comparer with Comparable.
  public int compareTo ( TimeCounter para ) {
    if ((( s > 0 ) && ( e >= s )) && 
        (( para.s > 0 ) && ( para.e >= para.s ))) {
      long diffThis = e - s;
      long diffPara = para.e - para.s;
      if ( diffThis > diffPara ) return 1;
      else if ( diffThis < diffPara ) return -1;
      else return 0;
    }
    else return 0;
  }

  // Just to test that it works properly.
  // Added some comparing stuff.
  public static void main ( String... args ) throws InterruptedException {
    final int OBJECTS = 10;
    TimeCounter[] tc = new TimeCounter[OBJECTS];
    for ( int i = 0; i < OBJECTS; i++ ) {
      System.out.println ("Running round: " + ( i+1 ));
      tc[i] = new TimeCounter ();
      tc[i].start();
      int sleepTime = ThreadLocalRandom.current().nextInt ( 500, 3000 );
      Thread.sleep ( sleepTime );
      tc[i].stop();
    }
    System.out.println ("Not sorted:");
    for ( int i = 0; i < OBJECTS; i++ )
      System.out.println ( tc[i] );
    Arrays.sort ( tc );
    System.out.println ("Sorted:");
    for ( int i = 0; i < OBJECTS; i++ )
      System.out.println ( tc[i] );
  }

}
