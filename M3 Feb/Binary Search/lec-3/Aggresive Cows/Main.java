import java.io.*;
import java.util.*;
import java.util.*;

class Solution {
    public static boolean isPossible(int[] stalls, int cows, int minDist) {
        int lastPlacedPos = stalls[0];
        int cowsPlaced = 1;

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlacedPos >= minDist) {
                cowsPlaced++;
                lastPlacedPos = stalls[i];
            }
        }

        return cowsPlaced >= cows;
    }

    // TC: O(N*log(N)), SC: O(1)
    public static int aggressiveCows(int a[], int cows) {
        // make all the closer stalls together
        Arrays.sort(a);

        // define range
        int hi = a[a.length - 1] - a[0];

        int lo = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            int dist = a[i] - a[i - 1];
            lo = Math.min(lo, dist);
        }

        int pans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(a, cows, mid) == true) {
                pans = mid;
                // maximize min dist
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return pans;
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.aggressiveCows(nums, k));

    }
}
