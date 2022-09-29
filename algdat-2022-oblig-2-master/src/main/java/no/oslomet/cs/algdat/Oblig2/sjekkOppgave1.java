package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave1 {
    public static void main(String[] args) {
        String[] s1 = {"D",null,"E","F","G", null};
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(s1);
        System.out.println(liste.antall() + " " + liste.tom());

        String[] s3 = {};
        DobbeltLenketListe<String> liste3 = new DobbeltLenketListe<>(s3);
        System.out.println(liste3.antall() + " " + liste3.tom());
    }
}
