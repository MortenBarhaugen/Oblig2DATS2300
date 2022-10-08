package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        this();

        if (a.length == 0) return;

        hode = hale = new Node<>(a[0], null, null);

        int i = 0; for (; i < a.length && a[i] == null; i++); //Finner første element som ikke er null

        if (i < a.length) {
            Node<T> p = hode = new Node<>(a[i], null, null);
            antall++;

            for (i++; i < a.length; i++) {
                if (a[i] != null) {
                    p = p.neste = new Node<>(a[i], null, null);
                    hale.neste = p;
                    p.forrige = hale;
                    hale = p;
                    p.neste = null;
                    antall++;
                }
            }
        }

        /*int j = a.length - 1; for (; j >= 0 && a[j] == null; j--); // Finner siste element som ikke er null

        if (j > 0) {
            Node<T> r = hale = new Node<>(a[j], hode, null); //Denne må kanskje endres

            for (j--; j >= 0; j--) {
                if (a[j] != null) {
                    /*r = r.forrige;
                    r =
                    r = r.forrige = new Node<>(a[j], hode, null); //Tror denne må endres
                }
            }

        }*/
    }

    public Liste<T> subliste(int fra, int til) {
        /*Liste<T> n = new DobbeltLenketListe<>();
        if (fraTilKontroll(fra, til) == true) {
        if (fraTilKontroll(fra, til) == true) {
            Node<T> p = hode;
            for (int i = fra; i < til; i++) { // Funker ikke helt
                n.leggInn(p.verdi);
                p = p.neste;
                DobbeltLenketListe subList(fra, til);
            }
        }
        return n;*/

        int diff = til - fra;
        if (diff < 0) {
            throw new IllegalArgumentException("fra er større enn til!");
        } else if (fra > antall || til > antall) {
            throw new IndexOutOfBoundsException("fra eller til er større enn antall!");
        } else if (fra < 0) {
            throw new IndexOutOfBoundsException("fra er negativ!");
        }

        Liste<T> n = new DobbeltLenketListe<T>();
        Node<T> startNode = hode;
        int c = 0;
        while (startNode != null) {
            if (c > fra - 1 && c < til && fraTilKontroll(fra, til)) {
                n.leggInn(startNode.verdi);
            }
            startNode = startNode.neste;
            c++;
        }
        return n;
    }

    public int getEndringer() {
        return endringer;
    }

    private boolean fraTilKontroll(int fra, int til) {
        if (fra > til) {
            throw new IllegalArgumentException("fra er større enn til!");
        } else if (fra < 0) {
            throw new IllegalArgumentException("fra er mindre enn 0!");
        } else if (til > antall()) {
            throw new IllegalArgumentException("til er større enn tabellengden!");
        }
        return true;
    }

    @Override
    public int antall() {
        //if (antall == 0) throw new NullPointerException("Tabellen a er null!");
        return antall;
    }

    @Override
    public boolean tom() {
        if(antall == 0) return true;
        return false;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        if (antall == 0)  {
            /*Node<T> n = new Node<>(verdi);
            n.neste = hode;
            hode = n;
            hale = n;*/

            hode = hale = new Node<>(verdi, null, null);  // tom liste
            endringer++;
            antall++;
        }
        else {
            Node<T> n = new Node<>(verdi);
            for (int i = 0; i<antall; i++){   // fungerer ikke, må endres!
               if (i == antall-1) {
                   hale.neste = n;
                   n.forrige = hale;
                   hale = n;
                   n.neste = null;
                   endringer++;
               }
            }
            antall++;
        }


        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Kan ikke ta inn null-verdier!");


        if (indeks < 0 || indeks >= antall) {
            indeksKontroll(indeks, false);
        }

        if (indeks == 0) {
            hode = new Node<>(verdi, hode, null);
            if (antall == 0) {
                hale = hode;
                endringer++;
                antall++;
            }
        }
        else if (indeks == antall) {
            hale = hale.neste = new Node<>(verdi, hale.forrige, null);
            endringer++;
            antall++;
        }
        else {
            Node<T> p = hode;
            for (int i = 1; i < indeks; i++) p = p.neste;
            endringer++;
            antall++;
        }

    }

    @Override
    public boolean inneholder(T verdi) {
        if (indeksTil(verdi) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi)
    {
        if (verdi == null) return -1;

        Node<T> p = hode;

        for (int indeks = 0; indeks < antall ; indeks++)
        {
            if (p.verdi.equals(verdi)) return indeks;
            p = p.neste;
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi, "Kan ikke ta inn null-verdier!");

        indeksKontroll(indeks, false);

        Node<T> p = finnNode(indeks);
        T gammel = p.verdi;
        p.verdi = nyverdi;
        endringer++;
        return gammel;
    }

    @Override
    public boolean fjern(T verdi) {


        boolean resultat = false;
        int indeks = -1;
        int runloop = 0;
        Node<T> r = hode;
        int teller = 0;

        while (runloop == 0 && r != null){
            if (verdi.equals(r.verdi)){
                runloop = 1;
                indeks = teller;
            }
            else{
                r = r.neste;
                teller++;
            }
        }

        if (indeks != -1){
            Node<T> p;
            Node<T> q;
            r = hode;
            for (int i = 0; i < indeks; i++) {
                r = r.neste;
            }
            q = r.forrige;
            p = r.neste;

            if (indeks == 0 && indeks != antall-1){
                p.forrige = q;
                hode = p;
            }
            else if (indeks == antall-1 && indeks != 0){
                q.neste = p;
                hale = q;
            }
            else if (indeks == 0 && indeks == antall-1){
                hode = hale = null;
            }
            else {
                q.neste = p;
                p.forrige = q;
            }
            antall--;
            endringer++;
            resultat = true;
        }
        else {
            resultat = false;
        }

        //sjekke at verdi ligger i lista
        //hvis finnIndeks returnerer -1 sett lik false
        //hvis verdi ligger i lista return true og fjern verdi
        return resultat;
    }

    @Override
    public T fjern(int indeks) { // sliter med at programmet failer når det indekseres over antallet
        Node<T> r = null;

        if (indeks < antall && indeks >= 0) {
            Node<T> p;
            Node<T> q;
            if (indeks <= antall / 2) {
                r = hode;
                for (int i = 0; i<indeks; i++){
                    r = r.neste;
                }
            } else if (indeks > antall / 2) {
                r = hale;
                for (int i = antall - 1; i>indeks; i--){
                    r = r.forrige;
                }
            }

            q = r.forrige;
            p = r.neste;

            if (indeks == 0 && indeks != antall-1){
                p.forrige = q;
                hode = p;
            }
            else if (indeks == antall-1 && indeks != 0){
                q.neste = p;
                hale = q;
            }
            else if (indeks == 0 && indeks == antall-1){
                hode = hale = null;
            }
            else {
                q.neste = p;
                p.forrige = q;
            }
            antall--;
            endringer++;
        }
        else{
            throw new IndexOutOfBoundsException("indeks er utenfor intervallet");
        }
        return r.verdi;
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append('[');

        if (!tom()) {
            Node<T> p = hode;

            while (p != null) {
                if (p == hode){
                    s.append(p.verdi);
                    p = p.neste;
                }
                else {
                    s.append(", ").append(p.verdi);
                    p = p.neste;
                }
            }
        }
        s.append(']');

        return s.toString();
    }

    public String omvendtString() { //Fungerer ikke hvis verdier blir lagt inn via leggInn()
        StringBuilder s = new StringBuilder();

        s.append('[');

        if (!tom() && antall > 1) {
            Node<T> r = hale;

            while (r != null) {
                if (r == hale){
                    s.append(r.verdi);
                    r = r.forrige;
                }
                else {
                    s.append(", ").append(r.verdi);
                    r = r.forrige;
                }
            }
        } else if (antall == 1) {
            s.append(hode.verdi);
        }
        s.append(']');

        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

    private Node<T> finnNode(int indeks) {
        Node<T> p = hode;
        Node<T> r = hale;
        if (indeks < antall() / 2) {
            for (int i = 0; i < indeks; i++){
                p = p.neste;
            }
            return p;
        } else {
            for (int j = 1; j < antall() - indeks; j++) {
                r = r.forrige;
            }
            return r;
        }
    }

} // class DobbeltLenketListe