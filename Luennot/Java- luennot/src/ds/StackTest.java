package ds;

import java.util.EmptyStackException;

/**
 * This is a classic implementation of the stack. See java.util.Stack for
 * a different kind of implementation.
 */
class IntStack {
  public static int MAX_SIZE = 10;
  int[] stack;
  int index;
  public IntStack () {
    stack = new int[MAX_SIZE];
    index = -1;
  }

  public void push ( int intNum ) {
    if ( index < MAX_SIZE-1 )
      stack [++index] = intNum;
  }

  public int pop () throws EmptyStackException {
    if ( index < 0 ) throw new EmptyStackException();
    return stack[index--];
  }

  public boolean empty () {
    return index == -1;
  }

  public int size () {
    return index+1;
  }
}


public class StackTest {
  public static void main ( String[] args ) {

    IntStack is = new IntStack();
    System.out.println ("Size: " + is.size());
    System.out.println ("Empty: " + is.empty());
    is.push ( 3 );
    is.push ( 5 );
    is.push ( 9 );
    is.push ( 7 );
    System.out.println ("Size: " + is.size());
    System.out.println ("Empty: " + is.empty());
    System.out.println ("Pop: " + is.pop());
    System.out.println ("Pop: " + is.pop());
    System.out.println ("Size: " + is.size());
    System.out.println ("Pop: " + is.pop());
    System.out.println ("Pop: " + is.pop());
    System.out.println ("Empty: " + is.empty());
    System.out.println ("Size: " + is.size());
    System.out.println ("Pop: " + is.pop()); // Exception.
    
    for ( int i = 0; i < IntStack.MAX_SIZE+3; i++ ) {
      is.push(i);
      System.out.println ("Size: " + is.size());
    }
  }
}