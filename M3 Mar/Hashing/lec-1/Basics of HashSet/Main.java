import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // initialize a hashSet
        HashSet<Integer> set = new HashSet<>();

        // add values to hashSet
        set.add(10);
        set.add(20);
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(50);

        // size of the set
        System.out.println("size: " + set.size());

        // search in O(1)
        if (set.contains(10) == true) {
            System.out.println("contains: " + 10);
        } else {
            System.out.println("doesn't contains: " + 10);
        }

        if (set.contains(40) == true) {
            System.out.println("contains: " + 40);
        } else {
            System.out.println("doesn't contains: " + 40);
        }

        // loop on the set
        for (int key : set) {
            System.out.println("value: " + key);
        }

        // print the set
        System.out.println("set: " + set);

        // remove ele from set
        set.remove(10);

        System.out.println("set: " + set);

        if (set.contains(10) == true) {
            System.out.println("contains: " + 10);
        } else {
            System.out.println("doesn't contains: " + 10);
        }
    }
}
