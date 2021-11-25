/*
 * Kalle Kiviluoma - 2021
 */
package T18_24;

import java.util.Arrays;

public class T22 {

//  22  A Fibonacci number is calculated as the sum of the two previous Fibonacci
//        numbers, i.e. Fi = Fi-1 + Fi-2. The two first numbers are 0 and 1 and after
//        that the series continues as explained. Make a class to calculate any “nacci”
//        series. See  https://fi.wikipedia.org/wiki/Fibonaccin_lukujono, for details.
    
    public static void main(String[] args) {
        //n = How many previous numbers are summed
        //length = wanted length of the series
        //Program calulates any n-step fibonacci series
        final int n = 6;
        final int length = 20;
        AnyNacci an = new AnyNacci(n,length);
        AnyNacci.Name(n);
        System.out.println("nacci number: \n"+an);
    }
    
}
class AnyNacci{
    //Field parameter
    int [] series;

    //Constructor - Calls the calculator method when making the class to get the
    //Series immediately
    public AnyNacci(int n, int reqNumbers) {
        this.series = new int[reqNumbers];
        series = Calculator(n, reqNumbers);
    }

    @Override
    public String toString() {
        return Arrays.toString(series);
    }
    //Methods containing the formula to get wanted results
    public static int[] Calculator(int n, int numRequested){
        if (n < 2) {
            return new int[]{0};
        }
        return Calculator((n == 2) ? new int[] { 1, 1 } : Calculator(n - 1, n), numRequested);
    }
    public static int[] Calculator(int[] startingValues, int numRequested)
    { 
    int[] retVal = new int[numRequested];
    int n = startingValues.length;
    System.arraycopy(startingValues, 0, retVal, 0, n);
    for (int i = n; i < numRequested; i++)
      for (int j = 1; j <= n; j++)
        retVal[i] += retVal[i - j];
    return retVal;
    }
    //Method for outputting the correct name depending on the n-value
    public static void Name(int n){
        switch (n){
            case 2 -> System.out.print("Fibo");
            case 3 -> System.out.print("Tribo");
            case 4 -> System.out.print("Tetra");
            case 5 -> System.out.print("Penta");
            case 6 -> System.out.print("Hexa");
            case 7 -> System.out.print("Hepta");
            default -> System.out.print(n+"-Step fibo");
        }
    }
}