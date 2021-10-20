package Classes;

public class ClockTime {
  private int hour;
  private int minute;
  public ClockTime ( int h, int m ) {
    hour = h;
    minute = m;
    System.out.println ("Allocating");
  }
  public void setTime ( int h, int m ) {
    hour = h;
    minute = m;
  }
  public int getHour () { return hour; }
  public int getMinute () { return minute;}
  
  public static void main ( String... args ) {
    ClockTime ct = new ClockTime ( 13, 42 );
    System.out.println ( ct.getHour() + ":" + ct.getMinute());
    
    ct.setTime ( 14, 15 );
    System.out.println ( ct.getHour() + ":" + ct.getMinute());
  }
}
