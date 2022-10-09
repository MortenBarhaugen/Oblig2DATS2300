package no.oslomet.cs.algdat.Oblig2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class sjekkOppgave8 {
    public static void main(String[] args) {


        String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Liste<String> liste = new DobbeltLenketListe<>(navn);
        liste.forEach(s -> System.out.print(s + " "));
        System.out.println();
        for (String s : liste) System.out.print(s + " ");


        /*int antallFeil = 0;

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        try {
            Iterator<Integer> i = liste.iterator();
            i.next();  // kaller next() i en tom liste
            System.out.println(
                    "Oppgave 8a: Skal kastes unntak for next() i en tom liste!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof NoSuchElementException)) {
                System.out.println("Oppgave 8b: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        liste.leggInn(1);

        Iterator<Integer> i = liste.iterator();

        if (i.next() != 1) {
            System.out.println
                    ("Oppgave 8c: Metoden next() gir feil verdi!");
            antallFeil++;
        }

        try {
            i.next();  // det er ikke flere i listen

            System.out.println(
                    "Oppgave 8d: Skal kastes unntak for next() her!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof NoSuchElementException)) {
                System.out.println("Oppgave 8e: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        for (int k = 2; k <= 7; k++) {
            liste.leggInn(k);
        }

        int k = 1;
        for (Iterator<Integer> j = liste.iterator(); j.hasNext(); ) {
            if (j.next() != k) {
                System.out.println("Oppgave 8f: Metoden next() gir feil verdier!");
                antallFeil++;
            }
            k++;
        }

        i = liste.iterator();
        liste.fjern(0); // bruker fjern(indeks) etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8g: ForventetAntallEndringer ikke endret i fjern(indeks)!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8h: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.leggInn(8);  // bruker leggInn(T) etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8i: ForventetAntallEndringer ikke endret i leggInn(T)!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8j: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.fjern(new Integer(8));  // bruker fjern(T) etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8k: ForventetAntallEndringer ikke endret i fjern(T)!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8l: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.leggInn(0, 1);  // bruker leggInn(indeks,T) etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8m: ForventetAntallEndringer ikke endret i leggInn(indeks,T)!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8n: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.oppdater(3, 9);  // oppdaterer etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8o: ForventetAntallEndringer ikke endret i oppdater()!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8p: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        i = liste.iterator();
        liste.nullstill();  // nullstiller etter at iteratoren er opprettet

        try {
            i.next();
            antallFeil++;
            System.out.println
                    ("Oppgave 8q: ForventetAntallEndringer ikke endret i nullstill()!");
        } catch (Exception e) {
            if (!(e instanceof ConcurrentModificationException)) {
                System.out.println("Oppgave 8r: Det kastes feil type unntak!");
                antallFeil++;
            }
        }

        for (int j = 1; j <= 7; j++) liste.leggInn(j);

        try {
            liste.iterator(7);
            System.out.println("Oppgave 8s: Indeks 7 finnes ikke!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 8t: Metoden kaster feil type unntak!");
                antallFeil++;
            }
        }

        try {
            liste.iterator(-1);
            System.out.println("Oppgave 8u: Indeks -1 finnes ikke!");
            antallFeil++;
        } catch (Exception e) {
            if (!(e instanceof IndexOutOfBoundsException)) {
                System.out.println("Oppgave 8v: Metoden kaster feil type unntak!");
                antallFeil++;
            }
        }

        int m = 4;
        i = liste.iterator(3);
        for (; i.hasNext(); ) {
            if (i.next() != m) {
                antallFeil++;
                System.out.println("Oppgave 8w: Feil i metoden next()!");
            }
            m++;
        }

        try {
            i.next();
            antallFeil++;
            System.out.println("Oppgave 8x: Skal kaste unntak for next() her!");
        } catch (Exception e) {
            if (!(e instanceof NoSuchElementException)) {
                System.out.println("Oppgave 8y: Det kastes feil type unntak!");
                antallFeil++;
            }
        }*/
    }
}
