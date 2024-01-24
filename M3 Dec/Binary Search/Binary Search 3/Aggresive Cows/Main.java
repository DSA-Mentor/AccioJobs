import java.io.*;
import java.util.*;
import java.util.*;

class Solution {
    public static boolean isPossible(int[] stalls, int cows, int minDist) {
        int numOfCowsPlaced = 1;
        int lastPositionPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPositionPlaced >= minDist) {
                lastPositionPlaced = stalls[i];
                numOfCowsPlaced++;
            }
        }

        return numOfCowsPlaced >= cows;
    }

    public static int aggressiveCows(int a[], int cows) {
        // Write your code here
        Arrays.sort(a);

        int hi = a[a.length - 1] - a[0];
        int lo = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            lo = Math.min(lo, a[i] - a[i - 1]);
        }

        int pans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (isPossible(a, cows, mid) == true) {
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
