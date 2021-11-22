package concurrent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Somebody I don't remember but this is NOT my code.
 * 
 * Works a bit peculiar time to time but I have no time to check why.
 */

class Data {
    private String packet;
     
    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;
  
    public synchronized void send ( String packet ) {
        System.out.println ("Trying to send: " + packet );
        while ( !transfer ) {
            try { 
                wait();  // Until notify called from some other thread.
            } catch ( InterruptedException e )  {
                Thread.currentThread().interrupt(); 
                System.out.println ("Thread interrupted"); 
            }
        }
        transfer = false;
         
        this.packet = packet;
        notify();
    }
  
    public synchronized String receive() {
        System.out.println ("Trying to receive: " + packet );
        while ( transfer ) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                System.out.println ("Thread interrupted"); 
            }
        }
        transfer = true;
 
        notify();
        return packet;
    }
}

class Sender implements Runnable {
    private Data data;

    Sender ( Data data ) {
      this.data = data;
    }
  
    @Override
    public void run() {
        String packets[] = {
          "First packet",
          "Second packet",
          "Third packet",
          "Fourth packet",
          "End"
        };
  
        for ( String packet : packets ) {
            data.send(packet);
 
            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                System.out.println ("Thread interrupted"); 
            }
            System.out.println("Sent: " + packet );
        }
    }
}

class Receiver implements Runnable {
    private Data load;

    Receiver ( Data data ) {
      this.load = data;
    }
  
    @Override
    public void run() {
        for ( String receivedMessage = load.receive();
          !"End".equals ( receivedMessage );
          receivedMessage = load.receive()) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println ("Thread interrupted"); 
            }
            System.out.println("Handled: " + receivedMessage );
        }
    }
}

public class Ex2 {
  public static void main ( String[] args ) {
    // This is how to handle two threads sequentaly.    
    Data data = new Data();
    Thread sender = new Thread ( new Sender ( data ));
    Thread receiver = new Thread ( new Receiver ( data ));
    sender.start();
    receiver.start();
    
    
  }
}
