package InterfacesAndShit;


public interface InterfaceExtender extends InterfaceBase {
  
  public void absi2();  // Another abstract method the implementer must implement.
  
  // deffis11 ignored --> is inherited.
  
  @Override
  // deffis12 is abstract in this interface --> the implementer must implement.
  public String deffis12();
  
  @Override
  public default String deffis13 () {
    return "This interface overrides deffis13";
  }
  
  // Exactly like the one in InterfaceBase. No matter because private to the interface.
  public static String staatis () {
    return "Interface Extender";
  }
}
