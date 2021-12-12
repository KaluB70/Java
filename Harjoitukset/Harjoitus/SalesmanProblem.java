/*
 * Kalle Kiviluoma - 2021
 */
package koodausharjoitus;

import java.util.ArrayList;

public class SalesmanProblem {

    public static void main(String[] args) {
        
    }
    
}
class City{
    private int x;
    private int y;

    public City() {
        this.x = (int) (Math.random() * 500);
        this.y = (int) (Math.random() * 500);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public double distanceToCity(City city) {
        int x = Math.abs(getX() - city.getX());
        int y = Math.abs(getY() - city.getY());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    
}
class Travel{
    private ArrayList<City> travel = new ArrayList<>();
    private ArrayList<City> previousTravel = new ArrayList<>();

    public Travel(int numberOfCities) {
        for (int i = 0; i < numberOfCities; i++) {
            travel.add(new City());
        }
    }
    
    public City getCity(int index) {
        return travel.get(index);
    }

    public int getDistance() {
        int distance = 0;
        for (int i = 0; i < travel.size(); i++) {
            City starting = getCity(i);
            City destination;
            if (i + 1 < travel.size()) {
                destination = getCity(i + 1);
            } else {
                destination = getCity(0);
            }
            distance += starting.distanceToCity(destination);
        }
        return distance;
    }
}