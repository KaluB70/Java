package koodausharjoitus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Task_1 {
    final static int MAXNUMBER =11; //Max integer value for decimal creation
    final static int MINNUMBER = 1;   //Min integer value for decimal creation
    final static int OBJECTSTOMAKE = 11;  //Total number of "DecToInt" objects to make and include in the list.
    //Object values are created randomly and added to the list on creation, so the order is randomized from the start.
    //12 Seems to be the limit of objects to create when using the "Change two random spots" if we keep the limit at 1 min.
    //Occasionally 13 will make it before 1 min
    final static boolean USERANDOMORDER = true;
    public static void main(String[] args) {
            //Showcasing results with different ways to solve it
        ArrayList<DecToInt> container = InitList();
        System.out.println("Coding Exercise - Task 1 - Kalle Kiviluoma");
        
        //Ordering the list by randomly exchanging 2 object's positions
        if (USERANDOMORDER) {
            System.out.println("Getting a list of " + OBJECTSTOMAKE +" objects ordered by exchanging object positions randomly: ");
            System.out.println("(Might take a while if list size >= 12)");
            System.out.println("Change the USERANDOMORDER to false to skip this part...");
        
        ChangeSpotsRandomized(container);
        
        container.forEach(decToInt -> {
            System.out.println(decToInt);
        });
        
        System.out.print("Press Enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {}
        }
        
        
        //Using a better way to order (no comparator)
        System.out.println("Getting a list of " + OBJECTSTOMAKE +" objects ordered through comparing the objects individually to the next one (without comparator): ");
        container = InitList();
        OrderWithoutComparator(container);
        container.forEach(decToInt -> {
            System.out.println(decToInt);
        });
        
        System.out.print("Press Enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {}
        
        //Using comparator
        System.out.println("Ordering a list of of " + OBJECTSTOMAKE +" objects with comparator: ");
        container = InitList();
        Collections.sort(container, new SortAscending());
        container.forEach(decToInt -> {
            System.out.println(decToInt);
        });
    }
    static ArrayList<DecToInt> InitList() throws IllegalArgumentException{
        //Initializing/resetting the list between every method
        ArrayList<DecToInt> container = new ArrayList<>();
        if (MAXNUMBER >= 0 && MINNUMBER >= 0 && MINNUMBER < MAXNUMBER && OBJECTSTOMAKE > 1) {
            for (int i = 0; i < OBJECTSTOMAKE; i++) {
            container.add(new DecToInt(MINNUMBER, MAXNUMBER));
            }
        }
        else{
            //Throws exception for invalid parameters
            throw new IllegalArgumentException("Invalid parameters");
        }
        return container;
    }
    static void ChangeSpotsRandomized(ArrayList<DecToInt> list){
        ArrayList<DecToInt> retVal = list;      //Return value - manipulated along the way
        Random rnd = new Random();
        boolean inOrder = false;                //Are the items on the list ordered or not
        int orderCount = 0;                     //Variable to hold the amount of ordered items during the iteration.
        long totalTries = 0;                    //Keeps track of the total tries it took to order the list
        
        //Runs the loop while the list is not in order
        while (inOrder == false){               
            //Getting two random index numbers -> exchanging the places of two objects based on these
            int randomIndex1 = rnd.nextInt(list.size());        
            int randomIndex2 = rnd.nextInt(list.size());
            while (randomIndex1 == randomIndex2){
                randomIndex2 = rnd.nextInt(list.size());
            }
            var tempItem = retVal.get(randomIndex1);
            retVal.set(randomIndex1, retVal.get(randomIndex2));
            retVal.set(randomIndex2, tempItem);
            
            //Checking the list if it is in order -> using the "<" operator made earlier
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size()-1) {
                    if (retVal.get(i).SmallerThan(retVal.get(i+1))) {
                        orderCount++;
                    }
                }
                
            }
            totalTries++;
            //Ends the loop if the list is in order
            if (orderCount == list.size()-1) {
                inOrder = true;
            }
            else{
                //Resets the order count if the list not in order
                orderCount = 0;
            }
        }
        System.out.println("Total tries: " + totalTries);
    }
    static void OrderWithoutComparator(ArrayList<DecToInt> list){
        ArrayList<DecToInt> retVal = list;  //Return value - manipulated along the way
        boolean inOrder = false;            //Are the items on the list ordered or not
        int orderCount = 0;                 //Variable to hold the amount of ordered items during the iteration.
        long totalTries = 0;                //Keeps track of the total tries it took to order the list
        
        //Runs the loop while the list is not in order
        while (inOrder == false){
            //Checks if the object from the current index is smaller than the object at the next index
            //If yes -> No change to the list, update current order count
            //If no  -> Change their places together
            for (int i = 0; i < retVal.size(); i++) {
                if (i != retVal.size()-1) {
                    if (retVal.get(i).SmallerThan(retVal.get(i+1))) {
                        orderCount++;
                    }
                    else{
                        var temp = retVal.get(i);
                        retVal.set(i, retVal.get(i+1));
                        retVal.set(i+1, temp);
                    }
                }
            }
            totalTries++;
            //Ends the loop if the list is in order
            if (orderCount == list.size()-1) {
                inOrder = true;
            }
            else{
                //Resets the order count if the list not in order
                orderCount = 0;
                
            }
        }
        System.out.println("Total tries: " + totalTries);
        }
    }
class DecToInt{
    //Variables to hold the two integers made from one decimal number - first = int part, second = decimal part
    int first;
    long second;

    //Constructor - Get random decimal based on the parameters assigned -> split it into two integers - assign them to the field variables
    public DecToInt(int n, int m){
        Random rnd = new Random();
        double d;
        if (m >= 0 && n >= 0 && n < m) {
            d = rnd.nextDouble(n, m);
            first = (int)d;
            second = Long.parseLong(Double.toString(d).split("\\.")[1]);
        } 
    }
    
    //The ">" operator
    public boolean GreaterThan(DecToInt other){
        if (this.first > other.first) {
            return true;
        }
        else if (other.first > this.first){
            return false;
        }
        else if (this.second > other.second){
            return true;
        }
        else if (other.second > this.second) {
            return false;
        }
        else return false;
    }
    
    // The "<" operator
    public boolean SmallerThan(DecToInt other){
        if (this.first < other.first) {
            return true;
        }
        else if (other.first < this.first){
            return false;
        }
        else if (this.second < other.second){
            return true;
        }
        else if (other.second < this.second) {
            return false;
        }
        else return false;
    }
    //The "==" operator
    public boolean Equals(DecToInt other) {
        return this.first == other.first && this.second == other.second;
    }
    //The "!=" operator
    public boolean NotEquals(DecToInt other){
        return !(this.first == other.first && this.second == other.second);
    }
    
    
    @Override
    public String toString() {
        return "First part: " + first + " <---> Second part: " + second;
    }
    
    
}
//Comparator to sort the list in descending order
class SortDescending implements Comparator<DecToInt>{

    @Override
    public int compare(DecToInt o1, DecToInt o2) {
        if (o1.SmallerThan(o2)) {
            return 1;
        }
        else if (o1.GreaterThan(o2)){
            return -1;
        }
        else{
            return 0;
        }
    }
    
}
//Comparator to sort the list in ascending order
class SortAscending implements Comparator<DecToInt>{

    @Override
    public int compare(DecToInt o1, DecToInt o2) {
        if (o1.GreaterThan(o2)) {
            return 1;
        }
        else if (o1.SmallerThan(o2)){
            return -1;
        }
        else{
            return 0;
        }
    }
    
}