package DN01_2022;

import java.util.ArrayList;
import java.util.HashMap;

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

public class ArrArray {

    //constructor
    public ArrArray() {

    }

    ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();

    insert(int e) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(e);



    }

    /*
    find(int e) {

    }

    delete(int e) {

    }
    */

    void printOut() {
        if (arrays.isEmpty()) {
            System.out.println("empty");
        }

    }

}

class TestClass {
    public static void main(String[] args) {
        ArrArray ar = new ArrArray();
        ar.printOut()
;    }
}