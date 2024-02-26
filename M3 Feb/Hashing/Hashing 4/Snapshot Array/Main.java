import java.util.*;

public class Main {
    static HashMap<Integer, HashMap<Integer, Integer>> map;
    static int id = 0;

    public static void SnapshotArray(int length) {
        map = new HashMap<>();
    }

    public static void set(int index, int val) {
        if (map.containsKey(id) == false) {
            map.put(id, new HashMap<>());
        }

        map.get(id).put(index, val);
    }

    public static int snap() {
        id++;

        return id - 1;
    }

    public static int get(int index, int snap_id) {
        if (snap_id > id) {
            snap_id = id;
        }

        while (map.get(snap_id) == null) {
            snap_id--;
        }

        while (snap_id >= 0 && map.get(snap_id).containsKey(index) == false) {
            snap_id--;
        }

        if (snap_id == -1) {
            return 0;
        }

        return map.get(snap_id).get(index);
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
