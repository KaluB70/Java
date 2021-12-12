/*
 * Kalle Kiviluoma - 2021
 */
package koodausharjoitus;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author Kalle
 */
public class WorkSchedule {


    public static void main(String[] args) {
        
    }
}
class Schedules{
    TreeMap<Employee, ArrayList<Shifts>> allShifts = new TreeMap<Employee, ArrayList<Shifts>>();

    public Schedules(Employee emp, ArrayList<Shifts> shifts) {
        if (allShifts.isEmpty()) {
            allShifts.put(emp, shifts);
        }
        for (int i = 0; i < allShifts.size(); i++) {
            if (allShifts.get(i).isEmpty()) {
                allShifts.put(emp, shifts);
            }
        }
    }
    
}
class Employee{
    String name;
    ArrayList<Shifts> shifts = new ArrayList<>();

    public Employee(String name, int weeks) {
        
    }

}

enum Shifts{
    A,
    I,
    Y,
    V
}