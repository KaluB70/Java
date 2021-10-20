package InterfacesAndShit;

public class RMSE implements Error {
  @Override
  public double getError ( int[] actual, int[] forecast ) {
    double sum = 0;
    for ( int i = 0; i < actual.length; i++ ) {
      sum += Math.pow ( actual[i] - forecast[i], 2 );
    }
    return Math.sqrt ( sum /(actual.length-1) );
  }
}
