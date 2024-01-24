import java.util.*;

class Solution {
    // public void allDuplicates(int n, int[] arr) {
    // HashSet<Integer> set = new HashSet();
    // for (int i = 0; i < n; i++) {
    // int ele = arr[i];

    // if (set.contains(ele) == true) {
    // // seeing it again
    // System.out.print(ele + " ");
    // } else {
    // // seeing for the first time
    // set.add(ele);
    // }
    // }
    // }

    public void allDuplicates(int n, int[] arr) {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        // for (int ele : arr) {
        // if (fmap.containsKey(ele) == true) {
        // fmap.put(ele, fmap.get(ele) + 1);
        // } else {
        // fmap.put(ele, 1);
        // }
        // }
        for (int ele : arr) {
            fmap.put(ele, fmap.getOrDefault(ele, 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            if (fmap.containsKey(i) == true && fmap.get(i) > 1) {
                for (int j = 0; j < fmap.get(i) - 1; j++) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.allDuplicates(n, arr);
        sc.close();
    }
}