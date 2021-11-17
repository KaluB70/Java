package T18_24;
import java.util.ArrayList;

public class T18 {

    public static void main(String[] args) {
        Numbers n = new Numbers();
        n.AddNum(3);
        n.AddNum(12);
        n.AddNum(53);
        n.AddNum(412);
        n.AddNum(5);
        System.out.println("The list currently holds the following numbers: \n"+n.nums);
        System.out.println("With the average of: " + n.mean + "\n(The program automatically updates the "
                + "value via a subroutine when adding or deleting numbers from the list)\n");
        n.DelNumByValue(53);
        System.out.println("Removed number 53, the new values are: \nNumbers: " + n.nums);
        System.out.println("Average: "+n.mean);
        n.DelNumByIndex(0);
        System.out.println("Removed a number from index 0, the new value are: \nNumbers: " + n.nums);
        System.out.println("Average:" + n.mean);

    }
    /**
    * Jos haluamme keskiarvon päivittyvän aina automaattisesti, tämä on hyvä tapa siihen.
    * On kuitenkin olemassa tilanteita, jossa vaikkapa haluaisimme tietää keskiarvon ennen poistoa/lisäystä,
    * jonka vuoksi emme itse "hallitse" arvojen käsittelyä, mikäli ohjelma toimii näin kuin tässä.
    * Jos tämän lisäksi käsittelisimme isoa määrää dataa kerralla, lisäämällä/poistamalla samaan aikaan
    * paljon numeroita, voi ongelmaksi tulla menetettyjä päivityksiä säikeiden päälleikkäisten
    * päivitysten vuoksi.
    */
    static class Numbers {
        ArrayList<Integer> nums;
        double mean;
        
        public Numbers (){
            nums = new ArrayList<>();
        }
        public void AddNum(int num){
            nums.add(num);
            mean = CalcMean();
        }
        public void DelNumByValue(int num){
            nums.remove(Integer.valueOf(num));
            mean = CalcMean();
        }
        public void DelNumByIndex(int index){
            nums.remove(index);
            mean = CalcMean();
        }
        public double CalcMean(){
            double sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += nums.get(i);
            }
            return sum / nums.size();
        }
    }
}