package Classes;

public class Statics {
  int[] observations;
  
  public Statics ( int[] o ) {
    observations = o;
  }
  
  // These next two moethods do the same thing. It is a matter of opinion which one is the better approach.
  public int nmbrOfDiffs ( Statics comps ) {
    int diffs = 0;
    for ( int i = 0; i < observations.length; i++ ) {
      if ( this.observations[i] != comps.observations[i] )
        diffs++;
    }
    return diffs;
  }
  public static int nmbrOfDiffs ( Statics p1, Statics p2 ) {
    int diffs = 0;
    for ( int i = 0; i < p1.observations.length; i++ ) {
      if ( p1.observations[i] != p2.observations[i] )
        diffs++;
    }
    return diffs;
  }
  
  // At some point you need a method to just do someting with an int-array.
  // In this case removing all numbers passed in as a parameter.
  // This is not dependant on the object of this class but on an int-array.
  public static int[] removeInts ( int[] arr, int toBeRemoved ) {
    int[] retVal = new int[arr.length-howManyOfInt ( arr, toBeRemoved )];
    int index = 0;
    for ( int i : arr ) {
      if ( i != toBeRemoved ) {
        retVal[index] = i;
        index++;
      }
    }
    return retVal;
  }
  
  // This is used as as a helper method. Therefore it is private.
  private static int howManyOfInt ( int[] arr, int toCheck ) {
    int cnt = 0;
    for ( int i : arr )
      if ( i == toCheck ) cnt++;
    return cnt;
  }
  
  public static void main ( String[] args ) {
    
    /**
     * You could use static methods when you want to do some computations based on two objects.
     * Use the one you think is more clear. Both are ok.
     */
    int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
    Statics s1 = new Statics ( arr1 );
    int[] arr2 = {1,2,4,3,6,5,7,8,10,9};
    Statics s2 = new Statics ( arr2 );
    System.out.println ( s1.nmbrOfDiffs ( s2 ));
    System.out.println ( Statics.nmbrOfDiffs ( s1, s2 ));
    
    int[] someVals = {6,1,6,2,6,3,6,4,6,5,6,6,6,6,6};
    int[] removed6 = Statics.removeInts ( someVals, 6 );
    System.out.println ("Check with debugger.");
  }
}
