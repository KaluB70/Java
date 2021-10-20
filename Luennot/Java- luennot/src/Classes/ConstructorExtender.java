package Classes;

public class ConstructorExtender extends Constructor {
  public ConstructorExtender () {
  }
  
  @Override
  public void setDefaults () {
    System.out.println("setDefaults in ConstructorExtender.");
  }
  
  public static void main ( String[] args ) {
    Constructor a = new Constructor();
    ConstructorExtender al = new ConstructorExtender();
    System.out.println ("Check with debugger.");
  }
}
