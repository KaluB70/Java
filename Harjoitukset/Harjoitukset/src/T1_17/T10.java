package T1_17;

public class T10 {
    public static void main(String[] args) {
        Reverse(23233134);
    }
    public static void Reverse(int number){
        int numberLength = Integer.toString(number).length()-1;
        for (int i = numberLength; i >= 0; i--) {
            System.out.print(Integer.toString(number).charAt(i));
        }
        System.out.println();
    }
    
}
