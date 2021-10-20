package Classes2;

import Classes.Base;

public class BaseUser {
  public static void main ( String[] args ) {
    
    // Because Base is in a different package we can only access the publics.
    Base b = new Base ();
    b.doPub();
    //b.doPro();
    //b.doPack();
    //b.doPri();
    
    // Because BaseExtender is in the same package, we can access all but the privates.
    BaseExtender be = new BaseExtender();
    be.doPub();
    be.doPack();
    be.doPro();
    //be.doPri();
  }
}
