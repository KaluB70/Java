package ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
  * No speed testing here because you don't choose maps for their speed.
  * You use maps when you need a key-value pair.
  * 
  * Introducing only how to construct a simple map.
  */
public class MapTester {
  public static void main ( String[] args ) {
    
    // Four different kind of maps.
    // See switch for details.
    int i = 0;
    Map<String, Set<Integer>> theMap;
    Set<Integer> theSet;
    switch ( i ) {
      case 0 : {  // Switch rule (->) Vaatii vähintään version 14.
        theMap = new HashMap();
        theSet = new HashSet();
        break;
      }
      case 1 : {
        theMap = new HashMap();
        theSet = new TreeSet();
        break;
      }
      case 2 : {
        theMap = new TreeMap();
        theSet = new HashSet();
        break;
      }
      case 3 : {
        theMap = new TreeMap();
        theSet = new TreeSet();
        break;
      }
      // Must have default because otherwise the variables might not be initialized.
      default : {
        theMap = new HashMap();
        theSet = new HashSet();
      }
    }
    
    String[] keys = {"abc","adgs","asjkdh","ajkh","asho","easjk"};
    int[] vals = {2000,400,600000,3,10000,50};
    for ( String key : keys ) {
      for ( int value : vals ) {
        if ( theMap.containsKey ( key )) {
          Set<Integer> s = theMap.get ( key );
          s.add ( value );
        }
        else {
          theSet.add ( value );
          theMap.put ( key, theSet );
        }
      }
    }
    System.out.println();
    
    Set<String> theKeys = theMap.keySet();
    for ( String key : theKeys ) {
      System.out.print ( key + ": ");
      Set<Integer> theVals = theMap.get ( key );
      
      Integer[] nums = new Integer[theVals.size()];
      System.out.println ( Arrays.toString ( theVals.toArray( nums )));
    }
  }
}
