/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ExtraTask;

/**
 *
 * @author Kalle
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int days = 2;
        int days2 = 67;
        int m = 7;
        days -= days2;
        m -= Math.ceil((double)Math.abs(days)/30);
        System.out.println(m);
    }
    
}
