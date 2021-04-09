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
    Elt head;
    Seznam rep;

    public Seznam(Elt elt, Seznam rep) {
        this.head = elt;
        this.rep = rep;
    }

    static Seznam insert(Seznam s, Elt e){}
    static Elt find(Seznam s, int key){}
    static Seznam delete(Seznam s, int key){}
    static void printElementKeys(Seznam s){}
    static void printElementKeyComparisons(Seznam s){}
}
