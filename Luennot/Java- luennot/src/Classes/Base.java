package Classes;

public class Base {
  public int pub;     // Meant to be accessed from anywhere.
  int pack;           // Package access. I use it as private should be used.
  protected int pro;  // Access from all descendants.
  private int pri;    // Only this class can access. I use it as totally private - not even getters and setters are provided.
  
  public Base () {
    pub = 0;
    pack = 1;
    pro = 2;
    pri = 3;
  }
  
  public void doPub () {
    System.out.println ("doPub in Base.");
  }
  void doPack () {
    System.out.println ("doPack in Base.");
  }
  protected void doPro () {
    System.out.println ("doPro in Base.");
  }
  private void doPri () {
    System.out.println ("doPri in Base.");
  }
} 

