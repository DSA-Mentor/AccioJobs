import java.util.*;

public class Main {
    static HashMap<Integer, Integer>[] hashmapArray;
    static int snapId;

    public static void SnapshotArray(int length) {
        hashmapArray = new HashMap[length];
        snapId = 0;
    }

    public static void set(int index, int val) {
        if (hashmapArray[index] == null) {
            hashmapArray[index] = new HashMap<>();
        }

        hashmapArray[index].put(snapId, val);
    }

    public static int snap() {
        snapId++;
        return snapId - 1;
    }

    public static int get(int index, int snap_id) {
        if (hashmapArray[index] == null) {
            return 0;
        }

        int lastSnapId = snap_id;
        while (lastSnapId >= 0 && hashmapArray[index].containsKey(lastSnapId) == false) {
            lastSnapId--;
        }

        if (lastSnapId == -1) {
            return 0;
        }

        return hashmapArray[index].get(lastSnapId);
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
