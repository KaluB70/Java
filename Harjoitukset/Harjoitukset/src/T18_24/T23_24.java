/*
 * Kalle Kiviluoma - 2021
 */
package T18_24;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class T23_24 {
//    23.   The Koodit folder includes a file named Jobs.txt. It has 1080 lines of job descriptions. A single line is constructed of
//          a)	a unique id
//          b)	a day identifier (ma1-su3 = the first Monday – the last Sunday)
//          c)	the code of the job
//          d)	the duration of the job in minutes
//          e)	the starting time of the job
//          f)	the ending time of the job
//          Make a class to hold the values.

    
//    24.   With the previous data, make data structures to hold
//          a)	all the jobs in the order they are in the file
//          b)	all the codes of the jobs
//          c)	all job ids for every day and week, the jobs must be ordered by the ids
//          d)	the amount of different codes of jobs for every week
//          e)	all the codes of the jobs for every day
//          f)	the amount of different starting times for every day, must be ordered by the starting time and day
//          g)	all job ids for every code of job, must be ordered by the ids
//          When making the structures, remember that you may want to update them.

    public static void main(String[] args) throws Exception {
        final int TOKENS = 6;

        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> day = new ArrayList<>();
        ArrayList<String> jobCode = new ArrayList<>();
        ArrayList<Integer> durationInMinutes = new ArrayList<>();
        ArrayList<Double> startTime = new ArrayList<>();
        ArrayList<Double> endTime = new ArrayList<>();
        File file = new File("Jobs.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {  
            StringTokenizer st = new StringTokenizer(str, "\t");
            if (st.countTokens() == TOKENS) {
                id.add(Integer.parseInt(st.nextToken()));
                day.add(st.nextToken());
                jobCode.add(st.nextToken());
                durationInMinutes.add(Integer.parseInt(st.nextToken()));
                startTime.add(Double.parseDouble(st.nextToken().replaceAll(":", ".")));
                endTime.add(Double.parseDouble(st.nextToken().replaceAll(":", ".")));
            }
        }
        TreeSet<Jobs> allJobs = new TreeSet<>(); //All jobs in order they are in the file
        ArrayList<String> codes = new ArrayList<>(); 
        TreeMap<String, Integer> codeOccurences = new TreeMap<>(); //Amount of different job codes
        Map<String, String> codesPerDay = new TreeMap<>();
        
        
        for (int i = 0; i < id.size(); i++) {

            Jobs j = new Jobs(id.get(i), durationInMinutes.get(i), day.get(i),  //Adding the data to the class
            jobCode.get(i), startTime.get(i), endTime.get(i));
            
            allJobs.add(j);                                                     //24 a)
            
            if (!codes.contains(jobCode.get(i))) {                              //24 b)
                codes.add(j.getJobCode());                                      
            }
            if (codeOccurences.containsKey(j.getJobCode())) {                   //24 d) (*for every day)
                codeOccurences.put(j.getJobCode(),
                codeOccurences.get(j.getJobCode()) + 1);
            }
            else{
                codeOccurences.put(j.getJobCode(), 1);
            }
            if (!codesPerDay.containsKey(j.getDay())) {                         // 24 e)
                codesPerDay.put(j.getDay(),j.getJobCode());
            }
            else if(codesPerDay.containsKey(j.getDay()) && 
            !codesPerDay.get(j.getDay()).contains(j.getJobCode())){
                String temp = codesPerDay.get(j.getDay());
                temp += j.getJobCode();
                codesPerDay.put(j.getDay(), temp);
            }
            
            
        }
        
//        for (Jobs t : allJobs) {
//            System.out.println(t);
//        }
//        for (String string : codes) {
//            System.out.println(string);
//        }

//        Set<String> allKeys = codeOccurences.keySet();
//        for ( String temp : allKeys ) {
//          int value = codeOccurences.get ( temp );
//          System.out.println(temp +": "+ value);
//        }

        Set<String> allKeys = codesPerDay.keySet();
        allKeys.forEach(temp -> {
            String value = codesPerDay.get(temp);
            System.out.println(temp +": "+ value);
        });
    }
}
class Jobs implements Comparable<Jobs>, Comparator<Jobs>{
    int id;
    int durationInMinutes;
    String day;
    String jobCode;
    Double startTime;
    Double endTime;


    public Jobs(int id, int durationInMinutes, String day, String jobCode, Double startTime, Double endTime) {
        this.id = id;
        this.durationInMinutes = durationInMinutes;
        this.day = day;
        this.jobCode = jobCode;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public Double getStartTime() {
        return startTime;
    }
    public String getDay() {
        return day;
    }

    public String getJobCode() {
        return jobCode;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Duration: " + durationInMinutes + ", Day: " + day + ", Code: " + jobCode
        + ", Start time: " + String.format("%.2f", startTime).replaceAll(",", ":") + ", End Time: " + String.format("%.2f", endTime).replaceAll(",", ":");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        else if (!(obj instanceof Jobs)){
            return false;
        }
        else if ((id == ((Jobs)obj).id) && (day.equals(((Jobs)obj).day)) && (jobCode.equals(((Jobs)obj).jobCode))
                && (startTime == ((Jobs)obj).startTime) && (endTime == ((Jobs)obj).endTime)){
            return true;
        }
        else return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Jobs o) {
        return this.id - o.id;
    }

    @Override
    public int compare(Jobs o1, Jobs o2) {
        return o1.id - o2.id;
    }
}
class SortByDay implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {

        return o1.compareTo(o2);
    }
}    

