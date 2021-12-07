import java.util.NoSuchElementException;

public class DoubleLinkListTester {
    public static void main(String[] args) {
        DoubleLinkList<Integer> test = new DoubleLinkList<>();

        // testing addFirst()
        test.addFirst(2);
        test.addFirst(2);
        test.addFirst(1);

        // testing getFirst()
        System.out.println(test.getFirst());

        // testing removeFirst()
        System.out.println(test.removeFirst());

        // testing addLast()
        test.addLast(4);

        // testing removeLast()
        System.out.println(test.removeLast());

        // testing get()
        System.out.println(test.get(1));

        // testing add()
        test.add(1, 3);
        test.add(2, 4);

        // testing remove()
        System.out.println(test.remove(1));

        // testing size()
        System.out.println(test.size());

        // testing toString()
        System.out.println(test);

        // testing reverse()
        test.reverse();
        System.out.println(test);
    }
}

class DoubleLinkList<E> {
    private Node first;
    private Node last;

    private class Node {
        public E data;
        public Node next;
        public Node prev;
    }

    public DoubleLinkList() {
        first = null;
        last = null;
    }

    /**
     * @return the first element in the linked list
     */
    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    /**
     * Removes the first element in the linked list.
     * @return the removed element
     */
    public E removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        E element = first.data;
        first = first.next;
        return element;
    }

    /**
     * Adds an element to the front of the linked list.
     * @param element the data to store in the linked list
     */
    public void addFirst(E element)  {
        Node newNode = new Node();
        newNode.data = element;
        if (first != null) {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        } else {
            first = newNode;
            last = newNode;
        }

    }

    /**
     * Adds an element to the back of the linked list.
     * @param element the data to store in the linked list
     */
    public void addLast(E element) {
        Node newNode = new Node();
        newNode.data = element;

        if (first != null) {
            Node curr = first;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            last = newNode;
            last.prev = curr;
        } else {
            first = newNode;
            last = newNode;
        }
    }

    /**
     * Removes the last element in the linked list.
     * @return the removed element
     */
    public E removeLast() {
        if (first == null) throw new NoSuchElementException();
        Node curr = first;
        while (curr.next.next != null) {
            curr = curr.next;
        }

        E element = curr.next.data;
        curr.next = null;

        return element;
    }

    /**
     * Gets data at a given index
     * @param index index given
     * @return data at a given index
     */
    public E get(int index) {
        if ((size() - 1 < index) || index < 0) throw new IndexOutOfBoundsException();
        Node curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * Adds an element at the given index
     * @param index index where element will be added
     * @param element element that will be added
     */
    public void add(int index, E element) {
        Node newNode = new Node();
        newNode.data = element;
        Node curr = first;

        if ((index < 0) || size() - 1 < index) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(element);
        } else if (index == size() - 1) {
            addLast(element);
        } else {
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next.prev = newNode;
            curr.next = newNode;
            newNode.prev = curr;
        }
    }

    /**
     * Removes an element at the given index
     * @param index where the element will be removed
     * @return the element removed
     */
    public E remove(int index) {
        E element;

        if ((size() - 1 < index) || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            element = removeFirst();
        } else if (index == size() - 1) {
            element = removeLast();
        } else {
            Node curr = first;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            element = curr.data;
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
        }
        return element;
    }

    /**
     * Gets the linked list size
     * @return size of the linked list
     */
    public int size() {
        int size = 0;
        Node curr = first;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    /**
     * Reverses the order of the linked list
     */
    public void reverse() {
        if (first == null) throw new NoSuchElementException();
        Node beforeCurr = first;

        while (first.next != null) {
            Node afterCurr = first.next;
            first.next = first.next.next;

            afterCurr.next = beforeCurr;
            beforeCurr.prev = afterCurr;

            afterCurr.prev = null;
            beforeCurr = afterCurr;
        }

        Node nodeSwitch = first;
        first = last;
        last = nodeSwitch;
    }

    /**
     * @return all elements in the linked list
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node curr = first;
        res.append("[");
        while (curr != null) {
            if (curr.next == null) {
                res.append(curr.data).append("]");
                break;
            }

            res.append(curr.data).append(", ");
            curr = curr.next;
        }
        return res.toString();
    }
}