package SchulBib_Version_Schueler;

public class Exemplar {
  // Anfang Attribute
  private int signatur;
  private boolean istAusgeliehen;
  private Buch buch;
  private static int autowert = 1;
  // Ende Attribute
  
  public Exemplar(Buch buch) {
    this.signatur = autowert++;
    this.istAusgeliehen = false;
    this.buch = buch;
    this.buch.hinzufuegenExemplar(this);
  }
  // Anfang Methoden
  public boolean istAusgeliehen() {
    return istAusgeliehen;
  }

  public int getSignatur() {
    return signatur;
  }
  public Buch getBuch() {
    return buch;
  }
  public void setIstAusgeliehen(boolean istAusgeliehen) {
    this.istAusgeliehen = istAusgeliehen;
  }

  // Ende Methoden
}
