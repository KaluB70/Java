package Tentti_1;

public class Tehtava_2 {

    public static void main(String[] args) {
        /**
          * Luodaan array tyypin muuttujat a1 ja a2
          * @param a1 - annetaan arvoiksi kokonaisluvut väliltä 1-5
          * @param a2 - annetaan samat arvot käänteisenä, eli väliltä 5-1
          */
        int[] a1 = {1,2,3,4,5}; 
        int[] a2 = {5,4,3,2,1};
        
        /**
          * @param a3 - array, jonka pituudeksi 
          * asetetaan a1 ja a2 muuttujien yhteenlaskettu pituus
          */
        int[] a3 = new int[a1.length+a2.length];
        
        /**
          * Silmukka varsinaisen toiminnan suorittamiseksi:
          * @param a3 rakentuu seuraavasti:
          * a3:n parillisiin indeksilokaatioihin (0,2,4,6,8) asetetaan arvot kaavalla:
          *     (a1:n silmukanaikainen arvo (indeksistä i) potenssiin
          *      a2:n silmukanaikainen arvo (indeksistä i))
          *      = 1^5, 2^4, 3^3, 4^2, 5^1
          * 
          * a3:n parittomiin indeksilokaatioihin (1,3,5,7,9) asetetaan arvot kaavalla:
          *     indeksimuuttuja * 10;
          *     = 1*10, 2*10, 3*10, 4*10
          */
        for ( int i = 0; i < a1.length; i++ ) {
        a3[i*2] = (int)Math.pow ( a1[i], a2[i] ); //(0,2,4,6,8,10)

        a3[i*2+1] = i*10; //(1,3,5,7,9)
        
        /**
          * a1 ja a2 vaihtavat silmukan aikana järjestystä 
          * keskenään tilapäismuuttujan avulla
          * (a1 laskeva järjestys - a2 nouseva)
          */
        int temp = a1[i];
        a1[i] = a2[i];
        a2[i] = temp;
        }
        /**
          * @param a1 arvo suorituksen jälkeen: [5, 4, 3, 2, 1]
          * @param a2 arvo suorituksen jälkeen: [1, 2, 3, 4, 5]
          * @param a3 arvo suotiruksen jälkeen: [1, 0, 16, 10, 27, 20, 16, 30, 5, 40]
          */
    }
    
}
