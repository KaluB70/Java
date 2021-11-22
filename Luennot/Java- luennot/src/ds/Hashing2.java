package ds;

import java.util.HashSet;

class MyInt2 {
  int num;
  public MyInt2 ( int n ) { num = n; }

  @Override
  public boolean equals ( Object o ) {
    System.out.println ("In equals");
    if ( this == o ) return true;
    else if ( o == null) return false;
    if (!(o instanceof MyInt2)) return false;
    MyInt2 o1 = (MyInt2) o;
    return this.num == o1.num;
  }
  
  @Override
  /**
   * Try comment this and reckon that the equals method is not working.
   * In fact, it does not even get called.
   * 
   * When you run the program you see that hashCode method
   * gets called first. If the hashCode returns the same value
   * for two objects it means they are equal.
   * 
   * The hashCode of Object checks if the objects have
   * the same "memory address". And that is why every distinct
   * object is different from all other objects, despite
   * what they include in their properties.
   */
  public int hashCode () {
    System.out.println ("In hashCode " + num*13 );
    return num * 13; // Objects with same values return the same value == they equal.
  }
}

public class Hashing2 {
  public static void main ( String[] args ) {
    HashSet<MyInt2> hs = new HashSet<>();
    MyInt2 ol1 = new MyInt2 ( 2 );
    MyInt2 ol2 = new MyInt2 ( 2 );
    hs.add ( ol1 );
    hs.add ( ol2 );
    System.out.println ();  // Debug.

    /*    
    HashSet<Integer> hs2 = new HashSet<>();
    hs2.add ( 2 );
    hs2.add ( 2 );
    System.out.println ();  // Debug.
    */
  }
}
