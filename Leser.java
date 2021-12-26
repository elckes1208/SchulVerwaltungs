package SchulBib_Version_Schueler;

public class Leser {
   private int leserNr;
   private String name;
   private String vorname;
   
   public Leser(int leserNr, String name, String vorname) {
     this.leserNr = leserNr;
     this.name = name;
     this.vorname = vorname;
   }
   
   public int getLeserNr() {
     return leserNr;
   }
   public String getName() {
     return name;
   }
   public String getVorname() {
     return vorname;
   }
   public String toString() {
     return name + ", " + vorname + " (LeserNr " + leserNr + ")";
   }
}
