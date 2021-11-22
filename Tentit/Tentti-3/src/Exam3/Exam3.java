package Exam3;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;


// OHJELMA EI TOIMI: Tiedoston lukeminen tuotti tosi paljon vaikeuksia. Onkohan opintojaksolla käyty ko. asia jossain
// vaiheessa läpi, vai olenko vain itse missannut sen...

public class Exam3 {
    static final int TOKENS = 22;
      
    public static void main ( String[] args ) throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader ( new InputStreamReader ( new FileInputStream("KnowHow.txt"), "UTF-8" ));
    String line;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String[]> knowledge = new ArrayList<>();
    while (( line = br.readLine()) != null ) {
      StringTokenizer sto = new StringTokenizer ( line, "\t");
      if ( sto.countTokens() == TOKENS ) {  // The read line is probably ok if the number of tokens is correct.
        name.add ( sto.nextToken());
        String[] ss = new String[TOKENS-1];
        knowledge.add ( ss );
        for ( int i = 0; i < TOKENS-1; i++ ) {
                ss[i] = sto.nextToken();
        }
      }
 
      else {
        System.out.println ("The number of tokens do not match.");
        System.exit(0);
      }
    }
    br.close();
    
    
    TreeSet<KnowHow> knowledges = new TreeSet<>();
    
        for (int i = 0; i < name.size(); i++) {
            String[] knowL = knowledge.get(i);
            for (int j = 0; j < knowL.length; j++) {
                KnowHow kh = new KnowHow(name.get(i), knowL);
                knowledges.add(kh);
            }
            
        }
        System.out.println(knowledges);
    }
}
class KnowHow implements Comparable<KnowHow>{
    private String id;
    private ArrayList<String> knows = new ArrayList<>();

    public KnowHow(String id, String[] know) {
        this.id = id;
        for (String know1 : know) {
            if (know1 != null) {
                knows.add(know1);
            }
        }
        
    }

    @Override
    public String toString() {
        return "KnowHow{" + "id=" + id + ", knows=" + knows + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getKnows() {
        return knows;
    }

    public void setKnows(ArrayList<String> knows) {
        this.knows = knows;
    }
    
    
    
    @Override
    public int compareTo(KnowHow other) {
        if (this.getId().compareTo(other.getId()) == -1){
            return -1;
        }
        else if (this.getId().compareTo(other.getId()) == 1){
            return 1;
        }
        else return 0;
    }
}


