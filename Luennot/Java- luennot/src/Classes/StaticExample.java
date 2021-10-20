package Classes;

public class StaticExample {
  int x;
  static int y = 0;
  static int[] arr = new int[5];
  
  // Static initialization block.
  static {
    for ( int i = 0; i < 5; i++ )
      arr[i] = i+1;
  }
  public StaticExample ( int x ) {
    this.x = x;
    // No idea to set a static variable in the constructor.
  }
  int getX () { return x; }
  static int getY () { return y; }
  
  static int[] getArr() { return arr; }
  static void printArr () {
    for ( int i = 0; i < 5; i++ )
      System.out.println ((i+1) + ". --> " + arr[i] );
  }
  
  void setX ( int x ) { this.x = x; }
  // Cannot reference this.y = y, because can be used without the object.
  static void setY ( int yy ) { y = yy; }
 
  
  Object couldBeAnyType = new Object ();

    public static void main ( String[] args ) {
    
    //Object cbat = couldBeAnyType;    // Why is not working?
    
    // Making two objects and checking the values of the properties.
    // Direct references to properties are not allowed in real life.
    StaticExample se1 = new StaticExample ( 100 );
    StaticExample se2 = new StaticExample ( 200 );
    System.out.println ( se1.x );
    System.out.println ( se2.x );
    System.out.println ( StaticExample.y );
    System.out.println ("----------------");
    
    
    se1.setX ( 101 );
    StaticExample.setY ( 10 );
    System.out.println ( se1.x );
    System.out.println ( se2.x );
    System.out.println ( se1.y );  // Just to make it clear that property y is shared among the objects.
    System.out.println ( se2.y );
    System.out.println ("----------------");
    
    // Once again: references to memory areas.
    StaticExample.printArr();
    System.out.println ("----------------");
    int[] t = StaticExample.getArr();
    t[2] = 300;
    t[4] = 500;
    StaticExample.printArr();
    System.out.println ("----------------");

    // The class Math has a lot of static methdos...
    System.out.println ( Math.abs ( -56 )); // 56
    System.out.println ( Math.pow ( 2, 8 ));  // 256
    System.out.println ( Math.max(Math.min(12,3),Math.min(14,7))); // 7
  }
}
