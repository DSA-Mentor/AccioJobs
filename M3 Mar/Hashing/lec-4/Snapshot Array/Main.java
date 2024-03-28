import java.util.*;

public class Main {
    // Declaration of the SnapshotArray mechanism
    static HashMap<Integer, Integer>[] mapArray; // An array of HashMaps to keep track of values at each index for each
                                                 // snap_id
    static int currSnapId; // A counter to keep track of the current snapshot ID

    // Initializes the SnapshotArray with the given length, setting each element to
    // 0
    public static void SnapshotArray(int length) {
        mapArray = new HashMap[length]; // Initialize the array of HashMaps with the specified length

        currSnapId = 0; // Initialize the snapshot ID counter to 0
    }

    // Sets the element at the given index to be equal to val
    public static void set(int index, int val) {
        if (mapArray[index] == null) {
            // If there's no HashMap at this index yet, create one
            mapArray[index] = new HashMap<>();
        }

        // Store the value with the current snapshot ID as the key in the HashMap at the
        // specified index
        mapArray[index].put(currSnapId, val);
    }

    // Takes a snapshot of the array by incrementing the snapshot ID and returns the
    // snap_id
    public static int snap() {
        currSnapId++; // Increment the current snapshot ID to signify a new snapshot
        return currSnapId - 1; // Return the snap_id, which is the total number of snapshots taken minus 1
    }

    // Returns the value at the given index, at the time the snapshot with the given
    // snap_id was taken
    public static int get(int index, int snap_id) {
        if (mapArray[index] == null) {
            // If there's no HashMap at this index, it means the value has never been set
            // and is 0
            return 0;
        }

        // If the exact snapshot ID is not present in the HashMap, decrement snap_id to
        // find the most recent value before the given snapshot
        while (snap_id >= 0 && !mapArray[index].containsKey(snap_id)) {
            snap_id--;
        }

        if (snap_id == -1) {
            // If snap_id becomes -1, it means there was no set operation performed on this
            // index before the requested snapshot
            return 0;
        }

        // Return the value associated with the most recent snap_id found
        return mapArray[index].get(snap_id);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String temp;
        int param1, param2;
        param1 = input.nextInt();
        SnapshotArray(param1);
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {

            temp = input.next();
            if (temp.equals("set") || temp.equals("get")) {
                param1 = input.nextInt();
                param2 = input.nextInt();
                if (temp.equals("set")) {
                    set(param1, param2);
                } else {
                    System.out.println(get(param1, param2));
                }
            } else {
                System.out.println(snap());
            }
        }

    }
}
