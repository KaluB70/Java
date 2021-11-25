package T18_24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class T20 {
    
//      20.	Make a class to hold a date. The date includes the number of the day,
//              the number of the month and the number of the year. The class also holds
//              the time of the day which it inherits from the class made in exercise 19.
//      a)	Make methods which increases/decreases the date.
//      b)	Make comparators (ascending and descending) which orders the dates.

    public static void main (String[] args){
        ArrayList<Date> dateL = new ArrayList<Date>();
        TimeOfDay tod = new TimeOfDay(12, 3, 45);
        TimeOfDay tod1 = new TimeOfDay(3, 21, 21);
        TimeOfDay tod2 = new TimeOfDay(6, 56, 12);
        dateL.add(new Date(12,2,26, tod));
        dateL.add(new Date(2,11,24, tod1));
        dateL.add(new Date(5,1,2, tod2));
        
        
        System.out.println("Unsorted list of Date objects: \n");
        PrintList(dateL);
        dateL.get(0).DecreaseDate(1, 2, 26, new TimeOfDay(5, 12, 54));
        
        
        System.out.println("Decreasing date at index 0: \n");
        PrintList(dateL);
        
        
        System.out.println("Sorting list to ascending order: \n");
        Collections.sort(dateL, new SortAscendingDate());
        PrintList(dateL);
        
        System.out.println("Increasing the time of index 1 and sorting to descending order: \n");
        dateL.get(1).IncreaseDate(7, 2, 5, new TimeOfDay(2,3,56));
        Collections.sort(dateL, new SortDescendingDate());
        PrintList(dateL);
    }
    static private void PrintList(ArrayList<Date> date){
            date.forEach(d-> {
                System.out.println(d);
        });
            System.out.println("");
        }
}
class Date{
    private int dayNr;
    private int monthNr;
    private int yearNr;
    private TimeOfDay timeOfDay;

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public Date(int YearNr, int MonthNr, int DayNr, TimeOfDay timeOfDay) {
        this.dayNr = DayNr;
        this.monthNr = MonthNr;
        this.yearNr = YearNr;
        this.timeOfDay = timeOfDay;
    }

    public int getDayNr() {
        return dayNr;
    }
    public void setDayNr(int DayNr) {
        this.dayNr = DayNr;
    }
    public int getMonthNr() {
        return monthNr;
    }
    public void setMonthNr(int MonthNr) {
        this.monthNr = MonthNr;
    }
    public int getYearNr() {
        return yearNr;
    }
    public void setYearNr(int YearNr) {
        this.yearNr = YearNr;
    }
     
    public void DecreaseDate(int years, int months, int days, TimeOfDay tod){
        timeOfDay.DecreaseTime(tod.TimeToSeconds(tod.GetHours(), tod.GetMinutes(), tod.GetSeconds()));
        dayNr -= days;
        if (dayNr <= 0) {
            monthNr -= Math.ceil((double)Math.abs(dayNr)/30);
            dayNr = Math.abs(dayNr)%30;
            dayNr = dayNr > 0 ? dayNr : 30;
        }
        monthNr -= months;
        if (monthNr <= 0) {
            yearNr -= Math.ceil((double)Math.abs(monthNr)/12);
            monthNr = Math.abs(monthNr)%12;
            monthNr = monthNr > 0 ? monthNr : 12;
        }
        yearNr -= years;
        
        yearNr = yearNr >= 0 ? yearNr : 0;
        monthNr = monthNr >= 0 ? monthNr : 0;
        dayNr = dayNr >= 0 ? dayNr : 0;
        
    }
    public void IncreaseDate(int  years, int months, int days, TimeOfDay tod){
        timeOfDay.IncreaseTime(tod.TimeToSeconds(tod.GetHours(), tod.GetMinutes(), tod.GetSeconds()));
        dayNr += days;
        monthNr = dayNr < 30 ? monthNr : monthNr + (int)Math.ceil((double)Math.abs(dayNr)/30);
        dayNr = dayNr < 30 ? dayNr : dayNr%30;
        monthNr += months;
        yearNr = monthNr < 12 ? yearNr : yearNr + (int)Math.ceil((double)Math.abs(monthNr)/12);
        monthNr = monthNr < 12 ? monthNr : monthNr%12;
        yearNr += years;
    }
    
    @Override
    public String toString() {
        return "Year: " + yearNr + " - Month: " +  monthNr + " - Day: " + dayNr + " - Time of day: " +  timeOfDay;
    }
    
    
    
}
class SortAscendingDate implements Comparator<Date>{

    @Override
    public int compare(Date o1, Date o2) {
        int days1 = (o1.getYearNr()*365)+(o1.getMonthNr()*12)+o1.getDayNr();
        int days2 = (o2.getYearNr()*365)+(o2.getMonthNr()*12)+o2.getDayNr();
        return days1 != days2 ? days1-days2 : o1.getTimeOfDay().TimeToSeconds() - o2.getTimeOfDay().TimeToSeconds();
    }
    
}
class SortDescendingDate implements Comparator<Date>{

    @Override
    public int compare(Date o1, Date o2) {
        int days1 = o1.getYearNr()*365+o1.getMonthNr()*12+o1.getDayNr();
        int days2 = o2.getDayNr()*365+o2.getMonthNr()*12+o2.getDayNr();
        
        return days1 != days2 ? days2-days1 : o2.getTimeOfDay().TimeToSeconds() - o1.getTimeOfDay().TimeToSeconds();
    }
    
}