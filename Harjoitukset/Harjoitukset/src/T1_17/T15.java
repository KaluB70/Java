package T1_17;

import static T1_17.T15.Reverser.Reverse2;

public class T15 {

    // Task a)
    public static void main(String[] args) {
        String text = "Pig is an animal";
        char[] charArr = text.toCharArray();
        char[] retVal = new char[charArr.length];
        for (int i = charArr.length-1; i >= 0; i--) {
            retVal[charArr.length-1-i] = charArr[i];
        }
        
        
        System.out.println(retVal);
        System.out.println(Reverse("Pig is an animal"));
        Reverse2();
        System.out.println(Reverser.text);
    }
    
    // Task b)
    public static String Reverse(String text){
        char[] charArr = text.toCharArray();
        char[] retVal = new char[charArr.length];
        for (int i = charArr.length-1; i >= 0; i--) {
            retVal[charArr.length-1-i] = charArr[i];
        }
        String retValB = new String(retVal);
        return retValB;
    }
    
    // Task c)
    public class Reverser{
        public static String text = "Pig is an animal";
    
        static void Reverse2(){
            char[] charArr = text.toCharArray();
            char[] retVal = new char[charArr.length];
            for (int i = charArr.length-1; i >= 0; i--) {
                retVal[charArr.length-1-i] = charArr[i];
            }
            String retValB = new String(retVal);
            text  = retValB;
        }
    }
}
