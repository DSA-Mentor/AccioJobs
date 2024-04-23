import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // initialize a HashSet
        HashSet<Integer> set = new HashSet<>();

        // TC: O(1)
        // add elements to hashSet
        set.add(10);
        set.add(20);
        set.add(10);
        set.add(40);

        // TC: O(1)
        // size of the hashSet
        System.out.println("size: " + set.size());

        // TC: O(1)
        // search in a hashSet
        if (set.contains(50) == true) {
            System.out.println("50 is present in the set");
        } else {
            System.out.println("50 is not present in the set");
        }

        // print all the elements of the hashSet
        for (int ele : set) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }    
}
