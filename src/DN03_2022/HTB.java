package DN03_2022;

public class HTB {
    int p, m, c1, c2;
    int[] tab;
    //int[] tab = {0, 10, 2, 11, 2};
    int collisions = 0;

    public HTB(int p, int m, int c1, int c2) {
        this.p = p;
        this.m = m;
        this.c1 = c1;
        this.c2 = c2;
        tab = new int[m];   //tab določim velikost m
    }

    void insert(int key) {
        //int ind2 = ind + (c1 * i) + (c2 * i) * mod m;
        if (!find(key)) {
            int ind = (key * p) % m;
            if (tab[ind] != 0) {
                for (int i = 0; i < tab.length; i++) {
                    ind = (((key * p) % m) + c1 * i + c2 * i*i) % m;
                    if (tab[ind] != 0) {
                        collisions++;
                    }
                    else {
                        tab[ind] = key;
                        break;
                    }
                }

                if (!find(key)) {
                    m = m * 2 + 1;  //preračunam nov m
                    int tab2[] = new int[m];

                    //grem čez tab in pišem v tab2
                    for (int i = 0; i < tab.length; i++) {
                        tab2[i] = tab[i];
                        delete(tab[i]);
                    }
                    tab = new int[m];

                    //insert
                    for (int i = 0; i < tab2.length; i++) {
                        if (tab2[i] != 0) {
                            insert(tab2[i]);
                        }
                    }
                    //insert-am key
                    insert(key);
                }

            }
            else {
                tab[ind] = key;
            }
        }
    }

    boolean find(int key) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == key) {
                return true;
            }
            else {
                continue;
            }
        }
        return false;
    }

    void delete(int key) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == key) {
                tab[i] = 0;
            }
        }
    }

    void printKeys() {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > 0) {
                System.out.println(i + ": " + tab[i]);
            }
        }
    }

    void printCollisions() { System.out.println(collisions); }
}

class Test {
    public static void main(String[] args) {
        HTB ht = new HTB(7, 3, 5, 7);

        ht.insert(19); ht.insert(11); ht.insert(23); ht.insert(19); ht.insert(29);
        ht.insert(17); ht.insert(2); ht.insert(33); ht.insert(99); ht.insert(129);

        ht.printKeys();
        System.out.println("--");
        ht.printCollisions();
    }

}
