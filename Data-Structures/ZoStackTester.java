import java.util.EmptyStackException;
import java.util.LinkedList;

public class ZoStackTester {
    public static void main(String[] args) {
        Stack<String> dishes = new Stack<>();
        System.out.println("Is it empty: " + dishes.isEmpty());
        System.out.println("Now pushing H, E, L, L, O");
        dishes.push("H");
        dishes.push("E");
        dishes.push("L");
        dishes.push("L");
        dishes.push("O");
        System.out.println("The top element is: " + dishes.peek());

        while (!dishes.isEmpty()){
            System.out.println("Popping: "+ dishes.pop());
        }

        System.out.println("Is it empty: " + dishes.isEmpty());
        System.out.println("Now pushing 1");
        dishes.push("1");
        System.out.println("Is it empty: " + dishes.isEmpty());
        System.out.println("Now pushing 2, 3, 4, 5");
        dishes.push("2");
        dishes.push("3");
        dishes.push("4");
        dishes.push("5");
        System.out.println("The top element is: " + dishes.peek());
        System.out.println("Removing " + dishes.pop() );
        System.out.println("Removing "+ dishes.pop() );
        System.out.println("Now pushing Last");
        dishes.push("Last");
        System.out.println("The top element is: " + dishes.peek());
        
        while (!dishes.isEmpty()) {
            System.out.println("Popping: " + dishes.pop());
        }
    }
}

/**
 * Class for the stack made from LinkedLists
 * @param <E>
 */
class Stack<E> implements YoStack<E> {
    private final LinkedList<E> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    /**
     * Checks if the stack is empty
     * @return boolean if the stack is empty
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Pushes to a stack
     * @param e The item to be pushed
     * @return The item pushed
     */
    public E push(E e) {
        stack.add(e);
        return e;
    }

    /**
     * Pops an item in the stack
     * @return the item removed
     */
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E o = stack.getLast();
        stack.removeLast();
        return o;
    }

    /**
     * Finds the top item in the stack
     * @return the top item in the stack
     */
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.getLast();
    }

    /**
     * @return the number of items in the stack
     */
    public int size() {
        return stack.size();
    }
}

/**
 * Interface for the Stack class
 * @param <E>
 */
interface YoStack<E> {
    boolean isEmpty();
    E push(E o);
    E pop();
    E peek();
    int size();
}
