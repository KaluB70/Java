package T1_17;

import static T1_17.T14.DynamicArray.increaseSizeOfArray;
import java.util.Random;

public class T14 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arrPos = new int[0];
        int[] arrNeg = new int[0];
        for (int i = 0; i < 100; i++) {
            int num = rnd.nextInt(-50,51);
            if (num >= 0) {
                if (i < arrPos.length) {
                    arrPos[i]=num;
                }
                else{
                    arrPos=increaseSizeOfArray(arrPos);
                    arrPos[arrPos.length-1] = num;
                }
            }
            else{
                if (i < arrNeg.length) {
                    arrNeg[i]=num;
                }
                else{
                    arrNeg = increaseSizeOfArray(arrNeg);
                    arrNeg[arrNeg.length-1] = num;
                }
            }
        }
        System.out.println("Count of positive integers in first array (including 0): " + arrPos.length);
        System.out.println("Count of negative integers in second array: " + arrNeg.length);
        
    }
    public class DynamicArray {
        static int []increaseSizeOfArray(int []arr){
            int []arr2=new int[(arr.length+1)];
            for (int i = 0; i < arr.length; i++) {
            arr2[i]=arr[i];     
            }
            return arr2;
        }
    }
}
