package T1_17;

public class T6 {

    public static void main(String[] args) {
        SecondsToUnitsOfTime(23332424);
    }
    public static void SecondsToUnitsOfTime(int seconds){
        int years = seconds/3600/24/365;
        int days = seconds/3600/24;
        int hours = seconds/3600;
        int minutes = seconds/60;
        System.out.println("Years: " + years);
        System.out.println("Days: " + days);
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Seconds " + seconds);
    }
}
