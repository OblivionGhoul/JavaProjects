public class TwoDTester {
    public static void main( String[] args ) {
        int[][] arr = { {1,2,3,4},{15,6,7,8},{9,10,11,12} };
        int[][] m1 = { {1,2,3}, {2,2,2}, {3,2,1}};
        int[][] m2 = { {7,7,7}, {7,7,7}, {7,7,7} };
        int[][] m3 = { {8,1,6}, {3,5,7}, {4,9,2} };
        System.out.println("MAX: " + max(arr) );
        System.out.println("Sum 2nd row: " + rowSum( arr, 2 ));
        System.out.println("Sum 3rd column: " + columnSum( arr, 3 ));
        System.out.println("arr is magic? " + isMagic(arr));
        System.out.println("m1 is magic? " + isMagic(m1));
        System.out.println("m2 is magic? " + isMagic(m2));
        System.out.println("m3 is magic? " + isMagic(m3));
    }

    public static int max(int[][] a) {
        int hiMax = a[0][0];
        for (int[] ints : a) {
            for (int anInt : ints) {
                hiMax = Math.max(hiMax, anInt);
            }
        }
        return hiMax;
    }

    public static int rowSum(int[][] a, int x) {
        int sum = 0;
        for (int i = 0; i < a[x].length; ++i) {
            sum += a[x][i];
        }
        return sum;
    }

    public static int columnSum(int[][] a, int x) {
        int sum = 0;
        for (int[] ints : a) {
            sum += ints[x];
        }
        return sum;
    }

    public static boolean isMagic(int[][] a) {
        if (a.length != a[0].length) {
            return false;
        }
        int firstRowSum = rowSum(a, 0);
        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for (int i = 0; i < a.length; ++i) {
            if (rowSum(a, i) != firstRowSum) {
                return false;
            }
            if (columnSum(a, i) != firstRowSum) {
                return false;
            }
            diagonalSum1 += a[i][i];
            diagonalSum2 += a[a.length - i - 1][a.length - i - 1];
        }
        if (diagonalSum1 != firstRowSum) {
            return false;
        }
        return diagonalSum2 == firstRowSum;
    }
}
