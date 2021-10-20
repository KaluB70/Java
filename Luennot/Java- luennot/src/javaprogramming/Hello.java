package javaprogramming;

import java.util.Scanner;

public class Hello {
  public static void main ( String[] args ) {
    Scanner reader = new Scanner ( System.in );
    System.out.print ("Gimme your name: ");
    String name = reader.next();
    System.out.println ("Your name is probably: " + name );
  }
}
