package concurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The idea is to have many of these worker threads.
 */
class WorkerThread implements Runnable {
  
  // This is the data the thread is building.
  StringBuilder info;
  
  public WorkerThread () {
    info = new StringBuilder();
  }
  
  public void run () {
    // Building the data = a random number between 0-9.
    info.append ( ThreadLocalRandom.current().nextInt ( 0, 10 ));
    int sleepTime = ThreadLocalRandom.current().nextInt ( 1000, 20000 );
    System.out.println ( info.toString() + " : " + Thread.currentThread().getName() + " " + sleepTime );
    try {
      Thread.sleep ( sleepTime );
    } 
    catch (InterruptedException ex) {
      System.out.println ("Interrupt.");
    }
  }
}

// This presents the handler-thread. This is used for gathering the information from the worker-threads.
public class Updater {
  static final int THREADS = 3;
  static final int ROUNDS = 3;
  public static void main ( String[] args ) throws InterruptedException, ExecutionException {
    ExecutorService es = Executors.newFixedThreadPool ( THREADS );  // Population size as parameter.
    ArrayList<Future<?>> futures = new ArrayList<>();  // Future<?> stands for any type implementing the Future-interface.
    
    // Making the threads to be executed.
    WorkerThread[] vv = new WorkerThread[THREADS];
    for ( int i = 0; i < THREADS; vv[i] = new WorkerThread(), i++ ) ;

    // The outcome of the threads is gathered to this StringBuilder.
    StringBuilder result = new StringBuilder();
    for ( int i = 0; i < ROUNDS; i++ ) {
      for ( int j = 0; j < THREADS; j++ ) {
        futures.add ( es.submit ( vv[j] ));  // Submits the Runnable for execution and starts it.
      }

      // For checking the running time.      
      long st = System.currentTimeMillis();

      // Waiting until ready.
      for ( Future<?> f : futures ) {
        f.get();  // Always return null because Runnables run-method does not return anything. Waits for the thread to complete. See also isDone.
        System.out.println ("Thread " + f.toString() + " ready.");
      }
      futures.clear();  // Delete the future-instances from the ArrayList.
      long et = System.currentTimeMillis();
      long time = et - st;
      System.out.printf ("Running the threads took: %6.2f seconds.\n", time/(double)1000 );
      
      // Checking the results now that the threads are all done.
      int smallest = Integer.MAX_VALUE;
      for ( WorkerThread v : vv ) {
        int val = Character.getNumericValue ( v.info.charAt ( v.info.length()-1 ));
        if ( val < smallest ) smallest = val;
      }
      result.append ( smallest );
      System.out.println ("Result: " + result.toString() + "\n");
    }
    es.shutdown();  // Stop (shut down) the thread pool.
  }
}
