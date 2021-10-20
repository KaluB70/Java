package InterfacesAndShit;

public class InterfaceUser {
  public static void main ( String[] args ) {
    InterfaceImplementerBase iib = new InterfaceImplementerBase();
    //iib  // Remove the comment and put a dot after iib and you see what iib contains.
    InterfaceImplementerExtender iie = new InterfaceImplementerExtender();
    //iie
    //InterfaceImplementerBase
    //InterfaceImplementerExtender
    //InterfaceBase
    InterfaceExtender.staatis();
  }
}
