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
    int occurrence = 0;  //counter

    public BST() {
        root = null;
    }

    boolean find(int key) {
        /*if (root == null) return false;
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return find(key);
        }
        return false;*/
        while(root != null)
        {
            if(root.data == key) return true;
            if(root.data > key) root = root.left;
            else root = root.right;
        }

        return false;
    }

    public void insert(int key) {
        root = insertFunction(root, key);
    }

    Node insertFunction(Node root, int key) {
        if (root == null) {
            root = new Node(key);
        }
        if (key < root.data) {
            root.left = insertFunction(root.left, key);
        }
        else if (key > root.data) {
            root.right = insertFunction(root.right, key);
        }
        return root;
    }


    //sprehodi po grafu
    void inorder(Node root) {
        if (root == null) {
            return;
        }
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
    }

    void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    void postoder(Node root) {
        if (root == null) {
            return;
        }
        postoder(root.left);
        postoder(root.right);
        System.out.println(root.data);
    }

    void printInorder() { inorder(root); }
    void printPreorder() { preorder(root); }
    void printPostorder() { postoder(root); }


    void delete(int key) {}
    void printNodeComparisons() {}

}

class Run {
    public static void main(String[] args) {
        BST b = new BST();

        b.insert(19);
        b.insert(11);
        b.insert(23);
        b.insert(19);
        b.insert(29);
        System.out.println(b.find(28));
        b.printPreorder();
//    System.out.println("--");
//
        b.printInorder();
//    System.out.println("--");
//
        b.printPostorder();
    }

}