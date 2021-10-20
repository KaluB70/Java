package T1_17;
import java.util.Random;
import java.util.Scanner;
public class T5 {

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        int correctNumber = rnd.nextInt(1, 100);
        int guessedNumber = 0;
        int tries = 0;
        do{
            try{
                System.out.print("Guess the number I'm thinking about (1-100): ");
                guessedNumber = scan.nextInt();
                System.out.println();
                tries++;
                if (guessedNumber > correctNumber) {
                    System.out.println("The number I'm thinking is lower...");
                }
                else if (guessedNumber < correctNumber){
                    System.out.println("The number I'm thinking is higher... ");
                }
            }
            catch(Exception e){
                String bad_input = scan.next();
                System.out.println("That is not an integer...");
                continue;
            }
        } while(guessedNumber != correctNumber);
        System.out.println("You guessed it! The correct number was " + correctNumber);
        System.out.println("You guessed the number " + tries + " times");
    }
    
}
