public class HeapTester {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(4);
        System.out.println("Creating Heap with max size of 4");
        System.out.println("Inserting elements into Heap");
        System.out.println("Inserting 65, 45, 35, 22, 41, 10, 17, 16, 14, 36, 38, 4, 6, 7");

        heap.insert(65);
        heap.insert(45);
        heap.insert(35);
        heap.insert(22);
        heap.insert(41);
        heap.insert(10);
        heap.insert(17);
        heap.insert(16);
        heap.insert(14);
        heap.insert(36);
        heap.insert(38);
        heap.insert(4);
        heap.insert(6);
        heap.insert(7);

        System.out.println("\nPrinting out the heap: ");
        heap.print();
    }
}

class Heap<E extends Comparable<E>> {
    private Comparable<E>[] heap;
    private int size;
    private int maxSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = (E[]) new Comparable[maxSize];
    }

    public void insert(Comparable<E> e) {
        if (size == maxSize) {
            maxSize *= 2;
            Comparable<E>[] tempArr = new Comparable[maxSize];
            System.arraycopy(heap, 0, tempArr, 0, heap.length);
            heap = tempArr;
        }

        heap[size++] = e;
        int current = size - 1;

        while (heap[current].compareTo((E) heap[parent(current)]) > 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        System.out.println(" " + heap[0]);

        for(int i = 0; i < size / 2; i++) {
            if (leftChild(i) < size) {
                System.out.print(" " + heap[leftChild(i)]);
            }

            if (rightChild(i) < size) {
                System.out.print(" " + heap[rightChild(i)]);
            }

            if (i == 0 || i == 2 || i == 8) {
                System.out.println();
            }
        }
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }
    
    private void swap(int pos1, int pos2) {
        E temp = (E) heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }
}