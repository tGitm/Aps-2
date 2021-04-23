package DN02;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        right = null;
        left = null;
    }
}

public class BST {
    Node root;  //ustvarim root object
    int occurrence = 0;

    public BST() {

    }

    void insert(int key) {}
    boolean find(int key) {

    }

    void delete(int key) {}
    void printInorder() {}
    void printPreorder() {}
    void printPostorder() {}
    void printNodeComparisons() {}

}

class Run {
    BST b = new BST();

//    b.insert(19);
//    b.insert(11);
//    b.insert(23);
//    b.insert(19);
//    b.insert(29);
//    b.printPreorder();
//    System.out.println("--");
//
//    b.printInorder();
//    System.out.println("--");
//
//    b.printPostorder();
}