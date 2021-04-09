package DN01;

import java.util.Comparator;

public class Elt implements Comparator<Elt> {
    public int key;
    public Object data;

    //constructor
    public Elt(int key) {
        this.key=key;
        data=null;
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }

    @Override
    public int compare(Elt o1, Elt o2) {
        return Integer.compare(o1.key, o2.key);
    }


}

//data structure - list
class Seznam {
    Elt glava;
    Seznam rep;
    static int primerjave = 0;

    public Seznam(Elt elt, Seznam rep) {
        this.glava = elt;
        this.rep = rep;
    }

    static Seznam insert(Seznam s, Elt e) {
        if (find(s, e.key) == null) {
            s = new Seznam(e, s);   //v glavo rep e, v rep seznam od začetka
        }
        return s;
    }

    static Elt find(Seznam s, int key) {
        if(s == null) { return null; }

        primerjave++;
        if (s.glava.key == key) {
            return s.glava;
        }
        else {
            return find(s.rep, key);
        }
    }

    static Seznam delete(Seznam s, int key) {
        if(s == null) { return s; }

        primerjave++;
        if (s.glava.key == key) {
            return s.rep;
        }
        else {
            return new Seznam(s.glava, delete(s.rep, key));
        }
    }

    static void printElementKeys(Seznam s) {
        int noDeletes = 0;
        while (s != null) {
            //izpiši ključe vseh elementov
            System.out.println(s.glava);    //izpišem glavo
            s = delete(s, s.glava.key); //pobrišem element tako, da sprazni seznam
            noDeletes++;
        }
        primerjave -= noDeletes;
    }

    static void printElementKeyComparisons(Seznam s) {
        if (s != null) {
            System.out.println(primerjave);
        }
    }
}