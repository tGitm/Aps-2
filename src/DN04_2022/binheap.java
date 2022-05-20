package DN04_2022;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("unchecked")
public class binheap {
    //Arrays kopica;
    //int[] kopica;
    ArrayList<Integer> kopica = new ArrayList<>();
    int comparisons;
    int index, maxSize;

    binheap() {
        this.comparisons = 0;
        this.index = 0;
        //this.maxSize = 10;
        //kopica = new int[maxSize];
    }

    private int stars(int pos) {
        return (pos - 1) / 2;
    }

    private int leviOtrok(int pos) {
        return (pos * 2) + 1;
    }

    private int desniOtrok(int pos) {
        return (pos * 2) + 2;
    }

    private boolean jeList(int pos) {
        if (desniOtrok(pos) >= kopica.size() || leviOtrok(pos) >= kopica.size()) {
            return true;
        }
        return false;
    }

    public int getMin() {
        /*int minElt = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            if (kopica[i] < minElt) {
                minElt = kopica[i];
            }
        }*/

        return kopica.get(0);
    }

    // funkcija za zamenjavo dveh node-ov v kopici
    private void swap(int pos1, int pos2) {
        //int tmpkopica;
        //tmpkopica = kopica.get(pos1);

        //kopica[pos1] = kopica[pos2];
        //kopica.add(pos1, pos2);
        //kopica.add(pos2, tmpkopica);
        Collections.swap(kopica, pos1, pos2);
        //kopica[pos2] = tmpkopica;
    }

    public void insert(int key) {
        if (index == 0) { comparisons++; }

        kopica.add(index, key);
        int trenuten = index;
        comparisons++;
        while (kopica.get(trenuten) < kopica.get(stars(trenuten))) {
            //comparisons++;
            swap(trenuten, stars(trenuten));
            trenuten = stars(trenuten);
        }
        index++;
    }

    // urejanje node-a na poziciji
    private void minkopicaify(int pos) {
        if (!jeList(pos)) {
            if (kopica.get(pos) > kopica.get(leviOtrok(pos)) || kopica.get(pos) > kopica.get(desniOtrok(pos))) {
                comparisons++;
                if (kopica.get(leviOtrok(pos)) <= kopica.get(desniOtrok(pos))) {
                    comparisons++;
                    swap(pos, leviOtrok(pos));
                    minkopicaify(leviOtrok(pos));
                } else {
                    comparisons++;
                    swap(pos, desniOtrok(pos));
                    minkopicaify(desniOtrok(pos));
                }
            }
        }

        /*
        if (!jeList(pos)) {

            if (kopica.get(pos) > kopica.get(leviOtrok(pos)) && kopica.get(leviOtrok(pos)) < kopica.get(desniOtrok(pos))) {
                comparisons++;
                swap(pos, leviOtrok(pos));
                minkopicaify(leviOtrok(pos));
            }
            if (kopica.get(pos) > kopica.get(desniOtrok(pos)) && kopica.get(leviOtrok(pos)) > kopica.get(desniOtrok(pos))) {
                comparisons++;
                swap(pos, desniOtrok(pos));
                minkopicaify(desniOtrok(pos));
            }
        }
        */
    }

    // Odstrani min element iz prednostne vrste. Če je vrsta prazna, izpiše "false", sicer pa "true: <element>".
    public void deleteMin() {
        //int minElt = getMin();
        if (kopica.size() != 0) {

            int deleted = getMin();
            //kopica.remove(kopica.get(0));
            kopica.set(0, kopica.get(--index));
            kopica.remove(index);
            minkopicaify(0);

            System.out.println("true: " + deleted);
        }
        else {
            System.out.println("false");
        }
    }

    public void printElements() {
        if (kopica.size() != 0) {
            for (int i = 0; i < kopica.size(); i++)
                if (i == 0) {
                    System.out.print(kopica.get(i));
                } else {
                    System.out.print(", " + kopica.get(i));
                }
        }
        else {
            System.out.print("empty");
        }
        System.out.println();
    }

    public void printMin() {
        if (kopica.size() == 0) {
            System.out.println("MIN: none");
        }
        else {
            System.out.println("MIN: " + kopica.get(0));
        }
    }

    public void printComparisons() {
        System.out.println("COMPARISONS: " + comparisons);
    }

}

class Binarykopica {
    public static void main(String[] args) {
        binheap bh = new binheap();

        /*
        bh.insert(10); bh.insert(20); bh.insert(30);
        bh.insert(5); bh.insert(15); bh.insert(7); bh.insert(25);
        bh.printElements();
        bh.printMin();
        bh.printComparisons();
        bh.deleteMin();
        bh.printElements();
        bh.printComparisons();
        */

        bh.printElements();
        bh.printMin();
        bh.printComparisons();
        bh.insert(30); bh.insert(20); bh.insert(10);
        bh.insert(7); bh.insert(25); bh.insert(5); bh.insert(15);
        bh.printElements();
        bh.printMin();
        bh.printComparisons();
        bh.deleteMin();
        bh.printElements();
        bh.printComparisons();
        bh.deleteMin();
        bh.printElements();
        bh.deleteMin();
        bh.printElements();
        bh.deleteMin(); bh.deleteMin(); bh.deleteMin();
        bh.printElements();
        bh.deleteMin();
        bh.printElements();
        bh.printComparisons();
    }
}