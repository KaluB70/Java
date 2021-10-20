package InterfacesAndShit;

public interface InterfaceBase {
  public static final int SOME_CONSTANT = 100;  // It is always public static final so you can omit the modifiers.
  public void absi();  // It is always public so you can omit the public modifier.
  public default String deffis11 () {
    return "This method is appended afterwards not to break any old code.";
  }
  public default String deffis12 () {
    return "This method...";
  }
  public default String deffis13 () {
    return "This method...";
  }
  public static String staatis () {
    return "Interface Base";
  }
}
