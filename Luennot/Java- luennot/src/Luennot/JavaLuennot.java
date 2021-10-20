/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Luennot;

import java.util.Scanner;
/**
 *
 * @author Kalle
 */
public class JavaLuennot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello Java!");
        Scanner reader = new Scanner (System.in);
        System.out.print("Gimme your name: ");
        String name = reader.next();
        System.out.println("Your name is probably " + name);
    }
    
}
