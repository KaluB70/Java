package Basics;

public class BuiltIns {
  public static void main ( String[] args ) {

    System.out.println ("Overflow of a byte variable: ");
    byte b = 120;
    for ( int temp = 0; temp < 10; temp++ )
      System.out.println ( b++ );
    
    System.out.println ("\nLoosing information after a type cast:");
    int i = 128;
    b = (byte)i;
    System.out.println ( i + " " + b );
    
    System.out.println ("\nA char can be converted to a numeric value. But what do you get out of it?");
    char c = 'a';
    for ( int temp = 0; temp < 10; temp++, c++ )
      System.out.println ((int)c + " " + c );
    
    System.out.println ("\nGetting the characters one by one from a string:");
    String s = "Java on loistava kieli.";
    for ( int temp = 0; temp < s.length(); temp++ )
      System.out.println ( s.charAt ( temp ));
    System.out.println ();
    
  }
}
