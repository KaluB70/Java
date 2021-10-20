package T1_17;
import java.util.Arrays;
import java.util.Scanner;
public class T11 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Separator()));
    }
    public static int [] Separator(){
        
        int [] numArr = new int[5];
        Scanner scan = new Scanner(System.in);
        try{
            int input = scan.nextInt();
            int length = String.valueOf(input).length();
            if (length != 5) {
                throw new ArithmeticException("Please only pass an integer of 5 digits");
            }
            char [] charArr = String.valueOf(input).toCharArray();
            
            for (int i = 0; i < charArr.length; i++){
                numArr[i] = Character.getNumericValue(charArr[i]);
            }
        }
        catch(java.util.InputMismatchException em){
            System.out.println("There was at least one character, which was not integer...");
            return null;
        }
        catch(java.lang.ArithmeticException eme){
            System.out.println(eme);
            return null;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
        return numArr;
    }
}
