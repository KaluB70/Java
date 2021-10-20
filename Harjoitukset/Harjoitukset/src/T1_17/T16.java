package T1_17;

public class T16 {

    // Task A)
    public static void main(String[] args) {
        String text = "Kaksi kertaa";
        String textAsLower = text.toLowerCase();
        char[] charArr;
        Boolean countSpaces = false;
        
        while(textAsLower.length() != 0){
            charArr = textAsLower.toCharArray();
            char c = charArr[0];
            int count =1;
            for (int i = 1; i < charArr.length; i++) {
                if (c == charArr[i]) {
                    count++;
                }
            }
            if (!countSpaces) {
                if(((c != ' ') && (c != '\t'))){
                    System.out.println(c + " <---> " + count);
                }
            }
            else{
                System.out.println(c + " <---> " + count);
            }
            textAsLower = textAsLower.replace(""+c, "");
        }
        System.out.println();
        
        System.out.print(CountOfChars("Kaksi kertaa"));
    }
    
    // Task B)
    public static String CountOfChars(String text){
        String textAsLower = text.toLowerCase();
        char[] charArr;
        Boolean countSpaces = false;
        String retVal = "";
        while(textAsLower.length() != 0){
            charArr = textAsLower.toCharArray();
            char c = charArr[0];
            int count =1;
            for (int i = 1; i < charArr.length; i++) {
                if (c == charArr[i]) {
                    count++;
                }
            }
            if (!countSpaces) {
                if(((c != ' ') && (c != '\t'))){
                    retVal += c + " <---> " + count + "\n";
                }
            }
            else{
                retVal += c + " <---> " + count + "\n";
            }
            textAsLower = textAsLower.replace(""+c, "");
        }
        return retVal;
    }
}
