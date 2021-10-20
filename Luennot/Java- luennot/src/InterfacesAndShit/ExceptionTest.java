package InterfacesAndShit;

import java.io.FileNotFoundException;
import java.io.FileReader;

class Test {
  FileReader f;
  String fileName;
  public Test ( String f ) {
    fileName = f;
  }
  public void open1 () throws FileNotFoundException {
    if ( f == null )
      f = new FileReader ( fileName );
  }
  public void open2 () {
    if ( f == null ) {
      try {
        f = new FileReader ( fileName );
      }
      catch ( FileNotFoundException fnfe ) {
        System.out.println ("Did not find the file Java2.java.");
        // Make something to get to problem disappear.
      }
    }
  }
  public void open3 () throws FileNotFoundException {
    if ( f == null )
      f = new FileReader ( fileName );
  }
}

public class ExceptionTest {
  public static void main ( String[] args ) throws FileNotFoundException {
    
    // Handled in caller.    
    Test t1 = new Test ("Java1.java");
    try {
      t1.open1();
    }
    catch ( FileNotFoundException fnfe ) {
      System.out.println ("Did not find the file Java1.java.");
    }

    // Handled where the error happens.
    Test t2 = new Test ("Java2.java");
    t2.open2();

    // Not handled, the program crashes.
    Test t3 = new Test ("Java3.java");
    t3.open3();
  }
}
