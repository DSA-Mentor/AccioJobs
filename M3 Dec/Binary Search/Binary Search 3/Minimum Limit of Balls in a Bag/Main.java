import java.util.*;
import java.io.*;

class Solution {
    public static boolean isPossible(int[] bags, int maxOpt, int maxValue) {
        int opt = 0;

        for (int balls : bags) {
            if (balls % maxValue == 0) {
                opt += (balls / maxValue) - 1;
            } else {
                opt += (balls / maxValue);
            }
        }

        return opt <= maxOpt;
    }

    public static int solve(int n, int m, int arr[]) {
        // Write your code here
        int lo = 1;
        int hi = 0;
        for (int balls : arr) {
            hi = Math.max(balls, hi);
        }

        int pans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (isPossible(arr, m, mid) == true) {
                pans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return pans;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();
        System.out.println(Solution.solve(n, m, arr));
    }
}