import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // initialize a HashSet
        HashSet<Integer> set = new HashSet<>();

        // add data in hashSet
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(10);
        set.add(10);
        set.add(30);

        // size of HashSet
        System.out.println("size: " + set.size());

        // remove elements from HashSet
        set.remove(10);

        // size of HashSet
        System.out.println("size: " + set.size());

        // Searching TC: O(1)
        if (set.contains(40) == true) {
            System.out.println("yes hashSet contains " + 40);
        } else {
            System.out.println(40 + " not found");
        }

        // loop over a HashSet
        for (int ele : set) {
            System.out.print(ele + " ");
        }
        System.out.println();

        System.out.println("set: " + set);

        ArrayList<Integer> arr = new ArrayList<>(set);
        System.out.println("arr: " + arr);
    }
}
