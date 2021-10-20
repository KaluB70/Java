package InterfacesAndShit;

public class Abs implements Error {

  @Override
  public double getError ( int[] actual, int[] forecast ) {
    double sum = 0;
    for ( int i = 0; i < actual.length; i++ ) {
      sum += Math.abs ( actual[i] - forecast[i] );
    }
    return sum/actual.length;
  }  
}
