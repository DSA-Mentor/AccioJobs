import java.io.*;
import java.util.*;

class Solution {
    public long pairDifference(int[] A, int n, int k) {
        HashMap<Integer, Long> map = new HashMap<>();

        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0L) + 1);
        }

        long count = 0;
        for (int y : map.keySet()) {
            int x = y + k;

            if (k == 0) {
                if (map.get(y) >= 2) {
                    count += 1;
                }
            } else {
                if (map.containsKey(x) == true) {
                    count += 1;
                }
            }
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] mat = new int[n];
        for (int i = 0; i < n; ++i) {
            mat[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.pairDifference(mat, n, k));
        System.out.println('\n');
    }
}
