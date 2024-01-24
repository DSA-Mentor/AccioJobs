import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    private static boolean isPossible(int[] A, long maxCap, int B) {
        int dayNum = 1;
        long weightOnShip = 0;

        for (int pkg : A) {
            if (weightOnShip + pkg <= maxCap) {
                weightOnShip += pkg;
            } else {
                dayNum++;
                weightOnShip = pkg;
            }
        }

        return dayNum <= B;
    }

    public static long solve(int[] A, int B) {
        long lo = 0;
        long hi = 0;
        for (int pkg : A) {
            lo = Math.max(lo, pkg);
            hi += pkg;
        }

        long pans = -1;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (isPossible(A, mid, B) == true) {
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