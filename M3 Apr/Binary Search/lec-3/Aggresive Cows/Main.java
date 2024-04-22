import java.io.*;
import java.util.*;
import java.util.*;

class Solution {
    public static boolean isPossible(int[] stalls, int cows, int minDist) {
        int lastCowPlacedAt = stalls[0];
        int cowsPlaced = 1;

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastCowPlacedAt >= minDist) {
                cowsPlaced++;
                lastCowPlacedAt = stalls[i];
            }
        }

        if (cowsPlaced < cows) {
            return false;
        } else {
            return true;
        }
    }

    public static int aggressiveCows(int stalls[], int cows) {
        Arrays.sort(stalls);

        int lo = Integer.MAX_VALUE;
        for (int i = 0; i < stalls.length - 1; i++) {
            int dist = stalls[i + 1] - stalls[i];
            lo = Math.min(lo, dist);
        }
        int hi = stalls[stalls.length - 1] - stalls[0];

        int pans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(stalls, cows, mid) == true) {
                pans = mid;
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
