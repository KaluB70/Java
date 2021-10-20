package Basics;

/**
 * A class with four int variables.
 */
class Simple {
  int a;
  int b;
  int c;
  int d;
  public void set ( int a, int b, int c, int d ) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }
  public void print () {
    System.out.println ("a: " + a + ", b: " + b + ", c: " + c + ", d: " + d );
  }
}

/**
 * This class can be cloned which is implied by "implements Cloneable".
 * Cloning is used here only for showing what happens when Java makes copies.
 * This class includes an array - which is an Object in Java. Remember that!
 */
class Dynamic implements Cloneable {
  int[] dynamicArray;
  public Dynamic ( int size ) {
    dynamicArray = new int[size];  // Creating an array of wanted size in constructor.
  }
  public void setSize ( int size ) {
    dynamicArray = new int[size];  // When setting the size of the dynamic array everything is lost!!!
  }
  public void setDynamicArray () {
    for ( int i = 0; i < dynamicArray.length; i++ )
      dynamicArray[i] = i;
  }
  public void printDynamicArray () {
    for ( int i = 0; i < dynamicArray.length; i++ )
      System.out.print ( dynamicArray[i] + ",");
    System.out.println ();
  }
  public void printAddress() {
    System.out.println ( dynamicArray.toString());  // The IDE warns about this but screw it. 
                                                    // The IDE thinks we want to output the content of the array.
  }
  // A very simple cloner. It only calls the clone method of the super class, Object.
  // This is NOT usually the thing you wan't to happen.
  @Override
  public Object clone () throws CloneNotSupportedException {
    return super.clone();
  }
}

public class AddressBasics {
  public static void main ( String[] args ) throws CloneNotSupportedException {
    System.out.println ("\nPlaying with addresses:");
    Simple simple1 = new Simple();
    System.out.print ("  simple1 address: " + simple1 );
    System.out.print (" | simple1 contains: " ); simple1.print();
    Simple simple2 = new Simple();
    System.out.print ("  simple2 address: " + simple2 );
    System.out.print (" | simple2 contains: " ); simple2.print();
    
    simple1.set ( 1, 2, 3, 4 );
    simple2.set ( 5, 6, 7, 8 );
    System.out.print ("  simple1 contains: " ); simple1.print();
    System.out.print ("  simple2 contains: " ); simple2.print();
    System.out.println ("  The addresses of simple1 and simple2 are the same: " + ( simple1 == simple2 ));
    
    System.out.println ("\nSo far so good. Now it's get complicated.");
    Simple simple3 = simple1;
    System.out.print ("  simple3 address: " + simple3 );
    System.out.print (" | simple3 contains: " ); simple3.print();
    System.out.println ("  The addresses of simple1 and simple 3 are the same: " + ( simple1 == simple3 ));
    
    System.out.println ("\nHandling the same memory area affects the same memory area :)");
    simple3.set ( 10, 20, 30, 40 );
    System.out.print ("  simple1 address: " + simple1 );
    System.out.print (" | simple1 contains: " ); simple1.print();
    System.out.print ("  simple3 address: " + simple3 );
    System.out.print (" | simple3 contains: " ); simple3.print();
    
    System.out.println ("\nObjects in objects...");
    Dynamic d = new Dynamic ( 2 );
    System.out.println ("  The address of our Dynamic variable: " + d );
    System.out.print ("  The address of the dynamic array in our Dynamic variable: ");
    d.printAddress();
    d.setSize(4);  // This call resets the dynamic variable in the class Dynamic.
    System.out.println ("  The address of our Dynamic variable: " + d );
    System.out.print ("  The address of the dynamic array in our Dynamic variable: ");
    d.printAddress();
    
    System.out.println ("\nJava makes a copy of the builtin types but NOT the objects. The objects are only shallow copied.");
    Dynamic dd = new Dynamic(10);
    Dynamic ddClone = (Dynamic)dd.clone();
    System.out.println ("  The address of our Dynamic variable dd: " + dd );
    System.out.print ("  The address of the dynamic array in our Dynamic dd variable: ");
    dd.printAddress();
    System.out.println ("  The address of our Dynamic variable ddClone: " + ddClone );
    System.out.print ("  The address of the dynamic array in our Dynamic ddClone variable: ");
    ddClone.printAddress();
    
    System.out.println ("\nSee what happens when setting the values inside the object:");
    dd.setDynamicArray();
    dd.printDynamicArray();
    ddClone.printDynamicArray();
    
    
  }
}
