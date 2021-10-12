import java.util.Arrays;

public class MergeTester {
    public static void main(String[] args) {
        int[] arr1 = genArray();
        int[] arr2 = genArray();

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(merge(arr1, arr2)));

    }

    private static final int minSize = 900;
    private static final int maxSize = 1100;
    private static final int minVal = 1;
    private static final int maxVal = 10000;
    private static final int maxRanNum = 5;

    public static int[] genArray() {
        int arrSize = (int)(Math.random() * maxSize) + minSize;
        int[] arr = new int[arrSize];

        for (int i = 1; i < arrSize; i++) {
            int val = (int)(Math.random() * maxRanNum) + minVal;
            arr[0] = val;
            int newVal = val + arr[i-1];
            if (newVal > maxVal) {
                arr[i] = arr[i-1] + 1;
            } else {
                arr[i] = newVal;
            }
        }
        return arr;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                k++;
                i++;
            } else {
                arr[k] = arr2[j];
                k++;
                j++;
            }
        }

        return arr;
    }
}