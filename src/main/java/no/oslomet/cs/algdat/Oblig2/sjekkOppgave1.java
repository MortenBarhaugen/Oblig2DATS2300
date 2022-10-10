package no.oslomet.cs.algdat.Oblig2;

import java.util.Arrays;

public class sjekkOppgave1 {
    public static void main(String[] args) {
        /*String[] s1 = {"D",null,"E","F","G", null};
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(s1);
        System.out.println(liste.antall() + " " + liste.tom());

        String[] s3 = {};
        DobbeltLenketListe<String> liste3 = new DobbeltLenketListe<>(s3);
        System.out.println(liste3.antall() + " " + liste3.tom());*/

        int antallFeil = 0;
        Liste<Integer> liste = new DobbeltLenketListe<>();

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1a: Feil i metoden antall()!");
        }

        if (liste.tom() != true) {
            antallFeil++;
            System.out.println("Oppgave 1b: Feil i metoden tom()!");
        }

        try {
            liste = new DobbeltLenketListe<>(null);
            antallFeil++;
            System.out.println("Oppgave 1c: Det skal kastes en NullPointerExcepiton her!");
        } catch (Exception e) {
            if (!(e instanceof NullPointerException)) {
                System.out.println
                        ("Oppgave 1d: Kaster feil type unntak for null-tabell!");
                antallFeil++;
            }
        }

        liste = new DobbeltLenketListe<>(new Integer[]{});

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1e: Feil i konstruktøren!");
        }

        if (liste.tom() != true) {
            antallFeil++;
            System.out.println("Oppgave 1f: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{1});

        if (liste.antall() != 1) {
            antallFeil++;
            System.out.println("Oppgave 1g: Feil i konstruktøren!");
        }

        if (liste.tom() != false) {
            antallFeil++;
            System.out.println("Oppgave 1h: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{1, 2});

        if (liste.antall() != 2) {
            antallFeil++;
            System.out.println("Oppgave 1i: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{1, 2, 3});

        if (liste.antall() != 3) {
            antallFeil++;
            System.out.println("Oppgave 1j: Feil i konstruktøren!");
        }

        Integer[] a = {1, 2, 3, 4, 5};
        Integer[] b = {1, 2, 3, 4, 5};
        liste = new DobbeltLenketListe<>(a);

        if (!Arrays.equals(a, b)) {
            antallFeil++;
            System.out.println("Oppgave 1k: Konstruktøren endrer parametertabellen!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null});

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1l: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, null});

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1m: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, null});

        if (liste.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 1n: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, 1, null});

        if (liste.antall() != 1) {
            antallFeil++;
            System.out.println("Oppgave 1o: Feil i konstruktøren!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, 1, null, 2, null, 3, null});

        if (liste.antall() != 3) {
            antallFeil++;
            System.out.println("Oppgave 1p: Feil i konstruktøren!");
        }

        class Test<T> extends DobbeltLenketListe<T> {
            public boolean leggInn(T verdi) {
                super.leggInn(verdi);
                super.leggInn(verdi);
                return true;
            }

            public Test(T[] a) {
                super(a);
            }
        }

        Integer[] tall = {1, 2, 3, 4, 5};
        Test<Integer> testliste = new Test(tall);

        if (testliste.antall() > 5) {
            antallFeil++;
            System.out.println("Oppgave 1q: leggInn-metoden brukes i konstruktøren!");
        }
    }
}
