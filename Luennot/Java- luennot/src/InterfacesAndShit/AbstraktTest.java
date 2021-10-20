package InterfacesAndShit;

/**
 * My oldest example!
 */

abstract class Shape {
  protected int x;  // NOTE: Allows the extending class to reference directly.
  protected int y;  // NOTE: Some references say that private properties are not inherited.
                    // Try make these private and check the debugger.
                    // The getters are for you to test it.
  public Shape ( int x, int y ) {
    this.x = x;
    this.y = y;
  }
  // If properties are private you got to use these two.
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  
  // Abstract because we don't know how to implement.
  public abstract double area();
  public abstract double perimeter();
}

class Circle extends Shape {
  int radius;
  public Circle ( int x, int y, int sade ) {
    super ( x, y );
    this.radius = sade; 
  }
  @Override
  public double area () {
    return Math.PI * radius * radius;
  }
  @Override
  public double perimeter () {
    return 2 * Math.PI * radius;
  }
}

class Square extends Shape {
  int x2;
  int y2;
  public Square ( int x1, int y1, int x2, int y2 ) { 
    super ( x1, y1 );
    this.x2 = x2; 
    this.y2 = y2; 
  }
  @Override
  public double area () {
    return (double)((x2-x)*(y2-y));
  }
  @Override
  public double perimeter () {
    return (double)(2 * ((x2-x)+(y2-y)));
  }
}

class AbstraktTest {
  public static void main ( String[] args ) {
    Circle y = new Circle ( 10, 10, 5 );
    System.out.println ("Circle area   = " + y.area());
    System.out.println ("Circle perimeter = " + y.perimeter());
    System.out.println ("---------------");
    
    Square n = new Square ( 10, 10, 20, 30 );
    System.out.println ("Square area   = " + n.area());
    System.out.println ("Square perimeter = " + n.perimeter());
    System.out.println ("---------------");
    
    // Polymorphism. An upper class (in the hierarchy) can reference a lower class (in the hierarchy).
    Shape m = y;
    System.out.println ("Shape area   = " + m.area());
    System.out.println ("Shape perimeter = " + m.perimeter());
    System.out.println ("---------------");

    m = n;
    System.out.println ("Shape area   = " + m.area());
    System.out.println ("Shape perimeter = " + m.perimeter());
    System.out.println ("---------------");
  }
}
