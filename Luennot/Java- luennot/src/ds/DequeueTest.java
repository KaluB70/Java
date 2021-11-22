package ds;

import java.util.NoSuchElementException;

/**
* This is a simplified dequeue implementation.
* See java.util.Deque for a not so simple implementation.
*/
class IntDequeue {
  public final int MAX_SIZE;
  int[] deck;
  int endIndex;
  
  public IntDequeue ( int size ) {
    MAX_SIZE = size;
    deck = new int[MAX_SIZE];
    endIndex = -1;
  }

  public boolean offerFirst ( int v ) {
    if ( endIndex >= MAX_SIZE-1 ) return false;
    else {
      int[] temp = new int[MAX_SIZE];
      endIndex++;
      temp[0] = v;
      for ( int i = 1; i <= endIndex; i++ )
        temp[i] = deck[i-1];
      deck = temp;
      return true;
    }
  }
  public boolean offerLast ( int v ) {
    if ( endIndex >= MAX_SIZE-1 ) return false;
    else {
      deck[++endIndex] = v;
      return true;
    }
  }
  
  public int removeFirst() {
    if ( endIndex < 0 ) throw new NoSuchElementException ();
    int retVal = deck[0];
    int[] temp = new int[MAX_SIZE];
    for ( int i = 0; i < endIndex; i++ )
      temp[i] = deck[i+1];
    deck = temp;
    endIndex--;
    return retVal;
  }
  public int removeLast() {
    if ( endIndex < 0 ) throw new NoSuchElementException ();
    int retVal = deck[endIndex];
    endIndex--;
    return retVal;
  }

  public boolean empty () {
    return endIndex == -1;
  }

  public int size () {
    return endIndex+1;
  }
}


public class DequeueTest {
  public static void main ( String[] args ) {
    
    // Run it with the debugger.

    int testSize = 5;
    IntDequeue id = new IntDequeue( testSize );
    // Filling the Deque.
    for ( int i = 1; i <= testSize; i++ ) {
      if ( Math.random() > 0.5 )
        id.offerLast ( i );
      else
        id.offerFirst ( i );
    }
    
    System.out.println ("Success in trying to insert an element to a full deque: " + id.offerFirst(11));
    System.out.println ("Success in trying to insert an element to a full deque: " + id.offerLast(11));
    
    // Emptying it.
    for ( int i = 1; i <= testSize; i++ ) {
      if ( Math.random() > 0.5 )
        id.removeLast ();
      else
        id.removeFirst();
    }
    
    try {
      System.out.println ("Success in removing from an empty deque head: " + id.removeFirst());
    }
    catch ( NoSuchElementException nsee ) {
      System.out.println ("Deque empty - not able to remove from head.");
    }
    try {
      System.out.println ("Success in removing from an empty deque tail: " + id.removeLast());
    }
    catch ( NoSuchElementException nsee ) {
      System.out.println ("Deque empty - not able to remove from tail.");
    }
  }
}