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
        lmax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i + 1]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int h = Math.min(lmax[i], rmax[i]);
            if (h > arr[i]) {
                totalWater += (h - arr[i]);
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