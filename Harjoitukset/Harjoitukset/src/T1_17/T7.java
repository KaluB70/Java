package T1_17;

public class T7 {

    public static void main(String[] args) {
        TriangleValidity(12.2, 13.2, 23.3);
    }
    public static void TriangleValidity(double a, double b, double c){
        if((a + b > c) && (b + c > a) && (a + c > b)) {
            System.out.println("Valid triangle");
        }
        else{
            System.out.println("Invalid triangle");
        }
    }
}
