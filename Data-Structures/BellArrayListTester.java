public class BellArrayListTester {
    public static void main(String[] args) {
        BellArrayList test = new BellArrayList(3);
        test.add("Hello");
        test.add("Goodbye");
        test.add("Eating");
        test.remove(2);

        test.add(0, "This Is The First Element");
        System.out.println(test.remove(1));
        System.out.println(test.set(1, "Hello Sir!"));
        System.out.println(test.get(2));
        
        test.printArray();

        System.out.println();
        System.out.println(test.size());
    }
}

/*
Array with dynamic size
size, get, add, set, remove, printArray functions
 */
class BellArrayList {
    private String[] arr;
    private int cap;
    private int size = 0;

    public BellArrayList() {
        arr = new String[10];
        cap = arr.length;
    }

    public BellArrayList(int size) {
        arr = new String[size];
        cap = arr.length;
    }

    /*
    @return size
     */
    public int size() {
        return size;
    }

    /*
    @param index
    @return index value
     */
    public String get(int index) {
        if (index > arr.length - 1) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    /*
    @param index, item
     */
    public void add(int index, String item) {
        if (index > arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (size == cap) {
            cap *= 2;
            add(index, item);
        } else if (index == size()) {
            add(item);
        } else {
            String[] temp = new String[cap];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            for (int i = size - 1; i > index; i--) {
                temp[i] = temp[i - 1];
            }
            temp[index] = item;
            arr = temp;
            size++;
        }
    }

    /*
    @param item
     */
    public void add(String item) {
        if (size > arr.length-1) cap *= 2;
        String[] temp = new String[cap];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) {
                temp[i] = item;
                break;
            }
        }
        arr = temp;
        size++;
    }

    /*
    @param index
    @return val
     */
    public String remove(int index) {
        String val = arr[index];
        if (index > arr.length - 1) throw new ArrayIndexOutOfBoundsException();
        for (int i = index; i <= size - 2; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;

        return val;
    }

    /*
    @param index, item
    @return val
     */
    public String set(int index, String item) {
        if (index > arr.length - 1) throw new IndexOutOfBoundsException();
        String val = arr[index];
        arr[index] = item;
        return val;
    }

    /*
    prints out array
     */
    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length-1) {
                System.out.print("\"" + arr[i] + "\", ");
            } else {
                System.out.print("\"" + arr[i] + "\"");
            }
        }
        System.out.print("]");
    }
}