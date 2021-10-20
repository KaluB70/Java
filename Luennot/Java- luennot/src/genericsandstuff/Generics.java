package genericsandstuff;

import java.util.ArrayList;

/*
The term PECS stands for "Producer Extends, Consumer Super", which is an odd acronym coined by Joshua Block 
in his Effective Java book but provides a mnemonic on what to do. It means that if a parameterized type 
represents a producer, use extends. If it represents a consumer, use super. If the parameter is both, 
don’t use wildcards at all — the only type that satisfies both requirements is the explicit type itself.

    Use extends when you only get values out of a data structure.
    Use super when you only put values into a data structure.
    Use an explicit type when you plan to do both.

    My opinion: forget this shit and use only explicit types.

In many places on the internet you are told that you must fully understand generics to be able to
use lambda calculus with streams. This is really not true because Java is doing a lot of stuff
under the hood. The best way to learn things is by searching for specifics when you wonder how you
should use something.
*/

class A {
  int x;
  A ( int x ) { 
    this.x = x; 
  }
  int getX () { return x; }
  @Override
  public String toString () { return "A"+x; }
}

class B extends A {
  int y;
  B ( int x, int y ) { 
    super ( x );
    this.y = y; 
  }
  @Override
  public String toString () { return "B"+getX()+y; }
}

/*
Have to use a simple data structure, ArrayList. It is an array of dynamic nature.
*/
public class Generics {
  public static void main ( String[] args ) {
    ArrayList<A> aas = new ArrayList<>();
    aas.add ( new A(1));
    aas.add ( new A(2));
    aas.add ( new A(3));
    aas.add ( new A(4));
    ArrayList<B> bees = new ArrayList<>();
    bees.add ( new B(5,5));
    bees.add ( new B(6,6));
    bees.add ( new B(7,7));
    bees.add ( new B(8,8));
    
    System.out.println("Handling both lists with extends generic.");
    printList ( aas );
    printList ( bees );
    
    System.out.println("Trying the 'obvious' way.");  // Would not help to change the type parameter to B.
    printList2 ( aas );
    //printList2 ( bees );  // Does not work becuase printList2 excpects an ArrayList with instances of class A.
    
    // Maybe getting a bit confusing?
    System.out.println ("Putting all bees into aas because we can. Still works because ArrayList<A> can take in also class B. ");
    aas.addAll( bees );
    printList ( aas );
    printList2 ( aas );
    
    System.out.println ("Why does the 'normal' situation work?");
    A a = new A(10);
    B b = new B(20,20);
    printVar ( a );
    printVar ( b );
    
    // I am getting scared :).
    System.out.println ("Let's do some insertion to a list of class A or its descendants.");
    ArrayList<A> whatEver = new ArrayList<>();
    addToList ( whatEver );
    printList ( whatEver );
  }
  
  public static void printList ( ArrayList<? extends A> l ) {
    for ( A a : l ) {
      System.out.println ( a );
    }
  }
  public static void printList2 ( ArrayList<A> l ) {
    for ( A a : l ) {
      System.out.println ( a );
    }
  }
  public static void printVar ( A aorb ) {
    System.out.println ( aorb );
  }
  public static void addToList ( ArrayList<? super A> l ) {
    l.add ( new A(100));
    l.add ( new B(200,200));
  }
}
