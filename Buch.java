package SchulBib_Version_Schueler;

import java.util.ArrayList;
public class Buch {
  private String isbn;
  private String titel;
  private String autor;
  private ArrayList<Exemplar> exemplare;
  
  public Buch(String isbn, String titel, String autor) {
    this.isbn = isbn;
    this.titel = titel;
    this.autor = autor;
    exemplare = new ArrayList<>();
  }
    
  public void hinzufuegenExemplar(Exemplar ex) {
    exemplare.add(ex);
  }
  public boolean loescheExemplar(Exemplar ex) {
    return exemplare.remove(ex);
  }
  public String getIsbn() {
    return isbn;
  }
  public String getTitel() {
      return titel;
    }
  public String getAutor() {
    return autor;
  }
  public ArrayList<Exemplar> getExemplare() {
    return exemplare;
  }
  public String toString() {
    return "Titel : " + titel + "\nAutor: " + autor + "\nISBN: " + isbn + "\n";
  }
}
