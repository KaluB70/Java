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
/*
class Times implements Comparable {
  public int st;
  public int et;
  public Times ( int st, int et ) {
    this.st = st;
    this.et = et;
  }

  // Must always be implemented when implementing equals.
  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals ( Object o ) {
    return false;
  }

  // Must always be implemented when using ordered collections.
  @Override
  public int compareTo ( Object t ) {
    return 0;
  }
}

class TimesOrderedByEndTime implements Comparator {
  @Override
  public int compare ( Object o1, Object o2 ) {
    return 0;
  }
}
*/

public class Work {
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
    // Check with debugger or print the data.
  }
}
