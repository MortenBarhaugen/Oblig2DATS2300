package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave3 {
    public static void main(String[] args) {
        int antallFeil = 0;

        Liste<Integer> testliste = new DobbeltLenketListe<>();
        for (int i = 0; i < 100000; i++) testliste.leggInn(i);
        long tid = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) testliste.hent(99999);
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            antallFeil++;
            System.out.println("Oppgave 3a: Dette (" + tid + " ms) gikk altfor sakte!");
            System.out.println("            Har du kodet metoden finnNode() riktig?");
        }

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        try {
            liste.hent(0);
            antallFeil++;
            System.out.println("Oppgave 3b: En tom liste har ikke indeks lik 0!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 3c: Metoden hent() kaster feil type unntak!");
                antallFeil++;
            }
        }

        liste.leggInn(1);

        try {
            liste.hent(-1);
            antallFeil++;
            System.out.println("Oppgave 3d: Feil i indeks-sjekken!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 3e: Metoden hent() kaster feil type unntak!");
                antallFeil++;
            }
        }

        try {
            liste.hent(1);
            antallFeil++;
            System.out.println("Oppgave 3f: Feil i indeks-sjekken!");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 3g: Metoden hent() kaster feil type unntak!");
                antallFeil++;
            }
        }

        if (liste.hent(0) != 1) {
            antallFeil++;
            System.out.println("Oppgave 3h: Metoden hent() gir feil svar!");
        }

        liste.leggInn(2);
        liste.leggInn(3);
        liste.leggInn(4);

        if (liste.hent(3) != 4 || liste.hent(2) != 3
                || liste.hent(1) != 2 || liste.hent(0) != 1) {
            antallFeil++;
            System.out.println("Oppgave 3i: Metoden hent() gir feil svar!");
        }

        try {
            liste.oppdater(3, null);
            antallFeil++;
            System.out.println("Oppgave 3j: Ikke tillatt med nullverdier i oppdater!");
        } catch (Exception e) {
            if (!(e instanceof NullPointerException)) {
                System.out.println(
                        "Oppgave 3k: Feil unntak for nullverdier i oppdater()!");
                antallFeil++;
            }
        }

        try {
            liste.oppdater(4, 5);
            antallFeil++;
            System.out.println
                    ("Oppgave 3l: En liste med fire verdier har ikke indeks lik 4");
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println
                        ("Oppgave 3m: Metoden kaster feil type unntak for indeksfeil!");
                antallFeil++;
            }
        }

        if (liste.oppdater(3, 5) != 4) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3n: Metoden oppdater() returnerer feil verdi!");
        }

        if (liste.antall() != 4) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3o: antallEndringer skal økes, men antall skal ikke endres!");
        }

        if (liste.hent(3) != 5) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3p: Metoden oppdater() setter verdien feil!");
        }

        if (liste.oppdater(0, -1) != 1) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3q: Metoden oppdater() returnerer feil verdi!");
        }

        if (liste.hent(0) != -1) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3r: Metoden oppdater() setter verdien feil!");
        }

        String s = liste.toString();
        if (!s.equals("[-1, 2, 3, 5]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3s: Du har " + s + ", skal være [-1, 2, 3, 5]!");
        }

        s = liste.omvendtString();
        if (!s.equals("[5, 3, 2, -1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3t: Du har " + s + ", skal være [5, 3, 2, -1]!");
        }

        Integer[] i = {};
        DobbeltLenketListe<Integer> iliste = new DobbeltLenketListe<>(i);

        if (!iliste.subliste(0, 0).toString().equals("[]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3u: Sublisten til en tom liste skal være tom!");
        }

        Character[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',};
        DobbeltLenketListe<Character> cliste = new DobbeltLenketListe<>(c);

        if (!cliste.subliste(0, 1).toString().equals("[A]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3v: Sublisten skal inneholde kun første verdi i listen!");
        }

        if (!cliste.subliste(9, 10).toString().equals("[J]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3w: Sublisten skal inneholde kun siste verdi i listen!");
        }

        if (!cliste.subliste(0, 2).toString().equals("[A, B]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3x: Sublisten skal inneholde kun de to første verdiene!");
        }

        if (!cliste.subliste(8, 10).toString().equals("[I, J]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3y: Sublisten skal inneholde kun de to siste verdiene!");
        }

        if (!cliste.subliste(3, 7).toString().equals("[D, E, F, G]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 3z: Sublisten skal inneholde [D, E, F, G]!");
        }

        try {
            cliste.subliste(9, 11);

            antallFeil++;
            System.out.println
                    ("Oppgave 3æ: Det skal kastes et unntak når til er større enn antall!");
        } catch (Exception e) {
            if (!e.getClass().getName().equals("java.lang.IndexOutOfBoundsException")) {
                antallFeil++;
                System.out.println
                        ("Oppgave 3ø: Skal ha IndexOutOfBoundsException her!");
            }

            if (e.toString().contains("tablengde")) {
                antallFeil++;
                System.out.println
                        ("Oppgave 3å: Bruk ikke tablengde i feilmeldingen! Bruk antall!");
            }
        }

        try {
            cliste.subliste(-1, 1);

            antallFeil++;
            System.out.println
                    ("Oppgave 3å1: Det skal kastes et unntak når fra er negativ!");
        } catch (Exception e) {
            if (!e.getClass().getName().equals("java.lang.IndexOutOfBoundsException")) {
                System.out.println
                        ("Oppgave 3å2: Skal ha IndexOutOfBoundsException her!");
                antallFeil++;
            }
        }

        try {
            cliste.subliste(2, 1);

            antallFeil++;
            System.out.println
                    ("Oppgave 3å3: Det skal kastes et unntak når fra er negativ!");
        } catch (Exception e) {
            if (!e.getClass().getName().equals("java.lang.IllegalArgumentException")) {
                System.out.println
                        ("Oppgave 3å4: Skal ha IllegalArgumentException her!");
                antallFeil++;
            }
        }
        System.out.println(antallFeil);
    }
}
