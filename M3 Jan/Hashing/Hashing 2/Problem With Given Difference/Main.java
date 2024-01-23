import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public int givenDifference(int[] A, int n, int B) {
        // write your code here
        HashSet<Integer> vis = new HashSet<>();

        for (int y : A) {
            int x1 = y + B;
            int x2 = y - B;

            if (vis.contains(x1) || vis.contains(x2)) {
                return 1;
            } else {
                vis.add(y);
            }
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, B;
        n = sc.nextInt();
        int[] mat = new int[n];
        for (int i = 0; i < n; ++i) {
            mat[i] = sc.nextInt();
        }
        B = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.givenDifference(mat, n, B));
        System.out.println('\n');
    }
}
