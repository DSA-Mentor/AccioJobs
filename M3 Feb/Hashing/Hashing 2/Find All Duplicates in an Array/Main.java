import java.util.*;

class Solution {
    // public void allDuplicates(int n, int[] arr) {
    // HashMap<Integer, Integer> fmap = new HashMap<>();
    // for (int num : arr) {
    // fmap.put(num, fmap.getOrDefault(num, 0) + 1);

    // if (fmap.get(num) >= 2) {
    // System.out.print(num + " ");
    // }
    // }

    // return;
    // }

    public void allDuplicates(int n, int[] arr) {
        HashSet<Integer> vis = new HashSet();
        for (int num : arr) {
            if (vis.contains(num) == true) {
                System.out.print(num + " ");
            } else {
                vis.add(num);
            }
        }

        return;
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