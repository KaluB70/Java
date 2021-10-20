package T1_17;

public class T8 {

    public static void main(String[] args) {
        int height = 12;
        int width = 12;
        
        for (int i = 1; i <= height; i++) {
            System.out.print("* ");
            for (int j = 1; j <= width-2; j++) {
                if (i == 1 || i == height) {
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println("*");
        }
    }
    
}
