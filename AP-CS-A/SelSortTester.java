public class SelSortTester {
    public static void main( String[] args ) {
      int[] arr1 = { 1, 2, 3, 4, 5, 9 };
      int[] arr2 = { 11, 2, 3, 4, 5, 9 }; 
      int[] arr3 = { 11, 9, 8, 4, 3, 1 }; 
      
      arr1 = selectionSort( arr1 );
      print( arr1 );
      arr2 = selectionSort( arr2 );
      print( arr2 );
      arr3 = selectionSort( arr3 );
      print( arr3 ); 
    }
    
    public static void print( int[] arr ) {
      System.out.print("[");
      for( int val : arr ) {
        System.out.print(val + ", ");
      }
      System.out.println("]");
    }
    
    /**
      Sorts the array passed in from largest to smallest.
      @return the sorted array (note that it is the same as the array passed in)
    */
    public static int[]  selectionSort( int[] arr )
    {
      for ( int i = 0; i < arr.length; i++ ) {
          // Assume the element at index i is the biggest
          int maxValue = arr[i];
          int maxIndex = i;
          // Check the remaining elements in the array for a bigger element....
          for ( int j = i; j < arr.length; j++ ) {
                  if ( arr[j] > maxValue ) // if bigger element found...
                  {
                     // update the maxIndex to the bigger element
                    maxValue = arr[j];
                    maxIndex = j;
  
                  }
              }
              // Swap the element at index i with the biggest element found at maxIndex:
              int temp = arr[i];
              arr[i] = arr[maxIndex];
              arr[maxIndex] = temp;
          }
  
      return arr; // replace this...
    }
  }    