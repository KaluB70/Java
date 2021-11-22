package ds;

import java.util.EnumMap;

/**
 * Typical enum usage. We know all the constants.
 */
enum StaticJobTypes {
  A, I, Y, V;
  
  public boolean isBefore ( StaticJobTypes jt ) {
    return this.ordinal() < jt.ordinal();
  }
}

/**
 * The idea of this enum is to be able to map job types to constants. We only
 * need one class, so this is a singleton. The only constructing method is setMappings
 * which throws an Exception if one tries to make more than one mapping.
 * 
 * Because this is a singleton all variables are static.
 */
enum DynamicJobTypes {
  J1, J2, J3, J4, J5, J6;  // You need to know the upper bound of the mappings (constants).
  
  private static int NMBR_OF_USED_VALUES = 0;
  private static final EnumMap<DynamicJobTypes, String> mappings = new EnumMap<> ( DynamicJobTypes.class );
  
  public static void setMappings ( String[] shiftsInOrder ) throws IllegalStateException {
    if ( NMBR_OF_USED_VALUES > 0 ) throw new IllegalStateException ("Already set!");  // This makes it a singleton.
    else {
      DynamicJobTypes[] djt = DynamicJobTypes.values();
      for ( int i = 0; i < shiftsInOrder.length; i++ )
        mappings.put( djt[i], shiftsInOrder[i] );
      NMBR_OF_USED_VALUES = shiftsInOrder.length;
    }
  }
  
  public static DynamicJobTypes getTypeFromString ( String s ) {
    for ( DynamicJobTypes djt : DynamicJobTypes.values()) {
      String  retVal = mappings.get ( djt );
      if (( retVal != null ) && ( retVal.equals( s )))
        return djt;
    }
    return null;
  }
}

public class EnumMapping {
  public static void main ( String[] args ) {
    
    // Peruskäyttö.
    StaticJobTypes jtA = StaticJobTypes.A;
    StaticJobTypes jtI = StaticJobTypes.I;
    StaticJobTypes jtY = StaticJobTypes.Y;
    StaticJobTypes jtV = StaticJobTypes.V;
    
    System.out.println ( jtA + " is before " + jtI + ": " + jtA.isBefore ( jtI ));
    System.out.println ( jtV + " is before " + jtY + ": " + jtV.isBefore ( jtY ));
    
    if ( jtI == StaticJobTypes.I )
      System.out.println ("The type is I");
    else
      System.out.println ("The type is not I but " + jtI );

    if ( jtA == StaticJobTypes.V )
      System.out.println ("The type is V");
    else
      System.out.println ("The type is not V but " + jtA );
    
    // Vähän monimutkaisempi käyttö.
    String[] s = {"A","I","Y","V"};
    DynamicJobTypes.setMappings ( s );  // Debug!
    System.out.println ();
    
    try {
      DynamicJobTypes.setMappings ( s ); // Not working because the class is a singleton.
    }
    catch ( IllegalStateException ise ) {
      System.out.println ("You have already set the types.");
    }
    
    // The search takes a while but after it you can use the variable as a normal enum. Handy?
    DynamicJobTypes check = DynamicJobTypes.getTypeFromString ("A");
    System.out.println ( check );
    check = DynamicJobTypes.getTypeFromString ("Y");
    System.out.println ( check );
    check = DynamicJobTypes.getTypeFromString ("R");
    System.out.println ( check );
  }
}
