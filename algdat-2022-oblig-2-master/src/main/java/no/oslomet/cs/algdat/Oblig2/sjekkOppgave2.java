package no.oslomet.cs.algdat.Oblig2;

public class sjekkOppgave2 {
    public static void main(String[] args) {
        /*String[] s1 = {}, s2 = {"A","B","C"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);

        System.out.println(l1.toString() + " " + l2.toString() + " " + l3.toString());

        System.out.println();

        System.out.println(l1.omvendtString() + " " + l2.omvendtString() + " " + l3.omvendtString());*/

        int antallFeil = 0;

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        if (liste.leggInn(1) != true) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2a: leggInn-metoden skal returnere true her!");
        }

        liste.leggInn(2);

        if (liste.antall() != 2) {
            antallFeil++;
            System.out.println("Oppgave 2b: leggInn-metoden oppdaterer ikke antall!");
        }

        try {
            liste.leggInn(null);
            antallFeil++;
            System.out.println
                    ("Oppgave 2c: leggInn skal stoppe null-verdier!");
        } catch (Exception e) {
            if (!(e instanceof NullPointerException)) {
                System.out.println
                        ("Oppgave 2d: Kaster feil type unntak for null-verdier i leggInn!");
                antallFeil++;
            }
        }

        liste = new DobbeltLenketListe<>();

        if (!liste.toString().equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 2e: Tom liste skal gi []!");
        }

        if (!liste.omvendtString().equals("[]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2f: Tom liste skal gi []!");
        }

        liste.leggInn(1);

        String s = liste.toString();
        if (!s.equals("[1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2g: Du har " + s + ", skal være [1]!");
        }

        s = liste.omvendtString();
        if (!s.equals("[1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2h: Du har " + s + ", skal være [1]!");
        }

        liste.leggInn(2);

        s = liste.toString();
        if (!s.equals("[1, 2]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2i: Du har " + s + ", skal være [1, 2]!");
        }

        s = liste.omvendtString();
        if (!s.equals("[2, 1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2j: Du har " + s + ", skal være [2, 1]!");
        }

        liste.leggInn(3);
        liste.leggInn(4);

        s = liste.toString();
        if (!s.equals("[1, 2, 3, 4]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2k: Du har " + s + ", skal være [1, 2, 3, 4]!");
        }

        s = liste.omvendtString();
        if (!s.equals("[4, 3, 2, 1]")) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2l: Du har " + s + ", skal være [4, 3, 2, 1]!");
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null});
        String t1 = "[]", t2 = liste.toString();

        if (!t1.equals(t2)) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2m: Du har " + t2 + ", men det skal være " + t1);
        }

        liste = new DobbeltLenketListe<>(new Integer[]{null, 1, null, 2, null});
        t1 = "[1, 2]";
        t2 = liste.toString();

        if (!t1.equals(t2)) {
            antallFeil++;
            System.out.println
                    ("Oppgave 2m: Du har " + t2 + ", men det skal være " + t1);
        }

        for (int i = 0; i < 20000; i++) liste.leggInn(i);
        long tid = System.currentTimeMillis();
        liste.toString();
        tid = System.currentTimeMillis() - tid;

        if (tid > 20) {
            antallFeil++;
            System.out.println("Oppgave 2n: Dette (" + tid + " ms) gikk altfor sakte!");
            System.out.println("            Har du kodet toString slik det ble bedt om?");
        }
    }
}