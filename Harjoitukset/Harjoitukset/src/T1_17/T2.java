package T1_17;

public class T2 {

    public static void main(String[] args) {
        NonDivisibleNumbers(1, 71);
    }
    static void NonDivisibleNumbers(int n, int m){
        for (int i = n; i <= m; i++) {
            if (i % 7 != 0 || i % 17 != 0) {
                System.out.print(i + " ");
            }
        }
    }
    
}
