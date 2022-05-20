package DN04_2022;


import java.util.Arrays;

public class binheap {
    //Arrays heap;
    int[] heap;
    int comparisons;
    int index, maxSize;

    binheap() {
        this.comparisons = 0;
        this.index = 0;
        this.maxSize = 10;
        heap = new int[maxSize];
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
        //if (pos <= index && pos > (index / 2)) {
        if (desniOtrok(pos) >= maxSize || leviOtrok(pos) >= maxSize) {
            comparisons++;
            return true;
        }
        return false;
    }

    public int getMin() {
        int minElt = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            if (heap[i] < minElt) {
                minElt = heap[i];
            }
        }
        return minElt;
    }

    // funkcija za zamenjavo dveh node-ov v kopici
    private void swap(int pos1, int pos2) {
        int tmpHeap;
        tmpHeap = heap[pos1];

        heap[pos1] = heap[pos2];
        heap[pos2] = tmpHeap;
    }

    int[] resizeHeap() {
        int[] copyHeap = Arrays.copyOf(heap, heap.length * 2);
        heap = new int[copyHeap.length];
        Arrays.fill(heap, 0);
        for (int i : copyHeap) {
            insert(i);
        }
        return copyHeap;
    }

    public void insert(int key) {
        if (index >= maxSize) {
            resizeHeap();
        }
        heap[index] = key;
        int trenuten = index;

        comparisons++;
        while (heap[trenuten] < heap[stars(trenuten)]) {
            //comparisons++;
            swap(trenuten, stars(trenuten));
            trenuten = stars(trenuten);
        }
        index++;
    }

    // urejanje node-a na poziciji
    private void minHeapify(int pos) {
        if (!jeList(pos)) {
            comparisons++;
            if (heap[pos] > heap[leviOtrok(pos)] || heap[pos] > heap[desniOtrok(pos)]) {
                comparisons++;
                // zamenjam z levim otrokom in uredim
                if (heap[leviOtrok(pos)] < heap[desniOtrok(pos)]) {
                    comparisons++;
                    swap(pos, leviOtrok(pos));
                    minHeapify(leviOtrok(pos));
                }

                // zamenjam z levim otrokom in uredim
                else {
                    swap(pos, desniOtrok(pos));
                    minHeapify(desniOtrok(pos));
                }
            }
        }
    }

    // Odstrani min element iz prednostne vrste. Če je vrsta prazna, izpiše "false", sicer pa "true: <element>".
    public void deleteMin() {
        int minElt = getMin();
        if (heap.length != 0) {
            int deleted = heap[0];
            heap[0] = heap[--index];
            minHeapify(0);

            System.out.println("true: " + minElt);
        }
        else {
            System.out.println("false");
        }
    }

    public void printElements() {
        if (heap.length == 0) {
            System.out.println("empty");
        }
        else {
            for (int i = 0; i < index; i++)
                if (i == 0) {
                    System.out.print(heap[i]);
                } else {
                    System.out.print(", " + heap[i]);
                }
        }
        System.out.println();
    }

    public void printMin() {
        if (heap.length == 0) {
            System.out.println("MIN: none");
        }
        else {
            System.out.println("MIN: " + getMin());
        }
    }

    public void printComparisons() {
        System.out.println("COMPARISONS: " + comparisons);
    }

}

class BinaryHeap {
    public static void main(String[] args) {
        binheap bh = new binheap();
        bh.insert(10); bh.insert(20); bh.insert(30);
        bh.insert(5); bh.insert(15); bh.insert(7); bh.insert(25);
        bh.printElements();
        bh.printMin();
        bh.printComparisons();
        bh.deleteMin();
        bh.printElements();
        bh.printComparisons();
        bh.printMin();
    }
}