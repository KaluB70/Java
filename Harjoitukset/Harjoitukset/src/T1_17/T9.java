package T1_17;

public class T9 {

    public static void main(String[] args) {
        int height = 10;
        
        for(int i=1; i<=height; i++){
            for(int j=height-1; j>=i; j--){
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i-1); k++){
                System.out.print("*");
            }
        System.out.println("");
        }
    }
}
