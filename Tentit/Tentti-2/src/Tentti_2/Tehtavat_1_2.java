package Tentti_2;

public class Tehtavat_1_2 {

    public static void main(String[] args) {
        Name n = new Name("Jari", "Kyngäs");
        StudyModule sm = new StudyModule("1", "Java-ohjelmointi", 8);
        StudyModule sm2 = new StudyModule("1", "Java-ohjelmointi", 8, n);
       
        System.out.println("Nimi: ");
        System.out.println(n.toString());
        System.out.println("Ilman tietoa opettajasta: ");
        System.out.println(sm.toString());
        System.out.println("Tieto opettajasta: ");
        System.out.println(sm2.toString());
        System.out.println();
        
        StudyModuleExtended sme = new StudyModuleExtended("1", "Java-ohjelmointi", 8, "Tietojenkäsittely", 50);
        StudyModuleExtended sme2 = new StudyModuleExtended("1", "Java-ohjelmointi", 8, n, "Tietojenkäsittely", 50);
        
        System.out.println("Periytetty luokka lisätiedoilla: ");
        System.out.println("Ilman tietoa opettajasta: ");
        System.out.println(sme.toString());
        System.out.println("Tieto opettajasta: ");
        System.out.println(sme2.toString());
    }
    
}
class Name {
  String forename;
  String surname;
  
  public Name (String fn, String sn){
      forename = fn;
      surname = sn;
  }
  
  @Override
  public String toString() {
    return (forename + " " + surname);
  }
}

class StudyModule {
    /**
     * Tehtävä 2. 
    * Jos kaikki ominaisuudet olisivat määritelty "protected" näkyvyysmääreellä,
    * vain itse sillä luokalla, sen aliluokilla ja samassa paketissa olevilla luokilla on pääsy niihin.
    * Tämä voi olla tarkoituskellista ja hyödyllistä tapauskohtaisesti, mutta mikäli tietoihin tarvitsisi
    * päästä käsiksi muualta kuin kyseisistä luokista, se ei silloin onnistu, ellei luokkaa periytetä.
    * Tässä yhteydessä protected määreestä ei ole haittaa, sillä luokka StudyModuleExtended on periytetty
    * StudyModule luokasta, ja täten pääsy protected määreellä varustettuihin ominaisuuksiin.
    **/
    
  String code;
  String name;
  int credit;
  Name teacher;
  
  public StudyModule(String cd, String nm, int cred, Name tchr){
      code = cd;
      name = nm;
      credit = cred;
      teacher = tchr;
  }
  public StudyModule(String cd, String nm, int cred){
      this (cd, nm, cred, null);
  }
  
  @Override
  public String toString() {
      if (teacher != null) {
        return "Koodi: " + code + ", Nimi: " + name + ", Opintopisteet: " + credit + " OP, Opettaja: " + teacher;
      }
     return "Koodi: " + code + ", Nimi: " + name + ", Opintopisteet: " + credit + " OP, Opettaja: ei tiedossa";
  }
}

class StudyModuleExtended extends StudyModule{
    String program;
    int seats;
    public StudyModuleExtended(String cd, String nm, int cred, Name tchr, String prg, int st){
        super(cd, nm, cred, tchr);
        this.program = prg;
        this.seats = st;
    }
      public StudyModuleExtended(String cd, String nm, int cred, String prg, int st){
        super(cd, nm, cred, null);
        this.program = prg;
        this.seats = st;
  }
    
    public String toString() {
        return super.toString() + ", Koulutusohjelma: " + program + ", Paikkojen määrä: " + seats;
    }
}

