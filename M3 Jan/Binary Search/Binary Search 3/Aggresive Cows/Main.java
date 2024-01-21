import java.io.*;
import java.util.*;
import java.util.*;

class Solution {
    private static boolean isPossible(int[] stalls, int minDist, int cows) {
        int cowsPlaced = 1;
        int lastPlacedIndex = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            int dist = stalls[i] - lastPlacedIndex;

            if (dist >= minDist) {
                cowsPlaced++;
                lastPlacedIndex = stalls[i];
            }
        }

        return cowsPlaced >= cows;
    }

    // TC: O(N logN), SC: O(1)
    public static int aggressiveCows(int a[], int cows){
        Arrays.sort(a);

        int lo = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            int consDist = a[i + 1] - a[i];
            lo = Math.min(consDist, lo);
        }
        int hi = a[a.length - 1] - a[0];

        int pans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (isPossible(a, mid, cows) == true) {
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
        Solution obj=new Solution();
        System.out.println(obj.aggressiveCows(nums, k));
    }
}
