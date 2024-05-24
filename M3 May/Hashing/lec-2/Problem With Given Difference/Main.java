import java.io.*;
import java.util.*;

class Solution {
    public int givenDifference(int[] A, int n, int B) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : A) {
            if (B == 0 && set.contains(ele) == true) {
                return 1;
            }

            set.add(ele);
        }

        if (B == 0) {
            return 0;
        }

        for (int y : A) {
            int x1 = B + y;
            int x2 = y - B;
            if (set.contains(x1) == true || set.contains(x2) == true) {
                return 1;
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
