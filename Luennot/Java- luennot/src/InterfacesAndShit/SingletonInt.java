package InterfacesAndShit;

/*
My second oldest example!
*/
class Singleton {
  /*
  A class variable. We have prevented the user to instantiate more
  than one object.
  */
  private static Singleton si = null;

  private int x; // Just for example use.

  /*  
  The keyword private prevents the implementation of this class.
  Because it is the only constructor it also prevents the
  extending of this class. This means that this class
  must be implemented from inside the class!
  */
  private Singleton () {}
  
  public void setX ( int xx ) {
    x = xx;
  }
  public int getX () {
    return x;
  }
  
  /* 
  This method is used to instantiate this class.
  When called for the first time it makes the object.
  After that it only returns the object instantiated
  in the first call.
  */
  public static Singleton getInstance() {
    if ( si == null ) si = new Singleton();
    return si;
  }
}

public class SingletonInt {
  public static void main ( String[] args ) {
    //Singleton sint = new Singleton(); // Ei onnistu.
    Singleton sint = Singleton.getInstance();
    Singleton s2int = Singleton.getInstance();
    sint.setX ( 10 );
    s2int.setX ( 20 );
    System.out.println ( sint.getX());
    System.out.println ( s2int.getX());
    System.out.println ( sint == s2int ); // Totta tietysti
  }
}


