package Classes;

public class Constructor {
  String forename;
  String lastname;
  int age;
  
  public Constructor ( String e, String s, int i ) {
    forename = e;
    lastname = s;
    age = i;
  }
  public Constructor ( String e, String s ) {
    this ( e, s, -1 );
  }  
  public Constructor ( int i ) {
    this ("", "", i );
  }
  
  /**
   * Very dangerous in Java.
   */
  public Constructor () {
    setDefaults();
  }
  
  public void setDefaults () {
    forename = "Pekka";
    lastname = "Puupää";
    age = 100;
    System.out.println("setDefaults in Constructor.");
  }
  
  public static void main ( String[] args ) {
    Constructor a1 = new Constructor ("Matti", "Meikäläinen", 45 );
    Constructor a2 = new Constructor ("Teijo", "Teikäläinen" );
    Constructor a3 = new Constructor ( 45 );

    // Check the debugger.
  }
}
