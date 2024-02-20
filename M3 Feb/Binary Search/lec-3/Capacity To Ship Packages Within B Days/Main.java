import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static boolean isPossible(int[] pkgs, int B, long maxCap) {
        int dayNum = 1;
        long cap = 0;

        for (int pkg : pkgs) {
            if (cap + pkg <= maxCap) {
                cap += pkg;
            } else if (pkg > maxCap) {
                return false;
            } else {
                dayNum++;
                cap = pkg;
            }
        }

        return dayNum <= B;
    }

    public static long solve(int[] A, int B) {
        // Write your code here
        long lo = 1;
        long hi = 100000000000L;

        long pans = -1;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (isPossible(A, B, mid) == true) {
                pans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return pans;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(Solution.solve(A, B));
    }
}