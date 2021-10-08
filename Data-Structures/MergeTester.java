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
        int len = arr1.length + arr2.length;
        int[] arr = new int[len];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = arr1.length; j < len; j++) {
                for (int value : arr2) {
                    arr[i] = arr1[i];
                    arr[j] = value;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}