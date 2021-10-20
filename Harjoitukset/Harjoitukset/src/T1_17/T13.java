package T1_17;
import java.util.Random;

public class T13 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] numArr = new int[100];
        for (int i = 0; i < 100; i++) {
            numArr[i] = rnd.nextInt(1,101);
        }
        
        FindLower(numArr, 5);
        
    }
    public static void FindLower(int[] arr, int max){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= max) {
                System.out.println(String.format("Value of %s in the array at index %d", arr[i], i));
            }
        }
    }
    
}
