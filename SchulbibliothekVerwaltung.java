package SchulBib_Version_Schueler; /**
 * Beschreibung
 *
 * @version 1.0 vom 11.12.2016
 * @author Elisabeth Engel
 */

import java.util.ArrayList;
import java.util.Comparator;

public class SchulbibliothekVerwaltung {
    // Anfang Attribute
    private static int maxAusleihDauer;
    private ArrayList<Leser> leser;
    private ArrayList<Ausleihe> ausleihen;
    private ArrayList<Buch> buecher;
    // Ende Attribute

    public SchulbibliothekVerwaltung() {
        leser = new ArrayList<>();
        ausleihen = new ArrayList<>();
        buecher = new ArrayList<>();

        //Testdaten erzeugen
        registrierenLeser(47, "LÖWE", "Robin");
        registrierenLeser(12, "FUCHS", "Bettina");
        registrierenLeser(5, "WEBER", "Susanne");
        registrierenLeser(18, "MEIER", "Malte");
        registrierenLeser(33, "MEIER", "Ulrike");
        registrierenLeser(47, "LÖWE", "Robin");


        Buch b1 = anlegenBuch("923-123-456", "Grundkurs Java", "Dietmar Abts");
        Buch b2 = anlegenBuch("923-123-445","Grundkurs JS","Elias Roth");
        Buch b3 = anlegenBuch("923-123-334","Grundkurs Python","Elias Paul");
        Exemplar exemplar = new Exemplar(b1);
        aufnehmenExemplar(b1);
        aufnehmenExemplar(b2);
        aufnehmenExemplar(b3);

        Ausleihe a1 = ausleihenBuch(exemplar, sucheLeser(0, leser.size(), 12));
        a1.getAusleihDat().setDate(20, 11, 2016);

        rueckgebenBuch(a1);
        Ausleihe a2 = ausleihenBuch(exemplar,registrierenLeser(47, "LÖWE", "Robin"));
        Ausleihe a3 = ausleihenBuch(exemplar, sucheLeser(0,leser.size(),18));
    }
    // Anfang Methoden

    /**
     * Methode instanziiert das Leser-Objekt, wenn es noch nicht existiert,
     * und f�gt es nach der leserNr aufsteigend sortiert in die Liste leser ein.
     *
     * @param leserNr des Leser-Objekts als Ganzzahl
     * @param name des Leser-Objekts als String
     * @param vorname des Leser-Objekts als String
     * @return Bereits existierendes oder neues Leser-Objekt
     */
    public Leser registrierenLeser(int leserNr, String name, String vorname) {
        Leser leserObjekt = new Leser(leserNr, name, vorname);
        if (leserObjekt == null) leser.add(leserObjekt);
        leser.add(leserObjekt);
        return leserObjekt;
    }

    /**
     * Methode sucht mit Hilfe der bin�ren Suche das Leser-Objekt mit der
     * entsprechenden leserNr und gibt es zur�ck.
     *
     * @param leserNr des Leser-Objekts als Ganzzahl
     * @return Leser-Objekt oder null, wenn nicht gefunden
     */
    public Leser sucheLeser(int start, int ende, int leserNr) {
        ende = leser.size() - 1;

        while (start <= ende){
            int m = (start+ende)/2;

            if(leserNr == leser.get(m).getLeserNr()) return leser.get(m);
            else if(leserNr < leser.get(m).getLeserNr()) ende = m - 1;
            else start = m + 1;
        }
        return null;
    }


    /**
     * Methode erzeugt eine neue Liste für Leser, fügt die Leser-Objekte aus leser
     * sortiert nach Namen (1. Filter) und Vornamen (2. Filter) aufsteigend ein
     * und gibt die sortierte Liste zurück.
     *
     * @return Liste der Leser nach Namen sortiert
     */

    public ArrayList<Leser> generiereSortierteLeserListe() {
        ArrayList<Leser> neueLeser = new ArrayList<>();
        for (int i = 0; i < leser.size()-1; i++) {
        }

        return neueLeser;
    }

    /**
     * Methode sortiert die Buch-Objekte im Container buecher aufsteigend
     * nach der ISBN-Nummer.
     * Hinweis: Sortieralgorithmus Bubble-Sort
     *
     */
    public void sortiereBuecher() {
        Buch k;
        boolean getauscht;
        do {
            getauscht = false;
            for (int i = 0; i < buecher.size() - 1; i++) {
                if (buecher.get(i).getIsbn().compareTo(buecher.get(i + 1).getIsbn()) < 0) {
                    continue;
                }
                getauscht = true;
                k = buecher.get(i + 1);
                buecher.remove(k);
                buecher.add(i, k);
            }
        } while (getauscht);
    }

