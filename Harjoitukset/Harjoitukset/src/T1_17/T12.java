package T1_17;
import java.util.Arrays;

public class T12 {

    public static void main(String[] args) {
        String[][] arr2dim = new String[10][10];
        
        for (int i = 0; i < arr2dim.length; i++) {
            for (int j = 0; j < arr2dim[i].length; j++) {
                arr2dim[i][j] = String.format("%s%d",i,j);
            }
        }
        System.out.println(arr2dim[1][2]);
        System.out.println(arr2dim[6][3]);
    }
    
}
