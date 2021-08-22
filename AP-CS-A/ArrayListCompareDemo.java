import java.util.ArrayList;

class ArrayListCompareDemo {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<String>();
        aList.add("yay");
        aList.add("hello");
        aList.add("goodbye");
        aList.add("no");
        aList.add("yes");
        
        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        aList.remove(2);
        aList.set(3, "yeet");
        aList.add(1, "lol");

        System.out.println("-----------------------------------------");
        for (String i : aList) {
            System.out.println(i);
        }

        System.out.print("Longest Word: " + findMax(aList));
    }

    // method incorrect
    public static String findMax( ArrayList<String> names ) {
        String largest = names.get(0);
        for (int i = 0; i < names.size()-1; i++) {
            if (names.get(i).compareTo(names.get(i+1)) > 0) {
                largest = names.get(i+1);
            }
        }
        return largest;
    }
}