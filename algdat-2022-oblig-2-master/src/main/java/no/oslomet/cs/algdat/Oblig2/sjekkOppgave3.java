package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave3 {
    public static void main(String[] args) {
        String[] s2 = {"A","D","F","G"};
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        System.out.println(l2.hent(2));
    }
}
