import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public void TappingWater(int[] arr, int n) {
        // Write code here and print output
        int[] lmax = new int[n];
        lmax[0] = 0;
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(arr[i - 1], lmax[i - 1]);
        }

        int[] rmax = new int[n];
        rmax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i + 1]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int hb = arr[i];
            int th = Math.min(lmax[i], rmax[i]);
            if (th > hb) {
                int hw = th - hb;
                totalWater += hw * 1;
            }
        }

        System.out.println(totalWater);
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