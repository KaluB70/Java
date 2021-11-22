package smallexers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This class saves the starting and stopping time of a shift.
 */
class Times implements Comparable {
  public int st;
  public int et;
  public Times ( int st, int et ) {
    this.st = st;
    this.et = et;
  }

  /**
   * Must always be implemented when implementing equals.
   */
  @Override
  public int hashCode() {
    System.out.println ();
    int hash = 7;
    hash = 97 * hash + this.st;
    hash = 97 * hash + this.et;
    return hash;
  }

  /**
   * Must always be implemented when using collections that do not
   * allow duplicates.
   */
  @Override
  public boolean equals ( Object o ) {
    if ( o == this )
     return true;
    else if ( o == null ) return false;
    else if (!(o instanceof Times )) return false;
    else if (( st == ((Times)o).st ) && ( et == ((Times)o).et )) return true;
    else return false;
  }

  /**
   * Must always be implemented when using ordered collections.
   */
  @Override
  public int compareTo ( Object t ) {
    Times temp = (Times)t;
    if ( this.st < temp.st ) return -1;
    else if ( this.st > temp.st ) return 1;
    else {
      if ( this.et < temp.et ) return -1;
      else if ( this.et > temp.et ) return 1;
      else return 0;
    }
  }
}

class TimesOrderedByEndTime implements Comparator {
  @Override
  public int compare ( Object o1, Object o2 ) {
    Times t1 = (Times)o1;
    Times t2 = (Times)o2;
    if ( t1.et < t2.et ) return -1;
    else if ( t1.et > t2.et ) return 1;
    else {
      if ( t1.st < t2.st ) return -1;
      else if ( t1.st > t2.st ) return 1;
      else return 0;
    }
  }
}

public class Work_Answer {
  static final int TOKENS = 43;  // The amount of tokens there should be on one line.
  static final int DAYS = 21;    // The number of days.
  static final int DAY_OFF_MARKER = -1;
  
  public static void main ( String[] args ) throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader ( new InputStreamReader ( new FileInputStream("Duunit.txt"), "UTF-8" ));
    String line;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<int[]> st = new ArrayList<>();
    ArrayList<int[]> et = new ArrayList<>();
    while (( line = br.readLine()) != null ) {
      StringTokenizer sto = new StringTokenizer ( line, "\t");
      if ( sto.countTokens() == TOKENS ) {  // The read line is probably ok if the number of tokens is correct.
        name.add ( sto.nextToken());
        int[] nums = new int[DAYS];
        st.add ( nums );
        for ( int i = 0; i < DAYS; i++ ) {
          try {
            int token = Integer.parseInt ( sto.nextToken());
            nums[i] = token;
          }
          catch ( NumberFormatException nfe ) {
            nums[i] = DAY_OFF_MARKER;  // Counts for a day off.
          }
        }
        nums = new int[DAYS];
        et.add ( nums );
        for ( int i = 0; i < DAYS; i++ ) {
          try {
            int token = Integer.parseInt ( sto.nextToken());
            nums[i] = token;
          }
          catch ( NumberFormatException nfe ) {
            nums[i] = DAY_OFF_MARKER;
          }
        }
      }
      else {
        System.out.println ("The number of tokens do not match.");
        System.exit(0);
      }
    }
    br.close();
    
    // Making a TreeSet of the shifts. Check the ordering criteria in class Times, method compareTo.
    // This is just to get all the different shifts, which is usually very important.
    TreeSet<Times> allShifts = new TreeSet<>();
    
    // Making a TreeMap to count the number of different shifts. Ordering defined in Times by method compareTo.
    // This is usually even more important than enumerating all the shifts.
    TreeMap<Times, Integer> shiftOccurrences = new TreeMap<>();
    
    for ( int i = 0; i < name.size(); i++ ) {
      int[] start = st.get ( i );
      int[] stop = et.get ( i );
      for ( int j = 0; j < start.length; j++ ) {
        Times t = new Times ( start[j], stop[j] );
        allShifts.add ( t );
        if ( shiftOccurrences.containsKey ( t ))
          shiftOccurrences.put ( t, shiftOccurrences.get ( t ) + 1 );
        else
          shiftOccurrences.put ( t, 1 );
      }
    }
    
    System.out.println ("All different shifts:");
    int cntr = 0;
    for ( Times t : allShifts ) {
      System.out.printf ("%3d %4d %4d\n", ++cntr, t.st, t.et );
    }
    System.out.println ();
    
    // Ordered by starting time.
    System.out.println ("All different shifts and the number of their occurrences:");
    cntr = 0;
    Set<Times> allKeys = shiftOccurrences.keySet();
    for ( Times temp : allKeys ) {
      int value = shiftOccurrences.get ( temp );
      System.out.printf ("%3d %5d %4d %4d\n", ++cntr, temp.st, temp.et, value );
    }
    System.out.println ();
    
    System.out.println ("Same as previous but ordered by stopping time:");
    TreeMap<Times, Integer> shiftOccurrences2 = new TreeMap<>( new TimesOrderedByEndTime());
    shiftOccurrences2.putAll ( shiftOccurrences );
    cntr = 0;
    for ( Map.Entry<Times,Integer> temp : shiftOccurrences2.entrySet()) {
      System.out.printf ("%3d %5d %4d %4d\n", ++cntr, temp.getKey().st, temp.getKey().et, temp.getValue());
    }
    System.out.println ();
    
    System.out.println ("Checking and printing longest streaks/stints or what ever you want to call them:");
    TreeMap<String, ArrayList<Integer>> workStints = new TreeMap<>();
    for ( int i = 0; i < name.size(); i++ ) {
      ArrayList<Integer> stints = new ArrayList();
      workStints.put ( name.get ( i ), stints );
      System.out.printf ("%5s: ", name.get ( i ));
      int[] start = st.get ( i );
      int len = 0;
      for ( int j = 0; j < start.length; j++ ) {
        if ( start[j] != DAY_OFF_MARKER ) {  // If not day off, stint continues.
          len++;
          if ( j == start.length-1 ) {  // If in the last day, the stint ends.
            //System.out.printf ("%2d", len );
            stints.add ( len );
          }
        }
        else {
          if ( len > 0 ) {
            //System.out.printf ("%2d", len );
            stints.add ( len );
            len = 0;
          }
        }
      }
      System.out.println ();
    }
    System.out.println ();
    
    System.out.println ("Printing the saved longest stints:");
    Set<String> keys = workStints.keySet();
    for ( String key : keys ) {
      System.out.printf ("%4s %s\n", key, Arrays.toString ( workStints.get ( key ).toArray()));
    }
  }
}
