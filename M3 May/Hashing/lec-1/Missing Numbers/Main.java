import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        // freq HashMap for both the array
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int ele : arr) {
            map1.put(ele, map1.getOrDefault(ele, 0) + 1);
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int ele : brr) {
            map2.put(ele, map2.getOrDefault(ele, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Extra elements in brr: Keys in Map2 that are not present in Map1
        // if present the freq should be same
        for (int key : map2.keySet()) {
            if (map1.containsKey(key) == false) {
                list.add(key);
            } else {
                if (map1.get(key) != map2.get(key)) {
                    list.add(key);
                }
            }
        }

        if (list.size() == 0) {
            System.out.print(-1);
            return;
        }

        Collections.sort(list);
        for (int ele : list) {
            System.out.print(ele + " ");
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n, arr, m, brr);
    }
}