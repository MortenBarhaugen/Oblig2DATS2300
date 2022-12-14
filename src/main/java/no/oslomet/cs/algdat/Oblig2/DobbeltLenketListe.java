package no.oslomet.cs.algdat.Oblig2;
////////////////// class DobbeltLenketListe //////////////////////////////
import java.util.Comparator;
import java.util.Iterator;
import java.util.*;
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
        int i = 0; for (; i < a.length && a[i] == null; i++);
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
    }
    public Liste<T> subliste(int fra, int til) {
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
            hode = hale = new Node<>(verdi, null, null);  // tom liste
            endringer++;
            antall++;
        }
        else {
            Node<T> n = new Node<>(verdi);
            for (int i = 0; i<antall; i++){
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
        if (indeks < 0 || indeks > antall) {
            indeksKontroll(indeks, false);
        }
        if (indeks == 0) {
            Node<T> n = new Node(verdi);
            if (antall == 0) {
                hode = hale = new Node<>(verdi, null, null);
            } else {
                n.neste = hode;
                hode.forrige = n;
                hode = n;
                n.forrige = null;
            }
            endringer++;
            antall++;
        }
        else if (indeks == antall) {
            Node<T> n = new Node(verdi);
            hale.neste = n;
            n.forrige = hale;
            hale = n;
            n.neste = null;
            endringer++;
            antall++;
        }
        else {
            Node<T> n = new Node(verdi);
            Node<T> p = hode;
            for (int i = 1; i < indeks; i++){
                p = p.neste;
            }
            Node<T> q = p.neste;

            n.neste = q;
            n.forrige = p;
            p.neste = n;
            q.forrige = n;

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
        int teller = 0;
        int runloop = 0;
        Node<T> r = hode;
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
        return resultat;
    }
    @Override
    public T fjern(int indeks) {
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
        //Metode 1: snitter på 2.5ms kjøretid for å slette 100000 elementer
        long tid = System.currentTimeMillis();
        Node<T> r = hode;
        Node<T> p;
        while (r != (null)){
            p = r.neste;
            r.verdi = null;
            r.neste = r.forrige = null;
            hode = p;
            r = p;
        }
        antall = 0;
        endringer++;
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);

        //Metode 2: snitter med 935ms kjøretid for å slette 100000 elementer
        /*long tid = System.currentTimeMillis();
        for (int i = 0; i < antall - 1; i++){
            fjern(i);
        }
        antall = 0;
        endringer++;
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);*/
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
    public String omvendtString() {
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
        return new DobbeltLenketListeIterator();
    }
    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator(indeks);
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
            Node<T> r;
            if (indeks <= antall / 2) {
                r = hode;
                for (int i = 0; i<indeks; i++){
                    r = r.neste;
                }
            } else {
                r = hale;
                for (int i = antall - 1; i>indeks; i--){
                    r = r.forrige;
                }
            }
            denne = r;
            fjernOK = false;
            iteratorendringer = endringer;
        }
        @Override
        public boolean hasNext() {
            return denne != null;
        }
        @Override
        public T next() {
            if (iteratorendringer != endringer){
                throw new ConcurrentModificationException();
            }
            else if (hasNext() != true) {
                throw new NoSuchElementException();
            }
            fjernOK = true;
            Node<T> annen = denne;
            denne = denne.neste;
            return annen.verdi;
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
