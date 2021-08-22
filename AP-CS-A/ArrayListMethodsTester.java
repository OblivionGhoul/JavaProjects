import java.util.ArrayList;
/**
 * creates array of numbers
 * creates a new instance called nums
 * uses the different methods
 */
public class ArrayListMethodsTester {
    public static void main(String[] args) {
        int[] testData = {5, 3, 7, 2, 8, 2, 8, 3, 2, 14, 18, 25};
        ArrayListMethods methods = new ArrayListMethods(testData);
        methods.display();
        methods = new ArrayListMethods(testData);
        System.out.println("Swapping first and last elements:");
        methods.swapFirstAndLast();
        methods.display();
        methods = new ArrayListMethods(testData);
        System.out.println("Right shifting all elements:");
        methods.shiftRight();
        methods.display();
        methods = new ArrayListMethods(testData);
        System.out.println("Setting all elements to zero:");
        methods.setEvenZero();
        methods.display();
        methods = new ArrayListMethods(testData);
        System.out.println("Setting all elements to larger neighbor:");
        methods.largerNeighbors();
        methods.display();
        methods = new ArrayListMethods(testData);
        System.out.println("Removing the middle element(s):");
        methods.removeMiddle();
        methods.display();
        methods = new ArrayListMethods(testData);
        System.out.println("Moving all even elements to the front:");
        methods.moveEvens();
        methods.display();
        methods = new ArrayListMethods(testData);
        System.out.println("Printing out second largest value:" + methods.secondLargest());
        methods = new ArrayListMethods(testData);
        System.out.println("List is sorted in increasing order: " + methods.isIncreasing());
        System.out.println("List has 2 adjacent duplicate elements: " + methods.hasAdjacentDuplicates());
        System.out.println("List has 2 duplicate elements: " + methods.hasDuplicates());
    }
}
/**
 * contains methods from problems
 * constructor creates new arraylist
 * @param int[] data
 * @return boolean
 * @return int
 */
class ArrayListMethods {
    private ArrayList<Integer> values;
    public ArrayListMethods(int[] data) {
        values = new ArrayList<>();
        for (int num : data) {
            values.add(num);
        }
    }

    public void display() {
        System.out.println(values);
    }

    public void swapFirstAndLast() {
        int temp = values.get(0);
        values.set(0, values.get(values.size() - 1));
        values.set(values.size() - 1, temp);
    }

    public void shiftRight() {
        for (int i = 0; i < values.size(); ++i) {
            int temp = values.get(i);
            values.set(i, values.get(0));
            values.set(0, temp);
        }
    }

    public void setEvenZero() {
        for (int i = 0; i < values.size(); ++i) {
            if (values.get(i) % 2 == 0) {
                values.set(i, 0);
            }
        }
    }

    // incorrect method
    public void largerNeighbors() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer value : values) {
            temp.add(value);
        }
        for (int i = 1; i < values.size() - 1; ++i) {
            int left = temp.get(i - 1);
            int right = temp.get(i + 1);
            values.set(i, Math.max(left, right));
        }
    }

    public void removeMiddle() {
        if (values.size() % 2 == 0) {
            values.remove(values.size() / 2 - 1);
        }
        values.remove(values.size() / 2);
    }

    public void moveEvens() {
        int current;
        for (int i = 0; i < values.size(); ++i) {
            current = values.get(i);
            if (current % 2 == 0) {
                values.remove(i);
                values.add(0, current);
            }
        }
    }

    // incorrect method
    public int secondLargest() {
        int largest = values.get(0);
        int second = values.get(1);
        if (second > largest) {
            int temp = second;
            second = largest;
            largest = temp;
        }
        int temp;
        for (int i = 2; i < values.size(); ++i) {
            temp = values.get(i);
            if (temp > second) {
                if (temp > largest) {
                    second = largest;
                    largest = temp;
                } else {
                    second = temp;
                }
            }
        }
        return second;
    }

    public boolean isIncreasing() {
        for (int i = 0; i < values.size() - 1; ++i) {
            if (values.get(i) > values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAdjacentDuplicates() {
        for (int i = 0; i < values.size() - 1; ++i) {
            if (values.get(i).equals(values.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicates() {
        for (int i = 0; i < values.size(); ++i) {
            for (int j = i; j < values.size(); ++j) {
                if (values.get(i).equals(values.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
