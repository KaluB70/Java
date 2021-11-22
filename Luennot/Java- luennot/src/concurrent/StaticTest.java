package concurrent;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This example is meant to be presented on lecture. So, only a few comments.
 * The example is demonstrating the usage of mutable static variables and how to use locks with them.
 * I am using the Runnable interface but you should also check out the Callable interface.
 */

class StaticDuunariBad implements Runnable {
  StringBuilder info;  // This is the data we are collecting in the threads. I don't use it here at all.
  static Random gen = new Random();
  volatile static int indexToWT = 0;  // volatile = do not put this in cache memory. How does this work on a server with many prosessors and cores???
  int sleepTime;
  
  public StaticDuunariBad () {
    info = new StringBuilder();
  }
  
  public void run () {
    info.append ( gen.nextInt ( 10 ));

    // When access to static variables are synchronized you use the Class-object of your loaded class.
    // Every thread should get a different indexToWT value so they would all sleep for a different amount of time.
    synchronized ( StaticDuunariBad.class ) {  
      System.out.println ("Inside sync A: " + indexToWT + " " + Thread.currentThread().getName());
      if ( indexToWT == 2 ) indexToWT = 0;
      else indexToWT++;
      System.out.println ("Inside sync B: " + indexToWT + " " + Thread.currentThread().getName());
    }
    
    System.out.println ("After sync  A: " + indexToWT + " " + Thread.currentThread().getName());
    
    // All threads can get the same value because...
    sleepTime = CommonMem.WAIT_TIME[indexToWT]*CommonMem.COEFF;
    System.out.println ("After sync  B: " + indexToWT + " " + Thread.currentThread().getName());
    System.out.println ( info.toString() + " : " + Thread.currentThread().getName() + " " + sleepTime + " " + " " + indexToWT );
    System.out.println ("After sync  C: " + indexToWT + " " + Thread.currentThread().getName());
    try {
      System.out.println ("In try      A: " + indexToWT + " " + Thread.currentThread().getName());
      Thread.sleep ( sleepTime );
      System.out.println ("In try      B: " + indexToWT + " " + Thread.currentThread().getName());
    } 
    catch (InterruptedException ex) {
      System.out.println ("Interrupted.");
    }
  }
}

/**
 * This class only differs in the length of the synchronized block.
 */
class StaticDuunariGood implements Runnable {
  StringBuilder info;
  static Random gen = new Random();
  volatile static int indexToWT = 0;
  int sleepTime;
  
  public StaticDuunariGood () {
    info = new StringBuilder();
  }
  
  @Override
  public void run () {
    info.append ( gen.nextInt ( 10 ));
    
    // This works better because we synchronize enough of the code. How do we know how much we should synchronize? 
    // You should not synchronize too much either.
    synchronized ( StaticDuunariGood.class ) {
      System.out.println ("Inside sync A: " + indexToWT + " " + Thread.currentThread().getName());
      if ( indexToWT == 2 ) indexToWT = 0;
      else indexToWT++;
      System.out.println ("Inside sync B: " + indexToWT + " " + Thread.currentThread().getName());
      System.out.println ("After sync  A: " + indexToWT + " " + Thread.currentThread().getName());
      sleepTime = CommonMem.WAIT_TIME[indexToWT]*CommonMem.COEFF;
      System.out.println ("After sync  B: " + indexToWT + " " + Thread.currentThread().getName());
      System.out.println ( info.toString() + " : " + Thread.currentThread().getName() + " " + sleepTime + " " + " " + indexToWT );
      System.out.println ("After sync  C: " + indexToWT + " " + Thread.currentThread().getName());
    }
    
    try {
      System.out.println ("In try      A: " + indexToWT + " " + Thread.currentThread().getName());
      Thread.sleep ( sleepTime );
      System.out.println ("In try      B: " + indexToWT + " " + Thread.currentThread().getName());
    } 
    catch (InterruptedException ex) {
      System.out.println ("Interrupted.");
    }
  }
}

