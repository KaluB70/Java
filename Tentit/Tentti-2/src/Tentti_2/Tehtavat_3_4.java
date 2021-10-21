package Tentti_2;


public class Tehtavat_3_4 {

    public static void main(String[] args) {
        TennisScore ts = new TennisScore("Roger Federer", "Rafael Nadal");
        ts.AddSet(3, 6);
        ts.AddSet(4, 7); // Virheellinen erä, ei lasketa mukaan
        ts.AddSet(7, 5);
        ts.AddSet(6, 7);
        ts.AddSet(6, 0);
        ts.AddSet(2, 6);
        
        System.out.print(ts.toString()); //ToString tulostus
    }
    
}
class TennisScore{
    String nameP1;
    String nameP2;
    String sets = "";
    int setWinsP1 = 0;
    int setWinsP2 = 0;
    public TennisScore(String p1Name, String p2Name){
         nameP1 = p1Name;
         nameP2 = p2Name;
    }
    public void AddSet(int scoreP1, int scoreP2){
        if (ValidSet(scoreP1, scoreP2)) {
            if (scoreP1>scoreP2) {
            setWinsP1++;
            sets += scoreP1 + "-" + scoreP2 + " ";
            }
            else{
            setWinsP2++;
            sets += scoreP1 + "-" + scoreP2 + " ";
            }
            if (setWinsP1 == 3|| setWinsP2 == 3) {
            System.out.print("Ottelu on päättynyt! Voittaja on: ");
                if (setWinsP1 == 3) {
                System.out.println(nameP1);
                System.out.println("Erätulokset: " + sets);
                }
                else{
                System.out.println(nameP2);
                System.out.println("Erätulokset: " + sets);
                }
            }         
        }
    }
    public Boolean ValidSet(int scoreP1, int scoreP2){
        if (scoreP1 == 7 && scoreP2 == 5 || scoreP2 == 6) {
            return true;
        }
        else if (scoreP2 == 7 && scoreP1 == 5 || scoreP1 == 6){
            return true;
        }
        else if (scoreP1 == 6 && scoreP2 >= 0 && scoreP2 <= 4){
            return true;
        }
        else if (scoreP2 == 6 && scoreP1 >= 0 && scoreP1 <= 4){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return "Pelaaja 1: " + nameP1 + "\nPelaaja 2: " + nameP2 + "\nTämänhetkiset erät (" + nameP1 + " ensin mainittuna): "
            + sets + "\nErävoitot tällä hetkellä: " + nameP1 + ": " + setWinsP1 + " - " + nameP2 + ": " + setWinsP2 + "\n";
    }
}
