package SchulBib_Version_Schueler;

public class TestUI {
    public static void main(String[] args) {
        SchulbibliothekVerwaltung s = new SchulbibliothekVerwaltung();

        System.out.println(s.registrierenLeser(1,"Roth","Elias"));
        System.out.println(s.generiereSortierteLeserListe());

        //Funktioniert nicht richtig
        System.out.println(s.sucheLeser(1));
        //Funktioniert nicht s.sortiereBuecher();

        System.out.println(s.anlegenBuch("111-111-111","KA","Jens"));
        System.out.println(s.sucheBuch("923-123-456"));
        s.aufnehmenExemplar(s.getBuecher().get(1));

        //Funktioniert nicht richtig
        System.out.println(s.sucheNichtAusgeliehenesExemplar(s.getBuecher().get(0)));

        System.out.println("HIER BIN ICH");
        System.out.println(s.ausleihenBuch(s.getBuecher().get(0).getExemplare().get(0),s.getLeser().get(0)));

        //Weiß nicht, ob es richtig geht
        System.out.println(s.rueckgebenBuch(s.getAusleihen().get(0)));
    }
}
