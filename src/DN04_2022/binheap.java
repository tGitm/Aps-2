package DN04_2022;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class binheap {
    int[] heap;
    int comparisons = 0;
    int heapSize, maxSize;

    private static final int FRONT = 1;

    binheap(int maxSize) {
        this.heapSize = 0;
        this.maxSize = maxSize;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (heapSize / 2) && pos <= heapSize) {
            return true;
        }
        return false;
    }

    // funkcija za zamenjavo dveh node-ov v kopici
    private void swap(int pos1, int pos2) {
        int tmp;
        tmp = heap[pos1];

        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    // urejanje node-a na poziciji
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {

                // zamenjam z levim otrokom in uredim
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // zamenjam z levim otrokom in uredim
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int key) {
        if (heapSize > maxSize) {
            return;
        }
        heap[++heapSize] = key;
        int current = heapSize;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer getMin() {
        int minElt = 100000;
        for (int i = 0; i < heapSize; i++) {
            if (heap[i] < minElt) {
                minElt = heap[i];
            }
        }
        return minElt;
    }

    // Odstrani min element iz prednostne vrste. Če je vrsta prazna, izpiše "false", sicer pa "true: <element>".
    public void deleteMin() {

        if (heap.length != 0) {
            int deleted = heap[FRONT];
            heap[FRONT] = heap[heapSize--];
            minHeapify(FRONT);

            System.out.println("true: " + getMin());
        }
        else {
            System.out.println("false");
        }
    }

    public void printElements() {
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + ", ");
        System.out.println();
    }

    public void printMin() {
        System.out.println("MIN: " + getMin());
    }

    public void printComparisons() {
        System.out.println("COMPARISONS: " + comparisons);
    }

}

class Test {
    public static void main(String[] args) {
        binheap bh = new binheap(10);
        bh.insert(10); bh.insert(20); bh.insert(30);
        bh.insert(5); bh.insert(15); bh.insert(7); bh.insert(25);
        bh.printElements(); bh.printMin(); bh.printComparisons();
        bh.deleteMin();
        bh.printElements();
    }
}