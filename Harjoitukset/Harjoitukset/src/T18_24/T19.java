package T18_24;


public class T19 {
    
//    Time can be increased/decreased by total seconds, or using hours, minutes and seconds separitely.
//    
    
    public static void main(String[] args) {
//      Adding the instances of TimeOfDay class to an Array
        TimeOfDay[] todList = new TimeOfDay[5];
        TimeOfDay tod = new TimeOfDay(2, 34, 23);
        TimeOfDay tod1 = new TimeOfDay(3, 21, 21);
        TimeOfDay tod2 = new TimeOfDay(6, 56, 12);
        TimeOfDay tod3 = new TimeOfDay(7, 22, 0);
        TimeOfDay tod4 = new TimeOfDay(1, 2, 30);
        todList[0] = tod;
        todList[1] = tod1;
        todList[2] = tod2;
        todList[3] = tod3;
        todList[4] = tod4;
        
        for(int i = 0; i<todList.length; i++){
            System.out.println(todList[i]);
        }
        
    }
    public static void SortIncreasing(TimeOfDay[] tods){
        TimeOfDay[] todCopy = tods;
        int currentMaxHr = 0;
        TimeOfDay currentMaxObj;
        for(int i = 0; i<tods.length; i++){
            if (tods[i].GetHours() > currentMaxHr) {
                currentMaxHr = tods[i].GetHours();
                currentMaxObj = tods[i];
            }
        }
    }
    
}
class TimeOfDay{
    int[] time = new int[3];
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
        DecreaseTime(TimeToSeconds(hr, min, sec));
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
        IncreaseTime(TimeToSeconds(hr, min, sec));
    }
    
    public int TimeToSeconds(int hrs, int min, int sec){
        int retVal = 0;
        retVal = (hrs * 60 * 60) + (min * 60) + sec;
        return retVal;
    }
    @Override
    public String toString(){
        return time[0] + " hours, " + time[1] + " minutes, " + time[2] + " seconds";
    }
    
}