import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public void TappingWater(int[] arr, int n) {
        // TC: O(N), SC: O(N)
        // Step 1: get left max of all elements
        int[] lmax = new int[n];
        lmax[0] = 0;
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], arr[i - 1]);
        }

        // TC: O(N), SC: O(N)
        // Step 2: get right max of all elements
        int[] rmax = new int[n];
        rmax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i + 1]);
        }

        // TC: O(N), SC: O(1)
        // Step 3: get height till water can go, i.e. Math.min(lmax[i], rmax[i])
        // get actual height of water, i.e if height of building is left that water than
        // go, then it is height till water can go - height of building
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int heightTillWaterCanGo = Math.min(lmax[i], rmax[i]);
            if (heightTillWaterCanGo > arr[i]) {
                int actualHeightOfWater = heightTillWaterCanGo - arr[i];
                // as width is 1, so thats why multiply by 1
                totalWater += actualHeightOfWater * 1;
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