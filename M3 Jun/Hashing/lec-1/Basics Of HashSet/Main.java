import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> mySet = new HashSet<>();

        // add data to hashSet
        mySet.add(10);
        mySet.add(20);
        mySet.add(30);
        mySet.add(20);
        mySet.add(20);
        mySet.add(10);

        // size of the HashSet
        System.out.println("size: " + mySet.size());

        // print a HashSet
        System.out.println(mySet);

        // iterate over a HashSet
        for (int ele : mySet) {
            System.out.print(ele + " ");
        }
        System.out.println();

        // searching
        if (mySet.contains(20) == true) {
            System.out.println("20 is present");
        } else {
            System.out.println("20 is not present");
        }

        if (mySet.contains(100) == true) {
            System.out.println("100 is present");
        } else {
            System.out.println("100 is not present");
        }
    }    
}
