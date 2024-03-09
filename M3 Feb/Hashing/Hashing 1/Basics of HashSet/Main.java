import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // initialize hashSet
        HashSet<Integer> set = new HashSet<>();

        // add elements to hashSet
        set.add(10);
        set.add(20);
        set.add(10);
        set.add(30);
        set.add(50);

        // size of the set
        System.out.println("size: " + set.size());

        // iteration over hashSet, forEach loop
        System.out.print("HashSet values: ");
        for (int key : set) {
            System.out.print(key + " ");
        }
        System.out.println();

        // remove elements
        set.remove(50);

        // size of the set
        System.out.println("size: " + set.size());

        // iteration over hashSet, forEach loop
        System.out.print("HashSet values: ");
        for (int key : set) {
            System.out.print(key + " ");
        }
        System.out.println();

        // search
        if (set.contains(10) == true) {
            System.out.println("Found " + 10 + " in set");
        } else {
            System.out.println("Unable to find " + 10 + " in set");
        }

        if (set.contains(90) == true) {
            System.out.println("Found " + 90 + " in set");
        } else {
            System.out.println("Unable to find " + 90 + " in set");
        }
    }
}
