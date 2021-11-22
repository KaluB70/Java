package concurrent;

class Counter {
  int count = 0;
  
  // Remove synchronized and try. What happens and why?
  public synchronized void add ( int toAdd ) {
    this.count += toAdd;
  }
  public void print () {
    System.out.println ( count );
  }
}

class CounterThread extends Thread {
  private Counter counter = null;
  public CounterThread ( Counter counter ) {
    this.counter = counter;
  }
  @Override
  public void run() {
    for ( int i = 1; i <=10; i++ ) {
      counter.add ( i );
      System.out.print ("Addded " + i + " and i is now: " + Thread.currentThread());
      counter.print();
      try {
        Thread.sleep ( 100 );
      } catch (InterruptedException ex) {
        System.out.println ("Interrupt.");
      }
    }
  }
}

public class Ex1 {
  public static void main(String[] args) {
    
    // Making an object of Counter to be shared with two different threads.
    Counter counter = new Counter();
    
    // Making the threads. Note that the Counter-class object in shared between the threads.
    Thread  threadA = new CounterThread ( counter );
    Thread  threadB = new CounterThread ( counter );

    // Starting the threads.
    threadA.start();
    threadB.start(); 
  }
}
