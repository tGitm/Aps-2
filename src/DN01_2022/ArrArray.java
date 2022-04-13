package DN01_2022;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("unchecked")
class Element {
    // existance of element -> bool
    // duplicates -> hashmap(element: numberOfDuplicates)
    HashMap<Integer,Integer> duplicates = new HashMap<Integer,Integer>();
    boolean isDeleted;

    Element(HashMap duplicates, boolean isDeleted) {
        this.duplicates = duplicates;
        this.isDeleted = isDeleted;
    }
}

@SuppressWarnings("unchecked")
public class ArrArray {

    //constructor
    public ArrArray() {

    }

    ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> elements = new ArrayList<Integer>();

    //TODO
    void insert(int e) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(e);

        for (int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j < arrays.get(i).size() - 1; j++) {
                if (arrays.get(i).isEmpty()){
                    arrays.get(i).equals(tmp);
                }
                if (i > 0) {
                    arrays.get(i).clear();
                }

            }
        }

    }

    //TODO
    boolean find(int e) {
        int min = 1000000;
        int max = 0;

        for (int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j < arrays.get(i).size() - 1; j++) {
                if (arrays.get(i).isEmpty()) {
                    continue;
                }

                //checking for min/max elements
                if (j >= max) {
                    max = j;
                }
                if (j <= min) {
                    min = j;
                }

                //if e == min or max -> return true
                if (e == min || e == max) {
                    return true;
                }
                if (e < min || e > max) {
                    continue;
                }

            }
        }

        return false;
    }

    //TODO
    boolean delete(int e) {
        return false;
    }

    //TODO
    void printOut() {
        if (arrays.isEmpty()) {
            System.out.println("empty");
        }

    }

}


class TestClass {
    public static void main(String[] args) {
        ArrArray ar = new ArrArray();
        ar.printOut();

        ar.elements.add(1);
        ar.elements.add(11);
        ar.elements.add(5);
        ar.elements.add(3);
        ar.elements.add(29);

        ar.arrays.add(ar.elements);
        System.out.println(ar.arrays);


    }
}