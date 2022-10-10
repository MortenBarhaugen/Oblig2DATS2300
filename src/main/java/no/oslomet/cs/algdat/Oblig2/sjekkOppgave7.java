package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave7 {
    public static void main(String[] args) {
        int antallFeil = 0;

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        for (int i = 0; i <= 100000; i++) {
            liste.leggInn(i);
        }

        liste.nullstill();

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println
                    ("Oppgave 7a: Feil i antalloppdateringen i nullstill!");
        }

        if (!liste.toString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 7b: Feil i metoden nullstill()!");
        }

        if (!liste.omvendtString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 7c: Feil i metoden nullstill()!");
        }

        if (liste.indeksTil(1) != -1) {
            antallFeil++;
            System.out.println("Oppgave 7d: Feil i metoden nullstill()!");
        }
    }
}