/**
 * This class uses a local variable to store the updated value of the shared variable. 
 * Perfect - at least with this version. What if it would have been a huge object?
 */
class StaticDuunariBest implements Runnable {
  StringBuilder info;
  static Random gen = new Random();
  volatile static int indexToWT = 0;
  int sleepTime;
  
  public StaticDuunariBest () {
    info = new StringBuilder();
  }
  
  public void run () {
    info.append ( gen.nextInt ( 10 ));

    // Local variable to store the value of the shared variable.
    int indexInLocal;  
    
    synchronized ( StaticDuunariGood.class ) {
      System.out.println ("Inside sync A: " + indexToWT + " " + Thread.currentThread().getName());
      if ( indexToWT == 2 ) indexToWT = 0;
      else indexToWT++;
      indexInLocal = indexToWT;
      System.out.println ("Inside sync B: " + indexToWT + " " + Thread.currentThread().getName());
    }
    System.out.println ("After sync  A: " + indexToWT + " " + Thread.currentThread().getName());
    sleepTime = CommonMem.WAIT_TIME[indexInLocal]*CommonMem.COEFF;
    System.out.println ("After sync  B: " + indexToWT + " " + Thread.currentThread().getName());
    System.out.println ( info.toString() + " : " + Thread.currentThread().getName() + " " + sleepTime + " " + " " + indexInLocal );
    System.out.println ("After sync  C: " + indexToWT + " " + Thread.currentThread().getName());
    try {
      System.out.println ("In try      A: " + indexToWT + " " + Thread.currentThread().getName());
      Thread.sleep ( sleepTime );
      System.out.println ("In try      B: " + indexToWT + " " + Thread.currentThread().getName());
  } 
  catch (InterruptedException ex) {
      System.out.println ("Interrupted.");
    }
  }
}

public class StaticTest {
  public static void main ( String[] args ) throws InterruptedException, ExecutionException {
    ExecutorService es = Executors.newFixedThreadPool ( 3 );  // Population of three.
    ArrayList<Future<?>> futures = new ArrayList<>();         // Needing the return value to check for completion.
    
    /*
    StaticDuunariBad[] vv = new StaticDuunariBad[3];
    vv[0] = new StaticDuunariBad ();
    vv[1] = new StaticDuunariBad ();
    vv[2] = new StaticDuunariBad ();
    */

    ///*
    StaticDuunariGood[] vv = new StaticDuunariGood[3];
    vv[0] = new StaticDuunariGood ();
    vv[1] = new StaticDuunariGood ();
    vv[2] = new StaticDuunariGood ();
    //*/

    /*
    StaticDuunariBest[] vv = new StaticDuunariBest[3];
    vv[0] = new StaticDuunariBest ();
    vv[1] = new StaticDuunariBest ();
    vv[2] = new StaticDuunariBest ();
    */

    StringBuilder result = new StringBuilder();
    for ( int i = 0; i < 3; i++ ) {
      while ( true ) {
        System.out.println ("\nStarting the threads...");
        for ( int j = 0; j < 3; j++ ) {
          System.out.println ("Adding " + j );
          futures.add ( es.submit ( vv[j] ));  // Submits the Runnable for execution and starts it.
          System.out.println ("Added " + j );
        }
        for ( Future<?> f : futures ) {
          f.get();  // Always return null because Runnables run-method does not return anything. Waits for the thread to complete. See also isDone.
        }

        //Thread.sleep ( 1000 );  // Giving some time to the threads so that the second line from this does not end the program. Try to remove this and see what happens.
        System.out.println ("The main threads shows the sleeping times: " + vv[0].sleepTime + " " + vv[1].sleepTime + " " + vv[2].sleepTime );
        if (!(( vv[0].sleepTime != vv[1].sleepTime ) && ( vv[0].sleepTime != vv[2].sleepTime ) && ( vv[1].sleepTime != vv[2].sleepTime )))
          System.exit(0);
        else {
          futures.clear();
        }
      }
    }
  }
}
