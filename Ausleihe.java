package SchulBib_Version_Schueler;

public class Ausleihe {
  // Anfang Attribute
  private int ausleihNr;
  private Exemplar exemplar;
  private Leser ausleiher;
  private Date ausleihDat;
  private Date rueckgabeDat;
  private static int autowert = 1;
  // Ende Attribute
  
  public Ausleihe(Exemplar ex, Leser ausleiher) {
    this.ausleihNr = autowert++;
    this.exemplar = ex;
    this.exemplar.setIstAusgeliehen(true);
    this.ausleiher = ausleiher;
    this.ausleihDat = new Date();
    this.rueckgabeDat = null; 
  }
  // Anfang Methoden
  public int getAusleihNr() {
    return ausleihNr;
  }

  public Exemplar getExemplar() {
    return exemplar;
  }

  public Leser getAusleiher() {
    return ausleiher;
  }

  public Date getAusleihDat() {
    return ausleihDat;
  }

  public Date getRueckgabeDat() {
    return rueckgabeDat;
  }

  public String toString() {
    return "Ausleihnummer " + ausleihNr +
           "\nSignatur " + exemplar.getSignatur() + "\n" +
           exemplar.getBuch().toString() + "Ausleihdatum " + ausleihDat + 
           ", R�ckgabedatum " + rueckgabeDat + "\nAusleiher: " +                
           ausleiher.toString() + "\n";
  }

  public void setRueckgabeDat(Date rueckgabeDat) {
    this.rueckgabeDat = rueckgabeDat;
  }

  // Ende Methoden

}
