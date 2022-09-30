package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave4 {
    public static void main(String[] args) {
        String[] s2 = {"A","D","F","G"};
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        String verdi = "F";
        System.out.println("Indeks til verdi: " + verdi + ", er: " + l2.indeksTil("F"));
    }
}
