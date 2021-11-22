package ds;

import java.util.HashSet;

class MyInt {
  int num;
  public MyInt ( int n ) { num = n; }
}

public class Hashing {
  public static void main ( String[] args ) {
    HashSet<MyInt> hs = new HashSet<>();
    MyInt ol1 = new MyInt ( 2 );
    MyInt ol2 = new MyInt ( 2 );
    hs.add ( ol1 );
    hs.add ( ol2 );  // Why do these both get inserted to the HashSet?
    System.out.println ();  // Debug.
    hs.add ( ol1 );
    hs.add ( ol2 );  // Why do these not get inserted?
    
    HashSet<Integer> hs2 = new HashSet<>();
    hs2.add ( 2 );
    hs2.add ( 2 );  // Why do only one of these get inserted to the HashSet?
    System.out.println ();
  }
}
