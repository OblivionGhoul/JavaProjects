import java.util.NoSuchElementException;

public class StackTester {
    public static void main(String[] args) {
        StackArray sa = new StackArray();
        sa.push("a");
        sa.push("b");
        sa.push("c");
        sa.push("d");
        sa.push("e");
        System.out.println(sa);
        System.out.println(sa.pop());
        System.out.println(sa);
        System.out.println(sa.pop());
        System.out.println(sa);
        System.out.println(sa.pop());
        System.out.println(sa);
        System.out.println(sa.pop());
        System.out.println(sa);
        System.out.println(sa.pop());
        System.out.println(sa);
        System.out.println(sa.pop());
    }
}

class StackArray {
    private Object[] item; // The array where elements are stored
    private int open = 0;  // The index of the first empty location in the stack
    private int size = 2;  // The current number of item locations in the stack

    /**
     Constructs an empty stack.
     */
    public StackArray() {
        item = new Object[size];
    }

    public void push(Object element) {
        if (open == item.length) {
            size *= 2;
            Object[] arr = new Object[size];
            System.arraycopy(item, 0, arr, 0, item.length);
            item = arr;
        }

        item[open] = element;
        open++;
    }

    public Object pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack Is Empty");

        Object obj = item[open - 1];
        item[open - 1] = null;
        open--;
        return obj;
    }

    public boolean isEmpty() {
        return open == 0;
    }

    public String toString() {
        if (open == 0) { return "[]"; }
        StringBuilder temp = new StringBuilder("[" + item[0]);
        int i = 1;
        while (i < open)
        {
            temp.append(", ").append(item[i]);
            i = i + 1;
        }
        temp.append("]");
        return temp.toString();
    }
}