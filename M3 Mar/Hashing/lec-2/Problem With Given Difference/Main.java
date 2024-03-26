import java.io.*;
import java.util.*;

class Solution {
    public int givenDifference(int[] A, int n, int B) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            int x = A[i];

            int y1 = x - B;
            int y2 = x + B;

            if (set.contains(y1) == true || set.contains(y2) == true) {
                return 1;
            }

            set.add(x);
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
