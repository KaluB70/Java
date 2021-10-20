package T1_17;


public class T4 {

    public static void main(String[] args) {
        countNoteAmount(4385);
    }
    private static void countNoteAmount(int amount){
        int[] banknotes = new int[]{100, 50, 20, 10, 5};
        int[] banknoteAmount = new int[5];
        
         for (int i = 0; i < banknoteAmount.length; i++) {
            if (amount >= banknotes[i]) {
                banknoteAmount[i] = amount / banknotes[i];
                amount = amount - banknoteAmount[i] * banknotes[i];
            }
        }
        System.out.println("Banknote amounts: ");
        for (int i = 0; i < banknoteAmount.length; i++) {
            if (banknoteAmount[i] != 0) {
                System.out.println(banknotes[i] + " -> " + banknoteAmount[i]);
            }
        }
    }
}
