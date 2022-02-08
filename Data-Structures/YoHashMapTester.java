import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class YoHashMapTester {
    public static void main(String[] args) {
        System.out.println("Creating HashMap");
        HashMap<String, Integer> hashMap = new HashMap<>();

        System.out.println("Putting Values 1, 2, 3 with keys \"a\", \"b\", \"c\"");
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);

        System.out.println("\nHashMap Size: " + hashMap.size());
        System.out.println("Printing HashMap:\n" + hashMap);

        System.out.println("Checking containsKey() method");
        System.out.println("Contains key \"a\": " + hashMap.containsKey("a"));
        System.out.println("Contains key \"b\": " + hashMap.containsKey("b"));
        System.out.println("Contains key \"c\": " + hashMap.containsKey("c"));
        System.out.println("Contains key \"d\": " + hashMap.containsKey("d"));

        System.out.println("\nChecking get() method");
        System.out.println("Value of key \"a\": " + hashMap.get("a"));
        System.out.println("Value at key \"b\": " + hashMap.get("b"));
        System.out.println("Value at key \"c\": " + hashMap.get("c"));
        System.out.println("Value at key \"d\": " + hashMap.get("d"));

        System.out.println("\nPrinting set of all keys: " + hashMap.keySet());

        System.out.println("\nRemoving the value at key \"b\"");
        System.out.println("Value at key \"b\" that was removed: " + hashMap.remove("b"));
        System.out.println("New HashMap: \n" + hashMap);
        System.out.println("After the value removed, HashMap size is now: " + hashMap.size());

        System.out.println("\nChanging value of key \"c\" to 300 with put() method");
        System.out.println("Old value at key \"c\" that is changed: " + hashMap.put("c", 300));
        System.out.println("New HashMap: \n" + hashMap);

        System.out.println("Clearing the hashmap");
        hashMap.clear();
        System.out.println("New HashMap: " + hashMap);
        System.out.println("HashMap size: " + hashMap.size());
    }
}

/**
 * Class for HashMap
 * @param <K> The key
 * @param <E> The value
 */
class HashMap<K extends String, E> {
    private final ArrayList<PairedObjects<K, E>> hashMap;
    private int size;

    /**
     * Class for each object in the ArrayList
     * Contains key, value, and next
     */
    private static class PairedObjects<K extends String, E> {
        private final K key;
        private E value;
        private PairedObjects<K, E> next;

        public PairedObjects(K key, E value, PairedObjects<K, E> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashMap() {
        hashMap = new ArrayList<>();
        size = 0;
    }

    public HashMap(int capacity) {
        hashMap = new ArrayList<>(capacity);
        size = 0;
    }

    /**
     * Clears the HashMap
     */
    public void clear() {
        hashMap.clear();
        size = 0;
    }

    /**
     * Checks if the HashMap contains a key
     * @param key The key to be checked in the HashMap
     * @return boolean if HashMap contains the key
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Gets the value at a key
     * @param key given to return the value at
     * @return The value at a key
     */
    public E get(K key) {
        PairedObjects<K, E> curr = hashMap.get(getHash(key));
        while (curr != null) {
            if (curr.key.equals(key)) return curr.value;
            curr = curr.next;
        }
        return null;
    }

    /**
     * Creates a Set of all the keys of the HashMap
     * @return The Set of all the keys in the HashMap
     */
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (PairedObjects<K, E> pairedObjects : hashMap) {
            while (pairedObjects != null) {
                keySet.add(pairedObjects.key);
                pairedObjects = pairedObjects.next;
            }
        }
        return keySet;
    }

    /**
     * Puts a new value with a key in the HashMap
     * Returns the old value if key already present
     * @param key for the new value
     * @param value for the new key
     * @return The old value at the key
     */
    public E put(K key, E value) {
        if (size == 0) {
            hashMap.add(new PairedObjects<>(key, value, null));
            size++;
            return null;
        }

        PairedObjects<K, E> curr = hashMap.get(getHash(key));

        while (curr.next != null) {
            if (curr.next.key.equals(key)) {
                E oldValue = curr.next.value;
                curr.next.value = value;
                return oldValue;
            }
            curr = curr.next;
        }
        curr.next = new PairedObjects<>(key, value, null);
        size++;
        return null;
    }

    /**
     * Removes the value at a given key
     * @param key to remove the value at
     * @return The element that was removed
     */
    public E remove(K key) {
        if (size == 0) return null;

        PairedObjects<K, E> curr = hashMap.get(getHash(key));
        while (curr.next != null) {
            if (curr.next.key.equals(key)) {
                E oldValue = curr.next.value;
                curr.next = curr.next.next;
                size--;
                return oldValue;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     * @return the size of the HashMap
     */
    public int size() {
        return size;
    }

    /**
     * @param key that will be hashed
     * @return the hash of the key
     */
    public int getHash(K key) {
        return key.length() % hashMap.size();
    }

    /**
     * @return the HashMap
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PairedObjects<K, E> pairedObjects : hashMap) {
            while (pairedObjects != null) {
                sb.append(pairedObjects.key).append(" = ").append(pairedObjects.value).append("\n");
                pairedObjects = pairedObjects.next;
            }
        }
        return sb.toString();
    }
}