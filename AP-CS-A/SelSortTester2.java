public class SelSortTester2 {
    public static void main(String[] args) {
        String[] arr1 = {"minh", "kay", "josh", "hanna", "torry", "chloe"};

        selectionSort(arr1);
        print(arr1);
    }

    public static void print(String[] arr) {
        System.out.print("[");
        for (String val : arr) {
            System.out.print(val + ", ");
        }
        System.out.println("]");
    }

    /**
     * Sorts names in array lexicographically
     */
    public static void selectionSort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i; j < arr.length; j++) {
                String word1 = arr[j];
                String word2 = arr[index];
                for (int k = 0; k < word1.length() && k < word2.length(); k++) {
                    if (word1.charAt(k) < word2.charAt(k)) {
                        index = j;
                        break;
                    } else if (word1.charAt(k) > word2.charAt(k)) {
                        break;
                    }
                }
            }
            String temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}