package T1_17;

public class T1 {

    public static void main(String[] args) {
        System.out.println(Distance(1,2,1,3));
    }
    static double Distance(double x1,double x2,double y1, double y2){
        return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
    }
}
