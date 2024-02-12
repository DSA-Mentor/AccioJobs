import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    // public void TappingWater(int[] arr, int n) {
    // // lmax
    // int[] lmax = new int[n];
    // lmax[0] = 0;
    // for (int i = 1; i < n; i++) {
    // lmax[i] = Math.max(lmax[i - 1], arr[i - 1]);
    // }

    // int[] rmax = new int[n];
    // rmax[n - 1] = 0;
    // for (int i = n - 2; i >= 0; i--) {
    // rmax[i] = Math.max(rmax[i + 1], arr[i + 1]);
    // }

    // int totalWater = 0;
    // for (int i = 0; i < n; i++) {
    // // support of water height
    // int support = Math.min(lmax[i], rmax[i]);
    // if (support > arr[i]) {
    // int hw = support - arr[i];
    // totalWater += hw * 1;
    // }
    // }

    // System.out.println(totalWater);
    // }

    // TC: O(N), SC: O(1)
    public void TappingWater(int[] arr, int n) {
        int LB = arr[0];
        int RB = arr[n - 1];
        int l = 1;
        int r = n - 2;

        int totalWater = 0;
        while (l <= r) {
            if (LB <= RB) {
                int support = LB;
                if (support > arr[l]) {
                    int hw = support - arr[l];
                    totalWater += hw * 1;
                }

                LB = Math.max(LB, arr[l]);
                l++;
            } else {
                int support = RB;
                if (support > arr[r]) {
                    int hw = support - arr[r];
                    totalWater += hw * 1;
                }

                RB = Math.max(RB, arr[r]);
                r--;
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