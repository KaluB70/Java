package Classes2;

import Classes.Base;


public class BaseExtender extends Base {
  
  public BaseExtender () {
    pub = 0;     // Always accessible because pub is public.
    //pack = 1;  // No access because Base is in a different package.
    pro = 2;     // Accessible because BaseExtender extends Base (in which pro is defined).
    //pri = 3;   // No access because pri is private in Base.
  }
  @Override
  public void doPub () {
    System.out.println ("doPub in BaseExtender.");
  }
  void doPack () {
    System.out.println ("doPack in BaseExtender.");
  }
  @Override
  protected void doPro () {
    System.out.println ("doPro in BaseExtender.");
  }
  private void doPri () {
    System.out.println ("doPri in BaseExtender.");
  }
}
