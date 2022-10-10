package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave4 {
    public static void main(String[] args) {
        int antallFeil = 0;

        DobbeltLenketListe<String> sliste = new DobbeltLenketListe<>();
        sliste.leggInn("A");

        if (sliste.indeksTil(new String("A")) != 0) {
            antallFeil++;
            System.out.println("Oppgave 4a: Stygg feil! Du MÅ bruke equals");
            System.out.println("            og ikke == i sammenligningen i indeksTil()!");
        }

        Liste<Integer> liste = new DobbeltLenketListe<>();

        if (liste.indeksTil(2) != -1) {
            antallFeil++;
            System.out.println("Oppgave 4b: En tom liste inneholder ikke noe!");
        }

        liste.leggInn(1);

        if (liste.indeksTil(1) != 0) {
            antallFeil++;
            System.out.println("Oppgave 4c: Verdien 1 har indeks 0!");
        }

        liste.leggInn(3);
        liste.leggInn(5);
        liste.leggInn(7);

        if (liste.indeksTil(10) != -1 || liste.indeksTil(4) != -1) {
            antallFeil++;
            System.out.println("Oppgave 4d: Listen inneholder hverken 4 eller 10!");
        }

        if (liste.indeksTil(1) != 0 || liste.indeksTil(3) != 1
                || liste.indeksTil(5) != 2 || liste.indeksTil(7) != 3) {
            antallFeil++;
            System.out.println("Oppgave 4e: Feil i metoden indeksTil()!");
        }

        try {
            if (liste.indeksTil(null) != -1) {
                antallFeil++;
                System.out.println
                        ("Oppgave 4f: Skal returnere -1 for null-verdier!");
            }
        } catch (Exception e) {
            System.out.println(
                    "Oppgave 4g: Skal ikke kaste unntak, men returnere -1 for null-verdier!");
            antallFeil++;
        }

        if (liste.inneholder(1) != true || liste.inneholder(7) != true
                || liste.inneholder(0) != false || liste.inneholder(6) != false) {
            antallFeil++;
            System.out.println("Oppgave 4h: Feil i metoden inneholder()!");
        }

        sliste = new DobbeltLenketListe<>();
        sliste.leggInn("Kari");
        sliste.leggInn("Kari");

        if (sliste.indeksTil("Kari") != 0) {
            antallFeil++;
            System.out.println
                    ("Oppgave 4i: Skal gi indeks til første forekomst hvis like verdier!");
        }
        System.out.println(antallFeil);
    }
}
