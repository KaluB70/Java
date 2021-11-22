package concurrent;

public class CommonMem {
  static final int COEFF = 1000;
  static final int[] WAIT_TIME = {1,2,3};
  int index = 0;
  public synchronized int update() {
    System.out.println ("In update");
    if ( index == 2 ) index = 0;
    else index++;
    return index;
  }
}