    /**
     * Methode instanziiert das Buch-Objekt, wenn es noch nicht existiert,
     * und f�gt es in die Liste buecher ein.
     *
     * @param isbn des Buch-Objekts als String
     * @param titel des Buch-Objekts als String
     * @param autor des Buch-Objekts als String
     * @return Bereits existierendes oder neues Buch-Objekt
     */
    public Buch anlegenBuch(String isbn, String titel, String autor) {
        Buch buchObjekt = new Buch(isbn, titel, autor);
        if (buchObjekt == null) buecher.add(buchObjekt);
        return buchObjekt;
    }

    /**
     * Methode sucht das Buch-Objekt mit der entsprechenden ISBN und gibt es zur�ck.
     *
     * @param isbn des Buch-Objekts als String
     * @return Buch-Objekt oder null, wenn es nicht existiert
     */
    public Buch sucheBuch(String isbn) {
        for (Buch b : buecher) {
            if (b.getIsbn().equals(isbn)) return b;
        }
        return null;
    }

    /**
     * Methode f�gt dem Exemplar-Container von Buch das neue Exemplar hinzu.
     *
     * @param buch
     */
    public void aufnehmenExemplar(Buch buch) {
        buecher.add(buch);
    }

    /**
     * Methode sucht im Buch-Objekt nach einem nicht ausgeliehenen Exemplar.
     *
     * @param buch
     * @return Exemplar-Objekt oder null, wenn keins vorhanden
     */
    public Exemplar sucheNichtAusgeliehenesExemplar(Buch buch) {
        for (int i = 0; i < buecher.size()-1; i++) {
            if(ausleihen.get(i) == null)
                System.out.println("Buch wurde nicht ausgeliehen!");
            return new Exemplar(buch);
        }
        return null;
    }

    /**
     * Methode erzeugt ein Ausleihe-Objekt, f�gt es dem Ausleihe-Container hinzu
     * und gibt das Ausleihe-Objekt zur�ck.
     *
     * @param ex ist das Exemplar, das ausgeliehen wird
     * @param leser, der Leser, der das Buch ausleiht
     * @return neues Ausleihe-Objekt
     */
    public Ausleihe ausleihenBuch(Exemplar ex, Leser leser) {
        Ausleihe ausleiheObjekt = new Ausleihe(ex,leser);
        ausleihen.add(ausleiheObjekt);
        return ausleiheObjekt;
    }

    /**
     * Methode setzt das R�ckgabedatum bei dem Ausleih-Objekt auf das aktuelle Datum.
     * Das Attribut istAusgeliehen von Exemplar wird auf false gesetzt.
     * Wenn die maximale Ausleihdauer �berschritten wurde,
     * wird false zur�ckgegeben, ansonsten true.
     *
     * @param *buch*
     * @return Exemplar-Objekt oder null, wenn keins vorhanden
     */
    public boolean rueckgebenBuch(Ausleihe ausleihe) {
        Date date = new Date(22, 12, 2021);
        Exemplar ex = new Exemplar(ausleihe.getExemplar().getBuch());

        ausleihe.setRueckgabeDat(date);
        ex.setIstAusgeliehen(false);

        if (getMaxAusleihDauer() == 12) return true;
        else return false;
    }

    /**
     * Methode erzeugt einen neuen Container f�r Ausleihen.
     * Es werden alle Ausleihen im Container ausleihen durchsucht.
     * Wenn die maximale Ausleihdauer des Ausleih-Objekts �berschritten ist,
     * wird das Objekt dem neuen Container hinzugef�gt.
     *
     * @return Container mit den Ausleihen, deren maximale Ausleihdauer �berschritten ist
     */
    public ArrayList<Ausleihe> sucheOffeneAusleihen() {
        ArrayList<Ausleihe> ausleiheArrayList = new ArrayList<>();

        for (int i = 0; i < ausleihen.size()-1; i++) {
            if(getMaxAusleihDauer() == 12)
                ausleiheArrayList.add(ausleihen.get(i));
        }
        return ausleiheArrayList;
    }

    public ArrayList<Leser> getLeser() {
        return leser;
    }

    public ArrayList<Ausleihe> getAusleihen() {
        return ausleihen;
    }

    public ArrayList<Buch> getBuecher() {
        return buecher;
    }

    public static int getMaxAusleihDauer() {
        return maxAusleihDauer;
    }

    public static void setMaxAusleihDauer(int maxAusleihDauer) {
        SchulbibliothekVerwaltung.maxAusleihDauer = maxAusleihDauer;
    }
}
