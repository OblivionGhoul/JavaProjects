import java.util.ArrayList;
import java.util.List;

class MinTester {
    public static void main(String[] args) {
        List<Integer> stuff = new ArrayList<Integer>();
        stuff.add(-2);
        stuff.add(12);
        stuff.add(22);
        stuff.add(17);
        stuff.add(19);
        stuff.add(-10);
        stuff.add(-2);
        System.out.println("Test 1: 2nd smallest is: " + find2ndMin(stuff) );
    
        stuff = new ArrayList<Integer>();
        stuff.add(-2);
        stuff.add(12);
        stuff.add(22);
        stuff.add(17);
        stuff.add(19);
        stuff.add(-1);
        stuff.add(-2);
        System.out.println("Test 2: 2nd smallest is: " + find2ndMin(stuff) );
    
        stuff = new ArrayList<Integer>();
        stuff.add(-2);
        stuff.add(12);
        stuff.add(22);
        stuff.add(17);
        stuff.add(19);
        stuff.add(-1);
        stuff.add(999999);
        System.out.println("Test 3: 2nd smallest is: " + find2ndMin(stuff) );
    }

    /**
    @param ints An arrayList with at least 2 elements (precondition). 
    Postcondition: The arrayList ints is not mutilated or disturbed in any way.
    @return the 2nd smallest value in the array (or the smallest if the min value occurs more than once)
    */
    public static int find2ndMin( List<Integer> ints ) {
        int smallest = ints.get(0);
        int smallest2 = 0;
        int index = 0;
        for (int i = 0; i < ints.size(); i++) {
            if (ints.get(i) < smallest) {
                smallest = ints.get(i);
                index = i;
            }
        }
        for (int i = 0; i < ints.size(); i++) {
            if (ints.get(i) < smallest2) {
                if (i != index) {
                    smallest2 = ints.get(i);
                }
            }
        }
        return smallest2;
    }
}