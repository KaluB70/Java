package concurrent;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CommonDuunari implements Runnable {
  StringBuilder info;
  static Random gen = new Random();
  int sleepTime;
  CommonMem shared;  // We use this object for synchronization. Every instance of CommonDuunari must get the same instance of CommonMem.
                     // So it is not static anymore but a common, mutable, data block.
  
  public CommonDuunari ( CommonMem cm ) {
    info = new StringBuilder();
    shared = cm;
  }
  
  public void run () {
    System.out.println ("Before sync: " + shared.index + " " + Thread.currentThread().getName());

    // Because we save the value of the updated index in CommonMem in a local variable --> everything works like clockwork.
    int index = shared.update();
    
    System.out.println ("After sync : " + shared.index + " " + Thread.currentThread().getName());
    info.append ( gen.nextInt ( 10 ));
    System.out.println ("After info : " + shared.index + " " + Thread.currentThread().getName());
    sleepTime = CommonMem.WAIT_TIME[index]*1000;
    System.out.println ("After slee : " + shared.index + " " + Thread.currentThread().getName());
    System.out.println ( info.toString() + " : " + Thread.currentThread().getName() + " " + sleepTime + " --> " + index  + " <--");
    System.out.println ("After prin : " + shared.index + " " + Thread.currentThread().getName());
    try {
      System.out.println ("Before sleep: " + shared.index + " " + Thread.currentThread().getName());
      Thread.sleep ( sleepTime );
      System.out.println ("After sleep: " + shared.index + " " + Thread.currentThread().getName());
    } 
    catch (InterruptedException ex) {
      System.out.println ("Interrupted.");
    }
  }
}

public class CommonMemTest {
  public static void main ( String[] args ) throws InterruptedException, ExecutionException {
    ExecutorService es = Executors.newFixedThreadPool ( 3 );
    ArrayList<Future<?>> futures = new ArrayList<>();
    
    // Only one instance of the CommonMem class. So the threads share it.
    CommonMem cm = new CommonMem();
    CommonDuunari[] vv = new CommonDuunari[3];
    vv[0] = new CommonDuunari (cm);
    vv[1] = new CommonDuunari (cm);
    vv[2] = new CommonDuunari (cm);

    for ( int i = 0; i < 3; i++ ) {
      while ( true ) {
        System.out.println ("\nStarting the threads...");
        for ( int j = 0; j < 3; j++ ) {
          System.out.println ("Adding " + j );
          futures.add ( es.submit ( vv[j] ));
          System.out.println ("Added " + j );
        }
        Thread.sleep ( 1000 );  // Just to give time to the sub threads.
        System.out.println ( vv[0].sleepTime + " " + vv[1].sleepTime + " " + vv[2].sleepTime );
        if (!(( vv[0].sleepTime != vv[1].sleepTime ) && ( vv[0].sleepTime != vv[2].sleepTime ) && ( vv[1].sleepTime != vv[2].sleepTime )))
          System.exit(0);
        else {
          for ( Future<?> f : futures ) {
            f.get();  // Always return null because Runnables run-method does not return anything. Odottaa, että säie lopettaa toimintansa.
            System.out.println ("Thread " + f.toString() + " ready.");
          }
          futures.clear();
        }
      }
    }
  }
}
