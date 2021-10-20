package Basics;

public class MoreMethods {
  public static void main ( String[] args ) {
    
    /**
     * First we will search for a character three times without using a method.
     */
    char findChar = 'o';
    String txt = "Hello World";
    int count=0;
    for ( int i = 0; i!= ( txt.length()); i++ ) {
      if ( txt.charAt(i) == findChar ) {
        count++;
      }
    }
    System.out.println ("Char '" + findChar + "' found in \"" + txt + "\" " + count + " times.");
    
    findChar = 'a';
    txt = "Who is general failure and why is he reading my disk.";
    count=0;
    for ( int i = 0; i!= ( txt.length()); i++ ) {
      if ( txt.charAt(i) == findChar ) {
        count++;
      }
    }
    System.out.println ("Char '" + findChar + "' found in \"" + txt + "\" " + count + " times.");
    
    findChar = 'e';
    txt = "Jesus saves, but Teemu gets the rebound and scores.";
    count=0;
    for ( int i = 0; i!= ( txt.length()); i++ ) {
      if ( txt.charAt(i) == findChar ) {
        count++;
      }
    }
    System.out.println ("Char '" + findChar + "' found in \"" + txt + "\" " + count + " times.");
    /**************************************************************************************************/
    /**
     * Then we will make the same thing using a method.
     */
    findChar = 'o';
    txt = "Hello World";
    count = searchForChar ( txt, findChar );
    System.out.println ("Char '" + findChar + "' found in \"" + txt + "\" " + count + " times.");
    
    findChar = 'a';
    txt = "Who is general failure and why is he reading my disk.";
    count = searchForChar ( txt, findChar );
    System.out.println ("Char '" + findChar + "' found in \"" + txt + "\" " + count + " times.");

    findChar = 'e';
    txt = "Jesus saves, but Teemu gets the rebound and scores.";
    count = searchForChar ( txt, findChar );
    System.out.println ("Char '" + findChar + "' found in \"" + txt + "\" " + count + " times.");
    
    // Just to remind - we don't need to save the return value if we don't need it later.
    System.out.println ( searchForChar ("Hello World", 'o'));
  }
  
  public static int searchForChar ( String fromTxt, char charToFind ) {
    int count=0;
    for ( int i = 0; i < fromTxt.length(); i++ ) {
      if ( fromTxt.charAt(i) == charToFind ) {
        count++;
      }
    }
    return count;
  }
}
