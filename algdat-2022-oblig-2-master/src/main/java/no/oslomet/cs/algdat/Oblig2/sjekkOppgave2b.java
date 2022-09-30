package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave2b {
    public static void main(String[] args) {
        String[] s1 = {"A","B","C"};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);

        System.out.println(l1.leggInn("D"));
        System.out.println(l1.toString());

        String[] s2 = {"A","D","F","G"};
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);

        System.out.println(l2.leggInn("A"));
        System.out.println(l2.toString());
        System.out.println(l2.hent(2));

        /*String[] s3 = {"A","B"};
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);

        System.out.println(l3.leggInn(null));
        System.out.println(l3.toString());*/
    }
}
