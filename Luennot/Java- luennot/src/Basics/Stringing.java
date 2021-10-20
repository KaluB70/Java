package Basics;


public class Stringing {
  public static void main ( String[] args ) {
    String s = "Jesus is coming";
    print ( s );
    String ss = ", take cover.";
    print ( ss );

    String sConcatSs = s.concat ( ss );    
    print ( sConcatSs );
    
    print ("" + s.endsWith("ing"));
    print ("" + s.endsWith("in"));
    
    print ("" + s.hashCode());
    print ("" + ss.hashCode());
    print ("" + sConcatSs.hashCode());
    
    char[] cs = s.toCharArray();
    for ( char c : cs )
      print ("" + c );
    
    /*
    Omaan luokkaan tulee:
      - concat
      - indexOf
      - join
      - repeat
      - replace
      - substring
      - toCharArray
    */
  }
  
  public static void print ( String s ) {
    System.out.println ( s );
  }
}
