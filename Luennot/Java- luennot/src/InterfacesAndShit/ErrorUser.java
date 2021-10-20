package InterfacesAndShit;

public class ErrorUser {
  public static void main ( String[] args ) {
    int[] a = {1,2,3,4,5};
    int[] f = {3,2,4,5,3};
    RMSE mse = new RMSE();
    System.out.println ( mse.getError ( a, f ));
    Abs abs = new Abs();
    System.out.println ( abs.getError ( a, f ));
    
    Error e = new RMSE();
    System.out.println ( e.getError ( a, f ));
    e = new Abs();
    System.out.println ( e.getError ( a, f ));
  }
}
