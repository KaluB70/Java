package genericsandstuff;

/**
 * The example is almost copied from: https://www.oracle.com/technetwork/articles/java/juneau-generics-2255374.html
 */

class ObjectContainer {
  private Object obj;
  public ObjectContainer ( Object obj ) { this.obj = obj; }
  public Object getObj() { return obj; }
  public void setObj ( Object obj ) { this.obj = obj; }
}

class GenericContainer<T> {
  private T obj;
  public GenericContainer ( T t ){ obj = t; }
  public T getObj() { return obj; }
  public void setObj ( T t ) { obj = t; }
}

public class Usages {
  public static void main ( String[] args ) {
    ObjectContainer oc1 = new ObjectContainer( 1 );  // Automatic int to Integer.
    System.out.println ( oc1.getObj());
    System.out.println (((Integer)oc1.getObj()).floatValue());  // Must use type cast because Object has no floatValue method.

    ObjectContainer oc2 = new ObjectContainer("Joopasen joo");
    System.out.println ( oc2.getObj());
    System.out.println (((String)oc2.getObj()).substring(1,3));  // Object has no substring method.

    ObjectContainer oc3 = new ObjectContainer( new A ( 17 ));
    System.out.println ( oc3.getObj());
    System.out.println (((A)oc3.getObj()).getX());
    
    GenericContainer<Integer> gc2 = new GenericContainer<> ( 2 );
    System.out.println ( gc2.getObj());
    
    // Why does not work?
    //System.out.println ( gc2.floatValue());
    
    // The ObjectContainer needs an explicit type cast.
    // The GenericContainer only needs the knowledge of what is in it.
    // What is the big difference?
    Integer oc2i = (Integer)oc1.getObj();
    Integer gc2i = gc2.getObj();
    
    // You can put anything into an ObjectContainer, which is not usually a good thing.
    ObjectContainer ocAll = new ObjectContainer ("Merkkijono");
    ocAll.setObj ( 2 );
    ocAll.setObj ( new A ( 20 ));
    
    // You can put only the type specified into a GenericContainer.
    GenericContainer<String> gcNotAll = new GenericContainer<>("Merkkijono");
    //gcNotAll.setObj ( 2 );
    //gcNotAll.setObj ( new A ( 20 ));
    

    /*
    So, is the type parameter a good thing? It is but on the other hand - who imbecile would put different type
    of data into the same structure? It would be like digging blood from your nose with a kuokka.
    
    See https://docs.oracle.com/javase/tutorial/java/generics/erasure.html to see how everything really works :).
    */    
  }
}
