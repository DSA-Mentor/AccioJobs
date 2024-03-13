import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public void TappingWater(int[] arr, int n) {
        int[] lmax = new int[n];
        lmax[0] = 0;
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], arr[i - 1]);
        }

        int[] rmax = new int[n];
        rmax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i + 1]);
        }

        int tw = 0;
        for (int i = 0; i < n; i++) {
            int lh = Math.min(lmax[i], rmax[i]);
            int hw = lh - arr[i];
            if (hw > 0) {
                tw += hw * 1;
            }
        }

        System.out.println(tw);
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
        Obj.TappingWater(arr, n);

        sc.close();

    }
}