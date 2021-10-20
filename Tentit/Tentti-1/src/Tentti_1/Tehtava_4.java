package Tentti_1;

public class Tehtava_4 {

    public static void main(String[] args) {
        int [] firstArr = {1,2,3,4};
        int [] secondArr = {4,5,6,7};
        System.out.println(ArrayMethod(firstArr, secondArr));
    }
    static int ArrayMethod(int [] arr1, int [] arr2){
        if (arr1.length == arr2.length) {
            int sumArr[] = new int[arr2.length];
            int sum = 0;
            for (int i = 0; i < arr2.length; i++) {
                sumArr[i] = arr1[i] + arr2[i];
            }
            for (int num : sumArr){
                sum += num;
            }
            return sum;
        }
        return arr1.length > arr2.length ? 1 : -1;
        /**
          * Tässä ongelmana on se, ettei käyttäjä tiedä tulostuksen
          * perusteella, onko palautettu arvo taulukoiden summa vai 
          * eripituisuudesta johtunut palautus.
          * Käytännössä käyttäjä ei välttämättä tiedä, onko syötetyt taulukot
          * samanpituisia.
          */
    }
    
    
}
