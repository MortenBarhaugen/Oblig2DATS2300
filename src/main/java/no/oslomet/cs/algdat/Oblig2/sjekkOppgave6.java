package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave6 {
    public static void main(String[] args) {
        /*DobbeltLenketListe<String> liste = new DobbeltLenketListe<>();
        liste = new DobbeltLenketListe<>(new String[]{"A", "B", "C", "D", "E", "F", "G"});

        liste.fjern("C");
        System.out.println(liste.toString());
        System.out.println(liste.omvendtString());*/

        int antallFeil = 0;

        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>();

        try {
            liste.fjern(0);
            antallFeil++;
            System.out.println("Oppgave 6a: Indeks 0 finnes ikke i en tom liste!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println
                        ("Oppgave 6b: Indekssjekken kaster feil unntak!");
                antallFeil++;
            }
        }

        liste = new DobbeltLenketListe<>(new String[]{"A", "B", "C", "D", "E", "F", "G"});

        try {
            liste.fjern(7);
            antallFeil++;
            System.out.println("Oppgave 6c: Indeks 7 finnes ikke!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 6d: Indekssjekken kaster feil unntak!!");
                antallFeil++;
            }
        }

        try {
            liste.fjern(-1);
            antallFeil++;
            System.out.println("Oppgave 6e: Indeks -1 finnes ikke!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 6f: Indekssjekken kaster feil unntak!!");
                antallFeil++;
            }
        }

        if (!liste.fjern(3).equals("D")) {
            antallFeil++;
            System.out.println("Oppgave 6ga: Feil returverdi i metoden fjern(indeks)!");
        }

        if (liste.antall() != 6) {
            antallFeil++;
            System.out.println("Oppgave 6gb: Feil i antall-oppdateringen i fjern(indeks)!");
            System.out.println("             Reduseres ikke antall? Reduserers den to ganger!");
        }

        liste.fjern(0);  // fjerner A
        liste.fjern(4);  // fjerner G

        if (liste.antall() != 4) {
            antallFeil++;
            System.out.println("Oppgave 6h: Feil i antall-oppdateringen i fjern(indeks)!");
        }

        if (!liste.toString().equals("[B, C, E, F]")) {
            antallFeil++;
            System.out.println("Oppgave 6i: Feil i fjern(indeks)-metoden!");
        }

        if (!liste.omvendtString().equals("[F, E, C, B]")) {
            antallFeil++;
            System.out.println("Oppgave 6j: Feil i fjern(indeks)-metoden!");
        }

        liste.leggInn("H");
        liste.leggInn("I");

        if (liste.fjern(" ") == true
                || liste.fjern("G") == true
                || liste.fjern("J") == true) {
            antallFeil++;
            System.out.println("Oppgave 6ka: Feil returverdi i metoden fjern(T)!");
        }

        liste.leggInn("B");
        liste.fjern("B");

        if (liste.antall() != 6) {
            antallFeil++;
            System.out.println("Oppgave 6kb: Feil i antall-oppdateringen i fjern(T)!");
            System.out.println("             Reduseres ikke antall? Reduserers den to ganger!");
        }

        if (!liste.toString().equals("[C, E, F, H, I, B]")) {
            antallFeil++;
            System.out.println("Oppgave 6kc: Skal fjerne første forekomst hvis flere like!");
        }

        liste.fjern("B");

        if (liste.fjern("F") != true
                || liste.fjern("I") != true) {
            antallFeil++;
            System.out.println("Oppgave 6l: Feil returverdi i metoden fjern(T)!");
        }

        if (!liste.toString().equals("[C, E, H]")) {
            antallFeil++;
            System.out.println("Oppgave 6m: Feil i metoden fjern(T)!");
        }

        if (!liste.omvendtString().equals("[H, E, C]")) {
            antallFeil++;
            System.out.println("Oppgave 6n: Feil i metoden fjern(T)!");
        }

        liste.fjern("H");
        liste.fjern("C");
        liste.fjern("E");

        if (!liste.toString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 6o: Feil i metoden fjern(T)!");
        }

        if (!liste.omvendtString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 6p: Feil i metoden fjern(T)!");
        }

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println(
                    "Oppgave 6q: Feil i antall-oppdateringen metoden fjern(T)!");
        }

        try {
            if (liste.fjern(null) != false) {
                antallFeil++;
                System.out.println
                        ("Oppgave 6r: skal returnere false for en null-verdi!");
            }
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6s: Skal ikke kaste unntak, men returnere false for en null-verdi!");
            antallFeil++;
        }

        liste = new DobbeltLenketListe<>();
        liste.leggInn("A");
        liste.leggInn("B");
        liste.leggInn("C");
        liste.leggInn("D");
        liste.leggInn("E");

        if (liste.fjern(new String("A")) != true
                || liste.fjern(new String("E")) != true
                || liste.fjern(new String("C")) != true
                || liste.fjern(new String("B")) != true
                || liste.fjern(new String("D")) != true) {
            antallFeil++;
            System.out.println("Oppgave 6t: Stygg feil! Du MÅ bruke equals");
            System.out.println("            og ikke == i sammenligningen i fjern(T)!");
        }

        liste = new DobbeltLenketListe<>();
        liste.leggInn("A");

        try {
            liste.fjern(0);
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6u: Her kastes det et unntak, men det skal ikke skje!!");
            antallFeil++;
        }

        if (!liste.toString().equals("[]")) {
            System.out.println
                    ("Oppgave 6v: Her må det være en pekerfeil!");
            antallFeil++;
        }

        if (!liste.omvendtString().equals("[]")) {
            System.out.println
                    ("Oppgave 6w: Her må det være en pekerfeil!");
            antallFeil++;
        }

        liste.leggInn("A");

        try {
            liste.fjern("A");
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6x: Her kastes det et unntak, men det skal ikke skje!!");
            antallFeil++;
        }

        if (!liste.toString().equals("[]")) {
            System.out.println
                    ("Oppgave 6y: Her må det være en pekerfeil!");
            antallFeil++;
        }

        if (!liste.omvendtString().equals("[]")) {
            System.out.println
                    ("Oppgave 6z: Her må det være en pekerfeil!");
            antallFeil++;
        }

        liste.leggInn("A");
        liste.leggInn("B");

        try {
            liste.fjern(1);
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6za: Her kastes det et unntak, men det skal ikke skje!!");
            antallFeil++;
        }

        if (!liste.toString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6zb: Her må det være en pekerfeil!");
            antallFeil++;
        }

        if (!liste.omvendtString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6zc: Her må det være en pekerfeil!");
            antallFeil++;
        }

        liste.leggInn("B");

        try {
            liste.fjern("B");
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6zd: Her kastes det et unntak, men det skal ikke skje!!");
            antallFeil++;
        }

        if (!liste.toString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6ze: Her må det være en pekerfeil!");
            antallFeil++;
        }

        if (!liste.omvendtString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6zf: Her må det være en pekerfeil!");
            antallFeil++;
        }

        Liste<Integer> nyliste = new DobbeltLenketListe<>();

        for (int i = 1; i <= 100_000; i++) nyliste.leggInn(i);
        long tid1 = System.currentTimeMillis();
        for (int i = 40000; i <= 50000; i++) nyliste.fjern(new Integer(i));
        tid1 = System.currentTimeMillis() - tid1;
        nyliste = new DobbeltLenketListe<>();

        for (int i = 1; i <= 100_000; i++) nyliste.leggInn(i);
        long tid2 = System.currentTimeMillis();
        for (int i = 40000; i <= 50000; i++) nyliste.fjern(i);
        tid2 = System.currentTimeMillis() - tid2;

        long maks = Math.max(tid1, tid2);
        long min = Math.min(tid1, tid2);

        System.out.println(tid2);
        System.out.println(tid1);
        System.out.println(1.5*min);

        if (maks > 1.5 * min) {
            System.out.println("Oppgave 6zg: Ineffektiv kode! Har du kodet den ene fjern-metoden");
            System.out.println("ved hjelp av den andre? Eller så er en av fjern-metodene dine litt treg.");
            antallFeil++;
        }
    }
}
