package T1_17;

public class T3 {

    public static void main(String[] args) {
        int dividend = 70;
        
        for (int i = 1; i < dividend; i++) {
            if (dividend % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
