package T18_24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class T19 {
//      19.	Make a class to hold the time of the day. The time is constructed of hours, minutes and seconds.
//      a)      Make methods which increases/decreases the time.
//      b)	Make a comparator which orders the time-objects into ascending order.
//      c)	Make a comparator which orders the time-objects into descending order.

//    Time can be increased/decreased by total seconds, or using hours, minutes and seconds separitely.
//    Program assumes that the values passed to the methods are valid time values
    
    public static void main(String[] args) {
        ArrayList<TimeOfDay> todList = new ArrayList<TimeOfDay>();
        TimeOfDay tod = new TimeOfDay(2, 34, 23);
        TimeOfDay tod1 = new TimeOfDay(3, 21, 21);
        TimeOfDay tod2 = new TimeOfDay(6, 56, 12);
        TimeOfDay tod3 = new TimeOfDay(7, 22, 0);
        TimeOfDay tod4 = new TimeOfDay(1, 2, 30);
        todList.add(tod);
        todList.add(tod1);
        todList.add(tod2);
        todList.add(tod3);
        todList.add(tod4);
        System.out.println("Times of day unsorted: ");
        
        PrintList(todList);
        
        Collections.sort(todList, new SortAscending());
        
        System.out.println("Times of day sorted to ascending order: ");
        PrintList(todList);
        
        System.out.println("Decreasing the time of the object [" + todList.get(2) + "]"
                + " by 1 hour, 23 minutes and 43 seconds. \nIncreasing the time of object [" + todList.get(todList.size()-1)
        + "] by 23334 seconds");
        
        todList.get(2).DecreaseTime(1, 23, 43);
        todList.get(todList.size()-1).IncreaseTime(23334);
        PrintList(todList);
        
        System.out.println("Same but sorted descending: ");
        Collections.sort(todList, new SortDescending());
        PrintList(todList);

    }
        static private void PrintList(ArrayList<TimeOfDay> tod){
            tod.forEach(timeOfDay -> {
                System.out.println(timeOfDay);
        });
            System.out.println("");
        }
    
}
class TimeOfDay{
    private int[] time = new int[3];
    public TimeOfDay(int hours, int minutes, int seconds){
        time[0] = hours;
        time[1] = minutes;
        time[2] = seconds;
    }
    
    public void DecreaseTime(int s){
        int sec = s % 60;
        int hr = s / 60;
        int min = hr % 60;
        hr = hr / 60;
        
        time[0] -= hr;
        time[1] -= min;
        time[2] -= sec;
        if (time[2] < 0 && time[0] > 0 && time[1] > 0) {
            time[2] = 60 - Math.abs(time[2]);
            time[1]--;
        }
        else if (time[2] < 0 && time[0] <= 0 && time[1] <= 0){
            time[2] = 0;
        }
        else if (time[1] < 0 && time[0] > 0) {
            time[1] = 60 - Math.abs(time[1]);
            time[0]--;
        }
        else if (time[1] < 0  && time[0] <= 0){
            time[1] = 0;
        }
        
        time[0] = time[0] > 0 ? time[0] : 0;
        time[1] = time[1] > 0 ? time[1] : 0;
        time[2] = time[2] > 0 ? time[2] : 0;
    }
    public void DecreaseTime(int hr, int min, int sec){
        if (min <= 60 && sec <= 60) {
            DecreaseTime(TimeToSeconds(hr, min, sec));      
        }
        
    }
    public int GetHours(){
        return time[0];
    }
    public int GetMinutes(){
        return time[1];
    }
    public int GetSeconds(){
        return time[2];
    }
    public void IncreaseTime(int s){
        int sec = s % 60;
        int hr = s / 60;
        int min = hr % 60;
        hr = hr / 60;
        
        time[0] += hr;
        time[1] += min;
        time[2] += sec;
        
        if (time[2] >= 60) {
            time[2] -= 60;
            time[1]++;
        }
        if (time[1] >= 60) {
            time[1] -= 60;
            time[0]++;
        }
        
    }
    public void IncreaseTime(int hr, int min, int sec){
        if (min <= 60 && sec <= 60) {
            IncreaseTime(TimeToSeconds(hr, min, sec));
        }
    }
    
    public int TimeToSeconds(int hrs, int min, int sec){
        int retVal;
        retVal = (hrs * 60 * 60) + (min * 60) + sec;
        return retVal;
    }
    public int TimeToSeconds(){
        int retVal;
        retVal = (this.GetHours()*60*60) + (this.GetMinutes()*60) + this.GetSeconds();
        return retVal;
    }
    @Override
    public String toString(){
        return time[0] + " hours, " + time[1] + " minutes, " + time[2] + " seconds";
    }

    
}
class SortAscending implements Comparator<TimeOfDay>{

    @Override
    public int compare(TimeOfDay o1, TimeOfDay o2) {
        return o1.TimeToSeconds(o1.GetHours(), o1.GetMinutes(), o1.GetSeconds())
                -o2.TimeToSeconds(o2.GetHours(), o2.GetMinutes(), o2.GetSeconds());
    }
    
}
class SortDescending implements Comparator<TimeOfDay>{

    @Override
    public int compare(TimeOfDay o1, TimeOfDay o2) {
        return o2.TimeToSeconds(o2.GetHours(), o2.GetMinutes(), o2.GetSeconds())
                -o1.TimeToSeconds(o1.GetHours(), o1.GetMinutes(), o1.GetSeconds());
    }
    
}