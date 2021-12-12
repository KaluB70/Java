package koodausharjoitus;

import java.util.ArrayList;
import java.util.Arrays;


public class Sarjaohjelma {


    public static void main(String[] args) {
        
        Team t1 = new Team("Assat", 0);
        Team t2 = new Team("Lukko", 1);
        Team t3 = new Team("Karpat", 2);
        Team t4 = new Team("Tappara", 3);
        Team t5 = new Team("Ilves", 4);
        Team t6 = new Team("Saipa", 5);
        Team t7 = new Team("Kalpa", 6);
        Series s = new Series(Team.teamAmount());
        System.out.println(s);
        
    }
    
}
class Team{
    private String name;
    private final int id;
    private static final ArrayList<Team> allTeams = new ArrayList<>();  
    
    public Team(String teamName, int id){
        this.name = teamName;
        this.id = id;
        appendList();
    }
    private void appendList(){
        allTeams.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public static String getAllTeamsString() {
        String retVal = "";
        for (int i = 0; i < allTeams.size()-1; i++) {
            retVal += allTeams.get(i).getName() + ", ";
        }
        retVal += allTeams.get(allTeams.size()-1).getName();
        return retVal;
    }
    public static String[] getAllTeamsArray(){
        String[] retVal = new String[teamAmount()];
        for (int i = 0; i < teamAmount(); i++) {
            retVal[i] = allTeams.get(i).name;
        }
        return retVal;
    }
    public static int[] getAllTeamIdsArray(){
        int[] retVal = new int[teamAmount()];
        for (int i = 0; i < teamAmount(); i++) {
            retVal[i] = allTeams.get(i).id;
        }
        return retVal;
    }
    public static int teamAmount(){
        return allTeams.size();
    }
    
}
class Match{
//    private final Team home;
//    private final Team away;
//    private static ArrayList<Match> history;
//
//    public Match(Team home, Team away) {
//        this.home = home;
//        this.away = away;
//        history.add(new Match(home, away));
//    }
    int[][] matches;

    public Match(int[][] matches) {
        this.matches = matches;
    }
    
}
class Series{
    private int BYE = -1;
    private int teamAmount;
    private int[][] seriesWithIds;



    public Series(int TeamAmount) {
        this.teamAmount = TeamAmount;
        seriesWithIds = GenerateSeriesOdd(this.teamAmount);
    }
    public int[][] GenerateSeriesOdd(int teamAmount){
        int n = (int)((teamAmount - 1) / 2);
        int[][] results = new int[teamAmount][teamAmount];
        int[] teams = Team.getAllTeamIdsArray();
        for (int r = 0; r < teamAmount; r++) {
            for (int i = 0; i < n; i++) {
                int team1 = teams[n-i];
                int team2 = teams[n+i+1];
                results[team1][r] = team2;
                results[team2][r] = team1;
            }
            results[teams[0]][r] = BYE;
            
            RotateArray(teams);
        }
        return results;
    }
        private void RotateArray(int[] teams) {
        int temp = teams[teams.length -1];
        System.arraycopy(teams, 0, teams, 1, teams.length -1);
        teams[0] = temp;
    }
    @Override
    public String toString() {
        String retVal = "";
        for (int i = 0; i < seriesWithIds[0].length-1; i++) {
            retVal += "Round " + i + ":\r\n";
            for (int t = 0; t < teamAmount; t++) {
                if (seriesWithIds[t][i] == BYE) {
                }
                else if (t < seriesWithIds[t][i]){
                    retVal += "   " + Team.getAllTeamsArray()[t] + " vs " + Team.getAllTeamsArray()[seriesWithIds[t][i]] + "\r\n";
                }
            }
        }
        return retVal;
    }
}


