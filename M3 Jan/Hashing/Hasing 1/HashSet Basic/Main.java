import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // initialize a hashset
        HashSet<Integer> mySet = new HashSet<>();

        // insert values in hashset
        mySet.add(3);
        mySet.add(4);
        mySet.add(33);
        mySet.add(3);
        mySet.add(4);

        // print this hashset
        for (int key : mySet) {
            System.out.print(key + ", ");
        }
        System.out.println();

        // searching in hashset
        if (mySet.contains(33) == true) {
            System.out.println("yes!");
        } else {
            System.out.println("no");
        }

        // size of the hashset
        System.out.println("size: " + mySet.size());

        // remove
        mySet.remove(33);

        // size of the hashset
        System.out.println("size: " + mySet.size());
    }
}
