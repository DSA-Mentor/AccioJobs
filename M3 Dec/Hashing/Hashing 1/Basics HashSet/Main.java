import java.util.HashSet;

public class Main {
    static void printHashSet(HashSet<Integer> mySet) {
        // interating over hash set
        System.out.println("Values are: ");
        for (int val : mySet) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // intitialize a hash set
        HashSet<Integer> mySet = new HashSet<>();

        // insert values in a hash set
        // TC: O(1)
        mySet.add(10);
        mySet.add(20);
        mySet.add(10);
        mySet.add(90);
        mySet.add(-10);
        mySet.add(-10);

        // Searching, TC: O(1)
        if (mySet.contains(-10) == true) {
            System.out.println("Found: " + -10);
        } else {
            System.out.println("Not Found");
        }

        if (mySet.contains(-20) == true) {
            System.out.println("Found: " + -20);
        } else {
            System.out.println("Not Found");
        }

        // size of the hash set
        System.out.println("Size: " + mySet.size());

        printHashSet(mySet);

        // remove an element from hash set
        mySet.remove(10);

        printHashSet(mySet);
    }
}
