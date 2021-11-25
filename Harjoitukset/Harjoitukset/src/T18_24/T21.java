package T18_24;

import java.util.ArrayList;

public class T21 {

//    21.   The formula below can be used to calculate the Fibonacci numbers. We could 
//          mathematically prove that the formula is correct, but that is quite difficult, 
//          especially if you’re not a mathematician. Instead we can prove it works 
//          by coding a program to test the formula. Do that. The formula 
//          is copied from: https://fi.wikipedia.org/wiki/Fibonaccin_lukujono.
    
    public static void main(String[] args) {
        //Adding Fibonacci series with the length of the variable to 2 ArrayLists
        //1st list contains the series made by the formula provided (To be tested in the task)
        //2nd list contains the series made by recursive calculation proven to be right
        //Comparing the two lists:
        
        final int AMOUNT = 30;
        int [] arrFormula = FibonacciFormula(AMOUNT);
        int [] arrRecursive = FibonacciRecursive(AMOUNT);
        System.out.println("Formula <---> Recursive");
        boolean valid = true;
        for (int i = 0; i < arrFormula.length; i++) {
            System.out.println(arrFormula[i] + " <---> " + arrRecursive[i]);
            if (arrFormula[i] != arrRecursive[i]) {
                valid = false;
            }
        }
        if (valid) {
            System.out.println("Formula is valid");
        }
        else{
            System.out.println("Formula is invalid");
        }
    }
    public static int [] FibonacciRecursive(int n){
        int values[] = new int[n];
        for (int i = 0; i < n; i++) {
            switch (i) {
                case 0:
                    values[i] = 0;
                    break;
                case 1:
                    values[i] = 1;
                    break;
                default:
                    values[i] = Fib(i);
                    break;
            }
        }
        return values;
    }
    //Helper method for recursive calculation
    public static int Fib(int n){
        if (n<2) {
            return n;
        }
        return Fib(n-1) + Fib(n-2);
    }
    public static int [] FibonacciFormula(int n){
        int [] values = new int[n];
        for (int i = 0; i < n; i++) {
            double formula = Math.round(1/Math.sqrt(5)*GoldenRatioPlus(i) - GoldenRatioMinus(i));
            values[i] = formula >= 0 ? (int)formula : 0;
        }
        return values;
    }
    //Golden ratio ~1.61803
    private static double GoldenRatioPlus(int i){
        return Math.pow((1+Math.sqrt(5))/2, i);
    }
    private static double GoldenRatioMinus(int i){
        return Math.pow((1-Math.sqrt(5))/2, i);
    }
    
}