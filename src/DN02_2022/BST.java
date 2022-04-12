package DN02_2022;

class Node {
    int data;
    int doubles = 0;
    Node left;
    Node right;

    public Node(int data, int doubles) {
        this.data = data;
        this.doubles = doubles;
        right = null;
        left = null;
    }
}

public class BST {
    boolean deleteL = true;
    Node root;  //ustvarim root object
    int comparisons = 0;  //counter

    public BST() {
        root = null;
    }

    boolean find(int key) {
        return findFunction(root, key);

        /*
        while(root != null)
        {
            comparisons++;
            if(root.data == key) return true;
            if(root.data > key) root = root.left;
            else root = root.right;
        }

        return false;*/
    }

    boolean findFunction(Node root, int key) {
        if (root == null){
            comparisons++;
            return false;
        }
        if (root.data == key) {
            comparisons++;
            return true;
        }
        else if (key > root.data) {
            comparisons++;
            return findFunction(root.right, key);
        }
        else {
            comparisons++;
            return findFunction(root.left, key);
        }
    }

    Node insertFunction(Node root, int key) {
        if (root == null) {
            return new Node(key, 0);
        }
        if (key < root.data) {
            comparisons++;
            root.left = insertFunction(root.left, key);
        }
        else if (key > root.data) {
            comparisons++;
            root.right = insertFunction(root.right, key);
        }
        else {
            root.doubles++;
        }
        return root;
    }

    //funkcija za preverjanje najmanjsega elementa
    int najmanjsi(Node root) {
        int najmanj = root.data;
        while (root.left != null)
        {
            najmanj = root.left.data;
            root = root.left;
        }
        return najmanj;
    }

    int najvecji(Node root) {
        int najvec = root.data;
        while (root.right != null)
        {
            najvec = root.right.data;
            root = root.right;
        }
        return najvec;
    }

    Node deleteFunction(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            comparisons++;
            root.left = deleteFunction(root.left, key);
            return root;
        }
        if (key > root.data) {
            comparisons++;
            root.right = deleteFunction(root.right, key);
            return root;
        }
        else if (root.data == key && root.doubles >= 1) {
            root.doubles -= 1;
        }
        else {
            comparisons++;
            //če ima samo enega ali pa nobenega otroka
            if (root.left == null) {
                comparisons++;
                return root.right;
            }
            else if (root.right == null) {
                comparisons++;
                return root.left;
            }

            //sprehajam se levo desno
            if (!deleteL) {
                root.data = najmanjsi(root.right);
                comparisons++;

                root.right = deleteFunction(root.right, root.data);
                deleteL = true;
                return root;
            }
            else {
                root.data = najvecji(root.left);
                comparisons++;

                root.left = deleteFunction(root.left, root.data);
                deleteL = false;
                return root;
            }


            //manjšega porinem v desno poddrevo
            //root.data = najmanjsi(root.right);
            //pobrišem
            //comparisons++;
            //root.right = deleteFunction(root.right, root.data);

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

    public void insert(int key) { root = insertFunction(root, key); }
    void delete(int key) { root = deleteFunction(root, key); }
    void printInorder() { inorder(root); }
    void printPreorder() { preorder(root); }
    void printPostorder() { postoder(root); }

    //izpis primerjav
    void printNodeComparisons() {
        System.out.println(comparisons);
    }

}


class Run {
    public static void main(String[] args) {
        BST b = new BST();

        b.insert(19);
        b.printNodeComparisons();
        System.out.println("--");

        b.insert(11); b.insert(23); b.insert(31); b.insert(42); b.insert(29);
        System.out.println( b.find(29) );
        System.out.println("--");

        b.insert(23); b.insert(29); b.delete(31);
        System.out.println( b.find(31) );
        System.out.println( b.find(23) );
        System.out.println("--");
        b.printInorder();
        System.out.println("--");

        b.printNodeComparisons();


//        b.insert(19);
//        b.insert(11);
//        b.insert(23);
//        b.insert(31);
//        b.insert(42);
//        b.insert(29);
//        b.insert(23);
//        b.insert(29);
//        b.delete(31);
//        //b.printPreorder();
//        System.out.println("--");
//
//        b.printInorder();
//        System.out.println("--");
//        //b.delete(19);
//        System.out.println(b.find(31));
//        System.out.println(b.find(23));

        //b.printPostorder();
    }
}
