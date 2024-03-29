import java.util.Arrays;
import java.util.Random;

public class ArrayExercisesTester {
    public static void main(String[] args) {
        ArrayExcercises test = new ArrayExcercises();

        int[] nums = { 1, 2, 5, 5, 3, 1, 2, 4, 3, 2, 2, 2, 2, 3, 6, 5, 5, 6, 3, 1 };

        test.getRun(nums);

        test.makeCombination(nums, 3);

        test.barChart(nums);
    }
}

class ArrayExcercises {
    public void getRun(int[] nums) {
        // R7.23
        int max = 1;
        int current = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                current++;
                max = Math.max(current, max);
            } else {
                current = 1;
            }
        }
        System.out.println(max);
    }

    public void makeCombination(int[] values, int n) {
        // R7.24
        Random generator = new Random();
        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(n);
            values[i] = numbers[i];
        }

        System.out.println(Arrays.toString(values));
    }

    public void barChart(int[] nums) {
        // E.19
        int height = nums[0];
        for (int n : nums) {
            if (n > height) height = n;
        }

        double scale = 20.0 / height;

        int width = nums.length;

        for (int row = 20; row > 0; row--) {
            for (int col = 0; col < width; col++) {
                if (row > (nums[col]) * scale) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}