public class HeapTester {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(4);
        System.out.println("Creating Heap with max size of 4");
        System.out.println("Inserting elements into Heap");

        System.out.println("Inserting 15 random elements into the heap. (1-100)");

        for (int i = 0; i < 15; i++) {
            heap.insert(1 + (int) (Math.random() * 100));
        }

        System.out.println("\nPrinting out the heap: ");
        heap.print();

        for (int i = 0; i < 16; i++) {
            System.out.println("\nRemoving root " + heap.removeRoot() + " and printing the heap: ");
            heap.print();
        }
    }
}

/**
 * Class for the max-heap
 * @param <E> the generic used for the heap
 */
@SuppressWarnings("unchecked")
class Heap<E extends Comparable<E>> {
    private Comparable<E>[] heap;
    private int size;
    private int maxSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = (E[]) new Comparable[maxSize];
    }

    /**
     * Inserts an element into the heap
     * @param e the element to be inserted into the heap
     */
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

    /**
     * Prints out the heap
     */
    public void print() {
        if (isEmpty()) {
            throw new Error("Heap is empty!");
        }

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

    /**
     * Removes the root from the heap
     * @return The root removed from the heap
     */
    public E removeRoot() {
        if (isEmpty()) {
            throw new Error("Heap is empty!");
        }

        E root = (E) heap[0];
        heap[0] = heap[--size];
        heap[size] = null;
        heapify(0);

        return root;
    }

    /**
     * Helper method for the removeRoot() method
     * @param i The index to be removed
     */
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size && heap[left].compareTo((E) heap[i]) > 0) {
            largest = left;
        }

        if (right < size && heap[right].compareTo((E) heap[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    /**
     * Finds the parent of the given position
     * @param pos the position to find the parent
     * @return the index of the parent
     */
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    /**
     * Finds the left child of the given position
     * @param pos the position to find the left child
     * @return the index of the left child
     */
    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    /**
     * Finds the right child of the given position
     * @param pos the position to find the right child
     * @return the index of the right child
     */
    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    /**
     * Swaps two elements in the heap
     * @param pos1 element to be swapped
     * @param pos2 element to be swapped
     */
    private void swap(int pos1, int pos2) {
        E temp = (E) heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    /**
     * Checks if the heap is empty
     * @return if the heap is empty
     */
    private boolean isEmpty() {
        return size == 0;
    }
}