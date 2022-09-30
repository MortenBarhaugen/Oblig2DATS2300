package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave5 {
    public static void main(String[] args) {
        String[] s2 = {"A","D","F","G","H","L"};
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        String verdi = "W";
        l2.leggInn(3, verdi);
        System.out.println(l2);
    }
}
