package Tentti_1;

import java.util.Arrays;
import java.util.Random;

public class Tehtava_3 {

    public static void main(String[] args) {
        int [] vastaus = Randomizer(1, 1000);
        System.out.print(Arrays.toString(vastaus));
    }
    static int [] Randomizer(int minNumber, int maxNumber){
        int [] taulukko = new int[10];
        for (int i = 0; i < 10; i++) {
            Random rnd = new Random();
            taulukko[i] = rnd.nextInt(minNumber, maxNumber);
        }
        return taulukko;
    }
}