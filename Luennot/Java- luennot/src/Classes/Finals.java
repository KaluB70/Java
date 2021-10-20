package Classes;

class FinalsUsed {
  public final int X = 10;
  public static final int Y = 20;
  public final int XX;
  private static final int YY;
  private static final int[] arr = {1,2,3};
  
  static {
    YY = 0;
  }
  
  public FinalsUsed ( int initOfX ) {
    XX = initOfX;
  }
  public void printAll () {
    System.out.println (" X: " + X );
    System.out.println (" Y: " + Y );
    System.out.println ("XX: " + XX );
    System.out.println ("YY: " + YY );
    System.out.println ("a0: " + arr[0] );
    System.out.println ("a1: " + arr[1] );
    System.out.println ("a2: " + arr[2] );
  }
  public static void setAll () {
    /*
    X = 100;
    Y = 200;
    XX = 300;
    YY = 400;
    */
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;
    //arr = new int[3];
  }
}

public class Finals {
  public static void main ( String[] args ) {
    FinalsUsed fu1 = new FinalsUsed ( 1 );
    FinalsUsed fu2 = new FinalsUsed ( 2 );
    //System.out.println ( FinalsUsed.X ); //Not working, why?
    System.out.println ( FinalsUsed.Y );
    System.out.println ("fu1:");
    fu1.printAll();
    System.out.println ("fu2:");
    fu2.printAll();
    
    FinalsUsed.setAll();
    fu1.printAll();
  }
}
