package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave3b {
    public static void main(String[] args) {
        /*String[] s2 = {"A","D","F","G"};
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        System.out.println(l2.hent(2));

        l2.subliste(1, 2);
        System.out.println(l2.subliste(1,3));*/

        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        System.out.println(liste.subliste(3,8));  // [D, E, F, G, H]
        System.out.println(liste.subliste(5,5));  // []
        System.out.println(liste.subliste(8,liste.antall()));  // [I, J] Fungerer ikke!
        // System.out.println(liste.subliste(0,11));  // skal kaste unntak
    }
}
