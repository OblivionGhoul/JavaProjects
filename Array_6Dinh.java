public class Array_6Dinh {
    public static void main(String[] args) {
        int[] nums = {1,5,22,15,0,9};
        String[] words = { "to", "be", "not", "aardvark", "scintillating" };
        ArrayTester_6Dinh test = new ArrayTester_6Dinh();
        test.testNums(nums);
        test.testStrings(words);
    }
}

class ArrayTester_6Dinh {
    public void testNums(  int[] nums ) {
        System.out.println("2nd Element: " + nums[1]);
        System.out.println("Last Element: " + nums[nums.length-1]);
        int largest = 0;
        for (int i = 0; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }
        System.out.println("Largest Element: " + largest + "\n");
    }

    public void testStrings(  String[] words ) {
        System.out.println("Last Element: " + words[words.length-1]);
        System.out.println("Contents of array: " );
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println("\n" + "Lengths of each word: " );
        for (int i = 0; i < words.length-1; i++) {
            System.out.println(words[i].length());
        }
    }
}