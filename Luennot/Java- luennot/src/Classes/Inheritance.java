package Classes;

class SuperClass {
  private int x;
  public SuperClass ( int x ) {
    this.x = x;
  }
  public int getX () {
    return x;
  }
  public int powerOfTwo () {
    return x*x;
  }
  public String toString() {
    return ""+x;
  }
}

class SubClass extends SuperClass {
  int y;
  public SubClass ( int x, int y ) {
    super ( x );
    this.y = y;
  }
  public int getY () {
    return y;
  }
  @Override
  public int powerOfTwo () {
    return getX()*getX() + y*y;
  }
  @Override
  public String toString () {
    return super.toString()+y;
  }
  // Overload
  public String toString ( String info ) {
    return info + toString();
  }
}

public class Inheritance {
  public static void main ( String[] args ) {
    SuperClass sup = new SuperClass ( 5 );
    System.out.println ( sup.powerOfTwo());
    System.out.println ( sup.toString());

    SubClass sub = new SubClass ( 7, 8 );
    System.out.println ( sub.powerOfTwo());
    System.out.println ( sub.toString());
    System.out.println ( sub.toString("Infoa pukataan: "));
  }
}
